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
  		<title>${list[0].gifName} 邪恶动态图 - 最愉阅-啪啪啪动态图-papapa</title>
	</c:if>
    <c:if test="${nowPage > 1}">
  		<title>${list[0].gifName} 邪恶动态图 - 最愉阅-啪啪啪动态图-papapa-第${nowPage}页</title>
	</c:if>
	
<meta name="keywords" content="啪啪啪,邪恶,动态图,papapa" />
<meta name="description" content="最愉阅官网提供最热门啪啪啪动态图,热门邪恶动态图,给你最想要的啪啪啪资源"/>

<link rel="shortcut icon" href="http://www.zuiyuyue.com/image/logo.gif" type="image/x-icon">
<link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.zuiyuyue.com" >
<meta name="mobile-agent" content="format=html5;url=http://m.zuiyuyue.com"/>


<%-- <meta name="robots" content="noarchive">--%>

<link href="http://www.zuiyuyue.com/css/app.css"  media="screen, projection" rel="stylesheet" type="text/css"/>
    
      <script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    
    <script src="/css/uaredirect.js" type="text/javascript"></script>
	
	<script type="text/javascript">
    	var type = window.location.href.replace("http://www.zuiyuyue.com/gif/list","").replace("?pageNum=","");
    	if(type=="" || type ==0){
    		uaredirect("http://m.zuiyuyue.com/m/gif/detail/list");
    	}else{
    		uaredirect("http://m.zuiyuyue.com/m/gif/detail/list?pageNum="+type*2);
    	}
    	
    </script>  
    
    
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

<div id="header" class="head">
<div class="content-block">
<div class="logo" id="hd_logo">
	<a href="/"><h1>最愉阅-啪啪啪动态图</h1></a>
</div>
<div id="menu" class="menu-bar menu clearfix" style="margin:0 10px">
	<a  id="highlight"  href="/gif/list">啪啪啪</a>
	<a  href="/images/1/list">美女图片</a>
	<%--<a  href="/" rel="nofollow">热门</a>
	<a  href="/hot/">24小时</a>
	<a  href="/text/">文字</a>
	<a  href="/history/">穿越</a>
	<a  href="/pic/">糗图</a>
	<a  href="/textnew/">新鲜</a>
	<a  class="fn-signin-required" href="javascript:void(0);" data-go="/add" rel="nofollow">投稿</a>
	--%>
</div>
<%-- <div class="userbar clearfix">
	<div class="login hidden">
		<a href="/my" class="username" id="uname" rel="nofollow"></a>
	</div>
<div class="logout">
	<a href="javascript:void(0);" class="fn-signin-required logintop" id='logintop' rel="nofollow" style="font-size:16.5px;">登录</a>
</div> --%>
</div>
</div>
</div>



<div id="content" class="main">
<div class="content-block clearfix">

<div id="content-left" class="col1">
  <c:forEach var="gif" items="${list}" >
 
<div class="article block untagged mb15" id='qiushi_tag_117404086'>

	<div class="author clearfix">
		<a href="/" target="_blank" rel="nofollow">
			<img src="http://www.zuiyuyue.com/image/logo.png" alt="最愉阅"/>
		</a>
		<a href="/" target="_blank" title="啪啪啪动态图">
			<h2>最愉阅-啪啪啪动态图</h2>
		</a>
	</div>
	<div class="content">
		${gif.gifName}
	</div>
	<div class="thumb">
		<a href="#" target="_blank">
			<img src="${gif.gifUrl}" alt="${gif.gifName}"  rel="nofollow"/>
		</a>
	</div>

<%--	<div class="stats">
	<span class="stats-vote"><i class="number">522</i> 好笑</span>
	<span class="stats-comments">
		<span class="dash"> · </span>
		<a href="/article/117404086" data-share="/article/117404086" id="c-117404086" class="qiushi_comments" target="_blank">
		<i class="number">11</i> 评论
		</a>
	</span>
</div>
<div id="qiushi_counts_117404086" class="stats-buttons bar clearfix">
<ul class="clearfix">
<li id="vote-up-117404086" class="up">
<a href="javascript:voting(117404086,1)" class="voting" data-article="117404086" id="up-117404086" rel="nofollow">
<i></i>
	<span class="number hidden">534</span>
</a>
</li>
<li id="vote-dn-117404086" class="down">
<a href="javascript:voting(117404086,-1)" class="voting" data-article="117404086" id="dn-117404086" rel="nofollow">
<i></i>
	<span class="number hidden">-12</span>
