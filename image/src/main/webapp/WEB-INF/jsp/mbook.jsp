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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="http://www.zuiyuyue.com">最愉阅</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav" id="showList">
        <li ><a href="/book/list">首页</a></li>
        <li ><a href="/m/image/2/detail/list">分类</a></li>
        <li ><a href="/m/image/3/detail/list">排行</a></li>
        <li ><a href="/m/image/3/detail/list">全本</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<table class="table table-striped">
  <caption align="top" class=" text-center" >小说列表</caption>
  <thead>
    <tr>
      <th>名称</th>
      <th>作者</th>
      <th>最新章节</th>
      <th>简介</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="book"  items="${list}">
	    <tr>
	      <td>${book.name}</td>
	      <td>${book.author}</td>
	      <td>${book.name}</td>
	      <td>${book.introInfo}</td>
	    </tr>
 	</c:forEach>
  </tbody>
</table>

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
    <li>
      <a href="?pageNum=${maxPage}" aria-label="Next">
        <span aria-hidden="true">末页</span>
      </a>
    </li>
  </ul>
  </body>

</html>