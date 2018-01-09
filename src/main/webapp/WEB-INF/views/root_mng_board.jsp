<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>工资管理系统</title>
    <!-- Bootstrap Styles-->
    <link href="/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="/assets/css/font-awesome.css" rel="stylesheet" />
    <link href="/lib/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="/assets/js/Lightweight-Chart/cssCharts.css">
</head>

<body>
<div ng-app="payroll_app" ng-controller="payroll_controller">
    <div id="wrapper">
        <jsp:include page="navbar_top.jsp" flush="true" />
        <jsp:include page="navbar_side.jsp" flush="true" />
      
		<div id="page-wrapper">
		    <div class="header">
                        <h1 class="page-header">
                            管理面板
                        </h1>
						<%--<ol class="breadcrumb">--%>
					  <%--<li><a href="#"></a></li>--%>
					  <%--<li><a href="#">Dashboard</a></li>--%>
					  <%--<li class="active">Data</li>--%>
					<%--</ol> --%>
		    </div>
            <div id="page-inner">

                <!-- /. ROW  -->
	
                <%--<div class="row">--%>
                    <%--<div class="col-md-3 col-sm-12 col-xs-12">--%>
					<%--<div class="board">--%>
                        <%--<div class="panel panel-primary">--%>
						<%--<div class="number">--%>
							<%--<h3>--%>
								<%--<h3>44,023</h3>--%>
								<%--<small>Daily Visits</small>--%>
							<%--</h3> --%>
						<%--</div>--%>
						<%--<div class="icon">--%>
						   <%--<i class="fa fa-eye fa-5x red"></i>--%>
						<%--</div>--%>
		 <%----%>
                        <%--</div>--%>
						<%--</div>--%>
                    <%--</div>--%>
					<%----%>
					       <%--<div class="col-md-3 col-sm-12 col-xs-12">--%>
					<%--<div class="board">--%>
                        <%--<div class="panel panel-primary">--%>
						<%--<div class="number">--%>
							<%--<h3>--%>
								<%--<h3>32,850</h3>--%>
								<%--<small>Sales</small>--%>
							<%--</h3> --%>
						<%--</div>--%>
						<%--<div class="icon">--%>
						   <%--<i class="fa fa-shopping-cart fa-5x blue"></i>--%>
						<%--</div>--%>
		 <%----%>
                        <%--</div>--%>
						<%--</div>--%>
                    <%--</div>--%>
					<%----%>
					       <%--<div class="col-md-3 col-sm-12 col-xs-12">--%>
					<%--<div class="board">--%>
                        <%--<div class="panel panel-primary">--%>
						<%--<div class="number">--%>
							<%--<h3>--%>
								<%--<h3>56,150</h3>--%>
								<%--<small>Comments</small>--%>
							<%--</h3> --%>
						<%--</div>--%>
						<%--<div class="icon">--%>
						   <%--<i class="fa fa-comments fa-5x green"></i>--%>
						<%--</div>--%>
		 <%----%>
                        <%--</div>--%>
						<%--</div>--%>
                    <%--</div>--%>
					<%----%>
					       <%--<div class="col-md-3 col-sm-12 col-xs-12">--%>
					<%--<div class="board">--%>
                        <%--<div class="panel panel-primary">--%>
						<%--<div class="number">--%>
							<%--<h3>--%>
								<%--<h3>89,645</h3>--%>
								<%--<small>Daily Profits</small>--%>
							<%--</h3> --%>
						<%--</div>--%>
						<%--<div class="icon">--%>
						   <%--<i class="fa fa-user fa-5x yellow"></i>--%>
						<%--</div>--%>
		 <%----%>
                        <%--</div>--%>
						<%--</div>--%>
                    <%--</div>--%>
				   <%----%>
                <%--</div>--%>
				     <%--<div class="row">--%>
                        <%--<div class="col-sm-6 col-xs-12">  --%>
                            <%--<div class="panel panel-default chartJs">--%>
                                <%--<div class="panel-heading">--%>
                                    <%--<div class="card-title">--%>
                                        <%--<div class="title">Line Chart</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="panel-body">--%>
                                    <%--<canvas id="line-chart" class="chart"></canvas>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="col-sm-6 col-xs-12">--%>
                            <%--<div class="panel panel-default chartJs">--%>
                                <%--<div class="panel-heading">--%>
                                    <%--<div class="card-title">--%>
                                        <%--<div class="title">Bar Chart</div>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <%--<div class="panel-body">--%>
                                    <%--<canvas id="bar-chart" class="chart"></canvas>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
				
		<%--<div class="row">--%>
			<%--<div class="col-xs-6 col-md-3">--%>
				<%--<div class="panel panel-default">--%>
					<%--<div class="panel-body easypiechart-panel">--%>
						<%--<h4>Profit</h4>--%>
						<%--<div class="easypiechart" id="easypiechart-blue" data-percent="82" ><span class="percent">82%</span>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
			<%--<div class="col-xs-6 col-md-3">--%>
				<%--<div class="panel panel-default">--%>
					<%--<div class="panel-body easypiechart-panel">--%>
						<%--<h4>Sales</h4>--%>
						<%--<div class="easypiechart" id="easypiechart-orange" data-percent="55" ><span class="percent">55%</span>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
			<%--<div class="col-xs-6 col-md-3">--%>
				<%--<div class="panel panel-default">--%>
					<%--<div class="panel-body easypiechart-panel">--%>
						<%--<h4>Customers</h4>--%>
						<%--<div class="easypiechart" id="easypiechart-teal" data-percent="84" ><span class="percent">84%</span>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
			<%--<div class="col-xs-6 col-md-3">--%>
				<%--<div class="panel panel-default">--%>
					<%--<div class="panel-body easypiechart-panel">--%>
						<%--<h4>No. of Visits</h4>--%>
						<%--<div class="easypiechart" id="easypiechart-red" data-percent="46" ><span class="percent">46%</span>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div><!--/.row-->--%>
        <%----%>
			<%--<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>--%>
		<%----%>
				<%--<div class="row">--%>
				    <%--<div class="col-md-5">--%>
                        <%--<div class="panel panel-default">--%>
                            <%--<div class="panel-heading">--%>
                                <%--Line Chart--%>
                            <%--</div>--%>
                        <%--<div class="panel-body">--%>
                            <%--<div id="morris-line-chart"></div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
					<%----%>
						<%--<div class="col-md-7">--%>
					<%--<div class="panel panel-default">--%>
					<%--<div class="panel-heading">--%>
                                <%--Bar Chart Example--%>
                            <%--</div>--%>
                            <%--<div class="panel-body">--%>
                                <%--<div id="morris-bar-chart"></div>--%>
                            <%--</div>--%>
						<%----%>
					<%--</div>  --%>
					<%--</div>--%>
					<%----%>
				<%--</div> --%>
			 <%----%>
				<%----%>
				<%----%>
                <%--<div class="row">--%>
                    <%--<div class="col-md-9 col-sm-12 col-xs-12">--%>
                        <%--<div class="panel panel-default">                            --%>
							<%--<div class="panel-heading">--%>
							<%--Area Chart--%>
						<%--</div>--%>
						<%--<div class="panel-body">--%>
							<%--<div id="morris-area-chart"></div>--%>
						<%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="col-md-3 col-sm-12 col-xs-12">--%>
                        <%--<div class="panel panel-default">--%>
                            <%--<div class="panel-heading">--%>
                                <%--Donut Chart Example--%>
                            <%--</div>--%>
                            <%--<div class="panel-body">--%>
                                <%--<div id="morris-donut-chart"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
				<%--<div class="row">--%>
				<%--<div class="col-md-12">--%>
				<%----%>
					<%--</div>		--%>
				<%--</div> 	--%>
                <!-- /. ROW  -->




                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                搜索
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal"
                                      action="/employee/" method="post" Ectype="text/plain">
                                    <div class="form-group">
                                        <label for="dep" class="col-md-1 control-label">部门</label>
                                        <div class="col-md-10">
                                            <select class="form-control" ng-model="depChosen" id="dep" name="dep"
                                                    ng-options="d.DName for d in allDepartment"
                                                    ng-change="changeDep(depChosen.DName)">
                                            </select>
                                        </div>
                                        <%--{{ count }}--%>
                                        <%--{{ depChosen.DName }}--%>
                                        <%--{{ selectEmployee }}--%>
                                    </div>
                                    <div class="form-group">
                                        <label for="ENo" class="col-md-1 control-label">员工</label>
                                        <div class="col-md-10">
                                            <select class="form-control" ng-model="employeeChosen" id="ENo" name="ENo"
                                                    ng-options="e.EName for e in selectEmployee">
                                            </select>
                                        </div>
                                    </div>
                                    <%--{{ depChosen }}--%>
                                    <%--{{ depChosen.DName }}--%>
                                    <%--{{ getENameByDName(depChosen.DName) }}--%>
                                    <%--{{ test }}--%>
                                    <div class="col-md-1">
                                        <a ng-href="/employee/{{ employeeChosen.ENo }}" class="btn btn-default">确认</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                员工基本信息
                            </div>
                            <%--<div ng-repeat="e in allEntity">--%>
                                <%--<a>{{ e }}</a>--%>
                            <%--</div>--%>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>工号</th>
                                                <th>姓名</th>
                                                <th>身份证号</th>
                                                <th>性别</th>
                                                <th>入职日期</th>
                                                <th>部门</th>
                                                <th>职位</th>
                                                <th>电话号码</th>
                                                <th>年龄</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr ng-repeat="entity in allEmployee">
                                                <td>{{ entity.ENo }}</td>
                                                <td>{{ entity.EName }}</td>
                                                <td>{{ entity.EId }}</td>
                                                <td>{{ entity.ESex }}</td>
                                                <td>{{ entity.EEntryDate }}</td>
                                                <td>{{ entity.DName }}</td>
                                                <td>{{ entity.PosName }}</td>
                                                <td>{{ entity.ETel }}</td>
                                                <td>{{ entity.EAge }}</td>
                                                <td>
                                                    <a class="btn btn-default" href="/employee/{{ entity.ENo }}" role="button">详情</a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /. ROW  -->
				<footer><p>Copyright &copy; 2018. SuLu & ChenMingyang All rights reserved.</p>
				</footer>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
