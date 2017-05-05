<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 目前引用后台上传的图片 -->
<%-- <c:set var="basepath" value="http://sources.wicp.net"></c:set> --%>
<!-- 线上图片服务器地址 -->
<c:set var="basepath" value="http://admin.16ayu.com"></c:set>
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
    <link href="${pageContext.request.contextPath }/css/guess/jctwo.css?v=7" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/guess/mask.css?v=6" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/css/weui.min.css" rel="stylesheet" />
<style>
	/* body{
		cursor: pointer;
	} */
    .radio-btn{ position:absolute; top:0; z-index:10; width: 100%;}
</style>
</head>
<body>
<div class="wap">
    <p><img class="banner" src="${pageContext.request.contextPath }/images/guess/jctwo-top.jpg" width="100%"/></p>
    <div class="main">
        <form action="/guess/submitGuessAnswer" method="post" class="form-list">
        	<c:forEach items="${guessItemList }" var="item" varStatus="status">
            <div class="game-list">
                <div class="game-box clearfix">
                    <div class="box-lf">
                        <div class="dui">
                            <img class="gameimg" src="${basepath }${item.masterImg }"/>
                            <p class="game-title">${item.masterName }</p>
                        </div>
                    </div>
                    <div class="box-mid"><img class="vsimg" src="${pageContext.request.contextPath }/images/guess/vs.png"/> </div>
                    <div class="box-rt">
                        <div class="dui">
                            <img class="gameimg" src="${basepath }${item.guestImg }"/>
                            <p class="game-title">${item.guestName }</p>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="items[${status.index }].id" value="${item.id }" />
                <input type="hidden" name="items[${status.index }].guessId" value="${item.guessId }" id="guessId"/>
                <input type="hidden" name="items[${status.index }].type" value="${item.type }" />
                <div class="radio-list">
                    <div class="radio-btn clearfix">
                        <p class="btna btn1">胜 ></p>
                        <p class="btna btn2">平 ></p>
                        <p class="btna btn3">负 ></p>
                    </div>
                    <div class="radio-radio clearfix">
                        <input type="radio" class="btna" name="items[${status.index }].result" value="3">
                        <input type="radio" class="btna" name="items[${status.index }].result" value="1">
                        <input type="radio" class="btna" name="items[${status.index }].result" value="0">
                    </div>
                </div>
            </div>
            </c:forEach>
            <div class="qrbtn">
                <img class="qrtj" src="${pageContext.request.contextPath }/images/guess/qrtj.png">
                <img class="xyc" src="${pageContext.request.contextPath }/images/guess/xyc.png">
            </div>
        </form>
    </div>
    	<!-- 弹出窗开始 -->
		<div class="mask" style="display:none;">
			<div class="mask-box">
				<img src="${pageContext.request.contextPath }/images/guess/mask-top.png" class="mask-top"/>
				<p class="maskcontent">请填完所有选项</p>
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
		<!-- weui-loading-start -->
		<div id="loadingToast" class="weui_loading_toast" style="display:none;position:fixed;z-index:100;">
		    <div class="weui_mask_transparent"></div>
		    <div class="weui_toast">
		        <div class="weui_loading">
		            <!-- :) -->
		            <div class="weui_loading_leaf weui_loading_leaf_0"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_1"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_2"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_3"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_4"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_5"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_6"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_7"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_8"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_9"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_10"></div>
		            <div class="weui_loading_leaf weui_loading_leaf_11"></div>
		        </div>
		        <p class="weui_toast_content">请稍候...</p>
		    </div>
		</div>
		<!-- weui-loading-end -->
