// JSHint global variable
/*global console, exports */
// TODO: Add module manager
var cat = {};

// configuration
/*
cat.config = {
  // userAgent browser information
  dataBrowser: [{
    string: navigator.userAgent,
    subString: "Chrome",
    identity: "Chrome"
  },{
    string: navigator.userAgent,
    subString: "OmniWeb",
    versionSearch: "OmniWeb/",
    identity: "OmniWeb"
  },{
    string: navigator.vendor,
    subString: "Apple",
    identity: "Safari",
    versionSearch: "Version"
  },{
    prop: window.opera,
    identity: "Opera",
    versionSearch: "Version"
  },{
    string: navigator.vendor,
    subString: "iCab",
    identity: "iCab"
  },{
    string: navigator.vendor,
    subString: "KDE",
    identity: "Konqueror"
  },{
    string: navigator.userAgent,
    subString: "Firefox",
    identity: "Firefox"
  },{
    string: navigator.vendor,
    subString: "Camino",
    identity: "Camino"
  },{ // for newer Netscapes (6+)
    string: navigator.userAgent,
    subString: "Netscape",
    identity: "Netscape"
  },{
    string: navigator.userAgent,
    subString: "MSIE",
    identity: "Explorer",
    versionSearch: "MSIE"
  },{
    string: navigator.userAgent,
    subString: "Gecko",
    identity: "Mozilla",
    versionSearch: "rv"
  },{ // for older Netscapes (4-)
    string: navigator.userAgent,
    subString: "Mozilla",
    identity: "Netscape",
    versionSearch: "Mozilla"
  }],
  // userAgent os info
  dataOS: [{
    string: navigator.platform,
    subString: "Win",
    identity: "Windows"
  },{
    string: navigator.platform,
    subString: "Mac",
    identity: "Mac"
  },{
    string: navigator.userAgent,
    subString: "iPhone",
    identity: "iPhone/iPod"
  },{
    string: navigator.platform,
    subString: "Linux",
    identity: "Linux"
  }]
};
*/

/* core */
/**
 * Return class name of givem object.
 * @param {object} o Given object of any type
 * @return {string} String representation of object type
 */
cat.classof = function(o){
  if (o === null) { return "null"; }
  if (o === undefined) { return "undefined"; }
  if (o !== o) { return "NaN"; }
  if (o.constructor && o.constructor.name) { return o.constructor.name; }
  return Object.prototype.toString.call(o).slice(8,-1);
};

/**
 * if value if falsy value
 * falsy value include:
 *    undefined
 *    null
 *    0
 *    -0
 *    NaN
 *    ""
 * @param value Value need to be checked
 */
cat.falsy = function(value){
  return value ? false : true;
//	return value == null || value == false || value != value ? true : false;
};

/**
 * clone only simple object
 * handle Array, Date and RegExp
 * resolve circular reference
 * @param {*} obj
 * @param {boolean} shallow Weather do shallow clone or deep clone
 * @return {*}
 */
cat.clone = (function(){
  // classify object
  var classof = function(o){
    if (o === null) { return "null"; }
    if (o === undefined) { return "undefined"; }
    // I suppose Object.prototype.toString use obj.constructor.name
    // to generate string
    var className = Object.prototype.toString.call(o).slice(8,-1);
    return className;
  };
  
  var references = null;

  var handlers = {
    // Handle regexp and date even in shallow.
    'RegExp': function(reg) {
      var flags = '';
      flags += reg.global ? 'g' : '';
      flags += reg.multiline ? 'm' : '';
      flags += reg.ignoreCase ? 'i' : '';
      return new RegExp(reg.source, flags);
    },
    'Date': function(date) {
      return new Date(+date);
    },
    'Array': function(arr, shallow) {
      var newArr = [], i;
      for (i=0; i<arr.length; i++) {
        if (shallow) {
          newArr[i] = arr[i];
        } else {
          // handle circular reference
          if (references.indexOf(arr[i]) !== -1) {
            continue;
          }
          var handler = handlers[classof(arr[i])];
          if (handler) {
            references.push(arr[i]);
            newArr[i] = handler(arr[i], false);
          } else {
            newArr[i] = arr[i];
          }
        }
      }
      return newArr;
    },
    'Object': function(obj, shallow) {
      var newObj = {}, prop, handler;
      for (prop in obj) {
        if (obj.hasOwnProperty(prop)) {
          // escape prototype properties
          if (shallow) {
            newObj[prop] = obj[prop];
          } else {
            // handle circular reference
            if (references.indexOf(obj[prop]) !== -1) {
              continue;
            }
            // recursive
            handler = handlers[classof(obj[prop])];
            if (handler) {
              references.push(obj[prop]);
              newObj[prop] = handler(obj[prop], false);
            } else {
              newObj[prop] = obj[prop];
            }
          }
        }
      }
      return newObj;
    }
  };

  return function(obj, shallow) {
    // reset references
    references = [];
    // default to shallow clone
    shallow = shallow === undefined ? true : false;
    var handler = handlers[classof(obj)];
    return handler ? handler(obj, shallow) : obj;
  };
}());

