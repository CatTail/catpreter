var cmm = require('./cmm.js').parser;
var source = require('fs').readFileSync('./test.c', "utf8");
var assembles = cmm.parse(source);
console.log(assembles);


var instructions = {
};

function Assembler (input) {
  this.parseInput(input);
};
Assembler.prototype.parseInput = function (input) {
  debugger;
  console.log(input.split('\n'));
};

function Machine () {
  this.stack = [];
  this.registers = {};
  this.symbols = {};
};

var assembler = new Assembler(assembles);

exports.Assembler = Assembler;


/*
## virsual machine spec
### assembly instruction
    def   define variable
    ld    load varible value into stack top
    st    store stack top into varible
    add   add top two element in stack,store result in accumulator
    sub   sub top two element in stack,store result in accumulator
    mul   multiple top two element in stack,store result in accumulator
    div   divide top two element in stack,store result in accumulator
    eq    test if top two element in stack are equal
    neq   test if top two element in stack are not equal
    lt    test if top element is little then under element in stack
    ja    change program count in all condition
    jt    change program count if stack top is truly value
    jf    change program count if stack top is falsy value
    push  push value in stack
    pop   pop stack top
    read  standard input
    write standard output
    label define label stand for address
    halt  end of program


### registers
* sp: stack pointer
* pc: program count
* ac: accumulator(deprecated)

### memory
stack
*/

