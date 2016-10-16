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



<div class="toptab">
	<span class="active">小说列表</span>
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
<!-- 			天地本源之火有九种形态，赤，橙，黄，绿，青，蓝，紫，黑，白。紫焰成神，黑焰灭世，白焰创生。&nbsp;&nbsp;&nbsp;&nbsp;杨逍第一世，乃紫焰成神的天生
			火神，站在众神之巅，却因顽石所化的肉身，无法更进一步，成为主宰，无奈自斩，投身人族。第二世，人族至尊，天生道体，却为人所算计，最终，虽集天下灵药之大成，化为人族药祖，炼出绝世神丹，也逃不过，自爆神格的
			下场。&nbsp;&nbsp;&nbsp;&nbsp;如今，百万年之后，昔年好友，师尊，道侣，皆不知所踪，却在凡俗小地，强者归来！&nbsp;&nbsp;&nbsp;&nbsp;“这一世，我定要踏上那
			主宰之境，算计我的，背叛我的，玩弄我的，皆要死！” -->
			</div>
		</div>
	</div>
 
 	</c:forEach>                   

<!-- <div class="footer">
  <ul>
    <li><a href="/">首页</a></li>
    <li><a href="http://www.zuiyuyue.com/">电脑版</a></li>
    <li><a href="/bookcase.php">书架</a></li>
  </ul>
</div> -->
<span style="display:none;"><script>tj()</script></span>


     <script>
function page(){
	var p = document.getElementById("pageinput").value;
	if(isPositiveNum(p)){window.open("/fenlei1_"+p+".html","_self");}
	function isPositiveNum(s){ 
    var re = /^[0-9]*[1-9][0-9]*$/ ;  
	    return re.test(s)  
	}
}
document.getElementById("s1").style.cssText = "background-color:#CCCCCC";
</script>

</body>


<%-- <table class="table table-striped">
  <caption align="top" class=" text-center" >小说列表</caption>
  <thead>
    <tr>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="book"  items="${list}">
	    <tr>
	      <td>${book.name}</td>
	      <td>${book.author}</td>
	      <td>${book.newchapter}</td>
	    </tr>
 	</c:forEach>
  </tbody>
</table> --%>

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
  </body>

</html>