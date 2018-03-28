<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>用户注册</title>
    <link type="text/css" rel="stylesheet" href="../css/style.css;">
    <base href="${pageContext.request.contextPath}/">
</head>
<script type="text/javascript">
	function check() {
		var un=document.getElementById("username").value;
		var pwd=document.getElementById("password").value;
		var fu=false;
		var fp=false;
		if(un!=null && un!=""){
			fu=true;
		}else{
			fu=false;
		}
		if(pwd!=null && pwd!=""){
			fp=true;
		}else{
			fp=false;
		}
		if(!fu){
			alert("用户名不能为空！");
			return false;
		}else if(!fp){
			alert("密码不能为空！");
			return false;
		}else{
			return true;
		}
	}
</script>
<body bgcolor="#E7ECEF">
    <center>
        <form action="UserServlet?flag=register" method="post" onsubmit="return check()">
            <table border="0" cellspacing="0" cellpadding="0" style="margin-top:130">             
                <tr height="330">
                    <td background="images/city_login.jpg" align="center" valign="top" width="545">
                         <table border="0" width="90%" cellspacing="0" cellpadding="0">
                             <tr height="50"><td colspan="2"></td></tr>
                             <tr height="30">
                                 <td align="right" width="40%">用户名：&nbsp;&nbsp;</td>
                                 <td style="text-indent:5"><input type="text" name="username" size="30" value="" id="username" onblur="checkusername()"/></td>
                             </tr>                
                             <tr height="30">
                                 <td align="right">密&nbsp;&nbsp;码：&nbsp;&nbsp;</td>
                                 <td style="text-indent:5"><input type="password" name="password" size="30" id="password" onblur="checkpassword()"/></td>
                             </tr>
                             <tr height="60">
                                 <td></td>
                                 <td>
								
                                     <input type="submit" value="注册"/>

                                     <input type="reset" value="重置"/>

                                     <a id="log_Login_action_" href="view/indextemp.jsp">[返回首页]</a>
                                 </td>
                             </tr>
                         </table>
                    </td>
                </tr>
            </table>
        </form>



     
    </center>
</body>
</html>