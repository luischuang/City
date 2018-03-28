
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<title>后台首页</title><link href="../css/style.css" rel="stylesheet" type="text/css">

<script>
	function del(uid){
		if(confirm("是否确认删除？")){
			window.location.href="UserServlet?flag=del&uid="+uid;
		}
	}
	
</script>

</head>
  
  
<body>
    <center>
    	<c:if test="${size>0 }">
        <table width="650" cellspacing="0" cellpadding="0" border="0" height="300">
           	<tbody><tr height="30"><td align="center">用户id</td><td>用户名</td><td>操作</td></tr>
           	<c:forEach items="${userList }" var="user">
           		<tr id="trdel" height="30">
           	   		<td align="center">${user.user_id }</td>
           	   		<td>${user.user_name }</td>
           	   	<td>
           	   	<a href="UserServlet?flag=toUpdate&uid=${user.user_id }">修改</a>
           	  	|<a href="#" onclick="del(${user.user_id })">删除</a>
           	   	</td>
           	   	</tr>
           	</c:forEach>

           	<tr>
           		<td align="center" colspan="3"><c:if test="${goPage!=1 }"><a href="UserServlet?flag=userList&goPage=${goPage-1 }&userid=${userid}">上一页</a></c:if>
           		|<c:if test="${goPage!=page }"><a href="UserServlet?flag=userList&goPage=${goPage+1 }&userid=${userid}">下一页</a></c:if>
           		</td>
           	</tr>
        </tbody></table>
        </c:if>
        <c:if test="${size<1 }"><p>您查找的用户不存在！</p></c:if>
    </center>

</body></html>