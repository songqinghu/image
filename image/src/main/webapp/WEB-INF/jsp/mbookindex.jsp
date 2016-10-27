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
        <li><a href="/page/to/mbookend">全本</a></li>
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
	<h2 class="title"><span><a href="/fenlei1_1.html">玄幻小说</a></span><a href="/fenlei1_1.html">更多...</a></h2>
	<div class="block">
		<ul>
		    
                    <li><a href="/13_13453/" class="blue">龙王传说</a>/唐家三少</li>
                
                    <li><a href="/0_68/" class="blue">武炼巅峰</a>/莫默</li>
                
                    <li><a href="/0_168/" class="blue">择天记</a>/猫腻</li>
                
                    <li><a href="/16_16384/" class="blue">武破九霄</a>/花颜</li>
                
                    <li><a href="/0_381/" class="blue">琴帝</a>/唐家三少</li>
                
                    <li><a href="/19_19272/" class="blue">凌天战尊</a>/风轻扬</li>
                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/fenlei2_1.html">修真小说</a></span><a href="/fenlei2_1.html">更多...</a></h2>
	<div class="block">
		<ul>
		    
                    <li><a href="/0_399/" class="blue">星辰变</a>/我吃西红柿</li>
                
                    <li><a href="/21_21470/" class="blue">不朽凡人</a>/鹅是老五</li>
                
                    <li><a href="/0_314/" class="blue">求魔</a>/耳根</li>
                
                    <li><a href="/16_16431/" class="blue">一念永恒</a>/耳根</li>
                
                    <li><a href="/4_4295/" class="blue">掠天记</a>/黑山老鬼</li>
                
                    <li><a href="/0_258/" class="blue">武逆</a>/只是小虾米</li>
                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/fenlei3_1.html">都市小说</a></span><a href="/fenlei3_1.html">更多...</a></h2>
	<div class="block">
		<ul>
		    
                    <li><a href="/0_161/" class="blue">校花的贴身高手</a>/鱼人二代</li>
                
                    <li><a href="/17_17552/" class="blue">兵王传奇</a>/四行</li>
                
                    <li><a href="/0_124/" class="blue">重生之妖孽人生</a>/黄金战士</li>
                
                    <li><a href="/9_9937/" class="blue">发个微信去天庭</a>/台灯下的节奏</li>
                
                    <li><a href="/9_9364/" class="blue">都市奇门医圣</a>/一念</li>
                
                    <li><a href="/0_147/" class="blue">特种兵在都市</a>/夜十三</li>
                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/fenlei4_1.html">历史小说</a></span><a href="/fenlei4_1.html">更多...</a></h2>
	<div class="block">
		<ul>
		    
                    <li><a href="/17_17502/" class="blue">逆明1644</a>/天涯海跃</li>
                
                    <li><a href="/17_17069/" class="blue">庶子风流</a>/上山打老虎额</li>
                
                    <li><a href="/17_17709/" class="blue">最强特种兵之龙刺</a>/赤色星尘</li>
                
                    <li><a href="/0_95/" class="blue">三国之暴君颜良</a>/陷阵都尉</li>
                
                    <li><a href="/0_9/" class="blue">大官人</a>/三戒大师</li>
                
                    <li><a href="/14_14362/" class="blue">寒门状元</a>/天子</li>
                
		</ul>
	</div>
</div>
    
<div class="article">
	<h2 class="title"><span><a href="/fenlei5_1.html">科幻小说</a></span><a href="/fenlei5_1.html">更多...</a></h2>
	<div class="block">
		<ul>
		    
                    <li><a href="/17_17602/" class="blue">重生之丧尸围城</a>/YY无罪</li>
                
                    <li><a href="/4_4292/" class="blue">修真四万年</a>/卧牛真人</li>
                
                    <li><a href="/9_9389/" class="blue">我在末世有套房</a>/晨星LL</li>
                
                    <li><a href="/0_54/" class="blue">末日新世界</a>/暗黑茄子</li>
                
                    <li><a href="/4_4326/" class="blue">重启末世</a>/古羲</li>
                
                    <li><a href="/0_122/" class="blue">希灵帝国</a>/远瞳</li>
                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/fenlei6_1.html">网游小说</a></span><a href="/fenlei6_1.html">更多...</a></h2>
	<div class="block">
		<ul>
		    
                    <li><a href="/9_9362/" class="blue">重生之最强剑神</a>/天运老猫</li>
                
                    <li><a href="/4_4540/" class="blue">网游之大盗贼</a>/泛舟填词</li>
                
                    <li><a href="/0_185/" class="blue">英雄监狱</a>/黄华溢</li>
                
                    <li><a href="/11_11443/" class="blue">超级指环王</a>/兔来割草</li>
                
                    <li><a href="/10_10479/" class="blue">网游之逆天戒指</a>/上古圣贤</li>
                
                    <li><a href="/16_16198/" class="blue">武林半侠传</a>/文抄公</li>
                
		</ul>
	</div>
</div>

<div class="article">
	<h2 class="title"><span><a href="/fenlei7_1.html">女频小说</a></span><a href="/fenlei7_1.html">更多...</a></h2>
	<div class="block">
		<ul>
		    
                    <li><a href="/22_22600/" class="blue">深宫弃妃：皇上别过来</a>/萌不萌</li>
                
                    <li><a href="/21_21877/" class="blue">千亿盛宠：大叔，吻慢点</a>/荷小仙</li>
                
                    <li><a href="/21_21435/" class="blue">高调强宠：恶魔老公，停一停</a>/单®</li>
                
		</ul>
	</div>
</div>
    


</body>
<div class="nav">
    <ul>
    	<li><a href="/">最愉阅</a></li>
    	<li><a href="/m/book/list">首页</a></li>
    	<li><a href="#">分类</a></li>
        <li><a href="#">排行</a></li>
        <li><a href="#">全本</a></li>
    </ul>
</div>

</html>