// Store cached info.
cat.cache = {};

/**
 * Create inner scope for function. Other code outside the function can't access the scope.
 * @param {Function} func Function will supplied with inner scope
 * @param {Function} [initialize] Init function to configure scope
 * @return {Function}
 */
cat.closure = function(func, initialize) {
  var scope = {};
  if (arguments.length === 2) {
    initialize(scope);
  }
  return function() {
    return func(scope);
  };
};

/**
 * Get browser type, version and os type.
 * @return {Object} Have property: browser, version, OS
 */
cat.userAgent = cat.closure(function(scope) {
  // return cached userAgent
  if (cat.cache.userAgent) {
    return cat.cache.userAgent;
  }
  return cat.cache.userAgent = {
    browser: scope.searchString(cat.config.dataBrowser) || "An unknown browser",
    version: scope.searchVersion(navigator.userAgent) ||
      scope.searchVersion(navigator.appVersion) ||
      "an unknown version",
    OS: scope.searchString(cat.config.dataOS) || "an unknown OS"
  };
}, function(scope) {
  var versionSearchString;
  scope.searchString = function (data) {
    for (var i=0;i<data.length;i++)	{
      var dataString = data[i].string;
      var dataProp = data[i].prop;
      versionSearchString = data[i].versionSearch || data[i].identity;
      if (dataString) {
        if (dataString.indexOf(data[i].subString) !== -1) {
          return data[i].identity;
        }
      }
      else if (dataProp) {
        return data[i].identity;
      }
    }
  };
  scope.searchVersion = function(dataString) {
    var index = dataString.indexOf(versionSearchString);
    if (index === -1) { return; }
    return parseFloat(dataString.substring(index+versionSearchString.length+1));
  };
});

/**
 * cookie manipulation class
 */
cat.cookie = {
	set : function(name,value,days,path){
		var result = '';
		result += [name,value].join('=');
		var today = new Date();
		days === undefined ? 0 : result += ['; expires',today.getTime()+days*24*60*60*1000].join('=');
		path === undefined ? 0 : result += ['; path',path].join('=');
		document.cookie = result;
	},
	get : function(name){
		var pairs = document.cookie.split('; ');
		for(var i=0;i<pairs.length;i++){
			var pair = pairs[i].split('=');
			if( pair[0] === name ){
				return pair[1];
			}
		}
	},
	remove : function(name){
		this.set(name,'',-1);
	}
};

/**
 * Create unique identifier in current webpage
 */
cat.uuid = (function(){
  var count = 0;
  return function(){
    return count++;
  };
}());

/**
 * Using regular expression to validate email address.
 * Exactly email address format refer to http://en.wikipedia.org/wiki/Email_address.
 * @param {string} email
 * @return {boolean}
 */
cat.validateEmail = (function() {
  // ATTENSION: escape is really mess because you have to escape in string and
  // in regular expression.
  var normal = "0-9a-zA-Z\\!#\\$%&'\\*\\+\\-\\/\\=\\?\\^_`\\{\\|\\}~";
  // mix contain normal character and special character
  // special character \ " need to be escaped
  var mix = '\\(\\),:;<>@\\[\\](\\\\\\\\)(\\\\")0-9a-zA-Z\\!#\\$%&\'\\*\\+-\\/\\=\\?\\^_`\\{\\|\\}~\\.\\s';

  // local part
  var mixPattern = '"['+mix+']*"';
  var normalPattern = '[' + normal + '("")]+?';
  var localPattern = ['^((', normalPattern, '\\.)*', normalPattern, ')'].join('');
  // domain part
  var hostnamePattern = '(:?[0-9a-zA-Z\\-]+\\.)*[0-9a-zA-Z\\-]+';
  var ipPattern = '\\[.+?\\]'; // TODO: handle IPv4 and IPv6
  var domainPattern = ['(?:(?:', hostnamePattern, ')|(?:', ipPattern, '))$'].join('');

  var commentPattern = "(?:\\(.*?\\))?";
  var pattern = localPattern + '@' + domainPattern;

  var mixreg = new RegExp(mixPattern, 'g');
  var reg = new RegExp(pattern, 'g');

  return function(email) {
    var valid = true;
    // reset regular expression
    reg.lastIndex = 0;
    // TODO: I want to combine special pattern into normal pattern.
    // Which means just one regular expression can handle everything.
    // Anybody have any good idea please contact with me(cattail2012@gmail.com)
    email = email.replace(mixreg, '""');
    return reg.test(email);
  };
}());

