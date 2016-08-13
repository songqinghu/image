<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>最愉阅-看你所看</title>
    <!-- Bootstrap -->
    <link href="http://www.zuiyuyue.com/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="http://www.zuiyuyue.com/js/bootstrap.min.js"></script>
  
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
      <ul class="nav navbar-nav">

        <li ><a target="_blank" href="http://www.zuiyuyue.com/images/1/list">美女图片<span class="sr-only">(current)</span></a></li>
<!--         <li ><a href="http://www.zuiyuyue.com/page/detail">热门小说<span class="sr-only">(current)</span></a></li>
        <li ><a href="http://www.zuiyuyue.com/page/search">技术博客<span class="sr-only">(current)</span></a></li>
        <li ><a href="http://www.zuiyuyue.com/page/search">技术工具<span class="sr-only">(current)</span></a></li>
        <li ><a href="http://www.zuiyuyue.com/page/search">有奖建议<span class="sr-only">(current)</span></a></li>
        <li ><a href="http://www.zuiyuyue.com/page/search">加入我们<span class="sr-only">(current)</span></a></li> -->
      </ul>

      <ul class="nav navbar-nav navbar-right">
<!--       <form class="navbar-form navbar-left" role="search">
 		 <div class="form-group">
   		 <input type="text" class="form-control" placeholder="想看什么图片">
  		</div>
 		 <button type="submit" class="btn btn-default">嗖一下</button>
		</form> -->
               <li ><a href="#">有奖建议<span class="sr-only">(current)</span></a></li>
              <li ><a href="#">加入我们<span class="sr-only">(current)</span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="alert alert-success" role="alert">   本站目前已有美女图片模块,点击左上角的美女图片观看吧!                后续更多精彩内容,敬请期待!!</div>
<div class="page-header">
  <h2><span class="label label-primary">性感美女</span><small><a href="http://www.zuiyuyue.com/images/1/list" >更多</a></small></h2>
</div>
<div class="row" id="one">
</div>
<div class="page-header">
  <h1><span class="label label-success">美女诱惑</span><small><a href="http://www.zuiyuyue.com/images/3/list" >更多</a></small></h1>
</div>
<div class="row" id="two">
 
</div>
<div class="page-header">
  <h1><span class="label label-danger">性感车模</span><small><a href="http://www.zuiyuyue.com/images/4/list" >更多</a></small></h1>
</div>
<div class="row" id="three">
 
</div>
<div class="page-header">
  <h1><span class="label label-warning">清纯美女</span><small><a href="http://www.zuiyuyue.com/images/6/list" >更多</a></small></h1>
</div>
<div class="row" id="four">
 
</div>
<div class="page-header">
  <h1><span class="label label-info">明星图片</span><small><a href="http://www.zuiyuyue.com/images/7/list" >更多</a></small></h1>
</div>
<div class="row"  id="five">
 
