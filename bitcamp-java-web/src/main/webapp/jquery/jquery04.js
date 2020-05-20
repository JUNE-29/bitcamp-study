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
	
	return el;
	
};

var $ = jQuery; //제이쿼리에있는 함수를 $에 넣는다.