</div>
    <!-- /.angular-js -->
<div ng-app="payroll_app" ng-controller="payroll_controller">
{{ currEName }}
</div>
    <!-- JS Scripts-->
    <script src="/lib/angular-1.6.8/angular.min.js"></script>
    <!-- jQuery Js -->
    <script src="/assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="/assets/js/morris/morris.js"></script>
	<script src="/assets/js/easypiechart.js"></script>
	<script src="/assets/js/easypiechart-data.js"></script>
	<script src="/assets/js/Lightweight-Chart/jquery.chart.js"></script>
    <!-- Custom Js -->
    <script src="/assets/js/custom-scripts.js"></script>
    <!-- Chart Js -->
    <script src="/assets/js/Chart.min.js"></script>
    <script src="/assets/js/chartjs.js"></script>
    <%--<script src="/lib/jquery-3.2.1.min.js"></script>--%>
    <script>
        var app = angular.module("payroll_app", []);
        app.controller("payroll_controller", function($scope){
            $scope.currEmployee = (JSON.parse('${currEmployee}'))[0];
            $scope.allEmployee = JSON.parse('${allEmployee}');
            $scope.allDepartment = JSON.parse('${allDepartment}');
            $scope.depChosen = $scope.allDepartment[0];
            $scope.selectEmployee = [];
            $scope.mngSideBar = "active-menu";
            $scope.idvSideBar = "";
            $scope.depSideBar = "";
            $scope.count = 0;

            $scope.changeDep = function(DName) {
                $scope.selectEmployee = [];
                // alert(DName);
                for(var i=0; i<$scope.allEmployee.length; i++) {
                    if($scope.allEmployee[i]["DName"] === DName) {
                        $scope.selectEmployee.push($scope.allEmployee[i]);
                    }
                    // alert($scope.allEmployee[i]["DName"], DName)
                }
                // $scope.selectEmployee = $scope.allEmployee;
            };
        });
    </script>
</body>

</html>