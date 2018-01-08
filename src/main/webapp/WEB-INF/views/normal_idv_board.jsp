<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/1/7
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
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
        <jsp:include page="normal_navbar_side.jsp" flush="true" />
        <div id="page-wrapper">
            <div class="header">
                <h1 class="page-header">
                    员工工资详情 <small>{{ currEmployee.EName }}</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#">{{ currEmployee.ENo }}</a></li>
                    <li><a href="#">{{ currEmployee.EName }}</a></li>
                    <li><a href="#">{{ currEmployee.DName }}</a></li>
                    <li><a href="#">{{ currEmployee.PosName }}</a></li>
                </ol>
            </div>
            <div id="page-inner">
                <!-- 考勤记录 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                考勤记录
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>日期</th>
                                            <th>事件</th>
                                            <th>奖罚金额</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr ng-repeat="log in searchAttendLog">
                                            <td>{{ log.ALDate }}</td>
                                            <td>{{ log.AEName }}</td>
                                            <td>{{ log.AEMoney }}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <%--<div>--%>
                                    <%--<form action="/employee/addattendlog" method="post" class="form-inline">--%>
                                        <%--<fieldset class="form-group">--%>
                                            <%--<label for="AENo">添加记录 &nbsp</label>--%>
                                            <%--<select class="form-control" id="AENo" name="AENo">--%>
                                                <%--<option ng-repeat="e in allEvent" VALUE="{{ e.AENo }}">--%>
                                                    <%--{{ e.AEName }}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--%>
                                                <%--</option>--%>
                                            <%--</select>--%>
                                        <%--</fieldset>--%>
                                        <%--<input type="hidden" id="ENo" name="ENo" value="{{ searchEmployee.ENo }}">--%>
                                        <%--<button type="submit" class="button btn btn-success btn-large">确认</button>--%>
                                    <%--</form>--%>
                                <%--</div>--%>
                            </div>
                        </div> <!-- ./panel -->
                    </div>
                </div> <!-- ./row -->
                <!-- /考勤记录 -->

                <!-- 工资记录 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                工资记录
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading">
                                                工资走势
                                            </div>
                                            <div class="panel-body">
                                                <div id="morris-line-chart"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>日期</th>
                                            <th>工资</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr ng-repeat="pay in searchPayroll">
                                            <td>{{ pay.PDate }}</td>
                                            <td>{{ pay.PPayroll }}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- ./row -->
                <!-- /工资记录 -->
            </div> <!-- ./page-inner -->
        </div> <!-- ./page-wrapper -->
    </div> <!-- ./wrapper -->
</div> <!-- ./angular-js -->

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
<%--<script src="/assets/js/custom-scripts.js"></script>--%>
<!-- Chart Js -->
<script src="/assets/js/Chart.min.js"></script>
<script src="/assets/js/chartjs.js"></script>
<%--<script src="/lib/jquery-3.2.1.min.js"></script>--%>
<script>
    var app = angular.module("payroll_app", []);
    app.controller("payroll_controller", function($scope){
        $scope.currEmployee = JSON.parse('${currEmployee}')[0];
        <%--$scope.searchEmployee = JSON.parse('${searchEmployee}')[0];--%>
        $scope.searchAttendLog = JSON.parse('${searchAttendLog}');
        $scope.searchPayroll = JSON.parse('${searchPayroll}');
        <%--$scope.allEvent = JSON.parse('${allEvent}');--%>
        $scope.rootSideBar = "";
        $scope.normalSideBar = "active-menu";
    });

    Morris.Line({
        element: 'morris-line-chart',
        data: JSON.parse('${searchPayroll}'),
        xkey: 'PDate',
        ykeys: ['PPayroll'],
        ymin: 'auto',
        labels: ['工资'],
        fillOpacity: 0.6,
        hideHover: 'auto',
        behaveLikeLine: true,
        resize: true,
        pointFillColors:['#ffffff'],
        pointStrokeColors: ['black'],
        lineColors:['gray','#1abc9c']

    });
</script>
</body>

</html>
