try {
  var cat = require('../lib/catjs/cat.js');
} catch (err) {}

var settings = {
  'ranLen': 6, // random production head name length in parser
  'null': '__undefined__', // string representation of 𝜀
};

try {
  exports.settings = settings;
} catch (err) {}
