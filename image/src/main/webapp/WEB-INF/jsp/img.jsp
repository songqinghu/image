<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="applicable-device"content="pc">
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
    <link href="http://www.zuiyuyue.com/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="http://www.zuiyuyue.com/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="http://www.zuiyuyue.com/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
  	<link rel="shortcut icon" href="http://www.zuiyuyue.com/image/logo.gif" type="image/x-icon">
    <link href="http://www.zuiyuyue.com/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.zuiyuyue.com/m/image/1/detail/list" >
    <meta name="mobile-agent" content="format=html5;url=http://m.zuiyuyue.com/m/image/1/detail/list"/>
    
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    
    <script src="/css/uaredirect.js" type="text/javascript"></script>
	<script type="text/javascript">
    	var type = window.location.href.replace("http://www.zuiyuyue.com/images/","").replace("/list","");
	    uaredirect("http://m.zuiyuyue.com/m/image/"+type+"/detail/list");
    </script>
    <script src="/js/referrer-killer.js"></script>
  </head>
  <body>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://www.zuiyuyue.com/js/bootstrap.min.js"></script>




	<ul>
		<li>Without sending referrer: <br/> 
		<span id="image_kill_referrer"  style='width:120px;height:160px;'>
		</span>
		</li>
		<img alt="测试" src="http://imgnew.uumnt.cc:8088/Thumb/2016/0804/ba793e8d5ed4ad3ace2e33c361fcd591.jpg">
	</ul>
	<script>
		document.getElementById('image_kill_referrer').innerHTML = ReferrerKiller.imageHtml('http://imgnew.uumnt.cc:8088/Thumb/2016/0804/ba793e8d5ed4ad3ace2e33c361fcd591.jpg');
	</script>

	
  </body>

</html> 





