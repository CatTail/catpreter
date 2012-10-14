var tokenMapping = {
	'DEFAULT': [
		/^\+$/,/^-/,/\*/,/\//,/</,/==/,/<>/,/\[/,/\]/,/=/,//运算符
		/if/,/else/,/while/,/read/,/write/,/int/,/real/,//关键字
		/\(/,/\)/,/;/,/\{/,/\}/,//标点符号
	],
	'ID': [
		/[a-zA-Z]\w*[a-zA-Z0-9]*/,//标识符
	],
	'INT_LITERAL': [
		/\d+/,
	],
	'REAL_LITERAL': [
		/\d+\.\d+(e[-+]?\d+)?/i,//常量
	],
	'WS': [
		/\s+/,//空白字符
	],
	'COMMENT': [
		/\/\//,/\/\*/,/\*\//,//注释
	],

};
var tokens = [];
for(var type in tokenMapping){
	tokens = tokens.concat(tokenMapping[type]);
}

exports.tokenMapping = tokenMapping;
exports.tokens = tokens;
