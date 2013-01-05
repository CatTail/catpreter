define(function (require, exports) {
  var util = require('./util');
  var addBind = util.addBind;
  var setBind = util.setBind;
  var getBind = util.getBind;
  var removeBind = util.removeBind;
  // load jade template
  util.loadTemplate();
  var templates = util.templates;

  // data binding
  $.ajax({
    url: '/js/sea-modules/catpreter/src/cmm.y',
    success: function (grammar) {
      setBind($('#cmm-grammar')[0], 'data', grammar);
    }
  });
  $.ajax({
    url: '/js/sea-modules/catpreter/src/cmm.l',
    success: function (lex) {
      setBind($('#cmm-lex')[0], 'data', lex);
    }
  })
  setBind($('#catpreter')[0], 'func', function (grammar, lex) {
    var catpreter = require('catpreter/catpreter');
    var grammar = require("catpreter/bnf").parse(grammar);
    var opt = grammar.options || {};
    if (lex) grammar.lex = require("catpreter/catlex").parse(lex);
    if (!opt.moduleType) opt.moduleType = "commonjs";
    if (!opt.moduleName && name) opt.moduleName =
        name.replace(/-\w/g, function (match){ return match.charAt(1).toUpperCase(); });

      var generator = new catpreter.Generator(grammar, opt);
      return generator.generate(opt);
  });

  var enableDnD = function(){
    // draggable
    $('.card').draggable({
      snap: '.action',
      snapMode: 'inner',
      revert: 'invalid',
      handle: '.card',
      cancel: '.card p',
      start: function (event, ui) {
        if (!getBind(this, 'droppable')) return;
        removeBind(getBind(this, 'droppable'), 'args', this);
        removeBind(this, 'droppable');
      }
    });
    // droppable
    $('.action').droppable({
      drop: function (event, ui) {
        var draggable = ui.draggable[0];
        var droppable = this;
        addBind(droppable, 'args', draggable);
        setBind(draggable, 'droppable', droppable);
      },
    });
    $('#toolbox').droppable({});

    // show code detail
    $('.code-detail').click(function () {
      util.modal({
        header: 'header',
        body: 'body'
      });
    });
  };
  enableDnD();

  // execute
  $('#execute').click(function () {
    var card = templates.card({id: 'id', title: 'title'});
    $('#output').append($(card));
    console.log(card);
    enableDnD();
    var args = getBind($('#input')[0], 'args').map(function (el) {
      return getBind(el, 'data');
    });
    var compiler = getBind(getBind($('#program')[0], 'args')[0], 'func').apply(null, args);
  });

});
