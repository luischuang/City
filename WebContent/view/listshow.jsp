<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>后台-查看信息列表</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
  <base href="${pageContext.request.contextPath}/">
</head>
<body background="images/back.gif">
    <center>
        <table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white">
            
<tr>

   <td width="690" height="400" align="left" valign="top" bgcolor="#FFFFFF">   
           <!-- 列表显示付费信息 -->
        <c:if test="${payInfo!=null }">
        <table border="0" width="670" cellspacing="0" cellpadding="0" style="margin-top:5">
            
            
                <tr height="30"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■推荐${payInfo.typeIntro }</b>『缴费专区』</font></td></tr>
                
                     
                         <tr><td align="center" style="border:1 solid" bgcolor="#F0F0F0">
                     
                     
                             <table border="0" width="655" cellpadding="3" style="word-break:break-all">
                                 <tr height="30">
                                     <td colspan="2">【${payInfo.typeIntro }】</td>
                                     <td align="right">发布时间：『${payInfo.infodate }』&nbsp;</td>
                                 </tr>
                                 <tr height="80"><td colspan="3">${payInfo.infocontent }</td></tr>
                                 <tr height="30" align="center">
                                     <td>联系电话：${payInfo.infophone }</td>
                                     <td>联 系 人：${payInfo.infolinkman }</td>
                                     <td>E-mail：${payInfo.infoemail }</td>
                                 </tr>                                 
                             </table>
                         </td>
                     </tr>
        </table>
        </c:if>
        <c:if test="${payInfo==null }">
        <table border="0" width="670" cellspacing="0" cellpadding="0" style="margin-top:5">
       <tr height="170">
				<td><p>您查找的付费信息不存在！</p></td>
		</tr>  
       </table>
        
        
        </c:if>
       
        
                <!-- 列表显示免费信息 -->
        <c:if test="${freeInfo!=null }">
        <table border="0" width="670" cellspacing="0" cellpadding="0" style="margin-top:5">
            
            
                <tr height="30"><td style="text-indent:5" valign="bottom"><font color="#004790"><b>■推荐${freeInfo.typeIntro }</b>『免费专区』</font></td></tr>
                
                     
                         <tr><td align="center" style="border:1 solid" bgcolor="#F0F0F0">
                     
                     
                             <table border="0" width="655" cellpadding="3" style="word-break:break-all">
                                 <tr height="30">
                                     <td colspan="2">【${freeInfo.typeIntro }】</td>
                                     <td align="right">发布时间：『${freeInfo.infodate }』&nbsp;</td>
                                 </tr>
                                 <tr height="80"><td colspan="3">${freeInfo.infocontent }</td></tr>
                                 <tr height="30" align="center">
                                     <td>联系电话：${freeInfo.infophone }</td>
                                     <td>联 系 人：${freeInfo.infolinkman }</td>
                                     <td>E-mail：${freeInfo.infoemail }</td>
                                 </tr>                                 
                             </table>
                         </td>
                     </tr>
        </table>
        </c:if>
        <c:if test="${freeInfo==null }">
        <table border="0" width="670" cellspacing="0" cellpadding="0" style="margin-top:5">
       <tr height="170">
				<td><p>您查找的免费信息不存在！</p></td>
		</tr>  
       </table>
        
        
        </c:if>
       
</td>
            </tr>
           
        </table>
       
    </center>
</body>
</html>