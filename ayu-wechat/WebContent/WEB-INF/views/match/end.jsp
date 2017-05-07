<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>大兴区象棋月赛赛事信息</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link href="${pageContext.request.contextPath }/css/match/all-style.css" rel="stylesheet">
<style>
.tc{ width:5.34rem; height:5.37rem; position:fixed; top:50%; left:50%; margin:-2.685rem 0 0 -2.68rem; background:#a7c7e3; border-radius:10px;}
.closea{ width:0.62rem; height:0.62rem; font-size:0.6rem; color:#fff; position:absolute; top:0.02rem; right:0.02rem;}
.tc img{ width:70%; position:absolute; top:1rem; left:0.78rem;}
</style>
</head>
<body>
<div class="wap">
       
<!--弹出层-->
<div class="tc">
	<div class="closea">×</div>
    <img src="${pageContext.request.contextPath }/images/match/bmyjs.jpg"/>
</div>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
<script>
$(function(){
		
/*弹出层关闭*/
    $(".tc .closea").click(function(){
		$(this).parent().hide();
		});
	})
</script>
</body>
</html>