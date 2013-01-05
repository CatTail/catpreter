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

  // load all the template string
  var templates = {};
  exports.loadTemplate = function () {
    // card
    $.ajax({
      url: 'template/card.jade',
      success: function (card) {
        templates.card = jade.compile(card);
      }
    });
    // modal
    /*
    $.ajax({
      url: 'template/modal.jade',
      success: function (modal) {
        templates.modal = jade.compile(modal);
      }
    });
   */
  };
  exports.templates = templates;

  // Card constructor
  exports.Card = function (title, data) {
    var rawCard = exports.templates.card({title: title});
    var card = $(rawCard);
    exports.setBind(card, 'data', data);
    return card;
  };

  // display modal
  exports.modal = function (locals) {
    $('.modal .modal-header .content').html(locals.header);
    $('.modal .modal-body .content').html(locals.body);
    $('.modal').modal();
  };


});
