<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>都市信息网</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
</head>
<body background="../images/back.gif">

        <table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white">

<tr>

   <td width="690" height="400" align="left" valign="top" bgcolor="#FFFFFF">        
        <table border="0" width="670" cellspacing="0" cellpadding="0" style="margin-top:5">
       
            <tr height="30"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■查询结果</b></font></td></tr>
            <tr height="1"><td></td></tr>
            <tr>
                <td align="left" style="border:1 solid">
                    <table border="0" width="100%" rules="rows" cellspacing="0">
                    <c:if test="${total>0 }">
                        <tr align="left" height="30" bgcolor="#F0F0F0">
                            <td width="6%"><b>序号</b></td>
                            <td width="11%"><b>信息类别</b></td>                            
                            <td width="8%"><b>ID值</b></td>
                            <td width="38%"><b>信息标题</b></td>
                            <td width="22%"><b>发布时间</b></td>
                            <td width="15%"><b>联系人</b></td>
                        </tr>
                        <c:forEach items="${list }" var="info">
                        	<tr>
                        	<td width="6%"><b>${info.infouserid }</b></td>
                            <td width="11%"><b>${info.typeIntro }</b></td>                            
                            <td width="8%"><b>${info.infoid }</b></td>
                            <td width="38%"><b><a href="ViewSearchInfoByIdServlet?infoid=${info.infoid }">${info.infoTitle }</a></b></td>
                            <td width="22%"><b>${info.infodate }</b></td>
                            <td width="15%"><b>${info.infolinkman }</b></td>
                        	</tr>
                        	
                        </c:forEach>
  						</c:if>
						<c:if test="${total<1 }">
							<tr>
								<td align="center">您查找的消息不存在。</td>
							</tr>
						</c:if>
        			</table>
        		<br>
				</td>
            </tr>
        </table>
        <table border="0" width="100%" cellspacing="0">
        	<tr>
        		<td align="left" width="40%" >
        			<table border="0" cellpadding="3">
        				<tr>
        					<td align="center">
        					<c:if test="${currentPage!=1 }">
        						<a href="SearchInfoServlet?currentPage=${currentPage-1 }&sqlvalue=${sqlvalue}&subsql=${subsql}&type=${type}">上一页</a>
        					</c:if>
        					<c:if test="${currentPage!=totalPage }">
        						<a href="SearchInfoServlet?currentPage=${currentPage+1 }&sqlvalue=${sqlvalue}&subsql=${subsql}&type=${type}">下一页</a>
        					</c:if>
        					</td>
        				</tr>
        			</table>
        		</td>
        	</tr>
        </table>
		</td>
		</tr>
		</table>

</body>
</html>