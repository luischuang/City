// JavaScript Document
//后台日历中的时间
function clock(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var week = date.getDay();
		switch(week){
			case 0:week="星期日";break;
			case 1:week="星期一";break;
			case 2:week="星期二";break;
			case 3:week="星期三";break;
			case 4:week="星期四";break;
			case 5:week="星期五";break;
			case 6:week="星期六";break;
		}
	//document.getElementById("r_f_f1").innerHTML="<font size='2px'>"+year+"年"+month+"月"+day+"日"+week+hour+":"+minute+":"+second+"</font>";
		//document.getElementById("clock").innerHTML=date;
	setTimeout("clock()",1000);
}
//后台显示验证
function show(){
	if(checkpay()&&checkstate()&&checkintro()){
		return true;
	}else{
		document.getElementById("back_man").setAttribute("src","error.html");
		return false;
	}
}
//后台付费状态验证
function checkpay(){
	var pay = document.getElementsByName("pay");
	if(pay[0].checked==""&&pay[1].checked==""&&pay[2].checked==""){
		return false;
	}else{
		return true;
	}
}
//后台付费状态验证
function checkstate(){
	var state = document.getElementsByName("state");
	if(state[0].checked==""&&state[1].checked==""&&state[2].checked==""){
		return false;
	}else{
		return true;
	}
}
//后台查询按钮验证
function xinxi(){
	var id = document.getElementById("id1").value;
	if(id==""||isNaN(id)){
		document.getElementById("back_man").setAttribute("src","error.html");
		return false;
	}else{
		document.getElementById("back_man").setAttribute("src","back_search.html");
		return true;
	}
}