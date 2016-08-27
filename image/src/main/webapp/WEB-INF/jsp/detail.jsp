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
  		<title>${image.picName}_美女图片-${nowImageType.typeName} - 最愉阅</title><!-- 动态生成标题 -->
	</c:if>
    <c:if test="${nowPage > 1}">
  		<title>${image.picName}_美女图片-${nowImageType.typeName} - 最愉阅-第${nowPage}页</title><!-- 动态生成标题 -->
	</c:if>
    
	
	<meta name="keywords" content="${image.picName}" /><!-- 动态生成关键字 -->
	<meta name="description" content="最愉阅-美女图片提供性感美女高清图片-${image.picName}。www.zuiyuyue.com" />
    
    <!-- Bootstrap -->
    <link href="http://www.zuiyuyue.com/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="http://www.zuiyuyue.com/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="http://www.zuiyuyue.com/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    
  	<link rel="shortcut icon" href="http://www.zuiyuyue.com/image/logo.gif" type="image/x-icon">
    <link href="http://www.zuiyuyue.com/css/content.css" rel="stylesheet" type="text/css" />
    <!-- 跳转到m站 -->
    <link rel="alternate" media="only screen and(max-width: 640px)" href="http://m.zuiyuyue.com/m/image/1/detail/list" >
    <meta name="mobile-agent" content="format=html5;url=http://m.zuiyuyue.com/m/image/1/detail/list"/>
    
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
    
    <script src="/css/uaredirect.js" type="text/javascript"></script>
    <script type="text/javascript">
		var param = window.location.href.replace("http://www.zuiyuyue.com/images/detail?","");
		uaredirect("http://m.zuiyuyue.com/m/image/detail?"+param);
    </script>
    <script language="javascript" src="http://www.zuiyuyue.com/js/mmpic.js"></script>
  </head>

<body>
<div class="toper">
 </div>
<div class="header">
<!--     <a href="http://www.zuiyuyue.com">
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

<!--    <div class="search">
   			<form id="form1" name="form1" method="post" action="http://www.zuiyuyue.com/search/">
   			<input type="text" name="keyword" id="textfield" class="search_text"/>
   			<input type="image" name="imageField" id="imageField" src="http://www.zuiyuyue.com/image/search_btn.png" />
   			</form>
   </div>
   <div class="search_hot"><a>热门搜索：</a><a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=美女">美女
		</a><a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=mm图片">mm图片</a>
		<a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=写真">写真</a>
		<a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=校花">校花</a>
		<a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=张馨予">张馨予</a>
		<a href="http://www.zuiyuyue.com/search/?kwtype=0&keyword=翟凌">翟凌</a>
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
<div class="place">您的位置:<a href='http://www.zuiyuyue.com/'>美女图片</a> > <a href='http://www.zuiyuyue.com/images/${nowImageType.imageType}/list'>${nowImageType.typeName}</a> > ${image.picName}</div>
<div class="content">
   <h5>${image.picName}(${nowPage})</h5>
   <div class="content-msg">更新时间：${image.createDate} <a href='http://www.zuiyuyue.com/'>最愉阅-美女图片</a></div>
   
   <div class="content-pic">
   			<a href='?pid=${pid}&pageNum=${nowPage + 1}'><!-- 下一张图片或者 下一个列表页 -->
   				<img height="100%" width="90%" alt="${image.picName}" src="${image.picUrl}" />
   			</a>
   </div>
   <div class="content-page">
            <span class="page-ch">共${maxPage}页</span>
            <c:if test="${nowPage > 1}">
  				 <a href='?pid=${pid}&pageNum=${nowPage - 1}' class="page-en">上一页</a>
			</c:if>
             <c:forEach var="page"  items="${pageList}">
             <c:choose>
    			<c:when test="${nowPage == page}">
     				 <span class="page_now">${nowPage}</span>
    			</c:when>

   				 <c:otherwise>
        			<a href='?pid=${pid}&pageNum=${page}' class="page-en">${page}</a>
   			 	</c:otherwise>
			</c:choose>
	 		 </c:forEach>
      	    <c:if test="${nowPage < maxPage}">
  				 <a href='?pid=${pid}&pageNum=${nowPage + 1}' class="page-en">下一页</a>
			</c:if>
      		<a href='?pid=${pid}&pageNum=${maxPage}' class="page-en">末页</a>
   		
   		
