define(function (require, exports) {
  // bind element with data or function with specified interface
  exports.addBind = function (element, interface, data) {
    element.binding ? 0 : element.binding = {};
    element.binding[interface] ?
      element.binding[interface].push(data) : element.binding[interface] = [data];
  };
  exports.setBind = function (element, interface, data) {
    element.binding ? 0 : element.binding = {};
    element.binding[interface] = data;
  };
  exports.getBind = function (element, interface) {
    return element.binding ? element.binding[interface] : undefined;
  };
  // if array, remove exactly data in array
  exports.removeBind = function (element, interface, data) {
    if (Array.isArray(element.binding[interface])) {
      element.binding[interface].splice(element.binding[interface].indexOf(data), 1);
    } else {
      delete element.binding[interface];
    }
  };

  // generate compiler
  exports.genCompiler = function (rawGrammar, lex) {
    var catpreter = require('catpreter/catpreter');

    var grammar = require("catpreter/bnf").parse(rawGrammar);
    var opt = grammar.options || {};
    if (lex) grammar.lex = require("catpreter/catlex").parse(lex);
    if (!opt.moduleType) opt.moduleType = "commonjs";
    if (!opt.moduleName && name) opt.moduleName =
        name.replace(/-\w/g, function (match){ return match.charAt(1).toUpperCase(); });

    var generator = new catpreter.Generator(grammar, opt);
    return generator.generate(opt);
  };

});
