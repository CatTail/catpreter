define(function (require, exports) {
// Set class to wrap arrays

var typal = require("./typal").typal;

var setMixin = {
  constructor: function Set_constructor (set, raw) {
    // CATTAIL: construct Set with a array or a list of arguments
    // if set is a array, create a new one rather than simple assignment.
    this._items = [];
    if (set && set.constructor === Array) {
      this._items = raw ? set: set.slice(0);
    } else if(arguments.length) {
      this._items = [].slice.call(arguments,0);
    }
  },
  concat: function concat (setB) {
    // CATTAIL: concatenate another Set or Array
    this._items.push.apply(this._items, setB._items || setB);
    return this;
  },
  eq: function eq (set) {
    // CATTAIL: weather equal to set
    return this._items.length === set._items.length && this.subset(set);
  },
  indexOf: function indexOf (item) {
    // CATTAIL: if item is a normal object, using Array.prototype.indexOf
    // method, otherwise if item is another set, loop to find a equal set using
    // Set.prototype.eq method.
    if(item && item.eq) {
      for(var k=0; k<this._items.length;k++) {
        if(item.eq(this._items[k])) {
          return k;
        }
        return -1;
      }
    }
    return this._items.indexOf(item);
  },
  union: function union (set) {
    // CATTAIL: using Set.prototype.complement
    return (new Set(this._items)).concat(this.complement(set));
  },
  intersection: function intersection (set) {
    // CATTAIL: return common element in this and set
    return this.filter(function (elm) {
      return set.contains(elm);
    });
  },
  complement: function complement (set) {
    // CATTAIL: return (set-this)
    var that = this;
    return set.filter(function sub_complement (elm) {
      return !that.contains(elm);
    });
  },
  subset: function subset (set) {
    // CATTAIL: weather is the subset of set
    var cont = true;
    for (var i=0; i<this._items.length && cont;i++) {
      cont = cont && set.contains(this._items[i]);
    }
    return cont;
  },
  superset: function superset (set) {
    // CATTAIL: using Set.prototype.subset reverse
    return set.subset(this);
  },
  joinSet: function joinSet (set) {
    // CATTAIL: different with Set.prototype.concat in joinSet don't include the
    // common element in both set.
    return this.concat(this.complement(set));
  },
  contains: function contains (item) { return this.indexOf(item) !== -1; },
  item: function item (v, val) { return this._items[v]; }, // CATTAIL: return the v-th value
  i: function i (v, val) { return this._items[v]; }, // CATTAIL: return the i-th value, same as Set.prototype.item method
  first: function first () { return this._items[0]; }, // CATTAIL: return first element
  last: function last () { return this._items[this._items.length-1]; }, // CATTAIL: return last element
  size: function size () { return this._items.length; },
  isEmpty: function isEmpty () { return this._items.length === 0; },
  copy: function copy () { return new Set(this._items); }, // CATTAIL: create a new Set with same items
  toString: function toString () { return this._items.toString(); }
};

"push shift unshift forEach some every join sort".split(' ').forEach(function (e,i) {
  // CATTAIL: using Array.prototype implementation rather than self-implement.
  // return array.
  setMixin[e] = function () { return Array.prototype[e].apply(this._items, arguments); };
  setMixin[e].name = e;
});
"filter slice map".split(' ').forEach(function (e,i) {
  // CATTAIL: using Array.prototype implementation rather than self-implement.
  // return new Set instead.
  setMixin[e] = function () { return new Set(Array.prototype[e].apply(this._items, arguments), true); };
  setMixin[e].name = e;
});

var Set = typal.construct(setMixin).mix({
  union: function (a, b) {
    // CATTAIL: join two array together without duplicate
    var ar = {};
    for (var k=a.length-1;k >=0;--k) {
      ar[a[k]] = true;
    }
    for (var i=b.length-1;i >= 0;--i) {
      if (!ar[b[i]]) {
        a.push(b[i]);
      }
    }
    return a;
  }
});

if (typeof exports !== 'undefined') {
  exports.Set = Set;
}
});
