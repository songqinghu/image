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
    <title>小说搜索-小说搜索-最愉阅移动版</title>
	<meta name="keywords" content="最愉阅小说,小说人气月榜,小说阅读网,小说" />
	<meta name="description" content="笔趣阁小说是广大书友最值得收藏的小说阅读网，网站收录了当前最火热的小说，免费提供高质量的小说最新章节，是广大网络小说爱好者必备的小说阅读网。" />
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


<c:if test="${totalCount==1}">
<div class="toptab">
	<span class="active">小说搜索</span>
</div>

     <c:forEach var="book"  items="${list}">
<div class="bookbox">
	<div class="bookimg">
		<a href="/m/book/detail/intro/${book.intro_id}">
			<img src="${book.old_pic_url}" onerror="this.src='/image/book-noimg.jpg'">
		</a>
	</div>
    <div class="bookinfo">
    	<h4 class="bookname">
    		<i class="iTit"><a href="/m/book/detail/intro/${book.intro_id}">${book.name}</a></i>
    	</h4>
    	<div class="author">作者：${book.author}</div>
    	<div class="cl0"></div><div class="update">
    		<span>更新至：</span><a href="/m/book/detail/content/${book.intro_id}/${book.newchapterId}">${book.newchapter}</a></div>
    	<div class="cl0"></div>
    	<div class="intro_line">
    	<span>简介：
    	</span>
    	${book.introInfo}
			</div>
		</div>
	</div>
 
 	</c:forEach>                   



  <ul class="pagination">
    <li>
      <a href="?pageNum=1" aria-label="Previous">
        <span aria-hidden="true">首页</span>
      </a>
    </li>
             <c:forEach var="page"  items="${pageList}">
             <c:choose>
    			<c:when test="${nowPage == page}">
     				<li class="active"><a href='?pageNum=${nowPage}'>${nowPage}</a></li>
    			</c:when>
   				 <c:otherwise>
        			<li><a href='?pageNum=${page}'>${page}</a></li>
   			 	</c:otherwise>
			</c:choose>
	 		 </c:forEach>
      	    <c:if test="${nowPage < maxPage}">
  				<li> <a href='?pageNum=${nowPage + 1}'>下一页</a></li>
			</c:if>
  </ul>
</c:if>
<c:if test="${totalCount==0}">
	<div class="toptab">
		<span class="active">没有找到书籍</span>
	</div>
</c:if>
 
  </body>

</html>