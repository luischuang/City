<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title>都市信息网</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body>
<center>
        <table style="margin-left: 10px;" bgcolor="white" border="0" cellpadding="0" cellspacing="0" width="920">
<tbody><tr>
   <td align="left" height="400" bgcolor="#FFFFFF" valign="top" width="670">        
        <table style="margin-top:5" border="0" cellpadding="0" cellspacing="0" width="650">
       
            <tbody><tr height="1"><td></td></tr>
            <tr>
                <td style="border:1 solid" align="center">
                    <table rules="rows" border="0" cellspacing="0" width="100%">
                        <tbody><tr align="center" height="30" bgcolor="#F0F0F0">
                                                    
                            <td width="10%"><b>信息类别</b></td>
                            <td width="36%"><b>信息标题</b></td>
                            <td width="22%"><b>发布时间</b></td>
                            <td width="15%"><b>联系人</b></td>
                        </tr>
  						<c:forEach items="${list }" var="info">
						<tr height="30">
							
							<td align="center" style="text-indent:10">${info.typeIntro }</td>
							<td align="center" style="text-indent:5"><a href="UserSearchCollectionByIdServlet?infoid=${info.infoid }&userid=${user_id}">${info.infoTitle }</a></td>
							<td align="center">${info.infodate }</td>                                    
							<td align="center" style="text-indent:10">${info.infolinkman }</td>
						</tr>
          				</c:forEach>
                    </tbody></table>
                </td>
            </tr>

</tbody></table>
    <table border="0" cellspacing="0" width="900">
        <tbody><tr>
            <td width="60%"><table border="0" cellpadding="3"><tbody><tr><td>每页显示：5 条记录！当前页：${currentPage }/${totalPage }页！</td></tr></tbody></table></td>
            <td align="left" width="40%">
            <table border="0" cellpadding="3">
            <tbody>
            	<tr>
            		<td>
            			<c:if test="${currentPage!=1 }">
        					<a href="GetMyCollectionServlet?currentPage=${currentPage-1 }&user_id=${user_id}">上一页</a>
        				</c:if>
        				<c:if test="${currentPage!=totalPage }">
        					<a href="GetMyCollectionServlet?currentPage=${currentPage+1 }&user_id=${user_id}">下一页</a>
        				</c:if>
        			</td>
        		</tr>
        	</tbody>
        	</table>
        	</td>
        </tr>
    </tbody></table>

            </td></tr>
           
        </tbody></table>
    </center>

</body></html>