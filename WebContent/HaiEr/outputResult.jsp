<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" media="screen" href="css-table.css" />
<link type="text/css" rel="stylesheet" href="../css/buttons.css">
<base href="${pageContext.request.contextPath}/">
<script type="text/javascript" src="../HaiEr/js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="../HaiEr/js/style-table.js"></script>
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

</style>
</head>
<body background="images/back.gif">
    <center>
        <table border="0" width="920" cellspacing="0" cellpadding="0" bgcolor="white">
            <tr>
                <td width="100%" align="center" valign="top" bgcolor="#FFFFFF">
				<table border="0" cellpadding="0" cellspacing="0" width="900" height="100%">
					<tr height="20"><td><img src="images/default_t.jpg" width="900px"></td></tr>
					<tr height="40">
						<td background="images/default_m.jpg" valign="top" align="center" width="900px">
						<font color="#004790" size="12"><b>排产结果</b></font>
						</td>
					</tr>

					<tr>
						<td background="images/default_m.jpg" valign="top" align="center" width="900px">
						<div align="center" style="width:850px; height:600px;overflow:scroll;">
						<table class="bordered" id="outputResult" align="center" width="850px">

    <thead>    
    	<tr>
            <th scope="col" rowspan="2">生产线</th>
            <th scope="col" rowspan="2">产品型号</th>
            <th scope="col" rowspan="2">生产数量</th>
            <th scope="col">周一</th>
            <th scope="col">周二</th>
            <th scope="col">周三</th>
            <th scope="col">周四</th>
            <th scope="col">周五</th>
            <th scope="col">周六</th>
            <th scope="col">周日</th>
        </tr>
        
        <tr>
            <th scope="col">7-22</th>
            <th scope="col">7-23</th>
            <th scope="col">7-24</th>
            <th scope="col">7-25</th>
            <th scope="col">7-26</th>
            <th scope="col">7-27</th>
            <th scope="col">7-28</th>
        </tr>        
    </thead>
    
<!--     <tfoot> -->
<!--     	<tr> -->
<!--         	<th scope="row">All modes</th> -->
<!--         	<th scope="row">All modes</th> -->
<!--         	<th scope="row">All modes</th> -->
<!--             <th scope="row">All modes</th> -->
<!--             <td>39</td> -->
<!--             <td>27</td> -->
<!--             <td>39</td> -->
<!--             <td>20</td> -->
<!--             <td>23</td> -->
<!--             <td>23</td> -->
<!--             <td>23</td> -->
<!--         </tr> -->
<!--     </tfoot> -->
    
    <tbody>
    <c:if test="${products!=null }">
    	<c:forEach items="${products }" var="product">
    	<tr>
    		<th scope="row" width="50">${product.line }</th>
    		<th scope="row">${product.productID }</th>
            <th scope="row">${product.number }</th>
            <td>${product.task.get(0) }</td>
            <td>${product.task.get(1) }</td>
            <td>${product.task.get(2) }</td>
            <td>${product.task.get(3) }</td>
            <td>${product.task.get(4) }</td>
            <td>${product.task.get(5) }</td>
            <td>${product.task.get(6) }</td>
        </tr>
    	</c:forEach>
    	
    </c:if>
    	
        
        
        
    </tbody>

</table>

						</div>
						</td>
						
					</tr>
					<tr>
						<td align="center">
							<button onclick="<%session.removeAttribute("orders"); session.invalidate();%>window.location='HaiEr/inputData.jsp'">返回</button>
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