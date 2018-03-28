<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.contextPath}/">
<title>首页</title>
</head>
				
				<body>
					<center>
						<!-- 缴费专区 -->						
						<table border="0" width="670" cellspacing="0" cellpadding="5">
							<tr height="35"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■推荐信息</b></font></td></tr>
							<tr bgcolor="#FAFCF5">
								<td style="border:1 solid">
								
								<table align="left" border="0" width="50%" cellspacing="0" cellpadding="0">
								<c:forEach items="${payInfoList1 }" var="payInfo1">
										 <tr height="23">
											<td width="50%">『<b>${payInfo1.typeIntro }</b>』
												<a href="ViewSearchInfoByIdServlet?infoid=${payInfo1.infoid }&userid=${user.user_id}">${payInfo1.infoTitle }</a>
											</td>
										</tr>
										</c:forEach>
									</table>
								<table align="right" border="0" width="50%" cellspacing="0" cellpadding="0">
								<c:forEach items="${payInfoList2 }" var="payInfo2">
										 <tr height="23">
											<td width="50%">『<b>${payInfo2.typeIntro }</b>』
												<a href="ViewSearchInfoByIdServlet?infoid=${payInfo2.infoid }&userid=${user.user_id}">${payInfo2.infoTitle }</a>
											</td>
										</tr>
										</c:forEach>
								</table>
								
								</td>
							</tr>
							<tr>
								<td align="right">
								<a href="ShowMoreServlet?payforType=1">更多...</a>
								</td>
							</tr>
						</table>
<!-- 						广告-->
						<table border="0" width="670"cellspacing="0" cellpadding="0" style="margin-top:1">
							<tr><td align="center"><img src="images/ad.jpg"></td></tr>
						</table>       
						<!-- 免费专区 -->
						<table border="0" width="670" cellspacing="2" cellpadding="0">
							<tr height="35"><td colspan="2" style="text-indent:5" valign="bottom"><font color="#004790"><b>■最新信息</b></font></td></tr>
						</table>
						<table align="left" border="0" width="335" cellspacing="2" cellpadding="0">
						<c:forEach items="${freeInfoList1 }" var="freeInfo1">
							<tr>
								<td align="center">
									<table border="1" cellspacing="0" cellpadding="0" width="332" height="160" rules="none" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white">
									<tr bgcolor="#00B48F" height="30">
										<td style="text-indent:10"><b><font color="white">${freeInfo1.typeIntro }</font></b></td> </tr>
									<tr bgcolor="#FAFCF5"><td style="text-indent:3">★ <a href="ViewSearchInfoByIdServlet?infoid=${freeInfo1.infoid }&userid=${user.user_id}">${freeInfo1.infoTitle }</a></td></tr>
<!-- 									<tr height="20" bgcolor="#FAFCF5"><td align="right"><a href="ShowMoreServlet?payforType='0'">更多...</a>&nbsp;&nbsp;</td></tr>	
 -->									
									</table>
								</td>
								</tr>
							</c:forEach>
							</table>
							<table align="right" border="0" width="335" cellspacing="2" cellpadding="0">
							<c:forEach items="${freeInfoList2 }" var="freeInfo2">
							<tr>
								<td align="center">
									<table border="1" cellspacing="0" cellpadding="0" width="332" height="160" rules="none" bordercolor="lightgrey" bordercolorlight="lightgrey" bordercolordark="white">
									<tr bgcolor="#00B48F" height="30">
										<td style="text-indent:10"><b><font color="white">${freeInfo2.typeIntro }</font></b></td> </tr>
									<tr bgcolor="#FAFCF5"><td style="text-indent:3">★<a href="ViewSearchInfoByIdServlet?infoid=${freeInfo2.infoid }&userid=${user.user_id}">${freeInfo2.infoTitle }</a></td></tr>
<!-- 									<tr height="20" bgcolor="#FAFCF5"><td align="right"><a href="ShowMoreServlet?payforType='0'">更多...</a>&nbsp;&nbsp;</td></tr>	
 -->									
									</table>
								</td>
							</tr>
							</c:forEach>
							<tr>
								<td align="right">
								<a href="ShowMoreServlet?payforType=0">更多...</a>
								</td>
							</tr>
							</table>
						
						<br>
					</center>
				</body>
				</html>

			</td>
		</tr>
