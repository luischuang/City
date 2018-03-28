<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title>都市信息网</title>
  <link type="text/css" rel="stylesheet" href="../css/style.css">
  <script type="text/javascript">
  	 function request(paras) {
            var url = location.href;
            var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
            var paraObj = { };
            for (i = 0; j = paraString[i]; i++) {
                paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
            }
            var returnValue = paraObj[paras.toLowerCase()];
            if (typeof (returnValue) == "undefined") {
                return "";
            } else {
                return returnValue;
            }
        }

       
  	
  function check(){
	  window.location.href="SetInfoCheckServlet?infoid=${info.infoid}";
  }
  function pay(){
	  window.location.href="SetInfoPayServlet?infoid=${info.infoid}";
  }
  </script>
</head>
<body>
	<div align="left">
			
		<table style="text-align:center;margin-left: 10px;" bgcolor="white" border="0" cellpadding="0" cellspacing="0" width="690">
			
			<tbody><tr>
				<td align="left" height="400" bgcolor="#FFFFFF" valign="top" width="690">        
					<!-- 列表显示免费信息 -->
					<c:if test="${info!=null }">
					<table style="margin-top:5" border="0" cellpadding="0" cellspacing="0" width="670">
					
						<tbody><tr height="30"> 
							<td style="text-indent:5" valign="bottom"><font color="#004790"><b>■查看详细信息</b></font>
							<input id="checkBut" value="审核通过" onclick="check()"  type="button" <c:if test="${info.infocheckstate==1 }"> disabled="disabled" </c:if>  >
							<input id="payBut" value="设置付费" onclick="pay()"  type="button" <c:if test="${info.infopaystate==1 }"> disabled="disabled" </c:if>>
							</td>
						</tr>            
						<tr height="1">
							<td></td>
						</tr>
						<tr bgcolor="#FAFCF5">
							<td >
								<table border="0" width="100%" cellspacing="0" cellpadding="2" style="font-size:14px;">
									<tr height="30">
										<td width="20%" style="text-indent:20">信息类别：</td>
										<td>${info.typeIntro }</td>
									</tr>
									<tr height="30">
										<td style="text-indent:20">发布时间：</td>
										<td>${info.infodate }</td>
									</tr>
									<tr height="30">
										<td style="text-indent:20">信息标题：</td>
										<td>${info.infoTitle }</td>
									</tr>
									<tr height="30">
										<td colspan="2" style="text-indent:20">信息内容：</td>
										
									</tr>
									<tr>
										<td align="center" colspan="2" bordercolor="#FAFCFA">${info.infocontent }</td>
									</tr>
									<!-- <tr>
										<td colspan="2" style="text-indent:20">车辆信息内容：</td>
									</tr> -->
									<tr height="40">
										<td colspan="2" align="left">
											<table border="0" width="630" cellspacing="0" cellpadding="0"  style="word-break:break-all;font-size:14px;" >
												<tr height="20" align="center">
													<td>联系电话：${info.infophone }</td>
													<td>联系人：${info.infolinkman }</td>
													<td>E-mial：${info.infoemail }</td>
												</tr>
											</table>                      
										</td>
									</tr>
									<tr height="40">
										<td align="center" colspan="2" ><a href="javascript:window.history.back(-1)">返回</a></td>
									</tr>                              
								
								</table>
							</td>
						</tr>
					</tbody></table>
					</c:if>
					<c:if test="${info==null }">
					<p align="center">您查找的信息不存在！</p>
					</c:if>
					<br>
				</td>
			</tr>      
		</tbody></table>
		<!-- 页脚 -->
	</div>


</body>
<!--  <script type="text/javascript">
 var type = decodeURI(request("type"));//De=‘未设置’
  	   if(type==1){
  	   	  document.getElementById("payBut").style.display="none";
  	   	}else{
  	   		 document.getElementById("checkBut").style.display="none";
  	   		
  	   		}
</script> -->
</html>