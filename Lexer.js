var tokens = require('./tokens').tokens;
var Cat = require('./cat').Cat;

function Lexer(source){
	var _this = this,
	source = source,
	tokenStart = 0,
	tokenEnd = 0,
	index = 0,
	buffer = '';

	_this.hasNext = function(){
		for(var i=0;i<5;i++){
			buffer += source[index];
			index++;
			var backtrack = undefined;
			var matches = tokens;
			while (matches.length!==0) {
				backtrack = matches;
				var tmp = [];
				Cat.each(matches,function(reg){
					reg.test(buffer) ? tmp.push(reg) : 0;
					reg.lastIndex = 0;
					debugger;
				});
				matches = tmp;
				console.log(matches);
			}
			buffer = '';
		}
	};
	_this.next = function(){
	};

}

exports.Lexer = Lexer;
