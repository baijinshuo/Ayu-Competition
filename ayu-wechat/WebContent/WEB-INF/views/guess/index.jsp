<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>足球竞猜</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link href="${pageContext.request.contextPath }/css/guess/all-style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/guess/index.css?v=4" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/guess/mask.css?v=1" rel="stylesheet" />
</head>
<body>
<div class="wap">
		<img class="banner" src="${pageContext.request.contextPath }/images/guess/indextop.jpg" width="100%"/>
		<div class="main">
			<div class="content">
				<div class="one">
					<h3>竞猜规则</h3>
					<ul class="gz">
						<li>① 竞猜内容：每周选取6场热门足球赛进行竞猜</li>
						<li>② 竞猜时间：竞猜截止于最近一场比赛开赛前</li>
						<li>③ 竞猜形式：采取单式投票，不可复式投注</li>
						<li>④ 竞猜结果：主场VS客场，竞猜以3、1、0表示</li>
						<li>⑤ 比分以全场90分钟的比分为准，不含加时赛</li>
					</ul>
					<h3>游戏规则</h3>
					<ul class="gz">
						<li>① 竞猜分5场竞猜和6场竞猜：<p> 选择5场竞猜的用户，猜中任意4场以上，视为中奖。猜中4场者，奖励2元红包；猜中5
场者，奖励5元红包。在5场竞猜场次后，用户可以选择竞猜第6场比赛场次，但是一旦选择
竞猜第6场场次，则不能返回前5场竞猜场次，必须竞猜第6场场次后方能提交，如退出返回
等则视为放弃此次竞猜资格。选择竞猜6场的用户，只有6场均竞猜对，奖励20元红包。如
有一场未对，则无任何奖励。凡上一场猜中6场者，下场竞猜再次猜中6场，奖励由20元提高
到40元，以此类推。</p></li>
						<li>② 凡中奖者，只奖励高奖结果，不可兼中兼得</li>
					</ul>
					<div class="begin-btn">开始竞猜</div>
					<img src="${pageContext.request.contextPath }/images/guess/ewm.jpg" class="ewm" />
					<p class="footer">规则解释权属阿彧比赛</p>
				</div>
			</div>
		</div>
		<!-- 弹出窗开始 -->
		<div class="mask" style="display:none;">
			<div class="mask-box">
				<img src="${pageContext.request.contextPath }/images/guess/mask-top.png" class="mask-top"/>
				<p class="maskcontent">您该期已经竟猜过了</p>
				<div class="btn-box">
					<div class="btn">确认</div>
				</div>
				<!--这是两种按钮留下需要的删除一种就行-->
				<!-- <div class="btn-box">
					<div class="btna">确认</div>
					<div class="btna">取消</div>
				</div> -->
			</div>
		</div>
		<!--弹出窗结束  -->
</div>
<script src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
<script>
$(function(){
	$('.begin-btn').click(function(){
		var flag='${isPartake}';
		if(flag){
			$('.mask').show();
		}else{
			window.location.href="/guess/list";
		}
	});
	//确定按钮关闭弹出框
	$('.mask .btn').click(function(){
		$('.mask').hide();
	});
});	
</script>
</body>
</html>