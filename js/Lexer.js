var tokenMapping = {
	'DEFAULT': [
		/^\+$/,/^-$/,/^\*$/,/^\/$/,/^<$/,/^==$/,/^<>$/,/^\[$/,/^\]$/,/^=$/,//运算符
		/^if$/,/^else$/,/^while$/,/^read$/,/^write$/,/^int$/,/^real$/,//关键字,匹配后需从标识符中取出
		/^\($/,/^\)$/,/^;$/,/^\{$/,/^\}$/,//标点符号
	],
	'ID': [
		/^[a-zA-Z]\w*[a-zA-Z0-9]*$/,//标识符
	],
	'INT_LITERAL': [
		/^\d+$/,
	],
	'REAL_LITERAL': [
		/^\d+\.\d+(e[-+]?\d+)?$/i,//常量
	],
	'WS': [
		/^\s+$/,//空白字符
	],
	'COMMENT': [
		/^\/\/$/,/^\/\*$/,/^\*\/$/,//注释
	],

};
var tokens = [];
for(var type in tokenMapping){
	tokens = tokens.concat(tokenMapping[type]);
}

function Lexer(source){
	var _this = this,
	source = source,
	index = 0,
	buffer = '',
	token = undefined,
	DFA = function(){
		var _this = this,
		buffer = '',
		matches = tokens;

		_this.consume = function(character){
			buffer += character;
			var tmp = [];
			cat.each(matches,function(reg){
				reg.test(buffer) ? tmp.push(reg) : 0;
				reg.lastIndex = 0;
			});
			matches = tmp;
		};

		_this.EOF = function(){
			buffer += '\n';//trick
		};

		_this.pattern = function(){
			buffer = buffer.slice(0,-1);
			var backtrack = [];
			cat.each(tokens,function(reg){
				reg.test(buffer) ? backtrack.push(reg) : 0;
				reg.lastIndex = 0;
			});
			return backtrack[0];
		};

		_this.isEnd = function(){
			return matches.length === 0;
		};
	},
	Token = function(name,value){
		var _this = this;
		_this.name = name;
		_this.value = value;
	};


	//get next token
	_this.__next = function(){
		var dfa = new DFA();
		while (!dfa.isEnd()) {
			if (_this.EOF()) {
				dfa.EOF();
				buffer += '\n';//trick
				index++;
				break;
			}
			dfa.consume(source[index]);
			buffer += source[index];
			index++;
		}
		//backtrack
		index--;
		buffer = buffer.slice(0,-1);
		token = undefined;
		if (buffer !== '') {
			var pattern = dfa.pattern();
			for (var type in tokenMapping) {
				cat.each(tokenMapping[type],function(reg){
					reg.toString() === pattern.toString() ?
						token = new Token(type,buffer) : 0;
				});
			}
		}
		buffer = '';
		return token;
	};
	
	_this.hasNext = function(){
		return token !== undefined;
	};
	_this.next = function(){
		return _this.__next();
	};
	_this.EOF = function(){
		return index === source.length;
	};
}
