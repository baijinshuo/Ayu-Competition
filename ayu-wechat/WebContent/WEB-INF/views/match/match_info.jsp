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
<link href="${pageContext.request.contextPath }/css/match/style.css?v=3" rel="stylesheet">
<style>
.sele.on{ color:#0C9;}
</style>
</head>
<body>
<div class="wap">
        <p><img style="margin:0 auto" src="${pageContext.request.contextPath }/images/match/three1.jpg" width="90%"/></p>
        <p style="text-align:center; margin:0.1rem 0;" class="xuan"><a class="sele on">个人</a> / <a class="sele">团体</a></p>
        <div class="forma">
        <!-- 个人 -->
        <div class="a1">
        <form id="match_form" action="/match/submitInfo" method="post" class="forma">
                <label>姓名</label>
                <span style="position:absolute; color:#f00; left:95%; top:6%;">*</span><input id="name" name="name" type="text" placeholder="请输入姓名"/>
                <p class="tishi name"></p>
                <label>性别</label>
                <input id="sexa" name="sex" type="text" placeholder="请选择/Please select" ReadOnly/>
                <p class="tishi sexa"></p>
                <ul class="sex">
                    <li>男</li>
                    <li>女</li>
                </ul>
                 <label>年龄</label>
                <input id="age" name="age" type="text" placeholder="请输入年龄"/>
                <p class="tishi age"></p>
                <label>身份证号</label>
                <input id="identity" name="idcard" type="text" placeholder="请输入身份证号"/>
                <p class="tishi identity"></p>
                <label>联系电话</label>
                <span style="position:absolute; color:#f00; left:95%; top:73%;">*</span><input id="ipone" name="tel" type="text" placeholder="请输入联系电话"/>
                <p class="tishi ipone"></p>
                <label>所在地区</label>
                <input type="text" id="Add" name="district" placeholder="请输入所在地区"/>
                <p class="tishi Add"></p>
                <input type="hidden" name="type" value="1">
        </form>
        </div>
        <!-- 团体 -->
        <div style="display:none; position:relative;" class="a1">
        <form id="team_form" action="/match/submitInfo" method="post" class="forma">
        		<input type="hidden" name="type" value="2">
                <label>团体名称</label>
                <span style="position:absolute; color:#f00; left:95%; top:12%;">*</span><input id="team_name" name="name" type="text" placeholder="请输入团体名称"/>
                <p class="tishi team_name"></p>
                 <label>联系电话</label>
                <span style="position:absolute; color:#f00; left:95%; top:46%;">*</span><input id="team_ipone" name="tel" type="text" placeholder="请输入联系电话"/>
                <p class="tishi team_ipone"></p>
                <label>所在地区</label>
                <input type="text" id="Add" name="district" placeholder="请输入所在地区"/>
                <p class="tishi Add"></p>
        </form>
        </div>
            <!--添加声明 -->  
            <div style="width:90%; margin:0 auto;">          
            <p class="shengm">报名需阅读并同意以下事项:</p>
            <div class="shengming">
            	<div>
                     1、一经报名成功，组委会将不予受理退款申请。<br/>
					 2、请仔细确认报名信息，报名成功后，组委会将不接受更改参赛信息。<br/>
					 3、报名资格不可转让，违者后果自负。 <br/>
					 4、阿彧比赛作为本次官方合作报名平台，通过阿彧比赛报名并成功付款的选手名额有效，选手资料信息将在报名截止后提交给赛事组委会。一经报名成功，因个人原因需要取消的申请均不予受理。<br/>
					 5、报名者须在赛事报名截止前完成支付，逾期未付即为未报名成功。<br/>
					 6、报名者须保证个人信息真实有效，并正确选择比赛项目。如提供不实信息，或误选参赛项目，后果由报名者自负，阿彧比赛将不予受理。<br/>
					 7、用户所填写的一切报名信息，阿彧比赛将严格保密，未经法律许可不会透露给任何组织，机构及个人。<br/>
					 8、如有疑问请随时与客服联系：15801658224。
                 </div>
            </div>
            <label>我理解并同意本政策</label><input class="check" type="checkbox"/>
			<!--添加声明 --> 
            <div class="midbtn">
            <img id="match_submit" src="${pageContext.request.contextPath }/images/match/twobtn1.png"/>
            <img id="match_re" class="restbtn" src="${pageContext.request.contextPath }/images/match/twobtn2.png"/>
            </div>
            </div>
        </div>
</div>
<script src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
<script src="${pageContext.request.contextPath }/js/match/yz.js?v=1"></script>
<script>
$(function(){
	$('#match_re').click(function(){
		$(':text').val('');
	});

	$(".xuan .sele").click(function(){
		var index=$(this).index();
		$(this).addClass("on").siblings().removeClass("on");
		$(".forma .a1").eq(index).show().siblings(".a1").hide();
	});
});
</script>
</body>
</html>