function Node () {
  this.name = 'Node';
  this.code = null;
  this.childNodes = [];
  this.parentNode = null;
}
Node.prototype.addCode = function (code) {
  this.code += code;
};
Node.prototype.getCode = function () {
  return this.code;
};
Node.prototype.appendChild = function (child) {
  this.childNodes.push(child);
  return this;
};
Node.prototype.toString = function () {
  return this.name + '->' + this.childNodes.join(' ');
};
