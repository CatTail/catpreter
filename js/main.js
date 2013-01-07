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
    url: 'js/sea-modules/catpreter/src/cmm.y',
    success: function (grammar) {
      setBind($('#cmm-grammar')[0], 'data', grammar);
    }
  });
  // cmm lex
  $.ajax({
    url: 'js/sea-modules/catpreter/src/cmm.l',
    success: function (lex) {
      setBind($('#cmm-lex')[0], 'data', lex);
    }
  });
  // cmm test program
  $.ajax({
    url: 'js/sea-modules/catpreter/src/test.c',
    success: function (program) {
      setBind($('#cmm-program')[0], 'data', program);
    }
  });
  // bnf grammar
  $.ajax({
    url: 'js/sea-modules/catpreter/src/bnf.y',
    success: function (grammar) {
      setBind($('#bnf-grammar')[0], 'data', grammar);
    }
  });
  // bnf lex
  $.ajax({
    url: 'js/sea-modules/catpreter/src/bnf.l',
    success: function (lex) {
      setBind($('#bnf-lex')[0], 'data', lex);
    }
  });
  // lex grammar
  $.ajax({
    url: 'js/sea-modules/catpreter/src/lex.y',
    success: function (grammar) {
      setBind($('#lex-grammar')[0], 'data', grammar);
    }
  });
  // lex lex
  $.ajax({
    url: 'js/sea-modules/catpreter/src/lex.l',
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
  $.ajax({
    url: 'js/sea-modules/catpreter/catpreter.js',
    success: function (code) {
      setBind($('#catpreter')[0], 'data', code);
    }
  });
  // assembler
  setBind($('#assembler')[0], 'func', function (assembles) {
    var Assembler = require('catpreter/assembler').Assembler;
    var assembler = new Assembler(assembles);
    return assembler.run();
  });
  $.ajax({
    url: 'js/sea-modules/catpreter/assembler.js',
    success: function (code) {
      setBind($('#assembler')[0], 'data', code);
    }
  });
  // test assembles
  $.ajax({
    url: 'js/sea-modules/catpreter/src/test.ass',
    success: function (assembles) {
      setBind($('#test-assembles')[0], 'data', assembles);
    }
  });
  // CMM compiler
  $.ajax({
    url: 'js/sea-modules/catpreter/src/cmm.js',
    success: function (compiler) {
      setBind($('#cmm-compiler')[0], 'data', compiler);
      var func = compiler + "return parser.parse(input);";
      func = new Function('input', func);
      setBind($('#cmm-compiler')[0], 'func', func);
    },
  });
  // calculator
  $.ajax({
    url: 'js/sea-modules/catpreter/src/calculator.l',
    success: function (lex) {
      setBind($('#calculator-lex')[0], 'data', lex);
    },
  });
  $.ajax({
    url: 'js/sea-modules/catpreter/src/calculator.y',
    success: function (grammar) {
      setBind($('#calculator-grammar')[0], 'data', grammar);
    },
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
    });
    // droppable
    $('.work-holder').droppable({
      tolerance: 'fit',
      drop: function (event, ui) {
        var draggable = ui.draggable;
        var droppable = $(this);
        droppable.append(draggable);
        draggable.css({
          position: 'absolute',
          top: '0',
          left: '0'
        });
      },
    });
    $('.tool-holder').droppable({
      tolerance: 'fit',
      drop: function (event, ui) {
        var draggable = ui.draggable;
        var droppable = $(this);
        droppable.append(draggable);
        draggable.css({
          position: 'absolute',
          top: '0',
          left: '0'
        });
      }
    });

    // show code detail
    $('.code-detail').click(function () {
      var draggable = $(this).parent();
      var header = draggable.children('span').html();
      var body = getBind(draggable[0], 'data');
      util.modal({
        card: draggable[0],
        header: header,
        body: body
      });
    });
  };
  // enable right away
  enableDnD();

  // run program
  $('#run').click(function () {
    // get input arguments
    var args = $('#input .work-holder .card').map(function (index, el) {
      return getBind(el, 'data');
    });
    var program = getBind($('#program .work-holder .card')[0], 'func');
    var output = program.apply(null, args);
    var card = new util.Card('new title', output);
    $('#output .work-holder').append(card);
    enableDnD();
  });
});
