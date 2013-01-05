define(function (require, exports) {
  var util = require('./util');
  var addBind = util.addBind;
  var setBind = util.setBind;
  var getBind = util.getBind;
  var removeBind = util.removeBind;

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
  // draggable
  $('.card').draggable({
    snap: '.action',
    snapMode: 'inner',
    revert: 'invalid',
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
    $('.modal').modal();
  });

  // execute
  $('#execute').click(function () {
    console.log(getBind($('#cmm-grammar')[0], 'data'));
  });
});