</a>
</li>

<li class="comments">
	<a href="/article/117404086" id="c-117404086" class="qiushi_comments" target="_blank">
	<i></i>
	</a>
</li>

</ul>
</div>
<div class="single-share">
<a class="share-wechat" data-type="wechat" title="分享到微信" rel="nofollow">微信</a>
<a class="share-qq" data-type="qq" title="分享到QQ" rel="nofollow">QQ</a>
<a class="share-qzone" data-type="qzone" title="分享到QQ空间" rel="nofollow">QQ空间</a>
<a class="share-weibo" data-type="weibo" title="分享到微博" rel="nofollow">微博</a>
</div>
<div class="single-clear"></div>
--%>
</div>
 </c:forEach>

<ul class="pagination">


<c:forEach var="page"  items="${pageList}">
     <c:choose>
    	<c:when test="${nowPage == page}">
    	<li>
			<span class="current" >
				${nowPage}
			</span>
			</li>
    	</c:when>

   	    <c:otherwise>
   	    <li>
		   <a href='?pageNum=${page}' >
			<span class="page-numbers">
				${page}
			</span>
			</a>
		</li>
   	    </c:otherwise>
	</c:choose>
</c:forEach>
      	    <c:if test="${nowPage < maxPage}">
      	    <li>
			<a href='?pageNum=${nowPage + 1}' >
				<span class="next">
				下一页
				</span>
			</a>
			</li>
			</c:if>          
</ul>

</div>
<div class="col2">
<div id="sidebar" class="sidebar">
<div class="sidebar-tutorial clearfix">
<h3>愉阅小提示</h3>
<div class="sidebar-tutorial-block">
<div class="sidebar-tutorial-keyboard"></div>
<div class="sidebar-tutorial-text">按 Ctrl+D 键，<br/>把最愉阅加入收藏夹</div>
</div>
</div>
<div class="sidebar-tag clearfix">
<h3>美女图片精选</h3>
<div class="sidebar-tag-block">

<c:forEach  var="pic"  items="${newList}">
	<a href="/images/detail?pid=${pic.pid}">${pic.picName}</a>
</c:forEach>
</div>
</div>
<div class="sidebar-hot clearfix">
<h3>性感美女精选</h3>
<ul>

<c:forEach var="max"  items="${maxList}">
<li class="item">
<a href="/images/detail?pid=${max.pid}" title="${max.picName}" rel="nofollow">
<span>
<img src="${max.picUrl}" alt="${max.picName}"   rel="nofollow">
</span>
</a>
<a href="/images/detail?pid=${max.pid}" title="${max.picName}">
<p>${max.picName}</p>
</a>
</li>
</c:forEach>
</ul>
</div>
<%--
<div class="sidebar-tag clearfix">
<h3>热门话题</h3>
<div class="sidebar-tag-block">


<a href="/joke/14149/">老外中文考试笑话</a>

</div>
</div>

<div class="sidebar-tag clearfix">
<h3>热门话题</h3>
<div class="sidebar-tag-block">
<a href="/joke/14149/">老外中文考试笑话</a>
</div>
</div>
 --%>

</div>
</div>



</div>
</div>


<div class="foot">

