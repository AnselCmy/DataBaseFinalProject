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
                    部门数据统计
                </h1>
                <%--<ol class="breadcrumb">--%>
                    <%--<li><a href="#">{{ currEmployee.ENo }}</a></li>--%>
                    <%--<li><a href="#">{{ currEmployee.EName }}</a></li>--%>
                    <%--<li><a href="#">{{ currEmployee.DName }}</a></li>--%>
                    <%--<li><a href="#">{{ currEmployee.PosName }}</a></li>--%>
                <%--</ol>--%>
            </div>
            <div id="page-inner">
                <!-- 全年工资柱状图 -->
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            全年工资柱状图
                        </div>
                        <div class="panel-body">
                            <div id="morris-bar-chart1"></div>
                        </div>
                    </div>
                </div>
                <!-- ./全年工资柱状图 -->

                <!-- 每月工资柱状图 -->
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            {{ monthChosen.key }}工资柱状图
                        </div>
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="month" class="col-md-1 control-label">月份</label>
                                <div class="col-md-10">
                                    <select class="form-control" ng-model="monthChosen" id="month" name="month"
                                            ng-change="changeMonth(monthChosen.val)"
                                            ng-options="m.key for m in month">
                                        <%--<option ng-repeat="m in month">--%>
                                            <%--{{ m }}--%>
                                        <%--</option>--%>
                                    </select>
                                </div>
                                <%--<div class="col-md-1">--%>
                                    <%--<a ng-href="/main/dep/{{ monthChosen.val }}" class="btn btn-default">确认</a>--%>
                                <%--</div>--%>
                                <%--{{ monthChosen }}--%>
                                <%--{{ monthChosen.val }}--%>
                            </div>
                        </form>
                        <div class="panel-body">
                            <div id="morris-bar-chart2"></div>
                        </div>
                    </div>
                </div>
                <!-- ./每月工资柱状图 -->
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
        <%--$scope.searchAttendLog = JSON.parse('${searchAttendLog}');--%>
        <%--$scope.searchPayroll = JSON.parse('${searchPayroll}');--%>
        <%--$scope.allEvent = JSON.parse('${allEvent}');--%>
        $scope.depDataByYear = JSON.parse('${depDataByYear}');
        $scope.depDataByMonth = JSON.parse('${depDataByMonth}');
        <%--$scope.selectMonth = ${month};--%>
        $scope.mngSideBar = "";
        $scope.idvSideBar = "";
        $scope.depSideBar = "active-menu";
        $scope.month = [{"val":"1", "key":"一月"},
                        {"val":"2", "key":"二月"},
                        {"val":"3", "key":"三月"},
                        {"val":"4", "key":"四月"},
                        {"val":"5", "key":"五月"},
                        {"val":"6", "key":"六月"},
                        {"val":"7", "key":"七月"},
                        {"val":"8", "key":"八月"},
                        {"val":"9", "key":"九月"},
                        {"val":"10", "key":"十月"},
                        {"val":"11", "key":"十一月"},
                        {"val":"12", "key":"十二月"}];
        $scope.changeMonth = function(param){
            var data = $scope.depDataByMonth;
            morrisByMonth.setData(data[0][param]);
        }
    });

    Morris.Bar({
        element: 'morris-bar-chart1',
        data: ${depDataByYear},
        xkey: 'DName',
        ykeys: ['Max', 'Min', 'Payroll'],
        labels: ['最高工资', '最低工资', '平均工资'],
        barColors: [
            '#22a7f0',
            '#1abc9c',
            '#f92f7d'
        ],
        hideHover: 'false',
        resize: true,
        xLabelMargin: 10
    });

    var morrisByMonth = Morris.Bar({
        element: 'morris-bar-chart2',
        data: JSON.parse('${depDataByMonth}')[0]["2"],
        xkey: 'DName',
        ykeys: ['Max', 'Min', 'Payroll'],
        labels: ['最高工资', '最低工资', '平均工资'],
        barColors: [
            '#22a7f0',
            '#1abc9c',
            '#f92f7d'
        ],
        hideHover: 'false',
        resize: true,
        xLabelMargin: 10
    });

</script>
</body>

</html>
