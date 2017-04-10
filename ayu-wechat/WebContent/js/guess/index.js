// 公用js

/*窗口大小*/
var winWidth,winHeight;


/*浏览器监听*/
window.onload=function(){
	checkWinSize();
	}



function checkWinSize(){		//检测窗口大小
	getWindowSize();
	document.getElementById('wap').style.width=winWidth + "px";
	document.getElementById('wap').style.height=winHeight + "px";		
	}
//获取窗口大小
function getWindowSize(){
	//获取窗口宽度
	if (window.innerWidth){
		 winWidth = window.innerWidth;
		}
	else if ((document.body) && (document.body.clientWidth)){
		 winWidth = document.body.clientWidth;
		}
	//获取窗口高度
	if (window.innerHeight){
		 winHeight = window.innerHeight;
		}
	else if ((document.body) && (document.body.clientHeight)){
		 winHeight = document.body.clientHeight;
		}
	//通过深入Document内部对body进行检测，获取窗口大小
	if (document.documentElement  && document.documentElement.clientHeight &&document.documentElement.clientWidth){
	   winHeight = document.documentElement.clientHeight;
	   winWidth = document.documentElement.clientWidth;
		}
	}