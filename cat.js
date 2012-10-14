var Cat = {};

/*
 * 如果在$本身为对象的情况下使得它可调用
 * 同时，如何使得$.fn下的函数调用转变为$的函数调用
 */

/* util */
/*
 * @param subClass Sub Class Constructor
 * @param superClass Super Class Constructor
 */
/*
 * call every element in arr
 * @param arr Array of supplied elements
 * @param callback Function will be called for every element in arr.
 * It will be supplied with 1.value 2.index 3.complete arr
 */
Cat.each = function(arr,callback,thisArg){
	thisArg = thisArg === undefined ? this : thisArg;
	for(var i=0;i<arr.length;i++){
		callback.call(thisArg,arr[i],i,arr);
	}
};
/*
 * check if every element in arr satisfy predicate
 * @param arr Array of element needed to be checked
 * @param predicate Checking function
 */
Cat.every = function(arr,predicate){
	var result = true;
	Cat.each(arr,function(el){
		Cat.falsy( predicate(el) ) ? result = false : 0;
	});
	return result;
};
/*
 * if value if falsy value
 * falsy value include:
 * 		undefined
 *		null
 *		0
 *		-0
 *		NaN
 *		""
 * @param value Value need to be checked
 */
Cat.falsy = function(value){
	return value == null || value == false || value != value ? true : false;
};
Cat.extend = (function(){
	function Tmp(){
	};
	return function(subClass,superClass){
		Tmp.prototype = superClass.prototype;
		var prototype = new Tmp;
		subClass.prototype = prototype;
		prototype.constructor = subClass;
	};
})();
/*
 * get all property names including methods obj have
 */
Cat.getAllPropertyNames =function(obj){
	var proto=obj , props=[];
	while(proto !== null){
		props = props.concat(Object.getOwnPropertyNames(proto));
		proto = Object.getPrototypeOf(proto);
	}
	return props;
}
/*
 * #Design Pattern# Proxy
 *
 * realSubject being proxied by subject internally
 * @param realSubject Internal object being manipulated
 * @param subject Outlooking subject used by user
 */
Cat.proxy = function(realSubject,subject){
	var all = Cat.getAllPropertyNames(realSubject);
	var properties = [] , methods = [];
	Cat.each(all,function(v){
		typeof v === 'function' ? method.push(v) : properties.push(v);
	});
	//method proxy
	Cat.each(methods,function(method){
		subject[method] = function(){
			realSubject[method].apply(realSubject,arguments);
		};
	});
	//property proxy
	//enumerable & configurable property still need to be read from realSubject
	Cat.each(properties,function(property){
		Object.defineProperty(subject,property,{
			get:function(){ return realSubject[property]; },
			set:function(value){ realSubject[property] = value; },
			enumerable:true,
			configurable:true,
		});
	});
};
/*
 * cookie manipulation class
 */
Cat.cookie = {
	set : function(name,value,days,path){
		var result = '';
		result += [name,value].join('=');
		var today = new Date;
		days === undefined ? 0 : result += ['; expires',today.getTime()+days*24*60*60*1000].join('=');
		path === undefined ? 0 : result += ['; path',path].join('=');
		document.cookie = result;
	},
	get : function(name){
		var pairs = document.cookie.split('; ');
		for(var i=0;i<pairs.length;i++){
			var pair = pairs[i].split('=');
			if( pair[0] === name ){
				return pair[1];
			}
		}
	},
	remove : function(name){
		this.set(name,'',-1);
	},
}

Cat.randomString = (function(){
	//Create constant char space
	//A-Z a-z 65-90 97-122
	var CharSpace = '';
	for(var i=0;i<26;i++){
		CharSpace += String.fromCharCode(i+65);
		CharSpace += String.fromCharCode(i+97);
	}
	//random string generator
	function __randomString(length){
		var result = '';
		for(var i=0;i<length;i++){
			result += __randomChar();
		}
		return result;

	}
	function __randomChar(){
		return CharSpace[ parseInt(Math.random() * CharSpace.length) ];
	}
	return __randomString;
})();
Cat.format = function(original){
	var args = arguments;
	return original.replace(/\{(\d+)\}/gi,function(match,p1){
		return args[+p1+1];
	});
};
/* DOM */
//simple select method
//BY FAR
Cat.querySelectorAll = function(selector){
	var result = null;
	switch(selector[0]){
		case '#'://id selector
			result = document.getElementById(selector.slice(1));
			return  result == null ? [] : [result];
			break;
		case '.'://class selector
			result = getElementsByClassName(selector.slice(1));
			return result == null ? [] : result;
			break;
		default://tag selector
			return document.getElementsByTagName(selector);
			break;
	}
	function getElementsByClassName(className){
		var elements = [];
		var all = document.getElementsByTagName('*');
		for(var i=0;i<all.length;i++){
			if( all[i].className === className ){
				elements.push(all[i]);
			}
		}
		return elements;
	}
};
/*
 * get element offset from page
 * @param el The element need to get offset
 */
Cat.offset = function(el){
	var offset = {left:el.offsetLeft,top:el.offsetTop};
	while( el = el.offsetParent ){
		offset.left += el.offsetLeft;
		offset.top += el.offsetTop;
	}
	return offset;
};

/* not finish yet */
//convert unknown(maybe px or number) to px or number
Cat.toPx = function(unknown){
	return typeof unknown === 'number' ? 
	unknown+'px' : (unknown.indexOf('px') === -1 ? unknown+"px" : unknown);
};
Cat.toNum = function(unknown){
	return typeof unknown === 'number' ? 
	unknown : (unknown.indexOf('px') === -1 ? +unknown : unknown.slice(0,-2));
};
Cat.animate = function(element,properties,duration){
	duration = duration || 1000;
	var interval = 50 , rate = duration/interval;

	var change = function(){
	};

	setInterval(change,interval);
	setTimeout(function(){
		clearInterval(change);
	},rate);

};

//exports.Cat = Cat;
