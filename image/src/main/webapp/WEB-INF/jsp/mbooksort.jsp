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
    
   	<title>分类列表-笔趣阁移动版-最愉阅</title>
	<meta name="keywords" content="分类列表,小说分类列表" />
	<meta name="description" content="玄幻小说,修真小说,都市小说,历史小说,网游小说,科幻小说,言情小说" />
	<meta name="MobileOptimized" content="240"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
	<link rel="shortcut icon" href="/favicon.ico" />
	<meta http-equiv="Cache-Control" content="max-age=0" />
	<meta http-equiv="Cache-Control" content="no-transform " />
	<link rel="stylesheet" type="text/css" href="/css/sort.css" />
	<script src="/js/common.js"></script>
	
    
    <!-- Bootstrap -->
    <link href="http://www.zuiyuyue.com/css/bootstrap.min.css" rel="stylesheet">
  	<link rel="shortcut icon" href="http://www.zuiyuyue.com/image/logo.gif" type="image/x-icon">
    <link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.kuaikanwang.com" >
    <link rel="stylesheet" type="text/css" href="/css/book.css" />
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

<div class="nav">
    <ul>
    	<li><a href="/">最愉阅</a></li>
    	<li><a href="/page/to/mbookindex">首页</a></li>
    	<li><a href="/page/to/mbooksort">分类</a></li>
        <li><a href="/m/book/list">排行</a></li>
        <li><a href="/m/book/list">全本</a></li>
<!--         <li><a href="/history.php">阅读记录</a></li>
        <li><a href="/bookcase.php">书架</a></li> -->
        <!-- <div class="cc"></div> -->
    </ul>
</div>
 

<div class="search">
  <form name="articlesearch" action="/m/book/list">
  <input type="hidden" name="s" value="287293036948159515">
    <table cellpadding="0" cellspacing="0" style="width:100%;">
      <tr>
	<td style="background-color:#fff; border:1px solid #CCC;"><input style="height:20px;line-height:20px;" id="s_key" name="q" type="text" class="key" value="输入书名后搜索，宁可少字不要错字" onFocus="this.value=''" /></td>
	<td style="width:35px; background-color:#0080C0; background-image:url('/image/search.png'); background-repeat:no-repeat; background-position:center"><input name="submit" type="submit" value="" class="go"></td>

      </tr>
    </table>
  </form>
</div>


<div class="content">
<ul>
<li class="prev"><a href="/fenlei1_1.html">玄幻小说</a></li>
<li class="prev"><a href="/fenlei2_1.html">修真小说</a></li>
<li class="prev"><a href="/fenlei3_1.html">都市小说</a></li>
</ul>
<ul>
<li class="prev"><a href="/fenlei4_1.html">历史小说</a></li>
<li class="prev"><a href="/fenlei6_1.html">网游小说</a></li>
<li class="prev"><a href="/fenlei5_1.html">科幻小说</a></li>
</ul>
<ul>
<li class="prev"><a href="/fenlei7_1.html">言情小说</a></li>
<li class="prev"><a href="/fenlei7_1.html">言情小说</a></li>
<li class="prev"><a href="/fenlei7_1.html">言情小说</a></li>
</ul>
</div>



</body>
<div class="nav">
    <ul>
    	<li><a href="/">最愉阅</a></li>
    	<li><a href="/m/book/list"></a></li>
    	<li><a href="/m/book/list">首页</a></li>
<!--     	<li><a href="#">分类</a></li>
        <li><a href="#">排行</a></li>
        <li><a href="#">全本</a></li> -->
    </ul>
</div>

</html>