<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
	<!-- Bootstrap Styles-->
    <link href="../AIEngine/assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="../AIEngine/assets/css/font-awesome.css" rel="stylesheet" />
        <!-- Custom Styles-->
    <link href="../AIEngine/assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.useso.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Dream</a>
            </div>

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Doe</strong>
                                    <span class="pull-right text-muted">
                                        <em>Today</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since an kwilnw...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">28% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: 28%">
                                            <span class="sr-only">28% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">85% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
                                            <span class="sr-only">85% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                	<li>
                        <a href="index.jsp"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                		<a href="dataSet.jsp"  class="active-menu"><i class="fa fa-edit"></i>数据集</a>
                	</li>
                	<li>
                        <a href="dataShow.jsp"><i class="fa fa-bar-chart-o"></i>展示</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop"></i> UI Elements</a>
                    </li>
					<li>
                        <a href="#"><i class="fa fa-bar-chart-o"></i> Charts</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-qrcode"></i> Tabs & Panels</a>
                    </li>
                    
                    <li>
                        <a href="#"><i class="fa fa-table"></i> Responsive Tables</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit"></i> Forms </a>
                    </li>


                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link</a>
                            </li>
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            新建数据集 <small>从本地文件导入</small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
              <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default" >
                        <div class="panel-heading">
                            导入数据
                        </div>
                        
                        <div class="panel-body" >
<!--                             <div class="row"> -->
                                <div class="col-lg-6">
                                	<form role="form" action="../LoadDataFile" enctype="multipart/form-data" method="post" onsubmit="return notNULL(file)">
                                	<div class="form-group">
                                            <label>选择文件</label>
                                            <input type="file" name="file" id="file">
                                    </div>
                                    <button type="submit" class="btn btn-default">打开</button>
                                    <button type="reset" class="btn btn-default">重置</button>
                                	</form>
                                    <form role="form">
                                        <div class="form-group">
                                            <label>数据集名称</label>
                                            <input class="form-control" value="${file_name }">
                                            <p class="help-block" align="right">你要新建的数据集的唯一标识。</p>
                                        </div>
                                     	<div class="table-responsive">
                                        <label>设置数据类型</label>
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>No.</th>
                                                <th>字段名</th>
                                                <th>数据类型</th>
                                                <th>属性描述</th>
                                                <th>能否为空</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>John</td>
                                                <td>Doe</td>
                                                <td>John15482</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Kimsila</td>
                                                <td>Marriye</td>
                                                <td>Kim1425</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            

                                        </tbody>
                                    </table>
                                </div>
                                <div class="table-responsive">
                                        <label>确认数据</label>
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>No.</th>
                                                <th>字段名</th>
                                                <th>数据类型</th>
                                                <th>属性描述</th>
                                                <th>能否为空</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>John</td>
                                                <td>Doe</td>
                                                <td>John15482</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Kimsila</td>
                                                <td>Marriye</td>
                                                <td>Kim1425</td>
                                                <td>name@site.com</td>
                                            </tr>
                                            

                                        </tbody>
                                    </table>
                                </div>
                                        <button type="submit" class="btn btn-default">确定</button>
                                        <button type="reset" class="btn btn-default">重置</button>
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
<!--                                 <div class="col-lg-6"> -->
<!--                                     <h4>Disabled Form States</h4> -->
<!--                                     <form role="form"> -->
<!--                                         <fieldset disabled=""> -->
<!--                                             <div class="form-group"> -->
<!--                                                 <label for="disabledSelect">Disabled input</label> -->
<!--                                                 <input class="form-control" id="disabledInput" type="text" placeholder="Disabled input" disabled=""> -->
<!--                                             </div> -->
<!--                                             <div class="form-group"> -->
<!--                                                 <label for="disabledSelect">Disabled select menu</label> -->
<!--                                                 <select id="disabledSelect" class="form-control"> -->
<!--                                                     <option>Disabled select</option> -->
<!--                                                 </select> -->
<!--                                             </div> -->
<!--                                             <div class="checkbox"> -->
<!--                                                 <label> -->
<!--                                                     <input type="checkbox">Disabled Checkbox -->
<!--                                                 </label> -->
<!--                                             </div> -->
<!--                                             <button type="submit" class="btn btn-primary">Disabled Button</button> -->
<!--                                         </fieldset> -->
<!--                                     </form> -->
<!--                                     <h4>Form Validation States</h4> -->
<!--                                     <form role="form"> -->
<!--                                         <div class="form-group has-success"> -->
<!--                                             <label class="control-label" for="inputSuccess">Input with success</label> -->
<!--                                             <input type="text" class="form-control" id="inputSuccess"> -->
<!--                                         </div> -->
<!--                                         <div class="form-group has-warning"> -->
<!--                                             <label class="control-label" for="inputWarning">Input with warning</label> -->
<!--                                             <input type="text" class="form-control" id="inputWarning"> -->
<!--                                         </div> -->
<!--                                         <div class="form-group has-error"> -->
<!--                                             <label class="control-label" for="inputError">Input with error</label> -->
<!--                                             <input type="text" class="form-control" id="inputError"> -->
<!--                                         </div> -->
<!--                                     </form> -->
<!--                                     <h4>Input Groups</h4> -->
<!--                                     <form role="form"> -->
<!--                                         <div class="form-group input-group"> -->
<!--                                             <span class="input-group-addon">@</span> -->
<!--                                             <input type="text" class="form-control" placeholder="Username"> -->
<!--                                         </div> -->
<!--                                         <div class="form-group input-group"> -->
<!--                                             <input type="text" class="form-control"> -->
<!--                                             <span class="input-group-addon">.00</span> -->
<!--                                         </div> -->
<!--                                         <div class="form-group input-group"> -->
<!--                                             <span class="input-group-addon"><i class="fa fa-eur"></i> -->
<!--                                             </span> -->
<!--                                             <input type="text" class="form-control" placeholder="Font Awesome Icon"> -->
<!--                                         </div> -->
<!--                                         <div class="form-group input-group"> -->
<!--                                             <span class="input-group-addon">$</span> -->
<!--                                             <input type="text" class="form-control"> -->
<!--                                             <span class="input-group-addon">.00</span> -->
<!--                                         </div> -->
<!--                                         <div class="form-group input-group"> -->
<!--                                             <input type="text" class="form-control"> -->
<!--                                             <span class="input-group-btn"> -->
<!--                                                 <button class="btn btn-default" type="button"><i class="fa fa-search"></i> -->
<!--                                                 </button> -->
<!--                                             </span> -->
<!--                                         </div> -->
<!--                                     </form> -->
<!--                                 </div> -->
                                <!-- /.col-lg-6 (nested) -->
<!--                             </div> -->
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p></footer>
			</div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="../AIEngine/assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="../AIEngine/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="../AIEngine/assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="../AIEngine/assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
