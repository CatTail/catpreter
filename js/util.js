define(function (require, exports) {
  // generate compiler
  exports.genCompiler = function (rawGrammar, lex) {
    var catpreter = require('catpreter/catpreter');

    var grammar = require("catpreter/bnf").parse(rawGrammar);
    var opt = grammar.options || {};
    if (lex) grammar.lex = require("catpreter/catlex").parse(lex);
    if (!opt.moduleType) opt.moduleType = "commonjs";
    if (!opt.moduleName && name) opt.moduleName = name.replace(/-\w/g, function (match){ return match.charAt(1).toUpperCase(); });

    var generator = new catpreter.Generator(grammar, opt);
    return generator.generate(opt);
  };

});
