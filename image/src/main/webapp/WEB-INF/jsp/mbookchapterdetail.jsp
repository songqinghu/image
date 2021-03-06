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
    <title>${bookIntro.name}章节列表, - 最愉阅移动版</title>
	<meta name="keywords" content="${bookIntro.name}最新章节列表,${bookIntro.name}全文阅读,${bookIntro.name}无弹窗广告,${bookIntro.author},最愉阅" />
	<meta name="description" content="${bookIntro.name}是${bookIntro.author}的作品,如果你是喜欢${bookIntro.name}吧友,那么请将${bookIntro.name}章节目录加入收藏方便下次全文阅读,最愉阅将于第一时间更新${bookIntro.name}无弹窗广告最新章节列表,如发现未及时更新,请联系我们。" />
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
    	<li><a href="/m/book/index">首页</a></li>
    	<li><a href="/page/to/mbooksort">分类</a></li>
        <li><a href="/m/book/list">排行</a></li>
        <li><a href="/m/book/end/1">全本</a></li>
    </ul>
</div>
<div class="search">
  <form name="articlesearch" action="/m/book/search">
  <input type="hidden" name="s" value="287293036948159515">
    <table cellpadding="0" cellspacing="0" style="width:100%;">
      <tr>
	<td style="background-color:#fff; border:1px solid #CCC;"><input style="height:20px;line-height:20px
;" id="s_key" name="q" type="text" class="key" value="输入书名后搜索，宁可少字不要错字" onFocus="this.value=''" /></td
>
	<td style="width:35px; background-color:#0080C0; background-image:url('/image/search.png'); background-repeat
:no-repeat; background-position:center"><input name="submit" type="submit" value="" class="go"></td>

      </tr>
    </table>
  </form>
</div>
<div style="margin-top:0px;padding-top:0px;" class="cover">
	<div id="intro" style="width:100%;margin-top:0px;padding-top:0px;" class="intro">${bookIntro.name}章节列表 <span style="float:right;padding-right:10px;"><a href="#bottom" style="color:Red;">↓直达页面底部</a></span></div>
<ul class="chapter">
      <c:forEach var="chapter"  items="${chapters}">
		<li> <a href="/m/book/detail/content/${bookIntro.intro_id}/${chapter.chapter_id}">${chapter.name}</a></li>
 	</c:forEach>  
</ul>

<div id="bottom" class="read">

<span><a href="#intro"><h3>[返回顶部]</h3></a></span>
</div>

<div class="nav">
    <ul>
    	<li><a href="/m/book/detail/intro/${bookIntro.intro_id}">${bookIntro.name}</a></li>
    	<li><a href="/m/book/index">首页</a></li>
    	<li><a href="/page/to/mbooksort">分类</a></li>
        <li><a href="/m/book/list">排行</a></li>
        <li><a href="/m/book/end/1">全本</a></li>
    </ul>
</div>


  </body>

</html>