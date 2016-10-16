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
    	<li><a href="/">最愉阅</a></li>
    	<li><a href="/m/book/list">首页</a></li>
    	<li><a href="#">分类</a></li>
        <li><a href="#">排行</a></li>
        <li><a href="#">全本</a></li>
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
	<td style="background-color:#fff; border:1px solid #CCC;"><input style="height:20px;line-height:20px
;" id="s_key" name="q" type="text" class="key" value="输入书名后搜索，宁可少字不要错字" onFocus="this.value=''" /></td
>
	<td style="width:35px; background-color:#0080C0; background-image:url('/image/search.png'); background-repeat
:no-repeat; background-position:center"><input name="submit" type="submit" value="" class="go"></td>

      </tr>
    </table>
  </form>
</div>


<div class="cover">
	<div class="block">
		<div class="block_img2">
			<img src="${bookIntro.old_pic_url}" border="0" width='85' height='100' onerror="this.src='/image/book-noimg.jpg'"/>
		</div>
		<div class="block_txt2">
			<p><a><h2>${bookIntro.name}</h2></a></P>
			<p>作者：${bookIntro.author}</p>
			<p>分类：${bookIntro.booktype}</p>
			<p>状态：
			    <c:if test="${bookIntro.isend == 0}">
			  		  连载
				</c:if>
			    <c:if test="${bookIntro.isend == 1}">
			  		  完本
				</c:if>
			    <c:if test="${bookIntro.isend == 2}">
			  		  太监
				</c:if>
			</p>
			<p>更新：${bookIntro.updatedate}</p>
			<p>最新：<a href="/m/book/detail/content/${bookIntro.intro_id}/${bookIntro.newchapterId}">${bookIntro.newchapter}</a></p>
		</div>
	</div>
	<div style="clear:both"></div>
	<div class="ablum_read">
		<span style="background:#FFFFFF;float:left;width:3%"></span>
		<span class="margin_right">
			<a href="/m/book/detail/chapter/${bookIntro.intro_id}">开始阅读</a>
		</span>
<!-- 		<span class="margin_right">
			<a id='shujia' href='javascript:shujia(168,"http://m.zuiyuyue.com/0_168/")'style='color:#fff'>加入书架</a>
		</span>
		<span><a href="/bookcase.php">查看书架</a></span> -->
	</div>
	<script>biqu_top();</script>
	<div class="intro"  id="intro" name="intro">${bookIntro.name}小说简介</div>
	<script>biqu_enbto();</script>
	<div class="intro_info">
		${bookIntro.introInfo}
	</div>
	<div class="intro">${bookIntro.name}最新章节</div>
	<ul class="chapter">
	
     <c:forEach var="chapter"  items="${chapters}">
		<li> <a href="/m/book/detail/content/${bookIntro.intro_id}/${chapter.chapter_id}">${chapter.name}</a></li>
 	</c:forEach>   
	</ul>

<div class="intro"><a href="/m/book/detail/chapter/${bookIntro.intro_id}">查看完整目录</a></div>
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