#! /bin/bash

./genGrammar.js > output/first.js
./genSymbols.js > output/symbols.js
./modGrammar.js > output/second.js
