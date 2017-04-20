// JavaScript Document
$(function(){
/*性别选项*/
	$("#sexa").click(function(){
		$(".sex").show();
		});
	$(".sex li").click(function(){
		$("#sexa").val($(this).html());
		$(".sex").hide();
		});
/*验证*/
/*手机号验证*/
        var phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
        var  phone=$('#ipone').val();
        $('#ipone').focus(function (){
               $("#ipone").val('');
        })
        var phone_fun=function (){
        	var  phone=$('#ipone').val();
       	 if(!phoneReg.test(phone)){
				$(".ipone").html("请输正确的手机号");
				$("#ipone").val('');
				return false;
			}else{
				$(".ipone").html("");
				return true;
			}
       }
        $('#ipone').on('blur',phone_fun);
        
        /*团体手机号验证*/
        var team_phoneReg = /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
        var  team_phone=$('#team_ipone').val();
        $('#team_ipone').focus(function (){
               $("#team_ipone").val('');
        })
        var team_phone_fun=function (){
        	var  team_phone=$('#team_ipone').val();
       	 if(!team_phoneReg.test(team_phone)){
				$(".team_ipone").html("请输正确的手机号");
				$("#team_ipone").val('');
				return false;
			}else{
				$(".team_ipone").html("");
				return true;
			}
       }
        $('#team_ipone').on('blur',team_phone_fun);
        
/*身份证号验证*/	
       var  identityReg=/\d{17}[\d|x]|\d{15}/;
	   var  identity=$("#identity").val();
	   $('#identity').focus(function (){
               $("#identity").val('');
        })
        var identity_fun=function (){
       		 var  identity=$('#identity').val();
       		 if(identity==''){
       			return true;
       		 }
		   	 if(!identityReg.test(identity)){
					$(".identity").html("请输正确的身份证号");
					$("#identity").val('');
					return false;
				}else{
					$(".identity").html("");
					return true;
					}
		   }
		 $('#identity').blur(identity_fun);
/*姓名	*/
var  nameReg=/^[A-Za-z0-9\u4e00-\u9fa5]+$/;
	   var  name=$("#name").val();
	   $('#name').focus(function (){
               $("#name").val('');
        })
        var name_fun=function (){
       		 var  name=$('#name').val();
		   	 if(!nameReg.test(name)){
					$(".name").html("请输入正确的姓名");
					$("#name").val('');
					return false;
				}else{
					$(".name").html("");
					return true;
					}
		   }
		 $('#name').blur(name_fun);
		 
		 /*团体名称	*/
		 var  team_nameReg=/^[A-Za-z0-9\u4e00-\u9fa5]+$/;
		 	   var  team_name=$("#team_name").val();
		 	   $('#team_name').focus(function (){
		                $("#team_name").val('');
		         })
		         var team_name_fun=function (){
		        		 var  team_name=$('#team_name').val();
		 		   	 if(!team_nameReg.test(team_name)){
		 					$(".team_name").html("请输入正确的团体名称");
		 					$("#team_name").val('');
		 					return false;
		 				}else{
		 					$(".team_name").html("");
		 					return true;
		 					}
		 		   }
		 		 $('#team_name').blur(team_name_fun);

/*年龄*/
var  ageReg=/^\d+$/;
	   var  age=$("#age").val();
	   $('#age').focus(function (){
               $("#age").val('');
        })
        var age_fun=function (){
       		 var  age=$('#age').val();
       		 if(age==''){
       			 return true;
       		 }
		   	 if(!ageReg.test(age)||age>130||age<0){
					$(".age").html("请输入正确年龄");
					$("#age").val('');
					return false;
				}else{
					$(".age").html("");
					return true;
					}
		   }
		 $('#age').blur(age_fun);
/*所在地*/
/**
var  AddReg=/^\S+$/;
	   var  Add=$("#Add").val();
	   $('#Add').focus(function (){
               $("#Add").val('');
        })
        var addr_fun=function (){
       		 var  sexa=$('#Add').val();
       		 if(sexa==''){
       			 return true;
       		 }
		   	 if(!AddReg.test(sexa)){
					$(".Add").html("请输入地址");
					$("#Add").val('');
					return false;
				}else{
					$(".Add").html("");
					return true;
					}
		   }
		 $('#Add').blur(addr_fun);
*/
		 //提交
		 $('#match_submit').click(function(){
			 	if(!$('.check').is(':checked')){
			 		return false;
			 	}
			 	var flag=false;
			 	var form1=$('#match_form').is(':visible');
			 	if(form1){
			 		flag=phone_fun() && identity_fun() && name_fun() && age_fun();
			 		if(flag){
			 			$('#match_form').submit();
			 		}
			 	}else{
			 		flag=team_phone_fun() && team_name_fun();
			 		if(flag){
			 			$('#team_form').submit();
			 		}
			 	}
		});
		
		
/*倒计时*/		
 var intDiff = parseInt(900);//倒计时总秒数量
        function timer(intDiff){
            window.setInterval(function(){
            var day=0,
            hour=0,
            minute=0,
                second=0;//时间默认值       
            if(intDiff > 0){
               
                minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
            }
            if(intDiff<0){
                $('.over1').show();
            }
            if (minute <= 9) minute = '0' + minute;
            if (second <= 9) second = '0' + second;
            $('#minute_show').html('<s></s>'+minute+'分');
            $('#second_show').html('<s></s>'+second+'秒');
            intDiff--;

            }, 1000);

            
        } 

        timer(intDiff);
 
 
 
$(".weixinzhifu").click(function(){
	$(".zhifuts").show();
	$(".zztz").show();
	$(".tsyheder").show();
	$(".daitianjia").hide();
	startit();
	var openid=$('#openid').val();
	var orderNo=$('#orderNo').val();
	var url='/wxpay/pay?out_trade_no='+orderNo+'&openid='+openid;
	$.post(url,function(data){
		$(".zhifuts").hide();
		$(".zztz").hide();
		$(".tsyheder").hide();
		$(".daitianjia").show();
		WeixinJSBridge.invoke(
				'getBrandWCPayRequest',
				data,
				function(res){
					if(res.err_msg=="get_brand_wcpay_request:ok"){
						window.location.href="/match/index";
					}
					else{
						//alert(res.err_code+" err_desc="+res.err_desc+" err_msg="+res.err_msg); 
					}
				}
			);
	},'json');
});
$(".daiTJ").click(function(){
	$(".zhifuts").show();
	$(".daitianjia").show();
	$(".zhifuts").show();
	$(".zztz").hide();
	$(".tsyheder").hide();
	});
$(".closea").click(function(){
	$(".zhifuts").hide();
	}); 
 
   
	})


/*计时器*/	
var timer = document.getElementById("timer");
var hour, minute, second; //时，分 ,钞 
var t; //setTimeout方法 
timer.innerHTML = "00:00:00"; //由于FF不支持使用innerText，故采用innerHTML 
hour = minute = second = 0; //初始化显示 
function startit(){ 
t = setTimeout("startit()", 1000); //每隔1秒（1000毫秒）递归调用一次 
second++; 
if(second>=60){ //判断秒是否到60, 是则进位 
second = 0; 
minute++; 
} 
if(minute>=60){ //判断分是否到60, 是则进位 
minute = 0; 
hour++; 
} 
timer.innerHTML = j(hour) + ":" + j(minute) + ":" + j(second) ; //更新显示 
 
} 
//显示数字填补，即当显示的值为0-9时，在前面填补0;如：1:0:4, 则填补成为 01:00:04 
var j = function(arg){ 
return arg>=10 ? arg : "0" + arg; 
} 