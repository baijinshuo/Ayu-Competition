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
<link href="${pageContext.request.contextPath }/css/match/style.css" rel="stylesheet">
</head>
<body>
<div class="wap">
    <div class="three">
        <p><img style="margin:0 auto" src="${pageContext.request.contextPath }/images/match/three1.jpg" width="100%"/></p>
        <p class="lkaic"><strong id="minute_show">15分</strong><strong id="second_show">00秒</strong></p>
        <p class="cs">请在指定时间内完成报名和付款。超过时间后您的报名名额将被释放给其他选手。</p>
        <p class="cs">Please complete registration within the specified time.Over time after,the reservation
        we're holding will be released to others.</p>
        <hr class="hra"/>
        <div class="kong"></div>
        <p class="tabhed"><span style="float:left">项目 Item</span><span style="float:right">金额 Amount</span></p>
        <div class="xinxi">
        	<p><span>2016阿彧象棋月赛</span><span style="float:right;">&yen;${match.money }</span></p>
            <p>${match.name }</p>
        </div>
        <div class="kong" style="margin:0.3rem 0 0.3rem 0;"></div>
        <img src="${pageContext.request.contextPath }/images/match/zfts.jpg" width="100%"/>
        <div class="zhifu">
        	<div class="clearfix" style="margin-top:0.2rem">
        		<img class="left weixinzhifu" src="${pageContext.request.contextPath }/images/match/zhifu1.jpg" width="48%"/>
            	<img class="right daiTJ" src="${pageContext.request.contextPath }/images/match/zhifu2.jpg" width="48%"/>
            </div>
            <div style="margin-top:0.2rem">
           		 <img class="left daiTJ" src="${pageContext.request.contextPath }/images/match/zhifu3.jpg" width="48%"/>
           		 <img class="right daiTJ" src="${pageContext.request.contextPath }/images/match/zhifu4.jpg" width="48%"/>
            </div>
        </div>
    </div>
    <div class="zhifuts" style="display:none">
    	<div class="tishiyu" >
        	<div class="close">
            	<span class="tsyheder">正在跳转微信支付</span>
                <span class="right closea" style="font-size:0.35rem">×</span>
            </div>
            <div class="zztz" style="display:none;">
                <img class="zhuan" src="${pageContext.request.contextPath }/images/match/07.gif" width="8%"/>
                <p>正在跳转到微信支付，请稍后...</p>
                <p>please waiting...</p>
                <p id="timer"></p>
            </div>
            <p class="daitianjia" style="margin-top:0.5rem; font-size:0.3rem;">此支付待开通，请使用微信支付</p>
        </div>
    </div>
    <input type="hidden" id="openid" name="openid" value="${match.openid }"/>
    <input type="hidden" id="orderNo" name="orderNo" value="${match.orderNo }"/>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
<script src="${pageContext.request.contextPath }/js/match/yz.js"></script>
</body>
</html>