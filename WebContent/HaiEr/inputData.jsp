<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导入数据</title>
<link type="text/css" rel="stylesheet" href="../css/style.css">
<link type="text/css" rel="stylesheet" href="../css/buttons.css">
      <base href="${pageContext.request.contextPath}/">
<style type="text/css">

/* body { */
/*     width: 600px; */
/*     margin: 40px auto; */
/*     font-family: 'trebuchet MS', 'Lucida sans', Arial; */
/*     font-size: 14px; */
/*     color: #444; */
/* } */

/* table { */
/*     *border-collapse: collapse; /* IE7 and lower */ */
/*     border-spacing: 0; */
/*     width: 100%;     */
/* } */
.ziti {
       font-family:Arial,Helvetica,sans-serif;
       font-size:1em;
       vertical-align:middle;
       font-weight:normal
      }
.bordered {
    border: solid #ccc 1px;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    -webkit-box-shadow: 0 1px 1px #ccc; 
    -moz-box-shadow: 0 1px 1px #ccc; 
    box-shadow: 0 1px 1px #ccc;         
}

.bordered tr:hover {
    background: #fbf8e9;
    -o-transition: all 0.1s ease-in-out;
    -webkit-transition: all 0.1s ease-in-out;
    -moz-transition: all 0.1s ease-in-out;
    -ms-transition: all 0.1s ease-in-out;
    transition: all 0.1s ease-in-out;     
}    
    
.bordered td, .bordered th {
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    padding: 3px;
    text-align: left;    
}

