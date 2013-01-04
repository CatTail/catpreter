var cmm = require('./cmm.js').parser;
var source = require('fs').readFileSync('./test.c', "utf8");
var assembles = cmm.parse(source);

function Machine () {
  this.stack = [];
  this.registers = {sp: 0, pc: 0, ac: 0};
  this.memory = [];
  this.symbols = {};
};
Machine.prototype.popStack = function () {
  this.registers.sp--;
  return this.stack.pop();
};
Machine.prototype.pushStack = function (value) {
  this.stack.push(value);
  this.registers.sp++;
};
// load assembles into memory
Machine.prototype.load = function (assembles) {
  this.memory = assembles.slice(0);
};
Machine.prototype.run = function () {
  var that = this;
  that.execute(0);

  var util = require('util');
  console.log(util.inspect(that, false, null));
};
Machine.prototype.execute = function (address) {
  var assemble = this.memory[address];
  this.constructor.instructions[assemble.operator].apply(this, assemble.operands);
};
Machine.prototype.next = function (address) {
  address = address ? address : ++this.registers.pc;
  this.execute(address);
};
Machine.instructions = (function(){
  var isArray = function (identifier) {
    return identifier.indexOf('[') !== -1;
  };
  var parseArray = function (identifier) {
    return {
      id: identifier.slice(0, identifier.indexOf('[')),
      indexes: identifier.match(/(\d+)/g).slice(0)
    };
  };

  var def = function (type, name) {
    var value, arr;
    value = parseFloat(this.popStack());
    if (isArray(type)) {
      this.symbols[name] = {type: type, value: []};
    } else {
      // default to 0
      value = isNaN(value) ? 0 : value;
      this.symbols[name] = {type: type, value: value};
    }
    this.next();
  };
  var ld = function (id) {
    var arr, value;
    if (isArray(id)) {
      arr = parseArray(id);
      // simple treat it as one dimension array
      value = this.symbols[arr.id].value[arr.indexes[0]];
    } else {
      value = this.symbols[id].value;
    }
    this.pushStack(value);
    this.next();
  };
  var st = function (id) {
    var value, arr;
    value  = this.popStack();
    if (isArray(id)) {
      arr = parseArray(id);
      this.symbols[arr.id].value[arr.indexes[0]] = value;
    } else {
      this.symbols[id].value = value;
    }
    this.next();
  };
  var add = function () {
    var first = this.popStack(),
    second = this.popStack();
    this.pushStack(second + first);
    this.next();
  };
  var sub = function () {
    var first = this.popStack(),
    second = this.popStack();
    this.pushStack(second - first);
    this.next();
  };
  var mul = function () {
    var first = this.popStack(),
    second = this.popStack();
    this.pushStack(second * first);
    this.next();
  };
  var div = function () {
    var first = this.popStack(),
    second = this.popStack();
    this.pushStack(second / first);
    this.next();
  };
  var eq = function () {
    var first = this.popStack(),
    second = this.popStack();
    this.pushStack(second === first);
    this.next();
  };
  var neq = function () {
    var first = this.popStack(),
    second = this.popStack();
    this.pushStack(second !== first);
    this.next();
  };
  var lt = function () {
    var first = this.popStack(),
    second = this.popStack();
    this.pushStack(second < first);
    this.next();
  };
  var ja = function (address) {
    this.next(address);
  };
  var jt = function (address) {
    if (this.popStack()) {
      this.next(address);
    } else {
      this.next();
    }
  };
  var jf = function (address) {
    if (!this.popStack()) {
      this.next(address);
    } else {
      this.next();
    }
  };
  var push = function (value) {
    this.pushStack(value);
    this.next();
  };
  var pop = function () {
    this.popStack();
    this.next();
  };
  var read = function () {
    var that = this;
    var readline = require('readline');
    var rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
    });
    rl.question('enter value\n', function (value) {
      that.pushStack(parseFloat(value));
      that.next();
      rl.close();
    });
  };
  var write = function () {
    console.log(this.popStack());
    this.next();
  };
  var label = function () {
    // skip label
    this.next();
  };
  var halt = function () {
  };
  return {
  'def': def,
  'ld': ld,
  'st': st,
  'add': add,
  'sub': sub,
  'mul': mul,
  'div': div,
  'eq': eq,
  'neq': neq,
  'lt': lt,
  'ja': ja,
  'jt': jt,
  'jf': jf,
  'push': push,
  'pop': pop,
  'read': read,
  'write': write,
  'label': label,
  'halt': halt
  };
}());


function Assembler (input) {
  var that = this;
  that.assembles = [];
  that.parseInput(input);
  that.parseLabel();

  var machine = new Machine();
  machine.load(that.assembles);
  machine.run();
};
/**
 * parse input string to array of operators.
 */
Assembler.prototype.parseInput = function (input) {
  var that = this, address = 0;
  input.split('\n').forEach(function (assemble) {
    assemble = assemble.split(/\s+/);
    that.assembles.push({
      operator: assemble[0],
      operands: assemble.slice(1),
      address: address++
    });
  });
};
/**
 * Parse assemble label into address.
 */
Assembler.prototype.parseLabel = function () {
  var that = this;
  that.assembles.forEach(function (assemble) {
    if (assemble.operator === 'label') {
      // replace jump label
      that.assembles.forEach(function (ass) {
        if ((ass.operator === 'ja' ||
             ass.operator === 'jt' ||
             ass.operator === 'jf') &&
             ass.operands[0] === assemble.operands[0]) {
          ass.operands[0] = assemble.address;
        }
      });
    }
  });
};

var assembler = new Assembler(assembles);

exports.Assembler = Assembler;
