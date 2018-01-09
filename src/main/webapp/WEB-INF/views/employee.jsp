<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/1/7
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
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
                    员工工资详情 <small>{{ searchEmployee.EName }}</small>
                </h1>
                <ol class="breadcrumb">
                <li><a href="#">{{ searchEmployee.ENo }}</a></li>
                <li><a href="#">{{ searchEmployee.EName }}</a></li>
                <li><a href="#">{{ searchEmployee.DName }}</a></li>
                <li><a href="#">{{ searchEmployee.PosName }}</a></li>
                </ol>
            </div>
            <div id="page-inner">
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
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr ng-repeat="log in searchAttendLog">
                                            <td>{{ log.ALDate }}</td>
                                            <td>{{ log.AEName }}</td>
                                            <td>{{ log.AEMoney }}</td>
                                            <td>
                                                <a class="btn btn-danger"
                                                   ng-href="/employee/deleteattendlog/{{ searchEmployee.ENo }}/{{ log.ALDate }}/{{ log.AENo }}"
                                                   role="button">删除</a>
                                            </td>
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

                <!-- 添加考勤记录 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                添加考勤
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal" action="/employee/addattendlog" method="post">
                                    <div class="form-group">
                                        <label for="SENo" class="col-md-1 control-label">类型</label>
                                        <div class="col-md-10">
                                            <select class="form-control" id="AENo" name="AENo">
                                                <option ng-repeat="e in allEvent" VALUE="{{ e.AENo }}">
                                                    {{ e.AEName }}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <input type="hidden" id="ENo" name="ENo" value="{{ searchEmployee.ENo }}">
                                    <div class="col-md-1">
                                        <button type="submit" class="btn btn-default">确认</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- ./添加考勤记录 -->

                <!-- 津贴记录 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                津贴记录
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>日期</th>
                                            <th>津贴</th>
                                            <th>金额</th>
                                            <th>备注</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr ng-repeat="log in searchSubsidyLog">
                                            <td>{{ log.SLDate }}</td>
                                            <td>{{ log.SEName }}</td>
                                            <td>{{ log.SLMoney }}</td>
                                            <td>{{ log.SLComment }}</td>
                                            <td>
                                                <a class="btn btn-danger"
                                                   ng-href="/employee/deletesubsidylog/{{ searchEmployee.ENo }}
                                                            /{{ log.SLDate }}/{{ log.SENo }}/{{ log.SLMoney }}/{{ log.SLComment }}"
                                                   role="button">删除</a>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /table -->
                            </div>
                        </div> <!-- ./panel -->
                    </div>
                </div> <!-- ./row -->
                <!-- /津贴记录 -->

                <!-- 添加津贴记录 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                添加津贴
                            </div>
                            <div class="panel-body">
                                <%--<form class="form-inline">--%>
                                    <%--<div class="form-group">--%>
                                        <%--<label for="SENo">类型</label>--%>
                                        <%--&lt;%&ndash;<input type="text" class="form-control" id="SENo" name="SENo"&ndash;%&gt;--%>
                                               <%--&lt;%&ndash;placeholder="津贴类型">&ndash;%&gt;--%>
                                        <%--<select class="form-control" id="SENo" name="SENo">--%>
                                            <%--<option ng-repeat="e in allSubsidyEvent" VALUE="{{ e.SENo }}">--%>
                                                <%--{{ e.SEName }}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp--%>
                                            <%--</option>--%>
                                        <%--</select>--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group">--%>
                                        <%--<label for="SLMoney">金额</label>--%>
                                        <%--<input type="text" class="form-control" id="SLMoney" name="SLMoney"--%>
                                               <%--placeholder="金额">--%>
                                    <%--</div>--%>
                                    <%--<div class="form-group">--%>
                                        <%--<label for="SLComment">备注</label>--%>
                                        <%--<input type="text" class="form-control" id="SLComment" name="SLComment"--%>
                                               <%--placeholder="备注">--%>
                                    <%--</div>--%>
                                    <%--<button type="submit" class="btn btn-default">Send invitation</button>--%>
                                <%--</form>--%>


                                <form class="form-horizontal"
                                      action="/employee/addsubsidylog" method="post" Ectype="text/plain">
                                    <div class="form-group">
                                        <label for="SENo" class="col-md-1 control-label">类型</label>
                                        <div class="col-md-10">
                                            <select class="form-control" id="SENo" name="SENo">
                                                <option ng-repeat="e in allSubsidyEvent" VALUE="{{ e.SENo }}">
                                                    {{ e.SEName }}
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="SLMoney" class="col-md-1 control-label">金额</label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" id="SLMoney" name="SLMoney"
                                                   placeholder="金额">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="SLComment" class="col-md-1 control-label">备注</label>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" id="SLComment" name="SLComment"
                                                   placeholder="备注">
                                        </div>
                                    </div>
                                    <input type="hidden" id="ENo" name="ENo" value="{{ searchEmployee.ENo }}">
                                    <div class="col-md-1">
                                        <button type="submit" class="btn btn-default">确认</button>
                                    </div>
                                </form>
                            </div>
                        </div> <!-- ./panel -->
                    </div>
                </div> <!-- ./添加津贴记录 -->

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
        $scope.searchEmployee = JSON.parse('${searchEmployee}')[0];
        $scope.searchAttendLog = JSON.parse('${searchAttendLog}');
        $scope.searchSubsidyLog = JSON.parse('${searchSubsidyLog}');
        $scope.searchPayroll = JSON.parse('${searchPayroll}');
        $scope.allEvent = JSON.parse('${allEvent}');
        $scope.allSubsidyEvent = JSON.parse('${allSubsidyEvent}');
        $scope.rootSideBar = "active-menu";
        $scope.normalSideBar = "";
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