.bordered th {
    background-color: #dce9f9;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
    background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:    -moz-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:     -ms-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:      -o-linear-gradient(top, #ebf3fc, #dce9f9);
    background-image:         linear-gradient(top, #ebf3fc, #dce9f9);
    -webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
    -moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
    box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
    border-top: none;
    text-shadow: 0 1px 0 rgba(255,255,255,.5); 
}

.bordered td:first-child, .bordered th:first-child {
    border-left: none;
}

.bordered th:first-child {
    -moz-border-radius: 6px 0 0 0;
    -webkit-border-radius: 6px 0 0 0;
    border-radius: 6px 0 0 0;
}

.bordered th:last-child {
    -moz-border-radius: 0 6px 0 0;
    -webkit-border-radius: 0 6px 0 0;
    border-radius: 0 6px 0 0;
}

.bordered th:only-child{
    -moz-border-radius: 6px 6px 0 0;
    -webkit-border-radius: 6px 6px 0 0;
    border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
    -moz-border-radius: 0 0 0 6px;
    -webkit-border-radius: 0 0 0 6px;
    border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
    -moz-border-radius: 0 0 6px 0;
    -webkit-border-radius: 0 0 6px 0;
    border-radius: 0 0 6px 0;
}
label.title{
 width:160px;height:24px;display:block;float:left;background-color: #97cbff;line-height:22px;color:#616161;padding-left:18px;margin-right:5px;
 } 
label.blue0{
 width:80px;height:24px;display:block;float:left;background-color: #dce9f9;line-height:22px;color:#616161;padding-left:18px;margin-right:5px;
 } 
label.blue1{
 width:80px;height:24px;display:block;float:left;background-color: #dce9f9;line-height:22px;color:#616161;padding-left:18px;margin-right:5px;
 } 
label.blue2{
 width:100px;height:24px;display:block;float:left;background-color: #dce9f9;line-height:22px;color:#616161;padding-left:18px;margin-right:5px;
 } 
 label.blue3{
 width:80px;height:24px;display:block;float:left;background-color: #dce9f9;line-height:22px;color:#616161;padding-left:18px;margin-right:5px;
 } 
 .text{
 	text-align:center;
 }
</style>
</head>

<script type="text/javascript">
function checkFile(obj){
	 //首先验证文件格式
    var fileName = obj.val();
    alert(fileName);
    if (fileName == "") {
        alert('请选择文件');
        return false;
    }
    var fileType = (fileName.substring(fileName
            .lastIndexOf(".") + 1, fileName.length))
            .toLowerCase();
    if (fileType !== 'xls' && fileType !== 'xlsx') {
        alert('文件格式不正确，excel文件！');
        return false;
    }

//     $("#load_data_action").ajaxSubmit({
//         dataType : "json",
//         success : function(data, textStatus) {
//             if (data['result'] === 'OK') {
//                 console.log('上传文件成功');
//             } else {
//                 console.log('文件格式错误');
//             }
//             return false;
//         }
//     });
    return true;
}
var isok=true;
function checkMail(obj) {
	var strReg="";
	var r;
	var strText=obj.value;
	strReg=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	r=strText.search(strReg);
	if(r==-1){
		alert("邮箱格式错误！");
		isok=false;
	}else{
		isok=true;
	}
}

function checkPhone(obj) {
	var strReg="";
	var r;
	var strText=obj.value;
	strReg=/^((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/;
	r=strText.search(strReg);
	if(r==-1){
		 alert("手机号码格式错误！");
		isok=false;
	}else{
		isok=true;
	}
}
function check(fielname,usename,remnane,len) {
	if(fielname.value.length>len){
		fielname.value=(fielname.value).subString(0,len);
		alert("您的输入超过"+len+"个字符了！");
		isok=false;
	}else{
		usename.value=eval(fielname.value.length);
		remnane.value=len-fielname.value.length;
		isok=true;
	}
}
function isCon(title,linkman,email) {
	if(isok&&title.value.length>0&&linkman.value.length>0&&email.value.length>0){
		return true;
	}else{
		alert("请检查正确后，再提交。")
		return false;
	}
}
</script>

<body background="images/back.gif">
    <center>
        <table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white">
            <tr>
                <td width="100%" align="center" valign="top" bgcolor="#FFFFFF">
				<table border="0" cellpadding="0" cellspacing="0" width="900" height="100%">
					<tr height="20"><td><img src="images/default_t.jpg" width="900"></td></tr>
					<tr>
						<td background="images/default_m.jpg" valign="top" align="center" width="900">
							<form id="load_data_action" name="load_data_action" onsubmit="return checkfile(fileInput)">
							<table border="0" width="850" >
								<tr height="30"><td style="text-indent:10"><font color="#004790"><b>■导入数据</b></font></td></tr>
								<tr height="60">
									<td align="right">
									
  <a class="button button-glow button-rounded button-raised button-primary" href="UploadHandleServlet">点击导入数据</a>
  									</td>
								</tr>
							</table>
							</form>
						
						</td>
					</tr>
					<tr>
					
						<td background="images/default_m.jpg" valign="top" align="center" width="900" height="30">
						
						<table class="bordered" cellspacing="0" width="850px" align="center">
    						 <thead>
    							<tr height="30px">
        							<th scope="col" width="40px">编号</th>        
        							<th scope="col" width="140px">产品型号</th>
        							<th scope="col" width="140px">数量</th>
        							<th scope="col" width="100px">线体</th>
        							<th scope="col" width="100px">优先级</th>
        							<th scope="col" width="140px">交期</th>
    							</tr>
    						</thead>
    						</table>
    						</td>
    						</tr>
					<tr>
					
						<td background="images/default_m.jpg" valign="top" align="center" width="900" height="400">
						<div style="width:850px; height:400px;overflow:scroll;">
						<table class="bordered" cellspacing="0" width="850px" align="center">
<!--     						 <thead> -->
<!--     							<tr> -->
<!--         							<th scope="col">编号</th>         -->
<!--         							<th scope="col">产品型号</th> -->
<!--         							<th scope="col">数量</th> -->
<!--         							<th scope="col">线体</th> -->
<!--         							<th scope="col">优先级</th> -->
<!--         							<th scope="col">交期</th> -->
<!--     							</tr> -->
<!--     						</thead> -->
    						<tbody>
    						
    						<c:if test="${orders!=null }">
    						<c:forEach items="${orders }" var="order">
    							<tr>
        							<th width="40px">${order.id }</th>        
        							<th width="140px">${order.productID }</th>
        							<th width="140px">${order.number }</th>
        							<th width="100px">${order.line }</th>
        							<th width="100px">${order.priority }</th>
        							<th width="140px">${order.delivery }</th>
    							</tr>
    						</c:forEach>
    						</c:if>
    							<tr height="30">
        							<th width="40px"></th>        
        							<th width="140px"></th>
        							<th width="140px"></th>
        							<th width="100px"></th>
        							<th width="100px"></th>
        							<th width="140px"></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    						
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    							<tr height="30">
        							<th></th>        
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
        							<th></th>
    							</tr>
    						</tbody>
    					
    					
						</table>
						</div>
						</td>
						
					</tr>
					<tr>
						<td background="images/default_m.jpg" valign="top" align="center" width="900">
							
							<form id="load_data_action" name="load_data_action" action="StartSchedulingServlet" method="post" >
<!-- 							<input type="hidden" name="addType" value="add"/> -->
							<table border="0" width="850" >
								<tr height="30"><td style="text-indent:10"><label ><font color="#004790"><b>■选择排产规则</b></font></label></td></tr>
								<tr>
									<td align="center">
										<table border="0" width="850" >                    
											<tr  height="50px">
												<td width="20%"><label >选择排产模式:</label></td>
												<td width="20%"><input type="radio" name="model" id="model_mixed" value="model_mixed" checked/><label for="model_mixed" class='blue0'>混合排产</label></td>
												<td width="20%"><input type="radio" name="model" id="model_forward" value="model_forward"  /><label for="model_forward" class='blue0'>正向排产</label></td> 
												<td width="20%"><input type="radio" name="model" id="model_reverse" value="model_reverse" /><label for="model_reverse" class='blue0'>逆向排产</label></td>
												
											</tr>
											<tr height="50px">
												<td><label >选择排产优先级：</label></td>
												<td><label class='blue1' >排产规则</label></td>
												<td><label class='blue2'>优先级顺序</label></td>
												<td><label class='blue3'>所占权重</label></td>
											
											</tr>
											<tr>
												<td></td>
												<td><select name="priority1" id="priority1">
														<option value="null" ></option>
														<option value="交期优先" >交期优先</option>
														<option value="订单优先" selected>订单优先</option>
														<option value="线体满负荷">线体满负荷</option>
														<option value="线体平衡">线体平衡</option>
														<option value="换模次数">换模次数</option>
												</select></td>
												<td><select  name="order1" id="order1">
														<option value="null" ></option>
														<option value="1" selected>1</option>
														<option value="2" >2</option>
														<option value="3" >3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														
												</select></td>
												<td><input type="text" class='text' value="60" size="5"/>%</td>
											</tr>
											<tr>
												<td></td>
												<td><select name="priority2" id="priority2">
												<option value="null" ></option>
														<option value="交期优先" selected>交期优先</option>
														<option value="订单优先" >订单优先</option>
														<option value="线体满负荷" >线体满负荷</option>
														<option value="线体平衡">线体平衡</option>
														<option value="换模次数">换模次数</option>
												</select></td>
												<td><select name="order2" id="order2">
												<option value="null" ></option>
														<option value="1" >1</option>
														<option value="2" selected>2</option>
														<option value="3" >3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														
												</select></td>
												<td><input type="text" class='text' value="40" size="5"/>%</td>
											</tr>
											<tr>
												<td></td>
												<td><select name="priorit3" id="priority3">
												<option value="null" ></option>
														<option value="交期优先" >交期优先</option>
														<option value="订单优先">订单优先</option>
														<option value="线体满负荷" >线体满负荷</option>
														<option value="线体平衡" >线体平衡</option>
														<option value="换模次数">换模次数</option>
												</select></td>
												<td><select name="order3" id="order3">
												<option value="null" ></option>
														<option value="1" >1</option>
														<option value="2" >2</option>
														<option value="3" >3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														
												</select></td>
												<td><input type="text" class='text' value="" size="5"/>%</td>
											</tr>
											<tr>
												<td></td>
												<td><select name="priority4" id="priority4">
												<option value="null" ></option>
														<option value="交期优先" >交期优先</option>
														<option value="订单优先" >订单优先</option>
														<option value="线体满负荷">线体满负荷</option>
														<option value="线体平衡" >线体平衡</option>
														<option value="换模次数" >换模次数</option>
												</select></td>
												<td><select name="order4" id="order4">
												<option value="null" ></option>
														<option value="1" >1</option>
														<option value="2" >2</option>
														<option value="3" >3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														
												</select></td>
												<td><input type="text" class='text' value="" size="5"/>%</td>
											</tr>
											<tr>
												<td></td>
												<td><select name="priority5" id="priority5">
												<option value="null" ></option>
														<option value="交期优先" >交期优先</option>
														<option value="订单优先" >订单优先</option>
														<option value="线体满负荷">线体满负荷</option>
														<option value="线体平衡" >线体平衡</option>
														<option value="换模次数" >换模次数</option>
												</select></td>
												<td><select name="order5" id="order5">
												<option value="null" ></option>
														<option value="1">1</option>
														<option value="2" >2</option>
														<option value="3" >3</option>
														<option value="4">4</option>
														<option value="5">5</option>
														
												</select></td>
												<td><input type="text" class='text' value="" size="5"/>%</td>
											</tr>                       
										</table>                
									</td>
								</tr>
								<tr align="center" height="50">
									<td>
									
  <input class="button button-pill button-primary" type="submit" value="发送排产">

  <input disabled="" class="button button-pill button-primary" type="reset" value="重置">

<!-- 										<input type="submit" id="info_Add_action_0" value="发送排产"/> -->

<!-- 										<input type="reset" value="重置"/> -->

									</td>
								</tr>
							</table>
							</form>

						</td>
					</tr>
					<tr height="26"><td><img src="images/default_e.jpg" width="900"></td></tr>        
				</table>
				</td>
            </tr>
        </table>        
    </center>
</body>
</html>