function jQuery(selector) {
	var el = document.querySelectorAll(selector);
	
	el.html =  function(value) {
		if (arguments.length == 0) {
			return this[0].innerHTML;
		}
		for (var e of el) {
			e.innerHTML = value;
		}
	};
	
	el.css =  function(name, value) {
		if (arguments.length == 0) {
			return; //찾은게 없으면 리턴
		}
		
		if (arguments.length == 1) {
			return this[0].style[name];
		}
		for (var e of el) {
			e.style[name] = value;
		}
	};
	
	el.on = function(event, listener) {
		if (arguments.length < 2) {
			return; //찾은게 없으면 리턴
		}
		
		for (var e of el) {
			e.addEventListener(event, listener);
		}
	};
	
	return el;
	
};

var $ = jQuery; //제이쿼리에있는 함수를 $에 넣는다.