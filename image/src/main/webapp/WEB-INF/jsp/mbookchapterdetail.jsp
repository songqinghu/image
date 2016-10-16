<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <c:if test="${nowPage == 1}">
  		<title>${nowImageType.typeName}_性感图片_${nowImageType.typeName}美女套图 - 最愉阅-美女图片</title>
	</c:if>
    <c:if test="${nowPage > 1}">
  		<title>${nowImageType.typeName}_性感图片_${nowImageType.typeName}美女套图 - 最愉阅-美女图片-第${nowPage}页</title>
	</c:if>
    
    <meta name="keywords" content="${nowImageType.typeName}" />
	<meta name="description" content="${nowImageType.typeName}" />
    <!-- Bootstrap -->
    <link href="http://www.zuiyuyue.com/css/bootstrap.min.css" rel="stylesheet">
  	<link rel="shortcut icon" href="http://www.zuiyuyue.com/image/logo.gif" type="image/x-icon">
    <link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.kuaikanwang.com" >
    <link rel="stylesheet" type="text/css" href="/css/book.css" />
    <link rel="stylesheet" type="text/css" href="/css/mulu.css" />
    <meta name="mobile-agent" content="format=html5;url=http://m.zuiyuyue.com"/>
        <script>
	var _hmt = _hmt || [];
	(function() {
	  var hm = document.createElement("script");
	  hm.src = "//hm.baidu.com/hm.js?e0621038655f4a4c83fa7510e4c4d08b";
	  var s = document.getElementsByTagName("script")[0]; 
	  s.parentNode.insertBefore(hm, s);
	})();
	</script>
  </head>
  <body>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://www.zuiyuyue.com/js/bootstrap.min.js"></script>
    	<script>
  	 $.ajax(  
		        {  
		            type : 'GET',  
		            url : 'http://www.zuiyuyue.com/spider/show/count',  
		        });  
	</script>

<body>
<div class="nav">
    <ul>
    	<li><a href="/m/book/detail/intro/${bookIntro.intro_id}">${bookIntro.name}</a></li>
    	<li><a href="/m/book/list">首页</a></li>
    	<li><a href="#">分类</a></li>
        <li><a href="#">排行</a></li>
        <li><a href="#">全本</a></li>
<!--         <li><a href="/history.php">阅读记录</a></li>
        <li><a href="/bookcase.php">书架</a></li> -->
        <!-- <div class="cc"></div> -->
    </ul>
</div>
<div style="margin-top:0px;padding-top:0px;" class="cover">
	<div id="intro" style="width:100%;margin-top:0px;padding-top:0px;" class="intro">${bookIntro.name}章节列表 <span style="float:right;padding-right:10px;"><a href="#bottom" style="color:Red;">↓直达页面底部</a></span></div>
<ul class="chapter">
      <c:forEach var="chapter"  items="${chapters}">
		<li> <a href="/0_168/2502978.html">${chapter.name}</a></li>
 	</c:forEach>  
</ul>

<div id="bottom" class="read">
<h3>列表结束！（底部）</h3>
<span><a href="#intro">[返回顶部]</a></span>
</div>

<!-- <div class="footer">
  <ul>
    <li><a href="/">首页</a></li>
    <li><a href="http://www.zuiyuyue.com/">电脑版</a></li>
    <li><a href="/bookcase.php">书架</a></li>
  </ul>
</div> -->


  </body>

</html>