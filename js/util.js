define(function (require, exports) {
  // bind element with data or function with specified interface
  exports.setBind = function (element, interface, data) {
    element.binding ? 0 : element.binding = {};
    element.binding[interface] = data;
  };
  exports.getBind = function (element, interface) {
    return element && element.binding && element.binding[interface];
  };
  exports.removeBind = function (element, interface, data) {
      delete element.binding[interface];
  };

  // load jade template, store in namespace `templates`
  var templates = {};
  exports.loadTemplate = function () {
    // card
    $.ajax({
      url: 'template/card.jade',
      success: function (card) {
        templates.card = jade.compile(card);
      }
    });
  };
  exports.templates = templates;

  /**
   * @constructor
   * @param {string} title Card title
   * @param {string} data Card binding data
   */
  exports.Card = function (title, data) {
    var card, compiler;
    card = $(exports.templates.card({title: title}))[0];
    exports.setBind(card, 'data', data);
    // try to create compiler if valid
    try {
      compiler = exports.genCompiler(data);
      exports.setBind(card, 'func', compiler);
    } catch (e) {}
    return card;
  };

  // display modal
  exports.modal = function (locals) {
    $('.modal .modal-header .content').html(locals.header);
    var body = $('.modal .modal-body');
    body.empty();
    body.append($('<textarea class="content"></textarea>'));
    $('.modal .modal-body .content').html(locals.body);
    var editor = CodeMirror.fromTextArea($('.modal-body .content')[0], {
      lineNumbers: true,
      mode: 'clike'
    });
    // update on change
    editor.on("change", function (instance, changeObj) {
      exports.setBind(locals.card, 'data', instance.getValue());
    });
    $('.modal').modal();
  };

  /**
   * create compiler using catpreter generated compiler string.
   * @param {string} raw Raw string representation of catpreter generated compiler
   * @return {function(string): string} Function act as compiler, accept string input
   * return string output
   */
  exports.genCompiler = function (raw) {
    var func = raw + "return parser.parse(input);";
    return new Function('input', func);
  };


});
