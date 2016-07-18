(function($){
   $.fn.extend({
      "slidelf":function(value){
         value = $.extend({
            "prev":"",
            "next":"",
            "speed":""
         },value)
         var dom_this = $(this).get(0); //将jquery对象转换成DOM对象;以便其它函数中调用；
         var movew = 146; //需要滑动的数值
         //左边的动画
         function leftani(){
            $("ul li:first",dom_this).animate({"margin-left":-movew},value.speed,function(){
               $(this).css("margin-left",14).appendTo($("ul",dom_this));	
            });	
         }
         //右边的动画
         function rightani(){
            $("ul li:last",dom_this).prependTo($("ul",dom_this));
            $("ul li:first",dom_this).css("margin-left",-movew).animate({"margin-left":14},value.speed);
         }
         //点击左边
         $("."+value.prev).click(function(){
            if(!$("ul li:first",dom_this).is(":animated")){
               leftani();
            }	
         });
         //点击左边
         $("."+value.next).click(function(){
            if(!$("ul li:first",dom_this).is(":animated")){
               rightani();
            }	
         })
      }	
   });	
})(jQuery)
	
