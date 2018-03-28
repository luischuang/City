// JavaScript Document
//判断前台发布信息中信息类别是否选择
function checkIntro() {
	var intro = document.getElementById("intro").value;
	if (intro == "0") {
		document.getElementById("title1").innerHTML = "<font color='red'>请选择信息类别！</font>";
		return false;
	} else {
		document.getElementById("title1").innerHTML = "";
		return true;
	}
}
// 判断前台发布信息中标题是否符合规范
function checkTitle() {
	var title = document.getElementById("title").value;
	if (title.length < 1 || title.length > 40) {
		document.getElementById("title1").innerHTML = "<font color='red'>标题字数不符！</font>";
		return false;
	} else {
		document.getElementById("title1").innerHTML = "";
		return true;
	}
}
// 判断前台发布信息中联系电话是否为空
function checkTel() {
	var tel = document.getElementById("tel").value;
	var checkTel = /^1\d{10}$/;
	if (tel == "") {
		document.getElementById("tel1").innerHTML = "<font color='red'>联系电话不能为空</font>";
		return false;
	} else if (!checkTel.test(tel)) {
		document.getElementById("tel1").innerHTML = "<font color='red'>联系电话格式不对！</font>";
		return false;
	} else {
		document.getElementById("tel1").innerHTML = "";
		return true;
	}
}
// 判断前台发布信息联系人是否为空
function checkUser() {
	var user = document.getElementById("linkman").value;
	if (user == "") {
		document.getElementById("user1").innerHTML = "<font color='red'>用户名不能为空！</font>";
		return false;
	} else {
		document.getElementById("user1").innerHTML = "";
		return true;
	}
}
// 判断前台发布信息邮件是否为空
function checkEmail() {
	var checkEmail = /^[ _a-z0-9]+@([ _a-z0-9]+\.)+[a-z0-9]{2,3}$/;
	var email = document.getElementById("email").value;
	if (email == "") {
		document.getElementById("email1").innerHTML = "<font color='red'>邮箱不能为空！</font>";
		return false;
	} else if (!checkEmail.test(email)) {
		document.getElementById("email1").innerHTML = "<font color='red'>邮箱格式不对！</font>";
		return false;
	} else {
		document.getElementById("email1").innerHTML = "";
		return true;
	}
}
// 判断前台发布信息点击发布验证
function checkChange() {
	if (checkIntro() && checkTitle() && checkTel() && checkUser()
			&& checkEmail()) {
		return true;
	} else {
		return false;
	}
}