</div>
<script src="${pageContext.request.contextPath }/js/jquery-2.0.3.min.js"></script>
<script>
    $(function(){
    	var minHeight=($(window).height()-$(".banner").height()-20)+"px";
		$(".main").css("min-height",minHeight);
		
//        选项
       	//$(document).on('click',".game-list .radio-btn .btna",function(){
       	$('.wap').delegate(".game-list .radio-btn .btna",'click',function(){
			$(this).addClass("on").siblings().removeClass("on");
			var index=$(this).index();
			$(this).parent().parent().find("input").eq(index).attr("checked","checked").siblings().removeAttr("checked");
		});

        //判断A轮全部答上
        var is_checked=function(){
        	var count='${guessItemList.size() }';
        	for(var i=0;i<count;i++){
        		var boolCheck=$('input:radio[name="items['+i+'].result"]').is(":checked");
        		if(!boolCheck){
        			return false;
        		}
        	}
        	return true;
        }
        //竟猜前5场
        $(".qrtj").click(function(){
            var flag=is_checked();
            if(!flag){
            	$('.mask').show();
            	return;
            }
            $(".qrtj").off('click');
            $(".xyc").off('click');
            $('#loadingToast').show();
            $.post('/guess/submitGuessAnswer',$('.form-list').serialize(),function(data){
            	if(data!='0'){
            		alert('您已参与过本期竟猜！');
            		window.location.href='/guess/index';
            	}else{
            		$('#loadingToast').hide();
            		window.location.href='/guess/success';
            	}
            });
        });
        //竟猜第6场
        $('.xyc').click(function(){
        	var flag=is_checked();
            if(!flag){
            	$('.mask').show();
            	return;
            }else{
            	$(".qrtj").off('click');
                $(".xyc").off('click');
            	$('#loadingToast').show();
            	load_b();
            }
        });
        var load_b=function(){
        	var ispartake=false;
            $.post('/guess/submitGuessAnswer',$('.form-list').serialize(),function(data){
            	if(data!='0'){
            		alert('您已参与过本期竟猜！');
            		ispartake=true;
            		if(ispartake){
                    	window.location.href='/guess/index';
                    	return;
                    }
            	}else{
            		var guessId=$('#guessId').val();
            		$.post('/guess/loadGuessOnlyB?guessId='+guessId,function(data){
            			if(data.resultcode!=0){
            				alert('加载B轮失败！');
            			}else{
            				//$('.game-list').remove();
            				$('.form-list').empty();
            				//目前B轮只有一个竟猜，所以取第1个
            				var item=data.data[0];
            				var template='<div class="game-list"><div class="game-box clearfix">'+
            				'<div class="box-lf">'+
            				'<div class="dui">'+
            				'<img class="gameimg" src="${basepath }'+item.masterImg+'"/>'+
            				'<p class="game-title">'+item.masterName+'</p>'+
            				'</div>'+
            				'</div>'+
            				'<div class="box-mid"><img class="vsimg" src="${pageContext.request.contextPath }/images/guess/vs.png"/> </div>'+
            				'<div class="box-rt">'+
            				'<div class="dui">'+
            				'<img class="gameimg" src="${basepath }'+item.guestImg+'"/>'+
            				'<p class="game-title">'+item.guestName +'</p>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                        '<input type="hidden" name="id" value="'+data.resultmessage+'" />'+
                        '<div class="radio-list">'+
                            '<div class="radio-btn clearfix"><p class="btna btn1">胜 ></p><p class="btna btn2">平 ></p><p class="btna btn3">负 ></p></div>'+
                            '<div class="radio-radio clearfix">'+
                                '<input type="radio" class="btna" name="result" value="3">'+
                                '<input type="radio" class="btna" name="result" value="1">'+
                                '<input type="radio" class="btna" name="result" value="0">'+
                            '</div>'+
                        '</div>'+
                    '</div>';
                    var but_template='<div class="qrbtn"><img class="tj_b" src="${pageContext.request.contextPath }/images/guess/qrtj.png"></div>';
                    
                    	//$('.qrbtn').before(template);
                    	$('.form-list').append(template+but_template);
                    	$('#loadingToast').hide();
            			}
            		},'json');
            	}
            });
        }
        $(document).on('click','.tj_b',function(){
        	var flag=$("input:radio[name='result']").is(":checked");
        	if(!flag){
        		$('.mask').show();
            	return;
        	}
        	$('.tj_b').off('click');
        	$.post('/guess/updateAnswer',$('.form-list').serialize(),function(data){
        		if(data=='0'){
        			window.location.href='/guess/success';
        		}
        	});
        });
      //确定按钮关闭弹出框
    	$('.mask .btn').click(function(){
    		$('.mask').hide();
    	});
    })
</script>
</body>
</html>