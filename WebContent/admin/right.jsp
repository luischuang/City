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
            <tr height="30" bgcolor="#F0F0F0"><td style="text-indent:5" style="border:1 solid"><font color="#004790"><b>■用户管理</b></font></td></tr>
            <tr height="1"><td></td></tr>
        	 <form action="UserServlet?flag=userList" method="post" target="default">
            <tr>
                <td align="center" valign="top" style="border:1 solid">
                    <table border="0" width="220" height="80" cellspacing="0"  style="font-size:12px">
                        <tr height="25"><td align="center" valign="bottom">请输入要查询的用户ID：</td></tr>
                        <tr height="40">
                            <td align="center">
                                <input type="text" name="userid" value="" size="24"/>
                                <input type="submit" value="查询"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            </form>
            <!-- 显示方式 -->
            <tr height="30" bgcolor="#F0F0F0"><td style="text-indent:5;border:1 solid"><font color="#004790"><b>■显示方式</b></font></td></tr>
            <tr height="1"><td></td></tr>
            <form id="admin_ListShow_action?" name="admin_ListShow_action?" action="InfoListServlet" method="post" target="default">
            <tr>
                <td align="center" valign="top" style="border:1 solid">
                    <table border="0" width="215" height="150" cellspacing="0" style="font-size:12px">
                        <tr>
                            <td colspan="2">
                                <fieldset style="height:60;width:200">
                                  <legend>★付费状态</legend>
                                  <br>
                                  <input type="radio" name="payforType" id="payforType0" value="0"/>
								  <label for="payforType0">未付费</label>
								<input type="radio" name="payforType" id="payforType1" value="1"/>
								<label for="payforType1">已付费</label>
								<input checked="checked" type="radio" name="payforType" id="payforTypeall" value="all"/>
								<label for="payforTypeall">全部</label>
                                </fieldset>
                                <fieldset style="height:60;width:200">
                                  <legend>★审核状态</legend>
                                  <br>
                                  <input type="radio" name="stateType" id="stateType0" value="0"/>
								  <label for="stateType0">未审核</label>
									<input type="radio" name="stateType" id="stateType1" value="1"/>
									<label for="stateType1">已审核</label>
									<input checked="checked" type="radio" name="stateType" id="stateTypeall" value="all"/>
									<label for="stateTypeall">全部</label>
                                </fieldset>
                            </td>
                        </tr>
                        <tr  height="30" bgcolor="lightgrey">
                            <td>
                               信息类别：
                                   <select name="infoType" id="infoType">
										<option value=""></option>
										<option value="0">暂时没有信息</option>
										<option value="1">招聘信息</option>
										<option value="2">培训信息</option>
										<option value="3">房屋信息</option>
										<option value="4">求购信息</option>
										<option value="5">招商引资</option>
										<option value="6">公寓信息</option>
										<option value="7">求职信息</option>
										<option value="8">家教信息</option>
										<option value="9">车辆信息</option>
										<option value="10">出售信息</option>
										<option value="11">寻找启示</option>
									</select>

                               <input type="submit" id="admin_ListShow_action?_0" value="显示"/>

                            </td>
                        </tr>
                        
                    </table>
                </td>
            </tr>
            </form>

            <tr height="5"><td></td></tr>
            <!-- 设置已付费信息 -->            
            <tr height="30" bgcolor="#F0F0F0"><td style="text-indent:5" style="border:1 solid"><font color="#004790"><b>■付费设置</b></font></td></tr>
            <tr height="1"><td></td></tr>
            <form action="SearchInfoByIdServlet" target="default" onsubmit="return checkId()">
            <tr>
                <td align="center" valign="top" style="border:1 solid">
                    <table border="0" width="220" height="80" cellspacing="0"  style="font-size:12px">
                        <tr height="25"><td align="center" valign="bottom">请输入要设为已付费状态的信息ID：</td></tr>
                        <tr height="40">
                            <td align="center">
                                <input type="text" id="infoid" name="infoid" value="" size="24"/>
                                <input type="submit" value="查询"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            </form>
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