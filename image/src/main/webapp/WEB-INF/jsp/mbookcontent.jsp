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
	<link rel="stylesheet" type="text/css" href="/css/bookstyle.css" />
	<script src="/js/bookcommon.js"></script>
	<script src="/js/read.js"></script>
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
    	<script>
  	 $.ajax(  
		        {  
		            type : 'GET',  
		            url : 'http://www.zuiyuyue.com/spider/show/count',  
		        });  
	</script>
  </head>
<body id="nr_body" class="nr_all c_nr">
<div class="nr_set">
	<div id="lightdiv" class="set1" onclick="nr_setbg('light')">关灯</div>
	<div id="huyandiv" class="set1" onclick="nr_setbg('huyan')">护眼</div>
	<div class="set2"><div>字体：</div>
	<div id="fontbig" onclick="nr_setbg('big')">大</div> 
	<div id="fontmiddle" onclick="nr_setbg('middle')" >中</div> 
	<div id="fontsmall" onclick="nr_setbg('small')">小</div></div>
	<div class="cc"></div>
</div>
<div class="nr_title" id="nr_title">${bookIntro.name}</div>
<div class="nr_title" id="nr_title">${bookContent.name}</div>
<script>style_head()</script>
<div class="nr_page">
<table cellpadding="0" cellspacing="0">
<tr>
<td class="prev">
<%--     <c:if test="${prev ==0}">
		<a id="pt_prev" href="/m/book/detail/chapter/${bookIntro.intro_id}">已到第一章</a>
	</c:if> --%>
	<c:if test="${prev > 0}">
		<a id="pt_prev" href="/m/book/detail/content/${bookIntro.intro_id}/${prev}">上一章</a>
	</c:if>
</td>
<td class="mulu"><a id="pt_mulu" href="/m/book/detail/chapter/${bookIntro.intro_id}">返回目录</a></td>
<td class="next">
<%--     <c:if test="${after ==0}">
		<a id="pt_next" href="/m/book/detail/chapter/${bookIntro.intro_id}">已到最后</a>
	</c:if> --%>
	<c:if test="${after > 0}">
		<a id="pt_next" href="/m/book/detail/content/${bookIntro.intro_id}/${after}">下一章</a>
	</c:if>
	
</td>
</tr>
</table>
</div>
<script>style_top()</script>
<div id="nr" class="nr_nr">
   <div id="nr1">
		 ${bookContent.showContent}
	</div>
<!-- <div style="text-align:center;margin-bottom:0px">
	<a style="text-align:center;color:red;"  onclick='shuqian(21470,1394111,"http://m.zuiyuyue.com/21_21470/1394111.html","楔子")'>『加入书签，方便阅读』</a></div>
</div> -->
<div class="nr_page">
   <script>style_middle()</script>
   <table cellpadding="0" cellspacing="0">
     <tr>
<td class="prev">
<%--     <c:if test="${prev ==0}">
		<a id="pt_prev" href="/m/book/detail/chapter/${bookIntro.intro_id}">已到第一章</a>
	</c:if> --%>
	<c:if test="${prev > 0}">
		<a id="pt_prev" href="/m/book/detail/content/${bookIntro.intro_id}/${prev}">上一章</a>
	</c:if>
</td>
	<td class="mulu"><a id="pt_mulu" href="/m/book/detail/chapter/${bookIntro.intro_id}">返回目录</a></td>
	<td class="next">
	<%--     <c:if test="${after ==0}">
			<a id="pt_next" href="/m/book/detail/chapter/${bookIntro.intro_id}">已到最后</a>
		</c:if> --%>
		<c:if test="${after > 0}">
			<a id="pt_next" href="/m/book/detail/content/${bookIntro.intro_id}/${after}">下一章</a>
		</c:if>
		
	</td>
     </tr>
          <tr>
	<td class="prev">
		<a id="pt_prev" href="/m/book/list">首页</a>
	</td>
	<td class="mulu">
		<a id="pt_mulu" href="/m/book/detail/intro/${bookIntro.intro_id}">返回 ${bookIntro.name}</a></td>
	<td class="next">
		
	</td>
     </tr>
   </table>
</div>

</body>
</html>