<!--    		<span class="page-ch">共50页</span>
   		<span class="page-ch">上一页</span>
   		<span class="page_now">1</span>
   		<a href='2569_2.html' class="page-en">2</a>
   		<a href='2569_3.html' class="page-en">3</a>
   		<a href='2569_4.html' class="page-en">4</a>
   		<a href='2569_5.html' class="page-en">5</a>
   		<a href='2569_6.html' class="page-en">6</a>
   		<a href='2569_7.html' class="page-en">7</a>
   		<a href='2569_8.html' class="page-en">8</a>
   		<a href='2569_9.html' class="page-en">9</a>
   		<a href='2569_10.html' class="page-en">10</a>
   		<a href='2569_11.html' class="page-en">11</a>
   		<a href='2569_12.html' class="page-en">12</a>
   		<a href='2569_13.html' class="page-en">13</a>
   		<a href='2569_14.html' class="page-en">14</a>
   		<a href='2569_15.html' class="page-en">15</a>
   		<a href='2569_16.html' class="page-en">16</a>
   		<a href='2569_17.html' class="page-en">17</a>
   		<a href='2569_18.html' class="page-en">18</a>
   		<a href='2569_19.html' class="page-en">19</a>
   		<a href='2569_20.html' class="page-en">20</a>
   		<a href='2569_21.html' class="page-en">21</a>
   		<a href='2569_22.html' class="page-en">22</a>
   		<a href='2569_23.html' class="page-en">23</a>
   		<a href='2569_2.html' class="page-ch">下一页</a>-->
   		</div> 
   <div class="updown">
                <c:choose>
    			<c:when test="${not empty previousImage}">
    				<a href='http://www.zuiyuyue.com/images/detail?pid=${previousImage.pid}' class="updown_l">${previousImage.picName}</a> 
    			</c:when>
   				 <c:otherwise>
        			<a href='#' class="updown_l">没有了</a>
   			 	</c:otherwise>
			</c:choose>
                <c:choose>
    			<c:when test="${not empty nextImage}">
    				<a href='http://www.zuiyuyue.com/images/detail?pid=${nextImage.pid}' class="updown_r">${nextImage.picName}</a> 
    			</c:when>
   				 <c:otherwise>
        			<a href='#' class="updown_r">没有了</a>
   			 	</c:otherwise>
			</c:choose>

