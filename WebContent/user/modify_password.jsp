<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>修改密码</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
  <base href="${pageContext.request.contextPath}/">
<script type="text/javascript">
	function check() {
		var oldpass=document.getElementById("oldPass").value;
		var newpass=document.getElementById("newPass").value;
		var newpass1=document.getElementById("newPass1").value;
		var fo=false;
		var fn=false;
		if(oldpass!=null && oldpass!=""){
			fo=true;
		}else{
			fo=false;
		}
		if(newpass!=newpass1){
			alert("两次输入新密码不同。");
			return false;
		}
		if(newpass!=null && newpass!=""){
			fn=true;
		}else{
			fn=false;
		}
		if(!fo){
			alert("请输入原密码。");
			return false;
		}else if(!fn){
			alert("新密码不能为空！");
			return false;
		}else{
			return true;
		}
	}
</script>
</head>

    <center>
    <form action="UserServlet?flag=modify&user_id=${user.user_id }" method="post" onsubmit="return check()">
    <table border="0" cellpadding="0" cellspacing="0" width="600" height="300">
            <tr>
            	<td align="left">原密码：</td>
            	<td><input type="text" name="oldPass" id="oldPass" size="50"/></td>
            </tr>
            <tr>
            	<td align="left">新密码：</td>
            	<td><input type="password" name="newPass" id="newPass" size="50"/></td>
            </tr>
            <tr>
            	<td align="left">确认密码：</td>
            	<td><input type="password" name="newPass1" id="newPass1" size="50"/></td>
            </tr>
            <tr>
            <td></td>
            <td><input type="submit" value="确认更改"/></td>
            	
            </tr>
        </table>
    	
    </form>
        
       
    </center>
</body>
</html>