/* Design pattern */

/**
 * @param subClass Sub Class Constructor
 * @param superClass Super Class Constructor
 */
cat.extend = (function(){
	function Ctor(){
	}
	return function(subClass,superClass){
		Ctor.prototype = superClass.prototype;
		var prototype = new Ctor();
		subClass.prototype = prototype;
		prototype.constructor = subClass;
	};
}());

/**
 * #Design Pattern# Singleton
 * Simple util to create singleton pattern.
 * @param {function} init Function used to initialize object
 * @return {function} Constructor have singleton pattern
 */
cat.singleton = function(init) {
  var instance;
  var constructor = function() {
    if (instance) { return instance; }

    instance = this;
    init.apply(this, arguments);
    return instance; // could be ignored, put here just for clearity
  };
  return constructor;
};

/**
 * #Design Pattern# Proxy
 *
 * realSubject being proxied by subject internally
 * @param realSubject Internal object being manipulated
 * @param subject Outlooking subject used by user*/
cat.proxy = function(realSubject,subject){
	var all = cat.getAllPropertyNames(realSubject);
	var properties = [] , methods = [];
	cat.each(all,function(v){
		typeof v === 'function' ? methods.push(v) : properties.push(v);
	});
	//method proxy
	cat.each(methods,function(method){
		subject[method] = function(){
			realSubject[method].apply(realSubject,arguments);
		};
	});
	//property proxy
	//enumerable & configurable property still need to be read from realSubject
	cat.each(properties,function(property){
		Object.defineProperty(subject,property,{
			get:function(){ return realSubject[property]; },
			set:function(value){ realSubject[property] = value; },
			enumerable:true,
			configurable:true
		});
	});
};

/* Object util */
cat.object = {};

/**
 * get all property names including methods obj have
 */
cat.object.getAllPropertyNames = function(obj){
	var proto=obj , props=[];
	while(proto !== null){
		props = props.concat(Object.getOwnPropertyNames(proto));
		proto = Object.getPrototypeOf(proto);
	}
	return props;
};

/* Array util */
cat.array = {};

/**
 * Remove item in array.
 * Only works in primitive types right now.
 * @param {Array} arr
 * @param {*} item Item need to be removed
 * @return {Array} Modified array
 */
cat.array.remove = function(arr, item){
  var idx = arr.indexOf(item);
  if (idx === -1) { return; }
  arr.splice(arr.indexOf(item), 1);
};

/**
 * Add exclude option to control item in array are different.
 * @param {Array} arr
 * @param {*} item
 * @param {?Boolean} exclude Weather item could be same in array, default to be
 * true.
 */
cat.array.push = function(arr, item, exclude){
  exclude = exclude === undefined ? true : false;
  if (exclude) {
    arr.indexOf(item) === -1 ? arr.push(item) : 0;
  }else{
    arr.push(item);
  }
};

/**
 * Add exclude option to control item in array are different.
 * @param {Array} arr
 * @param {*} item
 * @param {?Boolean} exclude Weather item could be same in array, default to be
 * true.
 */
cat.array.concat = function(arr, item, exclude) {
  exclude = exclude === undefined ? true : false;
  if (exclude) {
    // normal object
    // TODO: eligant the code
    if (cat.classof(item) === 'Array') {
      var sum = arr.slice();
      cat.array.each(item, function(el){
        arr.indexOf(el) === -1 ? sum = sum.concat(el) : 0;
      });
      return sum;
    }else{
      // array
      return arr.indexOf(item) === -1 ? arr.concat(item) : arr;
    }
  }else{
    return arr.concat(item);
  }
};

/**
 * If arr contain item.
 * @param {Array} arr
 * @param {*} item
 */
cat.array.contain = function(arr, item){
  return arr.indexOf(item) !== -1;
};

/**
 * call every element in arr
 * @param {Array} arr Array of supplied elements
 * @param {Function} callback Function will be called for every element in arr.
 * It will be supplied with 1.value 2.index 3.complete arr
 */
cat.array.each = function(arr,callback,thisArg){
	thisArg = thisArg === undefined ? this : thisArg;
  for (var i=arr.length-1;i>=0;i--) {
		callback.call(thisArg,arr[i],i,arr);
  }
};

