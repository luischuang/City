<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登录</title>
  
    <link type="text/css" rel="stylesheet" href="css/style.css;">
    <base href="${pageContext.request.contextPath}/">
</head>
<body>

<%
	String uname="";
	String password="";
	Cookie cookies[]=request.getCookies();
	if(cookies!=null){
		for(Cookie c:cookies){
			if(c.getName().equals("userName")){
				uname=c.getValue();
			}else if(c.getName().equals("userPassword")){
				password=c.getValue();
			}
		}
	}
%>
    <center>
        <form id="log_Login_action" name="log_Login_action" action="UserServlet?flag=login" method="post">
            <table border="0" cellspacing="0" cellpadding="0" style="margin-top:130">
                             
                <tr height="330">
                    <td background="images/city_login.jpg" align="center" valign="top" width="545">
                         <table border="0" width="90%" cellspacing="0" cellpadding="0">
                             <tr height="50"><td colspan="2"></td></tr>
                             <tr height="30">
                                 <td align="right" width="40%">用户名：&nbsp;&nbsp;</td>
                                 <td style="text-indent:5"><input type="text" name="userName" size="30" value="<%=uname %>" id="log_Login_action_user_userName"/></td>
                             </tr>                
                             <tr height="30">
                                 <td align="right">密&nbsp;&nbsp;码：&nbsp;&nbsp;</td>
                                 <td style="text-indent:5"><input type="password" name="userPassword" size="30" value="<%=password %>" id="log_Login_action_user_userPassword"/></td>
                             </tr>
                             <tr>
                             	<td></td>
                             	<td><input type="checkbox" name="remenberPass">记住密码</td>                             	
                             </tr>
                             <tr height="60">
                                 <td></td>
                                 <td>
                                     <input type="submit" id="" value="登录"/>
                                     <input type="reset" value="重置"/>

                                     <a id="log_Login_action_" href="view/indextemp.jsp">[返回首页]</a>
                                     <a id="log_Login_action_" href="admin/register.jsp">[注册]</a>
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