<!-- 	   	<a href='http://www.mm131.com/xinggan/2568.html' class="updown_l">学生妹赵小米秀完制服诱惑秀情趣</a> 
	   	<a href='#' class="updown_r">没有了</a> -->
    </div>
   <div class="otherpic">
      <div class="arr_left"><span class="anleft"></span></div>
      <div class="otherlist" id="opic">
         <ul>
      <c:forEach var="recommendImage"  items="${recommendImageList}">
          <li>
         <a href="http://www.zuiyuyue.com/images/detail?pid=${recommendImage.pid}" target="_blank">
         <img src="${recommendImage.picUrl}" alt="${recommendImage.picName}">
         ${recommendImage.picName}
         </a>
         </li>
	  </c:forEach>
       <!--   <li>
         <a href="http://www.mm131.com/xinggan/2148.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2148/0.jpg" alt="尤果网齐贝贝浴室内湿身诱惑写真">
         尤果网齐贝贝浴室内湿
         </a>
         </li>
         <li>
         <a href="http://www.mm131.com/xinggan/2233.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2233/0.jpg" alt="火辣姐妹花大胆演绎双飞诱惑美图">
         火辣姐妹花大胆演绎双
         </a>
         </li>
         <li><a href="http://www.mm131.com/xinggan/2328.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2328/0.jpg" alt="rosi女郎制服爆扣短裙美腿内内走光">rosi女郎制服爆扣</a>
         </li>
         <li>
         <a href="http://www.mm131.com/xinggan/2500.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2500/0.jpg" alt="电臀宝贝妮可性感挤胸丁字裤吸眼球">电臀宝贝妮可性感挤胸</a>
         </li>
         <li>
         <a href="http://www.mm131.com/xinggan/1363.html" target="_blank">
         <img src="http://img1.mm131.com/pic/1363/0.jpg" alt="纯情性感美女少妇露臀秀诱惑">
         纯情性感美女少妇露臀
         </a>
         </li>
         <li>
         <a href="http://www.mm131.com/xinggan/2523.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2523/0.jpg" alt="翘臀女神玛鲁娜户外片美乳大胆外露">
         翘臀女神玛鲁娜户外片
         </a>
         </li>
         <li>
         <a href="http://www.mm131.com/xinggan/2099.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2099/0.jpg" alt="尤果翘臀美女佟蔓大胆情趣内衣秀">
         尤果翘臀美女佟蔓大胆
         </a>
         </li>
         <li>
         <a href="http://www.mm131.com/xinggan/2519.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2519/0.jpg" alt="绝色小尤物赵小米吃冰棒表情销魂">
         绝色小尤物赵小米吃冰
         </a>
         </li>
         <li>
         <a href="http://www.mm131.com/xinggan/2563.html" target="_blank">
         <img src="http://img1.mm131.com/pic/2563/0.jpg" alt="情趣女王蔡文钰绝美身材赚足你眼球">
         情趣女王蔡文钰绝美身
         </a>
         </li>
	     <li>
	     <a href="http://www.mm131.com/xinggan/2428.html" target="_blank">
	     <img src="http://img1.mm131.com/pic/2428/0.jpg" alt="黑丝贵妇黄歆苑纤细美姿惹火诱人">
	     黑丝贵妇黄歆苑纤细美
	     </a>
	     </li>
	     <li>
	     <a href="http://www.mm131.com/xinggan/2335.html" target="_blank">
	     <img src="http://img1.mm131.com/pic/2335/0.jpg" alt="绝色女仆夏美酱纹身美臀巨乳俱全">
	     绝色女仆夏美酱纹身美
	     </a>
	     </li>
	     <li>
	     <a href="http://www.mm131.com/xinggan/2050.html" target="_blank">
	     <img src="http://img1.mm131.com/pic/2050/0.jpg" alt="黑纱薄裙张栩菲展现朦胧女人美">
	     黑纱薄裙张栩菲展现朦
	     </a>
	     </li> -->
	     </ul>
      </div>
      <div class="arr_right"><span class="anright"></span></div>
   </div>
   <div style="clear:both;"><script language="javascript" src="http://www.zuiyuyue.com/js/mmm.js"></script></div>
</div>
<div class="footer">本站纯属免费<a href="http://www.zuiyuyue.com/" title="美女图片">美女图片
		</a>欣赏网站,所有<a href="http://www.zuiyuyue.com/" title="mm">mm</a>
		图片均收集于互联网,如有侵犯版权请来信告知,我们将立即更正。<br />
		&copy; 2016 (<a href="/" target="_blank">www.zuiyuyue.com</a>) 最愉阅-美女图片 版权所有 
		<script type="text/javascript" src="http://www.zuiyuyue.com/js/stat.js"></script></div>
</body>
<script type="text/javascript">

	window.onload=function(){
	
	
	var pid = "${pid}";

	
	 $.ajax(  
		        {  
		            type : 'POST',  
		            url : 'http://www.zuiyuyue.com/image/count/add/pid',  
		            data : "pid=" + pid, 
		            success : function(data)  
		            {  
		                if (data == "true")  
		                {  
		          /*           var form = document.getElementById("myForm");  
		                    form.action = "Common/source/download";  
		                    form.submit(); */  
		                }  
		                else  
		                {  
		                   /*  alert("下载出现错误!");   */
		                }  
		                return;  
		            },  
		            error : function()  
		            {  
		               /*  alert("下载出现未知错误!");   */
		            }  
		        });  
	}

</script>
</html> 