/**
 * check if every element in arr satisfy predicate
 * @param {Array} arr Array of element needed to be checked
 * @param {Function} predicate Checking function
 * @param {Boolean} increase Execute element in increase sequence
 */
cat.array.every = function(arr, predicate, thisArg, increase){
  increase = increase === undefined ? false : increase;
	var result = true,
  i;
  if (increase) {
    for (i=0 ; i<arr.length ; i++) {
      if ( cat.falsy( predicate.call(thisArg, arr[i], i) )) {
        result = false;
        break;
      }
    }
  }else{
    for (i=arr.length-1 ; i>=0 ; i--) {
      if ( cat.falsy( predicate.call(thisArg, arr[i]), i)) {
        result = false;
        break;
      }
    }
  }
	return result;
};

/**
 * Creates a new array with the results of calling a provided function on every
 * element in this array.
 * @param {Array} arr Array supplied to create new array
 * @param {Function} callback Called with arguments 1)array item 2)item index
 * @param {Object|undefined} thisArg Callback this environment if provided
 * @param {Boolean} filter Set true to filter null and undefined
 * @return {Array}
 */
cat.array.map = function(arr, callback, filter, thisArg){
  var map = [];
  for (var i=0;i<arr.length;i++) {
    var altered = callback.call(thisArg, arr[i], i);
    if (filter && altered == null ) {
      continue;
    }
    map.push(altered);
  }
  return map;
};

/**
 * Returns once array element satisfy supplied function.
 * @param {Array} arr
 * @param {Function} func Varification function, arguments given are current
 * loop item, item index, the array being looped
 * @param {Object} thisArg
 * @return {Boolean}
 */
cat.array.once = function(arr, func, thisArg) {
  var len = arr.length;
  for (var i=0;i<len;i++) {
    if (func.call(thisArg, arr[i], i, arr)) {
      return true;
    }
  }
  return false;
};

/* Number util */
cat.number = {};
/**
 * Return a random number between min and max value.
 * @param {?number} min Lower bound of returned value, default to 0
 * @param {?number} max Upper bound of returned value, default to 9
 * @return {number} Random number between min and max
 */
cat.number.random = function(min, max) {
  min = min || 0;
  max = max || 9;
  return Math.floor(Math.random() * (max - min) + min);
};

/* String util */
cat.string = {};
/**
 * Return a random string of length `len` and every character is within `range`
 * @param {?number} len Length of random string, default to 4
 * @param {?string} range Character construct random string, default to alphabet
 * @return {string}
 */
cat.string.random = function(len, range) {
  var alphabet = 'abcdefghijklmnopqistuvwxyzABCDEFGHIJKLMNOPQISTUVWXYZ';
  if (arguments.length === 1) {
    // supplied with one argument
    if (typeof len === 'number') {
      range = alphabet;
    } else {
      range = len;
      len = 4;
    }
  } else {
    len = len || 4;
    range = range || alphabet;
  }
  var str = '';
  for ( ; len>0; len-- ) {
    str += range[cat.number.random(0, range.length)];
  }
  return str;
};

/**
 * Using place holder to inject String
 *  cat.format("This is {0} util {1} useful", 'a', 'really')
 * Will ouput "This is a util really usefull"
 */
cat.string.format = function(original){
	var args = arguments;
	return original.replace(/\{(\d+)\}/gi,function(match,p1){
		return args[+p1+1];
	});
};

/**
 * @see https://gist.github.com/4180701
 * Following is a list of function used for encoding conversion.
 */
// text -> unicode
cat.string.toUnicode = function(str) {
  var buf = [];
  for (var i=str.length-1;i>=0;i--) {
    buf.unshift( '%u' + str.charCodeAt(i).toString(16) );
  }
  return buf.join('');
};

