//JavaScript Document
//点击前台首页搜索后的更改以及点击搜索后的验证
function index() {
	document.getElementById("main").style.height = "450px";
	document.getElementById("m_r").style.height = "450px";
	if (checkkey() && checkop() && checklx()) {
		return true;
	} else {
		document.getElementById("indexmain").setAttribute("src", "error.html");
		return false;
	}
}
//点前台首页击题头后的更改
function clickTop() {
	document.getElementById("main").style.height = "450px";
	document.getElementById("m_r").style.height = "450px";
}
//点击前台首页发布信息后的更改
function clickInfo() {
	document.getElementById("main").style.height = "770px";
	document.getElementById("m_r").style.height = "770px"
}
//判断前台关键字是否为空
function checkkey() {
	var key = document.getElementById("key").value;
	var op = document.getElementById("op").value;
	if (key == "") {
		return false;
	} else if (op == "id" && isNaN(key)) {
		return false;
	} else {
		return true;
	}
}

//判断前台首页条件是否选择
function checkop() {
	var op = document.getElementById("op").value;
	if (op == null) {
		return false;
	} else {
		return true;
	}
}
//判断前台首页联系是否选择
function checklx() {
	var lx = document.getElementsByName("lx");
	if (lx[0].checked == "" && lx[1].checked == "") {
		return false;
	} else {
		return true;
	}
}
/*
//前台首页时间操作
function clock() {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var week = date.getDay();
	switch (week) {
	case 0:
		week = "星期日";
		break;
	case 1:
		week = "星期一";
		break;
	case 2:
		week = "星期二";
		break;
	case 3:
		week = "星期三";
		break;
	case 4:
		week = "星期四";
		break;
	case 5:
		week = "星期五";
		break;
	case 6:
		week = "星期六";
		break;
	}
	document.getElementById("m_li_top1").innerHTML = "<font size='2px'>" + year
	+ "年" + month + "月" + day + "日" + week + hour + ":" + minute + ":"
	+ second + "</font>";
	// document.getElementById("clock").innerHTML=date;
	setTimeout("clock()", 1000);
}
*/