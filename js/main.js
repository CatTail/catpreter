define(function (require, exports) {
  var util = require('./util');
  var setBind = util.setBind;
  var getBind = util.getBind;
  var removeBind = util.removeBind;

  // load jade template
  util.loadTemplate();

  /* data binding */
  // cmm grammar
  $.ajax({
    url: '/js/sea-modules/catpreter/src/cmm.y',
    success: function (grammar) {
      setBind($('#cmm-grammar')[0], 'data', grammar);
    }
  });
  // cmm lex
  $.ajax({
    url: '/js/sea-modules/catpreter/src/cmm.l',
    success: function (lex) {
      setBind($('#cmm-lex')[0], 'data', lex);
    }
  });
  // cmm test program
  $.ajax({
    url: '/js/sea-modules/catpreter/src/test.c',
    success: function (program) {
      setBind($('#cmm-program')[0], 'data', program);
    }
  });
  // bnf grammar
  $.ajax({
    url: '/js/sea-modules/catpreter/src/bnf.y',
    success: function (grammar) {
      setBind($('#bnf-grammar')[0], 'data', grammar);
    }
  });
  // bnf lex
  $.ajax({
    url: '/js/sea-modules/catpreter/src/bnf.l',
    success: function (lex) {
      setBind($('#bnf-lex')[0], 'data', lex);
    }
  });
  // lex grammar
  $.ajax({
    url: '/js/sea-modules/catpreter/src/lex.y',
    success: function (grammar) {
      setBind($('#lex-grammar')[0], 'data', grammar);
    }
  });
  // lex lex
  $.ajax({
    url: '/js/sea-modules/catpreter/src/lex.l',
    success: function (lex) {
      setBind($('#lex-lex')[0], 'data', lex);
    }
  });
  // catpreter
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
  // catassembler
  setBind($('#catassembler')[0], 'func', function (assembles) {
    var assembler = new require('catpreter/catassembler').Assembler(assembles);
    assembler.run();
  });

  /* Drag and Drop */
  var enableDnD = function(){
    // draggable
    $('.card').draggable({
      snap: '.work-holder, .tool-holder',
      snapMode: 'inner',
      revert: 'invalid',
      handle: '.card',
      cancel: '.card span',
      start: function (event, ui) {
        if (!getBind(this, 'droppable')) return;
        removeBind(getBind(this, 'droppable'), 'draggable', this);
        removeBind(this, 'droppable');
      }
    });
    // droppable
    $('.work-holder').droppable({
      tolerance: 'fit',
      drop: function (event, ui) {
        var draggable = ui.draggable[0];
        var droppable = this;
        setBind(droppable, 'draggable', draggable);
        setBind(draggable, 'droppable', droppable);
      },
    });
    $('.tool-holder').droppable({
      tolerance: 'fit'
    });

    // show code detail
    $('.code-detail').click(function () {
      util.modal({
        header: 'header',
        body: 'body'
      });
    });
  };
  // enable right away
  enableDnD();

  // run program
  $('#run').click(function () {
    // get input arguments
    var input = $('#input .work-holder').map(function (index, el) {
      return getBind(getBind(el, 'draggable'), 'data');
    });
    var program = getBind(getBind($('#program .work-holder')[0], 'draggable'), 'func');
    var output = program.apply(null, input);
    var card = new util.Card('new title', output);
    $('#output .work-holder').append(card);
    enableDnD();
  });
});