// unicode -> text
cat.string.fromUnicode = function(unicode) {
  return unicode.replace(/%u([0-9a-fA-F]+)/g, function(match, hex) {
    return String.fromCharCode(parseInt(hex, 16));
  });
};
// unicode -> utf8
cat.string.unicode2utf8 = function(unicode) {
  return unicode.replace(/%u([0-9a-fA-F]+)/g, function(match, hex) {
    var utf8CharCodes = [];
    c = parseInt(hex, 16);
    if (c < 128) {
      utf8CharCodes.push(c);
    } else if (c < 2048) {
      utf8CharCodes.push((c >> 6) | 192, (c & 63) | 128);
    } else if (c < 65536) {
      utf8CharCodes.push((c >> 12) | 224, ((c >> 6) & 63) | 128, (c & 63) | 128);
    } else {
      utf8CharCodes.push((c >> 18) | 240, ((c >> 12) & 63) | 128, ((c >> 6) & 63) | 128, (c & 63) | 128);
    }
    for (var i=utf8CharCodes.length-1;i>=0;i--) {
      utf8CharCodes[i] = '%' + utf8CharCodes[i].toString(16);
    }
    return utf8CharCodes.join('');
  });
};
// utf8 -> unicode
cat.string.utf82unicode = function(utf8) {
  var parts = utf8.split('%').slice(1),
  i = 0,
  buf = [];
  while (i<parts.length) {
    var part = parseInt(parts[i], 16),
    part2, part3, part4;
    if ((part & 128) === 0) {
      buf.push(part);
      i = i+1;
    } else if ((part & 240) === 240) {
      part2 = parseInt(parts[i+1], 16);
      part3 = parseInt(parts[i+2], 16);
      part4 = parseInt(parts[i+3], 16);
      buf.push(
        ((part & 7) << 18) + ((part2 & 63) << 12) + ((part3 & 63) << 6) + (part4 & 63)
      );
      i = i+4;
    } else if ((part & 224) === 224) {
      part2 = parseInt(parts[i+1], 16);
      part3 = parseInt(parts[i+2], 16);
      buf.push(
        ((part & 15) << 12) + ((part2 & 63) << 6) + (part3 & 63)
      );
      i = i+3;
    } else if ((part & 192) === 192) {
      part2 = parseInt(parts[i+1], 16);
      buf.push(
        ((part & 31) << 6) + (part2 & 63)
      );
      i = i+2;
    }
  }
  for (i=buf.length-1;i>=0;i--) {
    buf[i] = '%u' + buf[i].toString(16);
  }
  return buf.join('');
};

// text -> utf8
cat.string.toUtf8 = function(str){
  return unicode2utf8(toUnicode(str));
};
// utf8 -> text
cat.string.fromUtf8 = function(utf8) {
  return fromUnicode(utf82unicode(utf8));
};
// text -> html entity
cat.string.toHtmlEntity = function(str) {
  var buf = [];
  for (var i=str.length-1;i>=0;i--) {
    buf.unshift('&#'+str.charCodeAt(i)+';');
  }
  return buf.join('');
};
// html entity -> text
cat.string.fromHtmlEntity = function(entities) {
  return entities.replace(/&#(\d+);/g, function(match, dec) {
    return String.fromCharCode(dec);
  });
};

/* DOM util */
cat.dom = {};

//simple select method
//BY FAR
cat.dom.query = function(selector){
	var result = null;
	function getElementsByClassName(className){
		var elements = [];
		var all = document.getElementsByTagName('*');
		for(var i=0;i<all.length;i++){
			if( all[i].className === className ){
				elements.push(all[i]);
			}
		}
		return elements;
	}

	switch(selector[0]){
		case '#'://id selector
			result = document.getElementById(selector.slice(1));
			return  result == null ? [] : [result];
		case '.'://class selector
			result = getElementsByClassName(selector.slice(1));
			return result == null ? [] : result;
		default://tag selector
			return document.getElementsByTagName(selector);
	}
};

/*
 * get element offset from page
 * @param el The element need to get offset
 */
cat.dom.offset = function(el) {
	var offset = {left:el.offsetLeft,top:el.offsetTop};
	while( el = el.offsetParent ){
		offset.left += el.offsetLeft;
		offset.top += el.offsetTop;
	}
	return offset;
};

/* not finish yet */
//convert unknown(maybe px or number) to px or number
cat.dom.toPx = function(unknown){
	return typeof unknown === 'number' ?
	unknown+'px' : (unknown.indexOf('px') === -1 ? unknown+"px" : unknown);
};
cat.dom.toNum = function(unknown){
	return typeof unknown === 'number' ?
	unknown : (unknown.indexOf('px') === -1 ? +unknown : unknown.slice(0,-2));
};
cat.dom.animate = function(element,properties,duration){
	duration = duration || 1000;
	var interval = 50 , rate = duration/interval;

	var change = function(){
	};

	setInterval(change,interval);
	setTimeout(function(){
		clearInterval(change);
	},rate);

};

/* DEBUG util */
cat.debug = {};
// console log if not in DEBUG mode
cat.DEBUG = true;
cat.debug.log = function(){
  if (cat.DEBUG) {
    console.log.apply(console,arguments);
  }
};


// exports cat in nodejs
try {
  exports.cat = cat;
} catch (err) {
}
