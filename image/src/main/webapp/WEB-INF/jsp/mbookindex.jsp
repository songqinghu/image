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
    
   		<title>最愉阅_移动版_无弹窗书友最值得收藏的网络小说阅读网</title>
		<meta name="keywords" content="最愉阅,无弹窗,小说阅读网,biquge" />
		<meta name="description" content="最愉阅是广大书友最值得收藏的网络小说阅读网，网站收录了当前最火热的网络小说，免费提供高质量的小说最新章节，是广大网络小说爱好者必备的小说阅读网。" />
		<meta name="MobileOptimized" content="240"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0,  minimum-scale=1.0, maximum-scale=1.0" />
		<link rel="shortcut icon" href="/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="/css/mulu.css" />
    
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


<div class="article">
	<h2 class="title"><span><a href="#">封面强推</a></span></h2>
	 <c:forEach var="book"  items="${hotBooks}">
           <div class="block">
                <div class="block_img">
                   <a href="/m/book/detail/intro/${book.intro_id}">
                	 <img height=100 width=80 src="${book.old_pic_url}" onerror="this.src='/image/book-noimg.jpg'"/>
                   </a>
                </div>
                <div class="block_txt">
                    <p><a href="/m/book/detail/intro/${book.intro_id}"><h2>${book.name}</h2></a></p>
                    <p>作者：${book.author}</p>
                    <p><a href="/m/book/detail/intro/${book.intro_id}">
                        <font size=0.5>${book.introInfo}</font>
                        </a>
                    </p>
                 </div>
                <div style="clear:both"></div>
            </div>
     </c:forEach>   
        
</div>

<div class="article">
	<h2 class="title"><span><a href="/m/book/type/1/1">玄幻奇幻</a></span><a href="/m/book/type/1/1">更多...</a></h2>
	<div class="block">
		<ul>
		     <c:forEach var="book"  items="${booktypes[1]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>    
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/m/book/type/2/1">武侠仙侠</a></span><a href="/m/book/type/2/1">更多...</a></h2>
	<div class="block">
		<ul>
		     <c:forEach var="book"  items="${booktypes[2]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/m/book/type/3/1">都市言情</a></span><a href="/m/book/type/3/1">更多...</a></h2>
	<div class="block">
		<ul>
		     <c:forEach var="book"  items="${booktypes[3]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>
                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/m/book/type/4/1">青春校园</a></span><a href="/m/book/type/4/1">更多...</a></h2>
	<div class="block">
		<ul>
		    <c:forEach var="book"  items="${booktypes[4]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>
                
		</ul>
	</div>
</div>
    
<div class="article">
	<h2 class="title"><span><a href="/m/book/type/5/1">穿越架空</a></span><a href="/m/book/type/5/1">更多...</a></h2>
	<div class="block">
		<ul>
		     <c:forEach var="book"  items="${booktypes[5]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/m/book/type/6/1">惊悚悬疑</a></span><a href="/m/book/type/6/1">更多...</a></h2>
	<div class="block">
		<ul>
				     <c:forEach var="book"  items="${booktypes[6]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>
                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/m/book/type/7/1">历史军事</a></span><a href="/m/book/type/7/1">更多...</a></h2>
	<div class="block">
		<ul>
		     <c:forEach var="book"  items="${booktypes[7]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>
		</ul>
	</div>
</div>
    
<div class="article">
	<h2 class="title"><span><a href="/m/book/type/8/1">游戏竞技</a></span><a href="/m/book/type/8/1">更多...</a></h2>
	<div class="block">
		<ul>
		     <c:forEach var="book"  items="${booktypes[8]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/m/book/type/9/1">耽美同人</a></span><a href="/m/book/type/9/1">更多...</a></h2>
	<div class="block">
		<ul>
		     <c:forEach var="book"  items="${booktypes[9]}">
                    <li><a href="/m/book/detail/intro/${book.intro_id}" class="blue">${book.name}</a>/${book.author}</li>
            </c:forEach>
		</ul>
	</div>
</div>


</body>
<div class="nav">
    <ul>
    	<li><a href="/">最愉阅</a></li>
    	<li><a href="/m/book/index">首页</a></li>
    	<li><a href="/page/to/mbooksort">分类</a></li>
        <li><a href="/m/book/list">排行</a></li>
        <li><a href="/m/book/end/1">全本</a></li>
    </ul>
</div>

</html>