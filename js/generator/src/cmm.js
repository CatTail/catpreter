/* Catpreter generated parser */
var cmm = (function(){
var parser = {trace: function trace() { },
yy: {},
symbols_: {"error":2,"prog":3,"statement_list":4,"EOF":5,"statement":6,"compound_statement":7,"expression_statement":8,"selection_statement":9,"iteration_statement":10,"declaration":11,"{":12,"}":13,";":14,"expression":15,"write":16,"read":17,"IDENTIFIER":18,"declarator_specifiers":19,"selection_statement_head":20,"selection_statement_else":21,"if":22,"(":23,")":24,"else":25,"while":26,"assignment_expression":27,",":28,"equality_expression":29,"unary_expression":30,"=":31,"+=":32,"-=":33,"*=":34,"/=":35,"relational_expression":36,"==":37,"<>":38,"additive_expression":39,"<":40,"multiplicative_expression":41,"+":42,"-":43,"*":44,"/":45,"postfix_expression":46,"primary_expression":47,"[":48,"]":49,"INT_LITERAL":50,"REAL_LITERAL":51,"init_declarator_list":52,"int":53,"real":54,"init_declarator":55,"declarator":56,"initializer":57,"constant_expression":58,"$accept":0,"$end":1},
terminals_: {2:"error",5:"EOF",12:"{",13:"}",14:";",16:"write",17:"read",18:"IDENTIFIER",22:"if",23:"(",24:")",25:"else",26:"while",28:",",31:"=",32:"+=",33:"-=",34:"*=",35:"/=",37:"==",38:"<>",40:"<",42:"+",43:"-",44:"*",45:"/",48:"[",49:"]",50:"INT_LITERAL",51:"REAL_LITERAL",53:"int",54:"real"},
productions_: [0,[3,2],[4,1],[4,2],[6,1],[6,1],[6,1],[6,1],[6,1],[7,2],[7,3],[8,1],[8,2],[8,3],[8,3],[9,2],[9,4],[20,4],[21,1],[10,5],[15,1],[15,3],[27,1],[27,3],[27,3],[27,3],[27,3],[27,3],[29,1],[29,3],[29,3],[36,1],[36,3],[39,1],[39,3],[39,3],[41,1],[41,3],[41,3],[30,1],[30,2],[30,2],[46,1],[46,4],[47,1],[47,1],[47,1],[47,3],[11,3],[19,1],[19,1],[52,1],[52,3],[55,1],[55,3],[56,1],[56,4],[58,1],[57,1]],
performAction: function anonymous(yytext,yyleng,yylineno,yy,yystate,$$,_$) {

var $0 = $$.length - 1;
switch (yystate) {
case 1:console.log(symbols);
break;
case 15:yy.continueExecution=true
break;
case 16:yy.continueExecution=true
break;
case 17:yy.continueExecution=!!getValue($$[$0-1]);
break;
case 18:yy.continueExecution=!yy.continueExecution;
break;
case 20:this.$=$$[$0];
break;
case 21:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); setValue(this.$, getValue($$[$0]));
break;
case 22:this.$=$$[$0];
break;
case 23:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); setValue($$[$0-2], addSymbol(this.$).value=getValue($$[$0]));
break;
case 24:
        this.$=[$$[$0-2], $$[$0-1], $$[$0]].join('');
        var value = getValue($$[$0-2]) + getValue($$[$0]);
        setValue($$[$0-2], value);
        addSymbol(this.$).value = value;
      
break;
case 25:
        this.$=[$$[$0-2], $$[$0-1], $$[$0]].join('');
        var value = getValue($$[$0-2]) - getValue($$[$0]);
        setValue($$[$0-2], value);
        addSymbol(this.$).value = value;
      
break;
case 26:
        this.$=[$$[$0-2], $$[$0-1], $$[$0]].join('');
        var value = getValue($$[$0-2]) * getValue($$[$0]);
        setValue($$[$0-2], value);
        addSymbol(this.$).value = value;
      
break;
case 27:
        this.$=[$$[$0-2], $$[$0-1], $$[$0]].join('');
        var value = getValue($$[$0-2]) / getValue($$[$0]);
        setValue($$[$0-2], value);
        addSymbol(this.$).value = value;
      
break;
case 28:this.$=$$[$0];
break;
case 29:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-2])===getValue($$[$0]);
break;
case 30:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-2])!==getValue($$[$0]);
break;
case 31:this.$=$$[$0];
break;
case 32:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-2])<getValue($$[$0]);
break;
case 33:this.$=$$[$0];
break;
case 34:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-2])+getValue($$[$0]);
break;
case 35:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-2])-getValue($$[$0]);
break;
case 36:this.$=$$[$0];
break;
case 37:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-2])*getValue($$[$0]);
break;
case 38:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-2])/getValue($$[$0]);
break;
case 39:this.$=$$[$0];
break;
case 40:this.$=[$$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=getValue($$[$0-1]);
break;
case 41:this.$=[$$[$0-1], $$[$0]].join(''); addSymbol(this.$).value=-getValue($$[$0-1]);
break;
case 42:this.$=$$[$0];
break;
case 43:this.$=[$$[$0-3], $$[$0-2], getValue($$[$0-1]), $$[$0]].join(''); addSymbol(this.$);
break;
case 44:this.$=$$[$0]; addSymbol(this.$).type='int'; setValue(this.$, parseInt($$[$0]));
break;
case 45:this.$=$$[$0]; addSymbol(this.$).type='real'; setValue(this.$, parseFloat($$[$0]));
break;
case 46:this.$=$$[$0]; addSymbol(this.$);
break;
case 47:this.$=[$$[$0-2], $$[$0-1], $$[$0]].join(''); addSymbol(this.$); setValue(this.$, getValue($$[$0-1]));
break;
case 48:
        for (var i=0; i<$$[$0-1].length; i++) {
          getSymbol($$[$0-1][i]).type = $$[$0-2] + getSymbol($$[$0-1][i]).type;
        }
      
break;
case 49:this.$ = $$[$0];
break;
case 50:this.$ = $$[$0];
break;
case 51:this.$ = [$$[$0]]
break;
case 52:$$[$0-2].push($$[$0]); this.$=$$[$0-2];
break;
case 53:this.$=$$[$0];
break;
case 54:this.$=$$[$0-2]; setValue($$[$0-2], getValue($$[$0]));
break;
case 55:this.$=$$[$0]; addSymbol(this.$);
break;
case 56:this.$=$$[$0-3]; getSymbol(this.$).type += '['+$$[$0-1]+']';
break;
case 57:this.$=$$[$0];
break;
case 58:this.$=$$[$0];
break;
}
},
table: [{3:1,4:2,6:3,7:4,8:5,9:6,10:7,11:8,12:[1,9],14:[1,10],15:11,16:[1,12],17:[1,13],18:[1,32],19:16,20:14,22:[1,18],23:[1,33],26:[1,15],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],53:[1,19],54:[1,20]},{1:[3]},{5:[1,34],6:35,7:4,8:5,9:6,10:7,11:8,12:[1,9],14:[1,10],15:11,16:[1,12],17:[1,13],18:[1,32],19:16,20:14,22:[1,18],23:[1,33],26:[1,15],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],53:[1,19],54:[1,20]},{5:[2,2],12:[2,2],13:[2,2],14:[2,2],16:[2,2],17:[2,2],18:[2,2],22:[2,2],23:[2,2],26:[2,2],42:[2,2],43:[2,2],50:[2,2],51:[2,2],53:[2,2],54:[2,2]},{5:[2,4],12:[2,4],13:[2,4],14:[2,4],16:[2,4],17:[2,4],18:[2,4],22:[2,4],23:[2,4],25:[2,4],26:[2,4],42:[2,4],43:[2,4],50:[2,4],51:[2,4],53:[2,4],54:[2,4]},{5:[2,5],12:[2,5],13:[2,5],14:[2,5],16:[2,5],17:[2,5],18:[2,5],22:[2,5],23:[2,5],25:[2,5],26:[2,5],42:[2,5],43:[2,5],50:[2,5],51:[2,5],53:[2,5],54:[2,5]},{5:[2,6],12:[2,6],13:[2,6],14:[2,6],16:[2,6],17:[2,6],18:[2,6],22:[2,6],23:[2,6],25:[2,6],26:[2,6],42:[2,6],43:[2,6],50:[2,6],51:[2,6],53:[2,6],54:[2,6]},{5:[2,7],12:[2,7],13:[2,7],14:[2,7],16:[2,7],17:[2,7],18:[2,7],22:[2,7],23:[2,7],25:[2,7],26:[2,7],42:[2,7],43:[2,7],50:[2,7],51:[2,7],53:[2,7],54:[2,7]},{5:[2,8],12:[2,8],13:[2,8],14:[2,8],16:[2,8],17:[2,8],18:[2,8],22:[2,8],23:[2,8],25:[2,8],26:[2,8],42:[2,8],43:[2,8],50:[2,8],51:[2,8],53:[2,8],54:[2,8]},{4:37,6:3,7:4,8:5,9:6,10:7,11:8,12:[1,9],13:[1,36],14:[1,10],15:11,16:[1,12],17:[1,13],18:[1,32],19:16,20:14,22:[1,18],23:[1,33],26:[1,15],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],53:[1,19],54:[1,20]},{5:[2,11],12:[2,11],13:[2,11],14:[2,11],16:[2,11],17:[2,11],18:[2,11],22:[2,11],23:[2,11],25:[2,11],26:[2,11],42:[2,11],43:[2,11],50:[2,11],51:[2,11],53:[2,11],54:[2,11]},{14:[1,38],28:[1,39]},{15:40,18:[1,32],23:[1,33],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,41]},{6:42,7:4,8:5,9:6,10:7,11:8,12:[1,9],14:[1,10],15:11,16:[1,12],17:[1,13],18:[1,32],19:16,20:14,22:[1,18],23:[1,33],26:[1,15],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],53:[1,19],54:[1,20]},{23:[1,43]},{18:[1,47],52:44,55:45,56:46},{14:[2,20],24:[2,20],28:[2,20],49:[2,20]},{23:[1,48]},{5:[2,49],12:[2,49],13:[2,49],14:[2,49],16:[2,49],17:[2,49],18:[2,49],22:[2,49],23:[2,49],25:[2,49],26:[2,49],42:[2,49],43:[2,49],50:[2,49],51:[2,49],53:[2,49],54:[2,49]},{5:[2,50],12:[2,50],13:[2,50],14:[2,50],16:[2,50],17:[2,50],18:[2,50],22:[2,50],23:[2,50],25:[2,50],26:[2,50],42:[2,50],43:[2,50],50:[2,50],51:[2,50],53:[2,50],54:[2,50]},{14:[2,22],24:[2,22],28:[2,22],37:[1,49],38:[1,50],49:[2,22]},{14:[2,36],24:[2,36],28:[2,36],31:[1,51],32:[1,52],33:[1,53],34:[1,54],35:[1,55],37:[2,36],38:[2,36],40:[2,36],42:[2,36],43:[2,36],44:[2,36],45:[2,36],49:[2,36]},{14:[2,28],24:[2,28],28:[2,28],37:[2,28],38:[2,28],40:[1,56],49:[2,28]},{14:[2,39],24:[2,39],28:[2,39],31:[2,39],32:[2,39],33:[2,39],34:[2,39],35:[2,39],37:[2,39],38:[2,39],40:[2,39],42:[2,39],43:[2,39],44:[2,39],45:[2,39],48:[1,57],49:[2,39]},{18:[1,32],23:[1,33],30:58,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],30:59,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{14:[2,31],24:[2,31],28:[2,31],37:[2,31],38:[2,31],40:[2,31],42:[1,60],43:[1,61],49:[2,31]},{14:[2,42],24:[2,42],28:[2,42],31:[2,42],32:[2,42],33:[2,42],34:[2,42],35:[2,42],37:[2,42],38:[2,42],40:[2,42],42:[2,42],43:[2,42],44:[2,42],45:[2,42],48:[2,42],49:[2,42]},{14:[2,33],24:[2,33],28:[2,33],37:[2,33],38:[2,33],40:[2,33],42:[2,33],43:[2,33],44:[1,62],45:[1,63],49:[2,33]},{14:[2,44],24:[2,44],28:[2,44],31:[2,44],32:[2,44],33:[2,44],34:[2,44],35:[2,44],37:[2,44],38:[2,44],40:[2,44],42:[2,44],43:[2,44],44:[2,44],45:[2,44],48:[2,44],49:[2,44]},{14:[2,45],24:[2,45],28:[2,45],31:[2,45],32:[2,45],33:[2,45],34:[2,45],35:[2,45],37:[2,45],38:[2,45],40:[2,45],42:[2,45],43:[2,45],44:[2,45],45:[2,45],48:[2,45],49:[2,45]},{14:[2,46],24:[2,46],28:[2,46],31:[2,46],32:[2,46],33:[2,46],34:[2,46],35:[2,46],37:[2,46],38:[2,46],40:[2,46],42:[2,46],43:[2,46],44:[2,46],45:[2,46],48:[2,46],49:[2,46]},{15:64,18:[1,32],23:[1,33],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{1:[2,1]},{5:[2,3],12:[2,3],13:[2,3],14:[2,3],16:[2,3],17:[2,3],18:[2,3],22:[2,3],23:[2,3],26:[2,3],42:[2,3],43:[2,3],50:[2,3],51:[2,3],53:[2,3],54:[2,3]},{5:[2,9],12:[2,9],13:[2,9],14:[2,9],16:[2,9],17:[2,9],18:[2,9],22:[2,9],23:[2,9],25:[2,9],26:[2,9],42:[2,9],43:[2,9],50:[2,9],51:[2,9],53:[2,9],54:[2,9]},{6:35,7:4,8:5,9:6,10:7,11:8,12:[1,9],13:[1,65],14:[1,10],15:11,16:[1,12],17:[1,13],18:[1,32],19:16,20:14,22:[1,18],23:[1,33],26:[1,15],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],53:[1,19],54:[1,20]},{5:[2,12],12:[2,12],13:[2,12],14:[2,12],16:[2,12],17:[2,12],18:[2,12],22:[2,12],23:[2,12],25:[2,12],26:[2,12],42:[2,12],43:[2,12],50:[2,12],51:[2,12],53:[2,12],54:[2,12]},{18:[1,32],23:[1,33],27:66,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{14:[1,67],28:[1,39]},{19:68,53:[1,19],54:[1,20]},{5:[2,15],12:[2,15],13:[2,15],14:[2,15],16:[2,15],17:[2,15],18:[2,15],21:69,22:[2,15],23:[2,15],25:[1,70],26:[2,15],42:[2,15],43:[2,15],50:[2,15],51:[2,15],53:[2,15],54:[2,15]},{15:71,18:[1,32],23:[1,33],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{14:[1,72],28:[1,73]},{14:[2,51],28:[2,51]},{14:[2,53],28:[2,53],31:[1,74],48:[1,75]},{14:[2,55],28:[2,55],31:[2,55],48:[2,55]},{15:76,18:[1,32],23:[1,33],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],30:78,36:77,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],30:78,36:79,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],27:80,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],27:81,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],27:82,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],27:83,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],27:84,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],30:78,39:85,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{15:86,18:[1,32],23:[1,33],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{14:[2,40],24:[2,40],28:[2,40],31:[2,40],32:[2,40],33:[2,40],34:[2,40],35:[2,40],37:[2,40],38:[2,40],40:[2,40],42:[2,40],43:[2,40],44:[2,40],45:[2,40],49:[2,40]},{14:[2,41],24:[2,41],28:[2,41],31:[2,41],32:[2,41],33:[2,41],34:[2,41],35:[2,41],37:[2,41],38:[2,41],40:[2,41],42:[2,41],43:[2,41],44:[2,41],45:[2,41],49:[2,41]},{18:[1,32],23:[1,33],30:78,41:87,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],30:78,41:88,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],30:89,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{18:[1,32],23:[1,33],30:90,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31]},{24:[1,91],28:[1,39]},{5:[2,10],12:[2,10],13:[2,10],14:[2,10],16:[2,10],17:[2,10],18:[2,10],22:[2,10],23:[2,10],25:[2,10],26:[2,10],42:[2,10],43:[2,10],50:[2,10],51:[2,10],53:[2,10],54:[2,10]},{14:[2,21],24:[2,21],28:[2,21],49:[2,21]},{5:[2,13],12:[2,13],13:[2,13],14:[2,13],16:[2,13],17:[2,13],18:[2,13],22:[2,13],23:[2,13],25:[2,13],26:[2,13],42:[2,13],43:[2,13],50:[2,13],51:[2,13],53:[2,13],54:[2,13]},{5:[2,14],12:[2,14],13:[2,14],14:[2,14],16:[2,14],17:[2,14],18:[2,14],22:[2,14],23:[2,14],25:[2,14],26:[2,14],42:[2,14],43:[2,14],50:[2,14],51:[2,14],53:[2,14],54:[2,14]},{6:92,7:4,8:5,9:6,10:7,11:8,12:[1,9],14:[1,10],15:11,16:[1,12],17:[1,13],18:[1,32],19:16,20:14,22:[1,18],23:[1,33],26:[1,15],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],53:[1,19],54:[1,20]},{12:[2,18],14:[2,18],16:[2,18],17:[2,18],18:[2,18],22:[2,18],23:[2,18],26:[2,18],42:[2,18],43:[2,18],50:[2,18],51:[2,18],53:[2,18],54:[2,18]},{24:[1,93],28:[1,39]},{5:[2,48],12:[2,48],13:[2,48],14:[2,48],16:[2,48],17:[2,48],18:[2,48],22:[2,48],23:[2,48],25:[2,48],26:[2,48],42:[2,48],43:[2,48],50:[2,48],51:[2,48],53:[2,48],54:[2,48]},{18:[1,47],55:94,56:46},{18:[1,32],23:[1,33],27:96,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],57:95},{18:[1,32],23:[1,33],29:98,30:78,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],58:97},{24:[1,99],28:[1,39]},{14:[2,29],24:[2,29],28:[2,29],37:[2,29],38:[2,29],40:[1,56],49:[2,29]},{14:[2,36],24:[2,36],28:[2,36],37:[2,36],38:[2,36],40:[2,36],42:[2,36],43:[2,36],44:[2,36],45:[2,36],49:[2,36]},{14:[2,30],24:[2,30],28:[2,30],37:[2,30],38:[2,30],40:[1,56],49:[2,30]},{14:[2,23],24:[2,23],28:[2,23],49:[2,23]},{14:[2,24],24:[2,24],28:[2,24],49:[2,24]},{14:[2,25],24:[2,25],28:[2,25],49:[2,25]},{14:[2,26],24:[2,26],28:[2,26],49:[2,26]},{14:[2,27],24:[2,27],28:[2,27],49:[2,27]},{14:[2,32],24:[2,32],28:[2,32],37:[2,32],38:[2,32],40:[2,32],42:[1,60],43:[1,61],49:[2,32]},{28:[1,39],49:[1,100]},{14:[2,34],24:[2,34],28:[2,34],37:[2,34],38:[2,34],40:[2,34],42:[2,34],43:[2,34],44:[1,62],45:[1,63],49:[2,34]},{14:[2,35],24:[2,35],28:[2,35],37:[2,35],38:[2,35],40:[2,35],42:[2,35],43:[2,35],44:[1,62],45:[1,63],49:[2,35]},{14:[2,37],24:[2,37],28:[2,37],37:[2,37],38:[2,37],40:[2,37],42:[2,37],43:[2,37],44:[2,37],45:[2,37],49:[2,37]},{14:[2,38],24:[2,38],28:[2,38],37:[2,38],38:[2,38],40:[2,38],42:[2,38],43:[2,38],44:[2,38],45:[2,38],49:[2,38]},{14:[2,47],24:[2,47],28:[2,47],31:[2,47],32:[2,47],33:[2,47],34:[2,47],35:[2,47],37:[2,47],38:[2,47],40:[2,47],42:[2,47],43:[2,47],44:[2,47],45:[2,47],48:[2,47],49:[2,47]},{5:[2,16],12:[2,16],13:[2,16],14:[2,16],16:[2,16],17:[2,16],18:[2,16],22:[2,16],23:[2,16],25:[2,16],26:[2,16],42:[2,16],43:[2,16],50:[2,16],51:[2,16],53:[2,16],54:[2,16]},{6:101,7:4,8:5,9:6,10:7,11:8,12:[1,9],14:[1,10],15:11,16:[1,12],17:[1,13],18:[1,32],19:16,20:14,22:[1,18],23:[1,33],26:[1,15],27:17,29:21,30:22,36:23,39:27,41:29,42:[1,25],43:[1,26],46:24,47:28,50:[1,30],51:[1,31],53:[1,19],54:[1,20]},{14:[2,52],28:[2,52]},{14:[2,54],28:[2,54]},{14:[2,58],28:[2,58]},{49:[1,102]},{37:[1,49],38:[1,50],49:[2,57]},{12:[2,17],14:[2,17],16:[2,17],17:[2,17],18:[2,17],22:[2,17],23:[2,17],26:[2,17],42:[2,17],43:[2,17],50:[2,17],51:[2,17],53:[2,17],54:[2,17]},{14:[2,43],24:[2,43],28:[2,43],31:[2,43],32:[2,43],33:[2,43],34:[2,43],35:[2,43],37:[2,43],38:[2,43],40:[2,43],42:[2,43],43:[2,43],44:[2,43],45:[2,43],48:[2,43],49:[2,43]},{5:[2,19],12:[2,19],13:[2,19],14:[2,19],16:[2,19],17:[2,19],18:[2,19],22:[2,19],23:[2,19],25:[2,19],26:[2,19],42:[2,19],43:[2,19],50:[2,19],51:[2,19],53:[2,19],54:[2,19]},{14:[2,56],28:[2,56],31:[2,56],48:[2,56]}],
defaultActions: {34:[2,1]},
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
          
          // init continueExecution to true
          this.yy.continueExecution === undefined ? this.yy.continueExecution = true : 0;
          if (this.yy.continueExecution) {
            r = this.performAction.call(yyval, yytext, yyleng, yylineno, this.yy, action[1], vstack, lstack);
          }

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

