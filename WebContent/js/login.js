//登录页面验证是否为空
function login(){
	if(checkuname()&&checkpwd()){
		return true;
	}else{
		return false;
	}
}
//判断后台登录界面用户名是否为空
function checkuname(){
	var uname = document.getElementById("uname").value;
	if(uname==""){
		document.getElementById("uname1").innerHTML="<font color='red'>用户名不能为空！</font>";
		return false;
	}else{
		document.getElementById("uname1").innerHTML="";
		return true;
	}
}
//判断后台登录界面密码是否为空
function checkpwd(){
	var pwd = document.getElementById("pwd").value;
	if(pwd==""){
		document.getElementById("password1").innerHTML="<font color='red'>密码不能为空！</font>";
		return false;
	}else{
		document.getElementById("password1").innerHTML="";
		return true;
	}
}