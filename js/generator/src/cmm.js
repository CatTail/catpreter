/* Catpreter generated parser */
var cmm = (function(){
var parser = {trace: function trace() { },
yy: {},
symbols_: {"error":2,"prog":3,"statement_list":4,"EOF":5,"statement":6,"compound_statement":7,"expression_statement":8,"selection_statement":9,"iteration_statement":10,"declaration":11,"empty_compound_statement":12,"wrapped_compound_statement":13,"{":14,"}":15,"if_statement":16,"if_else_statement":17,"if":18,"(":19,"expression":20,")":21,"else":22,"while":23,"empty_expression_statement":24,"ended_expression_statement":25,"write_expression_statement":26,"read_expression_statement":27,";":28,"write":29,"read":30,"IDENTIFIER":31,"declarator_specifiers":32,"assignment_expression":33,",":34,"equality_expression":35,"unary_expression":36,"assignment_operator":37,"=":38,"+=":39,"-=":40,"*=":41,"/=":42,"relational_expression":43,"equality_operator":44,"==":45,"<>":46,"additive_expression":47,"<":48,"multiplicative_expression":49,"+":50,"-":51,"*":52,"/":53,"postfix_expression":54,"minus_unary_expression":55,"primary_expression":56,"[":57,"]":58,"INT_LITERAL":59,"REAL_LITERAL":60,"init_declarator_list":61,"int":62,"real":63,"init_declarator":64,"simple_declarator":65,"inited_declarator":66,"declarator":67,"initializer":68,"constant_expression":69,"$accept":0,"$end":1},
terminals_: {2:"error",5:"EOF",14:"{",15:"}",18:"if",19:"(",21:")",22:"else",23:"while",28:";",29:"write",30:"read",31:"IDENTIFIER",34:",",38:"=",39:"+=",40:"-=",41:"*=",42:"/=",45:"==",46:"<>",48:"<",50:"+",51:"-",52:"*",53:"/",57:"[",58:"]",59:"INT_LITERAL",60:"REAL_LITERAL",62:"int",63:"real"},
productions_: [0,[3,2],[4,1],[4,2],[6,1],[6,1],[6,1],[6,1],[6,1],[7,1],[7,1],[12,2],[13,3],[9,1],[9,1],[16,5],[17,7],[10,5],[8,1],[8,1],[8,1],[8,1],[24,1],[25,2],[26,3],[27,3],[20,1],[20,3],[33,1],[33,3],[37,1],[37,1],[37,1],[37,1],[37,1],[35,1],[35,3],[44,1],[44,1],[43,1],[43,3],[47,1],[47,3],[47,3],[49,1],[49,3],[49,3],[36,1],[36,2],[36,1],[55,2],[54,1],[54,4],[56,1],[56,1],[56,1],[56,3],[11,3],[32,1],[32,1],[61,1],[61,3],[64,1],[64,1],[65,1],[66,3],[67,1],[67,4],[69,1],[68,1]],
performAction: function anonymous(yytext,yyleng,yylineno,yy,yystate,$$,_$) {

var $0 = $$.length - 1;
switch (yystate) {
case 1:this.$=$$[$0-1];console.log(util.inspect(this.$, false, null));
break;
case 2:this.$=new g.StatementList($$[$0]);
break;
case 3:this.$=$$[$0-1].appendChild($$[$0]);
break;
case 4:this.$=$$[$0];
break;
case 5:this.$=$$[$0];
break;
case 6:this.$=$$[$0];
break;
case 7:this.$=$$[$0];
break;
case 8:this.$=$$[$0];
break;
case 9:this.$=$$[$0];
break;
case 10:this.$=$$[$0];
break;
case 11:this.$=new g.EmptyCompoundStatement();
break;
case 12:this.$=new g.WrappedCompoundStatement($$[$0-2]);
break;
case 13:this.$=$$[$0];
break;
case 14:this.$=$$[$0];
break;
case 15:this.$=new g.IfStatement($$[$0-2], $$[$0]);
break;
case 16:this.$=new g.IfElseStatement($$[$0-4], $$[$0-2], $$[$0]);
break;
case 17:this.$=new g.WhileStatement($$[$0-2], $$[$0]);
break;
case 18:this.$=$$[$0];
break;
case 19:this.$=$$[$0];
break;
case 20:this.$=$$[$0];
break;
case 21:this.$=$$[$0];
break;
case 22:this.$=new g.EmptyExpressionStatement();
break;
case 23:this.$=new g.EndedExpressionStatement($$[$0-1]);
break;
case 24:this.$=new g.WriteExpressionStatement($$[$0-1]);
break;
case 25:this.$=new g.ReadExpressionStatement($$[$0-1], $$[$0]);
break;
case 26:this.$=new g.Expression($$[$0]);
break;
case 27:this.$=$$[$0-2].appendChild($$[$0]);
break;
case 28:this.$=$$[$0];
break;
case 29:this.$=new g.AssignmentExpression($$[$0-2], $$[$0-1], $$[$0]);
break;
case 30:this.$=$$[$0];
break;
case 31:this.$=$$[$0];
break;
case 32:this.$=$$[$0];
break;
case 33:this.$=$$[$0];
break;
case 34:this.$=$$[$0];
break;
case 35:this.$=$$[$0];
break;
case 36:this.$=new g.EqualityExpression($$[$0-2], $$[$0-1], $$[$0]);
break;
case 37:this.$=$$[$0];
break;
case 38:this.$=$$[$0];
break;
case 39:this.$=$$[$0];
break;
case 40:this.$=new g.RealtionalExpression($$[$0-2], $$[$0]);
break;
case 41:this.$=$$[$0];
break;
case 42:this.$=new g.AdditveExpression($$[$0-2], $$[$0-1], $$[$0]);
break;
case 43:this.$=new g.AdditveExpression($$[$0-2], $$[$0-1], $$[$0]);
break;
case 44:this.$=$$[$0];
break;
case 45:this.$=new g.MultiplicativeExpression($$[$0-2], $$[$0-1], $$[$0]);
break;
case 46:this.$=new g.MultiplicativeExpression($$[$0-2], $$[$0-1], $$[$0]);
break;
case 47:this.$=$$[$0];
break;
case 48:this.$=$$[$0-1];
break;
case 49:this.$=$$[$0];
break;
case 50:this.$=new g.MinusUnaryExpression($$[$0]);
break;
case 51:this.$=$$[$0];
break;
case 52:this.$=$$[$0-3].addPostfix($$[$0-1]);
break;
case 53:this.$=new g.IntLiteral($$[$0]);
break;
case 54:this.$=new g.RealLiteral($$[$0]);
break;
case 55:this.$=new g.Identifier($$[$0]);
break;
case 56:this.$=new PrimaryExpression($$[$0-1]);
break;
case 57:this.$=new g.Declaration($$[$0-2], $$[$0-1]);
break;
case 58:this.$=$$[$0];
break;
case 59:this.$=$$[$0];
break;
case 60:this.$=new g.InitDeclaratorList($$[$0]);
break;
case 61:this.$=$$[$0-2].appendChild($$[$0]);
break;
case 62:this.$=$$[$0];
break;
case 63:this.$=$$[$0];
break;
case 64:this.$=$$[$0];
break;
case 65:this.$=new g.InitedDeclarator($$[$0-2], $$[$0]);
break;
case 66:this.$=new g.Identifier($$[$0]);
break;
case 67:this.$=$$[$0-3].addPostfix($$[$0-1]);
break;
case 68:this.$=$$[$0];
break;
case 69:this.$=$$[$0];
break;
}
},
table: [{3:1,4:2,6:3,7:4,8:5,9:6,10:7,11:8,12:9,13:10,14:[1,19],16:15,17:16,18:[1,24],19:[1,41],20:21,23:[1,17],24:11,25:12,26:13,27:14,28:[1,20],29:[1,22],30:[1,23],31:[1,36],32:18,33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],62:[1,25],63:[1,26]},{1:[3]},{5:[1,42],6:43,7:4,8:5,9:6,10:7,11:8,12:9,13:10,14:[1,19],16:15,17:16,18:[1,24],19:[1,41],20:21,23:[1,17],24:11,25:12,26:13,27:14,28:[1,20],29:[1,22],30:[1,23],31:[1,36],32:18,33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],62:[1,25],63:[1,26]},{5:[2,2],14:[2,2],15:[2,2],18:[2,2],19:[2,2],23:[2,2],28:[2,2],29:[2,2],30:[2,2],31:[2,2],50:[2,2],51:[2,2],59:[2,2],60:[2,2],62:[2,2],63:[2,2]},{5:[2,4],14:[2,4],15:[2,4],18:[2,4],19:[2,4],22:[2,4],23:[2,4],28:[2,4],29:[2,4],30:[2,4],31:[2,4],50:[2,4],51:[2,4],59:[2,4],60:[2,4],62:[2,4],63:[2,4]},{5:[2,5],14:[2,5],15:[2,5],18:[2,5],19:[2,5],22:[2,5],23:[2,5],28:[2,5],29:[2,5],30:[2,5],31:[2,5],50:[2,5],51:[2,5],59:[2,5],60:[2,5],62:[2,5],63:[2,5]},{5:[2,6],14:[2,6],15:[2,6],18:[2,6],19:[2,6],22:[2,6],23:[2,6],28:[2,6],29:[2,6],30:[2,6],31:[2,6],50:[2,6],51:[2,6],59:[2,6],60:[2,6],62:[2,6],63:[2,6]},{5:[2,7],14:[2,7],15:[2,7],18:[2,7],19:[2,7],22:[2,7],23:[2,7],28:[2,7],29:[2,7],30:[2,7],31:[2,7],50:[2,7],51:[2,7],59:[2,7],60:[2,7],62:[2,7],63:[2,7]},{5:[2,8],14:[2,8],15:[2,8],18:[2,8],19:[2,8],22:[2,8],23:[2,8],28:[2,8],29:[2,8],30:[2,8],31:[2,8],50:[2,8],51:[2,8],59:[2,8],60:[2,8],62:[2,8],63:[2,8]},{5:[2,9],14:[2,9],15:[2,9],18:[2,9],19:[2,9],22:[2,9],23:[2,9],28:[2,9],29:[2,9],30:[2,9],31:[2,9],50:[2,9],51:[2,9],59:[2,9],60:[2,9],62:[2,9],63:[2,9]},{5:[2,10],14:[2,10],15:[2,10],18:[2,10],19:[2,10],22:[2,10],23:[2,10],28:[2,10],29:[2,10],30:[2,10],31:[2,10],50:[2,10],51:[2,10],59:[2,10],60:[2,10],62:[2,10],63:[2,10]},{5:[2,18],14:[2,18],15:[2,18],18:[2,18],19:[2,18],22:[2,18],23:[2,18],28:[2,18],29:[2,18],30:[2,18],31:[2,18],50:[2,18],51:[2,18],59:[2,18],60:[2,18],62:[2,18],63:[2,18]},{5:[2,19],14:[2,19],15:[2,19],18:[2,19],19:[2,19],22:[2,19],23:[2,19],28:[2,19],29:[2,19],30:[2,19],31:[2,19],50:[2,19],51:[2,19],59:[2,19],60:[2,19],62:[2,19],63:[2,19]},{5:[2,20],14:[2,20],15:[2,20],18:[2,20],19:[2,20],22:[2,20],23:[2,20],28:[2,20],29:[2,20],30:[2,20],31:[2,20],50:[2,20],51:[2,20],59:[2,20],60:[2,20],62:[2,20],63:[2,20]},{5:[2,21],14:[2,21],15:[2,21],18:[2,21],19:[2,21],22:[2,21],23:[2,21],28:[2,21],29:[2,21],30:[2,21],31:[2,21],50:[2,21],51:[2,21],59:[2,21],60:[2,21],62:[2,21],63:[2,21]},{5:[2,13],14:[2,13],15:[2,13],18:[2,13],19:[2,13],22:[2,13],23:[2,13],28:[2,13],29:[2,13],30:[2,13],31:[2,13],50:[2,13],51:[2,13],59:[2,13],60:[2,13],62:[2,13],63:[2,13]},{5:[2,14],14:[2,14],15:[2,14],18:[2,14],19:[2,14],22:[2,14],23:[2,14],28:[2,14],29:[2,14],30:[2,14],31:[2,14],50:[2,14],51:[2,14],59:[2,14],60:[2,14],62:[2,14],63:[2,14]},{19:[1,44]},{31:[1,50],61:45,64:46,65:47,66:48,67:49},{4:52,6:3,7:4,8:5,9:6,10:7,11:8,12:9,13:10,14:[1,19],15:[1,51],16:15,17:16,18:[1,24],19:[1,41],20:21,23:[1,17],24:11,25:12,26:13,27:14,28:[1,20],29:[1,22],30:[1,23],31:[1,36],32:18,33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],62:[1,25],63:[1,26]},{5:[2,22],14:[2,22],15:[2,22],18:[2,22],19:[2,22],22:[2,22],23:[2,22],28:[2,22],29:[2,22],30:[2,22],31:[2,22],50:[2,22],51:[2,22],59:[2,22],60:[2,22],62:[2,22],63:[2,22]},{28:[1,53],34:[1,54]},{19:[1,41],20:55,31:[1,36],33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{31:[1,56]},{19:[1,57]},{5:[2,58],14:[2,58],15:[2,58],18:[2,58],19:[2,58],22:[2,58],23:[2,58],28:[2,58],29:[2,58],30:[2,58],31:[2,58],50:[2,58],51:[2,58],59:[2,58],60:[2,58],62:[2,58],63:[2,58]},{5:[2,59],14:[2,59],15:[2,59],18:[2,59],19:[2,59],22:[2,59],23:[2,59],28:[2,59],29:[2,59],30:[2,59],31:[2,59],50:[2,59],51:[2,59],59:[2,59],60:[2,59],62:[2,59],63:[2,59]},{21:[2,26],28:[2,26],34:[2,26],58:[2,26]},{21:[2,28],28:[2,28],34:[2,28],44:58,45:[1,59],46:[1,60],58:[2,28]},{21:[2,44],28:[2,44],34:[2,44],37:61,38:[1,62],39:[1,63],40:[1,64],41:[1,65],42:[1,66],45:[2,44],46:[2,44],48:[2,44],50:[2,44],51:[2,44],52:[2,44],53:[2,44],58:[2,44]},{21:[2,35],28:[2,35],34:[2,35],45:[2,35],46:[2,35],48:[1,67],58:[2,35]},{21:[2,47],28:[2,47],34:[2,47],38:[2,47],39:[2,47],40:[2,47],41:[2,47],42:[2,47],45:[2,47],46:[2,47],48:[2,47],50:[2,47],51:[2,47],52:[2,47],53:[2,47],58:[2,47]},{19:[1,41],31:[1,36],36:68,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{21:[2,49],28:[2,49],34:[2,49],38:[2,49],39:[2,49],40:[2,49],41:[2,49],42:[2,49],45:[2,49],46:[2,49],48:[2,49],50:[2,49],51:[2,49],52:[2,49],53:[2,49],58:[2,49]},{21:[2,39],28:[2,39],34:[2,39],45:[2,39],46:[2,39],48:[2,39],50:[1,69],51:[1,70],58:[2,39]},{21:[2,51],28:[2,51],34:[2,51],38:[2,51],39:[2,51],40:[2,51],41:[2,51],42:[2,51],45:[2,51],46:[2,51],48:[2,51],50:[2,51],51:[2,51],52:[2,51],53:[2,51],58:[2,51]},{21:[2,55],28:[2,55],34:[2,55],38:[2,55],39:[2,55],40:[2,55],41:[2,55],42:[2,55],45:[2,55],46:[2,55],48:[2,55],50:[2,55],51:[2,55],52:[2,55],53:[2,55],57:[1,71],58:[2,55]},{19:[1,41],31:[1,36],36:72,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{21:[2,41],28:[2,41],34:[2,41],45:[2,41],46:[2,41],48:[2,41],50:[2,41],51:[2,41],52:[1,73],53:[1,74],58:[2,41]},{21:[2,53],28:[2,53],34:[2,53],38:[2,53],39:[2,53],40:[2,53],41:[2,53],42:[2,53],45:[2,53],46:[2,53],48:[2,53],50:[2,53],51:[2,53],52:[2,53],53:[2,53],58:[2,53]},{21:[2,54],28:[2,54],34:[2,54],38:[2,54],39:[2,54],40:[2,54],41:[2,54],42:[2,54],45:[2,54],46:[2,54],48:[2,54],50:[2,54],51:[2,54],52:[2,54],53:[2,54],58:[2,54]},{19:[1,41],20:75,31:[1,36],33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{1:[2,1]},{5:[2,3],14:[2,3],15:[2,3],18:[2,3],19:[2,3],23:[2,3],28:[2,3],29:[2,3],30:[2,3],31:[2,3],50:[2,3],51:[2,3],59:[2,3],60:[2,3],62:[2,3],63:[2,3]},{19:[1,41],20:76,31:[1,36],33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{28:[1,77],34:[1,78]},{28:[2,60],34:[2,60]},{28:[2,62],34:[2,62]},{28:[2,63],34:[2,63]},{28:[2,64],34:[2,64],38:[1,79]},{28:[2,66],34:[2,66],38:[2,66],57:[1,80]},{5:[2,11],14:[2,11],15:[2,11],18:[2,11],19:[2,11],22:[2,11],23:[2,11],28:[2,11],29:[2,11],30:[2,11],31:[2,11],50:[2,11],51:[2,11],59:[2,11],60:[2,11],62:[2,11],63:[2,11]},{6:43,7:4,8:5,9:6,10:7,11:8,12:9,13:10,14:[1,19],15:[1,81],16:15,17:16,18:[1,24],19:[1,41],20:21,23:[1,17],24:11,25:12,26:13,27:14,28:[1,20],29:[1,22],30:[1,23],31:[1,36],32:18,33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],62:[1,25],63:[1,26]},{5:[2,23],14:[2,23],15:[2,23],18:[2,23],19:[2,23],22:[2,23],23:[2,23],28:[2,23],29:[2,23],30:[2,23],31:[2,23],50:[2,23],51:[2,23],59:[2,23],60:[2,23],62:[2,23],63:[2,23]},{19:[1,41],31:[1,36],33:82,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{28:[1,83],34:[1,54]},{32:84,62:[1,25],63:[1,26]},{19:[1,41],20:85,31:[1,36],33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{19:[1,41],31:[1,36],36:87,43:86,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{19:[2,37],31:[2,37],50:[2,37],51:[2,37],59:[2,37],60:[2,37]},{19:[2,38],31:[2,38],50:[2,38],51:[2,38],59:[2,38],60:[2,38]},{19:[1,41],31:[1,36],33:88,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{19:[2,30],31:[2,30],50:[2,30],51:[2,30],59:[2,30],60:[2,30]},{19:[2,31],31:[2,31],50:[2,31],51:[2,31],59:[2,31],60:[2,31]},{19:[2,32],31:[2,32],50:[2,32],51:[2,32],59:[2,32],60:[2,32]},{19:[2,33],31:[2,33],50:[2,33],51:[2,33],59:[2,33],60:[2,33]},{19:[2,34],31:[2,34],50:[2,34],51:[2,34],59:[2,34],60:[2,34]},{19:[1,41],31:[1,36],36:87,47:89,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{21:[2,48],28:[2,48],34:[2,48],38:[2,48],39:[2,48],40:[2,48],41:[2,48],42:[2,48],45:[2,48],46:[2,48],48:[2,48],50:[2,48],51:[2,48],52:[2,48],53:[2,48],58:[2,48]},{19:[1,41],31:[1,36],36:87,49:90,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{19:[1,41],31:[1,36],36:87,49:91,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{19:[1,41],20:92,31:[1,36],33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{21:[2,50],28:[2,50],34:[2,50],38:[2,50],39:[2,50],40:[2,50],41:[2,50],42:[2,50],45:[2,50],46:[2,50],48:[2,50],50:[2,50],51:[2,50],52:[2,50],53:[2,50],58:[2,50]},{19:[1,41],31:[1,36],36:93,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{19:[1,41],31:[1,36],36:94,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40]},{21:[1,95],34:[1,54]},{21:[1,96],34:[1,54]},{5:[2,57],14:[2,57],15:[2,57],18:[2,57],19:[2,57],22:[2,57],23:[2,57],28:[2,57],29:[2,57],30:[2,57],31:[2,57],50:[2,57],51:[2,57],59:[2,57],60:[2,57],62:[2,57],63:[2,57]},{31:[1,50],64:97,65:47,66:48,67:49},{19:[1,41],31:[1,36],33:99,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],68:98},{19:[1,41],31:[1,36],35:101,36:87,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],69:100},{5:[2,12],14:[2,12],15:[2,12],18:[2,12],19:[2,12],22:[2,12],23:[2,12],28:[2,12],29:[2,12],30:[2,12],31:[2,12],50:[2,12],51:[2,12],59:[2,12],60:[2,12],62:[2,12],63:[2,12]},{21:[2,27],28:[2,27],34:[2,27],58:[2,27]},{5:[2,24],14:[2,24],15:[2,24],18:[2,24],19:[2,24],22:[2,24],23:[2,24],28:[2,24],29:[2,24],30:[2,24],31:[2,24],50:[2,24],51:[2,24],59:[2,24],60:[2,24],62:[2,24],63:[2,24]},{5:[2,25],14:[2,25],15:[2,25],18:[2,25],19:[2,25],22:[2,25],23:[2,25],28:[2,25],29:[2,25],30:[2,25],31:[2,25],50:[2,25],51:[2,25],59:[2,25],60:[2,25],62:[2,25],63:[2,25]},{21:[1,102],34:[1,54]},{21:[2,36],28:[2,36],34:[2,36],45:[2,36],46:[2,36],48:[1,67],58:[2,36]},{21:[2,44],28:[2,44],34:[2,44],45:[2,44],46:[2,44],48:[2,44],50:[2,44],51:[2,44],52:[2,44],53:[2,44],58:[2,44]},{21:[2,29],28:[2,29],34:[2,29],58:[2,29]},{21:[2,40],28:[2,40],34:[2,40],45:[2,40],46:[2,40],48:[2,40],50:[1,69],51:[1,70],58:[2,40]},{21:[2,42],28:[2,42],34:[2,42],45:[2,42],46:[2,42],48:[2,42],50:[2,42],51:[2,42],52:[1,73],53:[1,74],58:[2,42]},{21:[2,43],28:[2,43],34:[2,43],45:[2,43],46:[2,43],48:[2,43],50:[2,43],51:[2,43],52:[1,73],53:[1,74],58:[2,43]},{34:[1,54],58:[1,103]},{21:[2,45],28:[2,45],34:[2,45],45:[2,45],46:[2,45],48:[2,45],50:[2,45],51:[2,45],52:[2,45],53:[2,45],58:[2,45]},{21:[2,46],28:[2,46],34:[2,46],45:[2,46],46:[2,46],48:[2,46],50:[2,46],51:[2,46],52:[2,46],53:[2,46],58:[2,46]},{21:[2,56],28:[2,56],34:[2,56],38:[2,56],39:[2,56],40:[2,56],41:[2,56],42:[2,56],45:[2,56],46:[2,56],48:[2,56],50:[2,56],51:[2,56],52:[2,56],53:[2,56],58:[2,56]},{6:104,7:4,8:5,9:6,10:7,11:8,12:9,13:10,14:[1,19],16:15,17:16,18:[1,24],19:[1,41],20:21,23:[1,17],24:11,25:12,26:13,27:14,28:[1,20],29:[1,22],30:[1,23],31:[1,36],32:18,33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],62:[1,25],63:[1,26]},{28:[2,61],34:[2,61]},{28:[2,65],34:[2,65]},{28:[2,69],34:[2,69]},{58:[1,105]},{44:58,45:[1,59],46:[1,60],58:[2,68]},{6:106,7:4,8:5,9:6,10:7,11:8,12:9,13:10,14:[1,19],16:15,17:16,18:[1,24],19:[1,41],20:21,23:[1,17],24:11,25:12,26:13,27:14,28:[1,20],29:[1,22],30:[1,23],31:[1,36],32:18,33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],62:[1,25],63:[1,26]},{21:[2,52],28:[2,52],34:[2,52],38:[2,52],39:[2,52],40:[2,52],41:[2,52],42:[2,52],45:[2,52],46:[2,52],48:[2,52],50:[2,52],51:[2,52],52:[2,52],53:[2,52],58:[2,52]},{5:[2,17],14:[2,17],15:[2,17],18:[2,17],19:[2,17],22:[2,17],23:[2,17],28:[2,17],29:[2,17],30:[2,17],31:[2,17],50:[2,17],51:[2,17],59:[2,17],60:[2,17],62:[2,17],63:[2,17]},{28:[2,67],34:[2,67],38:[2,67]},{5:[2,15],14:[2,15],15:[2,15],18:[2,15],19:[2,15],22:[1,107],23:[2,15],28:[2,15],29:[2,15],30:[2,15],31:[2,15],50:[2,15],51:[2,15],59:[2,15],60:[2,15],62:[2,15],63:[2,15]},{6:108,7:4,8:5,9:6,10:7,11:8,12:9,13:10,14:[1,19],16:15,17:16,18:[1,24],19:[1,41],20:21,23:[1,17],24:11,25:12,26:13,27:14,28:[1,20],29:[1,22],30:[1,23],31:[1,36],32:18,33:27,35:28,36:29,43:30,47:34,49:38,50:[1,32],51:[1,37],54:31,55:33,56:35,59:[1,39],60:[1,40],62:[1,25],63:[1,26]},{5:[2,16],14:[2,16],15:[2,16],18:[2,16],19:[2,16],22:[2,16],23:[2,16],28:[2,16],29:[2,16],30:[2,16],31:[2,16],50:[2,16],51:[2,16],59:[2,16],60:[2,16],62:[2,16],63:[2,16]}],
defaultActions: {42:[2,1]},
parseError: function parseError(str, hash) {
    throw new Error(str);
  },
parse: function parse(input) {
    var self = this,
    stack = [0],
    vstack = [null], // semantic value stack
    lstack = [], // location stack
    table = this.table,
    yytext = '', // store lexer match text
    yylineno = 0, // lexer current line number
    yyleng = 0, // lexer match pattern length
    recovering = 0,
    TERROR = 2,
    EOF = 1;

    //this.reductionCount = this.shiftCount = 0;

    this.lexer.setInput(input);
    this.lexer.yy = this.yy;
    this.yy.lexer = this.lexer;
    this.yy.parser = this;
    if (typeof this.lexer.yylloc == 'undefined')
      this.lexer.yylloc = {};
    var yyloc = this.lexer.yylloc;
    lstack.push(yyloc);

    var ranges = this.lexer.options && this.lexer.options.ranges;

    if (typeof this.yy.parseError === 'function')
      this.parseError = this.yy.parseError;

    function popStack (n) {
      stack.length = stack.length - 2*n;
      vstack.length = vstack.length - n;
      lstack.length = lstack.length - n;
    }

    function lex() {
      var token;
      token = self.lexer.lex() || 1; // $end = 1
      // if token isn't its numeric value, convert
      if (typeof token !== 'number') {
        token = self.symbols_[token] || token;
      }
      return token;
    }

    var symbol, preErrorSymbol, state, action, a, r, yyval={},p,len,newState, expected;
    while (true) {
      // retreive state number from top of stack
      state = stack[stack.length-1];

      // use default actions if available
      if (this.defaultActions[state]) {
        action = this.defaultActions[state];
      } else {
        if (symbol === null || typeof symbol == 'undefined') {
          symbol = lex();
        }
        // read action for current state and first input
        action = table[state] && table[state][symbol];
      }

      // CATTAIL: error recover
      // handle parse error
      _handle_error:
        if (typeof action === 'undefined' || !action.length || !action[0]) {

        var errStr = '';
        if (!recovering) {
          // Report error
          expected = [];
          for (p in table[state]) if (this.terminals_[p] && p > 2) {
            expected.push("'"+this.terminals_[p]+"'");
          }
          if (this.lexer.showPosition) {
            errStr = 'Parse error on line '+(yylineno+1)+":\n"+this.lexer.showPosition()+"\nExpecting "+expected.join(', ') + ", got '" + (this.terminals_[symbol] || symbol)+ "'";
          } else {
            errStr = 'Parse error on line '+(yylineno+1)+": Unexpected " +
              (symbol == 1 /*EOF*/ ? "end of input" :
               ("'"+(this.terminals_[symbol] || symbol)+"'"));
          }
          this.parseError(errStr,
                          {text: this.lexer.match, token: this.terminals_[symbol] || symbol, line: this.lexer.yylineno, loc: yyloc, expected: expected});
        }

        // just recovered from another error
        if (recovering == 3) {
          if (symbol == EOF) {
            throw new Error(errStr || 'Parsing halted.');
          }

          // discard current lookahead and grab another
          yyleng = this.lexer.yyleng;
          yytext = this.lexer.yytext;
          yylineno = this.lexer.yylineno;
          yyloc = this.lexer.yylloc;
          symbol = lex();
        }

        // try to recover from error
        while (1) {
          // check for error recovery rule in this state
          if ((TERROR.toString()) in table[state]) {
            break;
          }
          if (state === 0) {
            throw new Error(errStr || 'Parsing halted.');
          }
          popStack(1);
          state = stack[stack.length-1];
        }

        preErrorSymbol = symbol == 2 ? null : symbol; // save the lookahead token
        symbol = TERROR;         // insert generic error symbol as new lookahead
        state = stack[stack.length-1];
        action = table[state] && table[state][TERROR];
        recovering = 3; // allow 3 real symbols to be shifted before reporting a new error
      }

      // this shouldn't happen, unless resolve defaults are off
      if (action[0] instanceof Array && action.length > 1) {
        throw new Error('Parse Error: multiple actions possible at state: '+state+', token: '+symbol);
      }
     
      switch (action[0]) {

        case 1: // shift
          //this.shiftCount++;
          stack.push(symbol);
          vstack.push(this.lexer.yytext);
          lstack.push(this.lexer.yylloc);
          stack.push(action[1]); // push state
          symbol = null;
          if (!preErrorSymbol) { // normal execution/no error
            yyleng = this.lexer.yyleng;
            yytext = this.lexer.yytext;
            yylineno = this.lexer.yylineno;
            yyloc = this.lexer.yylloc;
            if (recovering > 0)
              recovering--;
          } else { // error just occurred, resume old lookahead f/ before error
            symbol = preErrorSymbol;
            preErrorSymbol = null;
          }
          break;

        case 2: // reduce
          //this.reductionCount++;
          len = this.productions_[action[1]][1];
          // perform semantic action
          yyval.$ = vstack[vstack.length-len]; // default to $$ = $1
          // default location, uses first token for firsts, last for lasts
          yyval._$ = {
            first_line: lstack[lstack.length-(len||1)].first_line,
            last_line: lstack[lstack.length-1].last_line,
            first_column: lstack[lstack.length-(len||1)].first_column,
            last_column: lstack[lstack.length-1].last_column
          };
          if (ranges) {
            yyval._$.range = [lstack[lstack.length-(len||1)].range[0], lstack[lstack.length-1].range[1]];
          }
          
          r = this.performAction.call(yyval, yytext, yyleng, yylineno, this.yy, action[1], vstack, lstack);

          if (typeof r !== 'undefined') {
            return r;
          }

          // pop off stack
          if (len) {
            // CATTAIL: Don't think there are any need to push symbol into stack.
            // Only state are needed.
            stack = stack.slice(0,-1*len*2);
            vstack = vstack.slice(0, -1*len);
            lstack = lstack.slice(0, -1*len);
          }

          stack.push(this.productions_[action[1]][0]);    // push nonterminal (reduce)
          vstack.push(yyval.$);
          lstack.push(yyval._$);
          // goto new state = table[STATE][NONTERMINAL]
          newState = table[stack[stack.length-2]][stack[stack.length-1]];
          stack.push(newState);
          break;

        case 3: // accept
          return true;
      }

    }

    return true;
  }};

var g = require('./grammar');
var util = require('util');

/* catpreter generated lexer */
var lexer = (function(){
var lexer = ({EOF:1,
parseError:function parseError(str, hash) {
      if (this.yy.parser) {
        this.yy.parser.parseError(str, hash);
      } else {
        throw new Error(str);
      }
    },
setInput:function (input) {
      this._input = input;
      this._more = this._less = this.done = false;
      this.yylineno = this.yyleng = 0;
      this.yytext = this.matched = this.match = '';
      this.conditionStack = ['INITIAL'];
      // CATTAIL: yylloc store lexer token locator
      this.yylloc = {first_line:1,first_column:0,last_line:1,last_column:0};
      if (this.options.ranges) this.yylloc.range = [0,0];
      this.offset = 0;
      return this;
    },
input:function () {
      var ch = this._input[0];
      this.yytext += ch;
      this.yyleng++;
      this.offset++;
      this.match += ch;
      this.matched += ch;
      var lines = ch.match(/(?:\r\n?|\n).*/g);
      if (lines) {
        this.yylineno++;
        this.yylloc.last_line++;
      } else {
        this.yylloc.last_column++;
      }
      if (this.options.ranges) this.yylloc.range[1]++;

      this._input = this._input.slice(1);
      return ch;
    },
unput:function (ch) {
      var len = ch.length;
      var lines = ch.split(/(?:\r\n?|\n)/g);

      this._input = ch + this._input;
      // CATTAIL: are there any wrong here? I think it should be like this
      // `this.yytext = this.yytext.substr(0, this.yytext.length-len);` or something like
      // `this.yytext = this.yytext.substring(0, this.yytext.length-len-1);`
      this.yytext = this.yytext.substr(0, this.yytext.length-len-1);
      //this.yyleng -= len;
      this.offset -= len;
      var oldLines = this.match.split(/(?:\r\n?|\n)/g);
      this.match = this.match.substr(0, this.match.length-1);
      this.matched = this.matched.substr(0, this.matched.length-1);

      if (lines.length-1) this.yylineno -= lines.length-1;
      var r = this.yylloc.range;

      // CATTAIL: having problem to understand `yylloc` for the lack of knowing `match` and `matched`
      this.yylloc = {
        first_line: this.yylloc.first_line,
        last_line: this.yylineno+1,
        first_column: this.yylloc.first_column,
        last_column: lines ?
          (lines.length === oldLines.length ? this.yylloc.first_column : 0) + oldLines[oldLines.length - lines.length].length - lines[0].length:
          this.yylloc.first_column - len
      };

      if (this.options.ranges) {
        this.yylloc.range = [r[0], r[0] + this.yyleng - len];
      }
      return this;
    },
more:function () {
      this._more = true;
      return this;
    },
less:function (n) {
      this.unput(this.match.slice(n));
    },
pastInput:function () {
      var past = this.matched.substr(0, this.matched.length - this.match.length);
      return (past.length > 20 ? '...':'') + past.substr(-20).replace(/\n/g, "");
    },
upcomingInput:function () {
      var next = this.match;
      if (next.length < 20) {
        next += this._input.substr(0, 20-next.length);
      }
      return (next.substr(0,20)+(next.length > 20 ? '...':'')).replace(/\n/g, "");
    },
showPosition:function () {
      var pre = this.pastInput();
      var c = new Array(pre.length + 1).join("-");
      return pre + this.upcomingInput() + "\n" + c+"^";
    },
next:function () {
      if (this.done) {
        return this.EOF;
      }
      if (!this._input) this.done = true;

      var token, match, tempMatch, index, col, lines;
      if (!this._more) {
        this.yytext = '';
        this.match = '';
      }
      // CATTAIL: get current start condition rules
      var rules = this._currentRules();
      // CATTAIL: first being matched
      for (var i=0;i < rules.length; i++) {
        tempMatch = this._input.match(this.rules[rules[i]]);
        if (tempMatch && (!match || tempMatch[0].length > match[0].length)) {
          match = tempMatch;
          index = i;
          if (!this.options.flex) break;
        }
      }
      if (match) {
        lines = match[0].match(/(?:\r\n?|\n).*/g);
        if (lines) this.yylineno += lines.length;

        this.yylloc = {
          first_line: this.yylloc.last_line,
          last_line: this.yylineno+1,
          first_column: this.yylloc.last_column,
          last_column: lines ? lines[lines.length-1].length-lines[lines.length-1].match(/\r?\n?/)[0].length:
            this.yylloc.last_column + match[0].length
        };
        this.yytext += match[0];
        this.match += match[0];
        this.matches = match;
        this.yyleng = this.yytext.length;
        if (this.options.ranges) {
          this.yylloc.range = [this.offset, this.offset += this.yyleng];
        }
        this._more = false;
        this._input = this._input.slice(match[0].length);
        this.matched += match[0];
        // CATTAIL: `performAction` is create by `Function("yy,yy_,$avoiding_name_collisions,YY_START", fun)`
        token = this.performAction.call(this, this.yy, this, rules[index],this.conditionStack[this.conditionStack.length-1]);
        if (this.done && this._input) this.done = false;
        if (token) return token;
        else return;
      }
      if (this._input === "") {
        return this.EOF;
      } else {
        return this.parseError('Lexical error on line '+(this.yylineno+1)+'. Unrecognized text.\n'+this.showPosition(),
                               {text: "", token: null, line: this.yylineno});
      }
    },
lex:function lex() {
      var r = this.next();
      if (typeof r !== 'undefined') {
        return r;
      } else {
        return this.lex();
      }
    },
begin:function begin(condition) {
      this.conditionStack.push(condition);
    },
popState:function popState() {
      return this.conditionStack.pop();
    },
_currentRules:function _currentRules() {
      return this.conditions[this.conditionStack[this.conditionStack.length-1]].rules;
    },
topState:function () {
      return this.conditionStack[this.conditionStack.length-2];
    },
pushState:function begin(condition) {
      this.begin(condition);
    }});
lexer.options = {};
lexer.performAction = function anonymous(yy,yy_,$avoiding_name_collisions,YY_START) {

var YYSTATE=YY_START;
switch($avoiding_name_collisions) {
case 0:/* ignore line comment */
break;
case 1:this.begin('comment');
break;
case 2:this.popState();
break;
case 3:/* skip comment content*/
break;
case 4:/* ignore white space */
break;
case 5:return 18;
break;
case 6:return 22;
break;
case 7:return 23;
break;
case 8:return 30;
break;
case 9:return 29;
break;
case 10:return 62;
break;
case 11:return 63;
break;
case 12:return 59;
break;
case 13:return 60;
break;
case 14:return 31;
break;
case 15:return 50;
break;
case 16:return 51;
break;
case 17:return 52;
break;
case 18:return 53;
break;
case 19:return 48;
break;
case 20:return 45;
break;
case 21:return 46;
break;
case 22:return 57;
break;
case 23:return 58;
break;
case 24:return 38;
break;
case 25:return 19;
break;
case 26:return 21;
break;
case 27:return 28;
break;
case 28:return 14;
break;
case 29:return 15;
break;
case 30:return 34;
break;
case 31:/* ignore */
break;
case 32:return 5
break;
}
};
lexer.rules = [/^(?:\/\/.*)/,/^(?:\/\*)/,/^(?:\*\/)/,/^(?:.)/,/^(?:\s+)/,/^(?:if\b)/,/^(?:else\b)/,/^(?:while\b)/,/^(?:read\b)/,/^(?:write\b)/,/^(?:int\b)/,/^(?:real\b)/,/^(?:((\d+)+))/,/^(?:(((\d+)+)\.((\d+)+)(e[-+]?((\d+)+))?))/,/^(?:(([a-zA-Z])(([a-zA-Z])|([0-9])|_)*))/,/^(?:\+)/,/^(?:-)/,/^(?:\*)/,/^(?:\/)/,/^(?:<)/,/^(?:==)/,/^(?:<>)/,/^(?:\[)/,/^(?:\])/,/^(?:=)/,/^(?:\()/,/^(?:\))/,/^(?:;)/,/^(?:\{)/,/^(?:\})/,/^(?:,)/,/^(?:.)/,/^(?:$)/];
lexer.conditions = {"comment":{"rules":[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32],"inclusive":true},"INITIAL":{"rules":[0,1,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32],"inclusive":true}};

;
return lexer;})();
parser.lexer = lexer;
function Parser () { this.yy = {}; }Parser.prototype = parser;parser.Parser = Parser;
return new Parser;
})();
if (typeof require !== 'undefined' && typeof exports !== 'undefined') {
exports.parser = cmm;
exports.Parser = cmm.Parser;
exports.parse = function () { return cmm.parse.apply(cmm, arguments); };
exports.main = function commonjsMain(args) {
    if (!args[1])
      throw new Error('Usage: '+args[0]+' FILE');
    var source, cwd;
    if (typeof process !== 'undefined') {
      source = require('fs').readFileSync(require('path').resolve(args[1]), "utf8");
    } else {
      source = require("file").path(require("file").cwd()).join(args[1]).read({charset: "utf-8"});
    }
    return exports.parser.parse(source);
  };
if (typeof module !== 'undefined' && require.main === module) {
  exports.main(typeof process !== 'undefined' ? process.argv.slice(1) : require("system").args);
}
}