// symbol and constant table
var symbols = {};
var util = require('util');

function addSymbol (address) {
  if (symbols[address]) return symbols[address];
  return symbols[address] = {type: '', value: null};
}

function getSymbol (address) {
  return symbols[address];
}

function setValue (address, value) {
  var matches = address.match(/\[(\d+)\]/g);
  if (matches) {
    address = address.slice(0, address.indexOf('['));
    var symbol = getSymbol(address);
    var v = symbol.value ? symbol.value : [];
    for (var i=1; i<matches.length; i++) {
      v = v[matches[i]] = v[matches[i]] ? v[matches[i]] : [];
    }
    v[i-1] = value;
  } else {
    getSymbol(address).value = value;
  }
  return value;
}

function getValue (address) {
  var matches = address.match(/\[(\d+)\]/g);
  var value;
  if (matches) {
    // get array's value
    address = address.slice(0, address.indexOf('['));
    value = getSymbol(address).value;
    for (var i=1; i<matches.length; i++) {
      value = value[matches[i]];
    }
  } else {
    value = getSymbol(address).value;
  }
  return value;
}


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
case 1:this.begin(comment);
break;
case 2:/* eat anything that's not a '*' */
break;
case 3:/* eat up '*'s not followed by '/'s */
break;
case 4:this.yy_.yylineno++;
break;
case 5:this.begin(INITIAL);
break;
case 6:/* ignore white space */
break;
case 7:return 22;
break;
case 8:return 25;
break;
case 9:return 26;
break;
case 10:return 17;
break;
case 11:return 16;
break;
case 12:return 53;
break;
case 13:return 54;
break;
case 14:return 50;
break;
case 15:return 51;
break;
case 16:return 18;
break;
case 17:return 42;
break;
case 18:return 43;
break;
case 19:return 44;
break;
case 20:return 45;
break;
case 21:return 40;
break;
case 22:return 37;
break;
case 23:return 38;
break;
case 24:return 48;
break;
case 25:return 49;
break;
case 26:return 31;
break;
case 27:return 23;
break;
case 28:return 24;
break;
case 29:return 14;
break;
case 30:return 12;
break;
case 31:return 13;
break;
case 32:return 28;
break;
case 33:/* ignore */
break;
case 34:return 5
break;
}
};
lexer.rules = [/^(?:\/\/.*)/,/^(?:\/\*)/,/^(?:[^*\n]*)/,/^(?:\*+[^*/\n]*)/,/^(?:\n\b)/,/^(?:\*+\/)/,/^(?:\s+)/,/^(?:if\b)/,/^(?:else\b)/,/^(?:while\b)/,/^(?:read\b)/,/^(?:write\b)/,/^(?:int\b)/,/^(?:real\b)/,/^(?:((\d+)+))/,/^(?:(((\d+)+)\.((\d+)+)(e[-+]?((\d+)+))?))/,/^(?:(([a-zA-Z])(([a-zA-Z])|([0-9])|_)*))/,/^(?:\+)/,/^(?:-)/,/^(?:\*)/,/^(?:\/)/,/^(?:<)/,/^(?:==)/,/^(?:<>)/,/^(?:\[)/,/^(?:\])/,/^(?:=)/,/^(?:\()/,/^(?:\))/,/^(?:;)/,/^(?:\{)/,/^(?:\})/,/^(?:,)/,/^(?:.)/,/^(?:$)/];
lexer.conditions = {"comment":{"rules":[2,3,4,5],"inclusive":false},"INITIAL":{"rules":[0,1,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34],"inclusive":true}};

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