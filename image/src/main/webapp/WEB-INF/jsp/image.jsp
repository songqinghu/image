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
    <title>${nowImageType.typeName}_性感图片_${nowImageType.typeName}美女套图 - 最愉阅-美女图片</title>
	<meta name="keywords" content="性感美女,性感图片,美女套图" />
	<meta name="description" content="性感美女频道提供各类顶级美女机构性感美女图片，如推女郎、秀人网、ROSI等众多性感美女写真及大胆日本美女艺术套图。" />
    <!-- Bootstrap -->
    <link href="http://www.zuiyuyue.com/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="http://www.zuiyuyue.com/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="http://www.zuiyuyue.com/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
  	<link rel="shortcut icon" href="http://www.zuiyuyue.com/image/logo.gif" type="image/x-icon">
    <link href="http://www.zuiyuyue.com/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.kuaikanwang.com/xinggan/" >
    <meta name="mobile-agent" content="format=html5;url=http://m.zuiyuyue.com"/>
    
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    
    <script src="/css/uaredirect.js" type="text/javascript"></script>
    <script type="text/javascript">uaredirect("http://m.kuaikanwang.com/xinggan/");</script>
  </head>
  <body>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://www.zuiyuyue.com/js/bootstrap.min.js"></script>


<div class="toper">

</div>
<div class="header">
<!--    <a href="http://www.zuiyuyue.com">
   <img height="50%" width="15%" alt="http://www.zuiyuyue.com" src="http://www.zuiyuyue.com/image/logo.gif">
   </a> -->
   <div class="share">
<div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a title="分享到QQ空间" href="#" class="bds_qzone" data-cmd="qzone"></a><a title="分享到新浪微博" href="#" class="bds_tsina" data-cmd="tsina"></a><a title="分享到腾讯微博" href="#" class="bds_tqq" data-cmd="tqq"></a><a title="分享到人人网" href="#" class="bds_renren" data-cmd="renren"></a><a title="分享到微信" href="#" class="bds_weixin" data-cmd="weixin"></a></div>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
   </div>
   <div  class="search">
      <a href="http://www.zuiyuyue.com">
      <img height="300%" width="100%" alt="http://www.zuiyuyue.com" src="http://www.zuiyuyue.com/image/logo.gif">
      </a>
   </div>
   <!-- 暂时不要搜索部分 后期使用 solr 再加入 -->
<!--    <div class="search">
   <form id="form1" name="form1" method="post" action="/search/">
   <input type="text"name="keyword" id="textfield" class="search_text"/>
   <input type="image" name="imageField" id="imageField" src="http://www.zuiyuyue.com/image/search_btn.png" />
   </form>

   </div> -->
<!-- <div class="search_hot"><a>热门搜索：</a>这里应该是动态生成的! 先写死
    <a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=性感美女">性感美女</a>
    <a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=mm">mm</a>
	<a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=图片">图片</a>
	<a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=妹子图">妹子图</a>
	<a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=人体艺术">人体艺术</a>
</div> -->
</div>
<div class="nav">
   <ul>
      <li><a href='http://www.zuiyuyue.com/'>首页</a></li>
      <!-- 这里是动态从数据库中获取图片分类 -->
       <c:forEach var="type"  items="${imageTypeList}">
  		<li><a href='http://www.zuiyuyue.com/images/${type.imageType}/list'>${type.typeName}</a></li>
	  </c:forEach>

      
   </ul>
