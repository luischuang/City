<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gbk">
  <title>页眉</title>
   <link type="text/css" rel="stylesheet" href="../css/style.css">
      <base href="${pageContext.request.contextPath}/"> 
   <script type="text/javascript">
   function AddFavorite(sURL, sTitle)
   {
       try
       {
           window.external.addFavorite(sURL, sTitle);
       }
       catch (e)
       {
           try
           {
               window.sidebar.addPanel(sTitle, sURL, "");
           }
           catch (e)
           {
               alert("加入收藏失败，有劳您手动添加。");
           }
       }
   }
   function addfavorite(){
	   if(confirm("要收藏本页吗？")==true)   
	   {   
		   window.external.AddFavorite('http://localhost:8080/city/view/indextemp.jsp', '都市信息网');
	   }else{
		   
	   }
   
   }
   
   function addHome()
   {
	   if(confirm("要将本页设为首页吗？")==true){
		   document.body.style.behavior='url(#default#homepage)';
		   document.body.setHomePage('http://localhost:8080/city/view/indextemp.jsp');
	   }
   
   }
   
</script>
</head>
<body>

    <center>
        <table border="0" width="100%" cellspacing="0" cellpadding="0">
            <!-- 顶部菜单 -->
           <tr height="20">
                <td style="text-indent:10" valign="bottom">
                    
                    <c:if test="${user!=null }">
                    <font style="color:red">${user.user_name }</font>
                    <a href="" onclick="window.parent.location.href='../user/usermain.jsp?user=${user}'" style="color:gray">个人中心</a>
                    </c:if>
                    <c:if test="${user==null }">
                    <a href="" onclick="window.parent.location.href='../login.jsp'" style="color:gray">登录</a>/
                    <a href="" onclick="window.parent.location.href='../admin/register.jsp'" style="color:gray">注册</a>
                    </c:if>
                </td>
                <td align="right" valign="bottom">
                
                    <a style="color:gray" style="BEHAVIOR: url(#default#homepage)"  
onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://localhost:8080/city/view/indextemp.jsp');return(false);"  
href="http://localhost:8080/city/view/indextemp.jsp" class="ths">设为首页-</a>
                     <a style="color:gray" href="javascript:window.external.AddFavorite('http://localhost:8080/city/view/indextemp.jsp','都市信息网')" class="ths">加入收藏-</a>
                    <a href="mailto:914765033@qq.com" style="color:gray">联系我们-</a>
                    <a href="FileDownLoad?name=用户手册.doc" style="color: gray;">用户手册</a>
                    &nbsp;
                </td>
            </tr>
            <!-- 导航菜单 -->
            <tr height="56">
                <td align="center" width="220" background="images/logo.gif"></td>
                <td align="right" background="images/menu.gif">
                    <table border="0" width="600">
						<tr align="center">
							<td width="100">
								<a href="view/indextemp.jsp" style="color:white" target="_parent">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></font></td>
							
							<!-- <td width="100">
								<a href="SelectInfoServlet?infotypeid=0" style="color:white" target="default">暂时没有信息</a>
							</td> -->
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=1" style="color:white" target="default">招聘信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=2" style="color:white" target="default">培训信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=3" style="color:white" target="default">房屋信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=4" style="color:white" target="default">求购信息</a>
							</td>
						
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=5" style="color:white" target="default">招商引资</a>
							</td>
							</tr>
								
						<tr align="center">
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=6" style="color:white" target="default">公寓信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=7" style="color:white" target="default">求职信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=8"  style="color:white" target="default">家教信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=9" style="color:white" target="default">车辆信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=10" style="color:white" target="default">出售信息</a>
							</td>
							<td width="100">
								<a href="SelectInfoServlet?infotypeid=11" style="color:white" target="default">寻找启示</a>
							</td>    
						</tr>                      
					</table>
                    
                </td>
            </tr>
        </table>
        <table border="0" width="100%" height="90" cellspacing="0" cellpadding="0" style="margin-top:1">
            <tr><td align="center"><img src="images/city_top.jpg"></td></tr>
        </table>
    </center>

</body>
</html>