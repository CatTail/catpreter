define(function (require, exports) {
  var util = require('./util');

  var grammar, lex;
  $.when(
    $.ajax({
      url: '/js/sea-modules/catpreter/src/cmm.y',
      success: function (data) {
        grammar = data;
      }
    }),
    $.ajax({
      url: '/js/sea-modules/catpreter/src/cmm.l',
      success: function (data) {
        lex = data;
      }
    })
  ).then(function () {
    console.log(util.genCompiler(grammar, lex));
  });
})