</div>
<div class="alert alert-success" role="alert">欢迎站长联系互加友情链接!</div>
 <div class="row">
	<h3><span class="label label-warning">&nbsp;&nbsp;&nbsp;友情链接</span></h3>
	<div>
		<h4><span >&nbsp;&nbsp;&nbsp;&nbsp;友情链接&nbsp;&nbsp;友情链接&nbsp;&nbsp;友情链接&nbsp;&nbsp;友情链接</span></h4>
	</div>
  </div>
  </body>
  <script type="text/javascript">

	window.onload=function(){
	


	var pictype = 1;

	 $.ajax(  
		        {  
		            type : 'POST',  
		            url : 'http://www.zuiyuyue.com/index/show/pic',  
		            data : "pictype=" + pictype, 
		            success : function(data)  
		            {  

		                    var images = data.data;
		                    var image ;
		                    for(var i = 0 ;i<images.length; i++){
		                    	image = images[i];
		                    	$("#one").append(
"<div class=\"col-sm-6 col-md-3\"><div class=\"thumbnail\"><a href=\"http://www.zuiyuyue.com/images/detail?pid="+image.pid+"\" class=\"thumbnail\">"+
"<img src=\""+image.picUrl+"\" alt=\""+image.picName+"\"><div class=\"caption\">"+
"<h3>"+image.picName+"</h3></div></a></div></div>"
		                    	)
		                    }
		                return;  
		            },  
		            error : function()  
		            {  
		                 alert("未知错误,请刷新页面!");
		            }  
		        });  
	 

	 pictype =3;

	 $.ajax(  
		        {  
		            type : 'POST',  
		            url : 'http://www.zuiyuyue.com/index/show/pic',  
		            data : "pictype=" + pictype, 
		            success : function(data)  
		            {  

		                    var images = data.data;
		                    var image ;
		                    for(var i = 0 ;i<images.length; i++){
		                    	image = images[i];
		                    	$("#two").append(
"<div class=\"col-sm-6 col-md-3\"><div class=\"thumbnail\"><a href=\"http://www.zuiyuyue.com/images/detail?pid="+image.pid+"\" class=\"thumbnail\">"+
"<img src=\""+image.picUrl+"\" alt=\""+image.picName+"\"><div class=\"caption\">"+
"<h3>"+image.picName+"</h3></div></a></div></div>"
		                    	)
		                    }
		                return;  
		            },  
		            error : function()  
		            {  
		                 alert("未知错误,请刷新页面!");
		            }  
		        });  

	 pictype =4;

	 $.ajax(  
		        {  
		            type : 'POST',  
		            url : 'http://www.zuiyuyue.com/index/show/pic',  
		            data : "pictype=" + pictype, 
		            success : function(data)  
		            {  

		                    var images = data.data;
		                    var image ;
		                    for(var i = 0 ;i<images.length; i++){
		                    	image = images[i];
		                    	$("#three").append(
"<div class=\"col-sm-6 col-md-3\"><div class=\"thumbnail\"><a href=\"http://www.zuiyuyue.com/images/detail?pid="+image.pid+"\" class=\"thumbnail\">"+
"<img src=\""+image.picUrl+"\" alt=\""+image.picName+"\"><div class=\"caption\">"+
"<h3>"+image.picName+"</h3></div></a></div></div>"
		                    	)
		                    }
		                return;  
		            },  
		            error : function()  
		            {  
		                 alert("未知错误,请刷新页面!");
		            }  
		        });  

	 pictype =6;

	 $.ajax(  
		        {  
		            type : 'POST',  
		            url : 'http://www.zuiyuyue.com/index/show/pic',  
		            data : "pictype=" + pictype, 
		            success : function(data)  
		            {  

		                    var images = data.data;
		                    var image ;
		                    for(var i = 0 ;i<images.length; i++){
		                    	image = images[i];
		                    	$("#four").append(
"<div class=\"col-sm-6 col-md-3\"><div class=\"thumbnail\"><a href=\"http://www.zuiyuyue.com/images/detail?pid="+image.pid+"\" class=\"thumbnail\">"+
"<img src=\""+image.picUrl+"\" alt=\""+image.picName+"\"><div class=\"caption\">"+
"<h3>"+image.picName+"</h3></div></a></div></div>"
		                    	)
		                    }
		                return;  
		            },  
		            error : function()  
		            {  
		                 alert("未知错误,请刷新页面!");
		            }  
		        });  

	 pictype =7;

	 $.ajax(  
		        {  
		            type : 'POST',  
		            url : 'http://www.zuiyuyue.com/index/show/pic',  
		            data : "pictype=" + pictype, 
		            success : function(data)  
		            {  

		                    var images = data.data;
		                    var image ;
		                    for(var i = 0 ;i<images.length; i++){
		                    	image = images[i];
		                    	$("#five").append(
"<div class=\"col-sm-6 col-md-3\"><div class=\"thumbnail\"><a href=\"http://www.zuiyuyue.com/images/detail?pid="+image.pid+"\" class=\"thumbnail\">"+
"<img src=\""+image.picUrl+"\" alt=\""+image.picName+"\"><div class=\"caption\">"+
"<h3>"+image.picName+"</h3></div></a></div></div>"
		                    	)
		                    }
		                return;  
		            },  
		            error : function()  
		            {  
		                 alert("未知错误,请刷新页面!");
		            }  
		        });  
	 
	 
	 
	 
	 
	  }

</script>
</html>