</div>
<div class="main">
   <dl class="list-left public-box">
   	  <!-- 这里应该也是动态的 -->
      <dt class="public-title">您的位置:<a href='http://www.zuiyuyue.com/'>最愉阅</a> > <a href='http://www.zuiyuyue.com/images/${nowImageType.imageType}/list'>${nowImageType.typeName}</a> > 图集列表</dt>
      <!-- 这里应该也是动态的获取数据 -->
      <c:forEach var="image"  items="${list}">
  		<dd><a target="_blank" href="http://www.zuiyuyue.com/images/detail?pid=${image.pid}"><img src="${image.picUrl}" alt="${image.picName}" width="120" height="160" />${image.picName}</a></dd>	 
	  </c:forEach>
      <!-- ajax进行局部数据刷新 -->
      <!-- 如果当前页小于5那就显示1到10页 -->
      <dd class="page">
           <a href='?pageNum=1' class="page-en">首页</a>
            <c:if test="${nowPage > 1}">
  				 <a href='?pageNum=${nowPage - 1}' class="page-en">上一页</a>
			</c:if>
             <c:forEach var="page"  items="${pageList}">
             <c:choose>
    			<c:when test="${nowPage == page}">
     				 <span class="page_now">${nowPage}</span>
    			</c:when>

   				 <c:otherwise>
        			<a href='?pageNum=${page}' class="page-en">${page}</a>
   			 	</c:otherwise>
			</c:choose>
	 		 </c:forEach>
      	    <c:if test="${nowPage < maxPage}">
  				 <a href='?pageNum=${nowPage + 1}' class="page-en">下一页</a>
			</c:if>
      		<a href='?pageNum=${maxPage}' class="page-en">末页</a>
     </dd>
   </dl>
   <div class="main-right">
<!--       <dl class="cool public-box">
         <dd><a href="http://site.baidu.com" target="_blank"><img src="http://img1.mm131.com/image/baidu.jpg" border="0" /></a></dd>
      </dl> -->
      <dl class="list_hot public-box">
         <dt class="public-title">浏览排行</dt>
         <!-- 动态生成 -->
            <c:forEach var="image"  items="${countPicList}">
         	        <dd><a target="_blank" href="http://www.zuiyuyue.com/images/detail?pid=${image.pid}">${image.picName}</a></dd>
	  	     </c:forEach>
<!--           <dd><a target="_blank" href="http://www.mm131.com/xinggan/2155.html">mm王语纯诱惑黑丝透明情趣大PK</a></dd>
	      <dd><a target="_blank" href="http://www.mm131.com/xinggan/2283.html">推女郎易阳丰臀巨乳让人垂涎三尺</a></dd>
		  <dd><a target="_blank" href="http ://www.mm131.com/xinggan/2250.html">妹子艾莉Evelyn紧身内内刺激男人眼</a></dd>
		  <dd><a target="_blank" href="http://www.mm131.com/xinggan/1419.html">蕾丝兔宝宝海边性感露臀写真</a></dd>
		  <dd><a target="_blank" href="http://www.mm131.com/xinggan/513.html">日本媚娘新图精选无水印</a></dd>
		  <dd><a target="_blank" href="http://www.mm131.com/xinggan/2148.html">尤果网齐贝贝浴室内湿身诱惑写真</a></dd>
		  <dd><a target="_blank" href="http://www.mm131.com/xinggan/2359.html">果儿mm肥硕美乳圆润玉滑诱惑有加</a></dd>
		  <dd><a target="_blank" href="http://www.mm131.com/xinggan/2260.html">麻辣教官刘娅希与小猎物的激情碰撞</a></dd>
		  <dd><a target="_blank" href="http://www.mm131.com/xinggan/2424.html">推女郎易阳露深沟巨大美乳呼之欲出</a></dd>
		  <dd><a target="_blank" href="http://www.mm131.com/xinggan/2334.html">美乳黄佳丽为博欢心几近全裸上阵</a></dd> -->
      </dl>
      <dl class="channel_list public-box list_new">
         <dt class="public-title">最近更新</dt>
         	<!-- 动态生成 -->
         	    <c:forEach var="image"  items="${latestPicList}">
         	        <dd><a target="_blank" href="http://www.zuiyuyue.com/images/detail?pid=${image.pid}">${image.picName}</a></dd>
	  			</c:forEach>
      </dl>
   </div>
   <div class="clearfloat"></div>
</div>
  <div class="footer">本站纯属免费<a href="http://www.zuiyuyue.com/" title="美女图片">美女图片</a>欣赏网站,所有<a href="http://www.zuiyuyue.com/" title="mm">mm</a>图片均收集于互联网,如有侵犯版权请来信告知,我们将立即更正。<br />&copy; 2016 (<a href="/" target="_blank">www.zuiyuyue.com</a>) 最愉阅 美女图片 版权所有  <script type="text/javascript" src="http://www.zuiyuyue.com/css/stat.js"></script></div>
  </body>
</html> 





