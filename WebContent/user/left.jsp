<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>后台-侧栏</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
    <base href="${pageContext.request.contextPath}/">
  <link rel="stylesheet" type="text/css" href="themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="css/demo.css"/>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
  	function checkId() {
		var flag=true;
		var infoid=document.getElementById("infoid").value;
		if(infoid=="" || infoid==null){
			alert("请输入要查询的信息ID！");
			flag=false;
		}
		
		return flag;
	}
  </script>
</head>
<body background="../images/back.gif" style="background-color:white">
    <center>
   
        <table border="0" width="225" height="auto" cellspacing="0" cellpadding="0" style="margin-top:7;background-color:white">
        	
        	<tr>欢迎<font color="red">${sessionScope.user.user_name }</font>登录 </tr>
        	<tr height="30" bgcolor="#F0F0F0">
        		<td align="center" style="text-indent:5" style="border:1 solid" >
        		<a href="" onclick="window.parent.location.href='../admin/addInfo.jsp'" target="default" ><font color="#004790">发布信息</font></a>
        		</td>
        	</tr>
        	<tr height="30" bgcolor="#F0F0F0">
        		<td align="center" style="text-indent:5" style="border:1 solid" >
        		<a href="GetMyInfoServlet?user_id=${user.user_id }" target="default">我的发布</a>
        		</td>
        	</tr>
        	<tr height="30" bgcolor="#F0F0F0">
        		<td align="center" style="text-indent:5" style="border:1 solid" >
        		<a href="GetMyCollectionServlet?user_id=${user.user_id }" target="default">我的收藏</a>
        		</td>
        	</tr>
        	<tr height="30" bgcolor="#F0F0F0">
        		<td align="center" style="text-indent:5" style="border:1 solid" >
        		<a href="user/modify_password.jsp" target="default">修改密码</a>
        		</td>
        	</tr>
            <!-- 日历 -->            
            <tr height="180">
				<td valign="top" align="center">
					<div class="m_l_top">
					<ul>
						<li class="m_li">日历</li>
						<li class="m_li_top">
							<div class="easyui-calendar" style="width: 98%; height: 98%;"></div>
						</li>
					</ul>
				</div>
				</td>
            </tr>
        </table>        
    </center>
</body>

</html>