<%-- <div class="foot-nav clearfix">
<div class="foot-nav-col">
<h3>
关于
</h3>
<ul>
<li>
<a href="http://about.qiushibaike.com/web_jobs.html#team" target="_blank" rel="nofollow">
关于糗百
</a>
</li>
<li>
<a href="http://about.qiushibaike.com/web_jobs.html#tech" target="_blank" rel="nofollow">
加入我们
</a>
</li>
<li>
<a href="http://about.qiushibaike.com/web_jobs.html#contact" target="_blank" rel="nofollow">
联系方式
</a>
</li>
</ul>
</div>
<div class="foot-nav-col">
<h3>
帮助
</h3>
<ul>
<li>
<a href="http://about.qiushibaike.com/feedback.html" target="_blank" rel="nofollow">
在线反馈
</a>
</li>
<li>
<a href="http://about.qiushibaike.com/agreement.html" target="_blank" rel="nofollow">
用户协议
</a>
</li>
<li>
<a href="http://about.qiushibaike.com/policy.html" target="_blank" rel="nofollow">
隐私政策
</a>
</li>
</ul>
</div>
<div class="foot-nav-col">
<h3>
下载
</h3>
<ul>
<li>
<a href="http://android.myapp.com/android/appdetail.jsp?appid=107431&icfa=15144196000105020000&lmid=2031" target="_blank" rel="external nofollow">
Android 客户端
</a>
</li>
<li>
<a href="http://itunes.apple.com/app/id422853458" target="_blank" rel="external nofollow">
iPhone 客户端
</a>
</li>
</ul>
</div>
<div class="foot-nav-col">
<h3>
关注
</h3>
<ul>
<li>
<a href="#" class="foot-wechat">
微信
<div class="foot-wechat-tips">
<span class="foot-wechat-icon"></span>
手机扫描二维码关注
</div>
</a>
</li>
<li>
<a href="http://weibo.com/qiushibaike" target="_blank" rel="external nofollow">
新浪微博
</a>
</li>
<li>
<a href="http://user.qzone.qq.com/1492495058" target="_blank" rel="external nofollow">
QQ空间
</a>
</li>
</ul>
</div>
<div class="foot-nav-col">
<h3>
组织
</h3>
<ul>
<li>
<a href="http://shang.qq.com/wpa/qunwpa?idkey=da34d190ca97a0b21d64ebc6f3ab72c076ed35820e629b78fcf9f6a78f7063cd" target="_blank" rel="external nofollow">
网站反馈群
</a>
</li>
<li>
<a href="http://user.qzone.qq.com/1492495058/blog/1408597608" target="_blank"
rel="external nofollow">官方粉丝群
</a>
</li>
</ul>
</div>
</div> --%> 
<div class="foot-copyrights">
<p>&copy; 2016 zuiyuyue.com 最愉阅版权所有</p>
<p>
<span>本站纯属免费动态图欣赏网站,所有动态图均收集于互联网,如有侵犯版权请来信告知,我们将立即更正。</span>

<%-- 
<span>京ICP备14028348号-1</span>
<span>京ICP证140448号</span>
<span>京公网安备11010502026088</span>
--%>
</p>
</div>
</div>
<%--<div class="signin-box" id="login-form">
<div class="sigin-left">
<div class="signin-account clearfix">
<h4 class="social-signin-heading">社交帐号登录</h4>
<a rel="external nofollow" oauth_href href="https://open.weixin.qq.com/connect/qrconnect?appid=wx559af2d26b56c655&redirect_uri=http%3A%2F%2Fwww.qiushibaike.com%2Fsession%3Fsrc%3Dwx&response_type=code&scope=snsapi_login#wechat_redirect" class="social-btn social-wechat">使用 微信 账号</a>
<a rel="external nofollow" oauth_href href="https://api.weibo.com/oauth2/authorize?client_id=63372306&redirect_uri=http%3A%2F%2Fwww.qiushibaike.com%2Fsession" class="social-btn social-weibo">使用 微博 账号</a>
<a rel="external nofollow" oauth_href href="https://graph.qq.com/oauth2.0/authorize?which=Login&display=pc&client_id=100251437&response_type=code&redirect_uri=www.qiushibaike.com/session?src=qq" class="social-btnsocial-qq">
使用 QQ 账号 </a>
</div>
<div class="signin-form clearfix">
<h4 class="social-signin-heading">糗事百科账号登录</h4>
<form method="post" action="/session">
<input type="hidden" name="_xsrf" value="2|1f5a980b|826fdf6d67c6dfcfff6c1c8f87230f63|1472561702"/>
<div class="signin-section clearfix">
<input type="text" class="form-input form-input-first" name="login" placeholder="昵称或邮箱">
<input type="password" class="form-input" name="password" placeholder="密码">
<input type="checkbox" id="remember_me" name="remember_me" checked="" value="checked" style="display:none">
</div>
<div class="signin-error" id="signin-error"></div>
<button type="submit" id="form-submit" class="form-submit">登录</button>
</form>
</div>
<div class="signin-foot clearfix">
<a rel="nofollow" href="/new4/fetchpass" class="fetch-password">忘记密码?</a>
</div>
</div>
</div>

<div class="float-nav">
<a class="float-nav-backtop" href="#" rel="nofollow">
<span class="float-nav-backtop-icon"></span>
</a>
</div>

<script type="text/javascript" src="http://static.qiushibaike.com/js/dist/web/libs.min.js?v=bc8ddd36f0e7fed7c27f437c17f23ce0"></script>
<script type="text/javascript" src="http://static.qiushibaike.com/js/dist/web/app.min.js?v=c6bf820341a79dc26f7d3545990992f7"></script>
--%>

</body>
</html>