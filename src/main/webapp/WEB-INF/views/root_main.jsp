<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/1/4
  Time: 下午8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>工资管理系统</title>
    <link rel="stylesheet" href="/lib/bootstrap-3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/lib/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="/lib/angular-1.6.8/angular.min.js"></script>
    <script src="/lib/jquery-3.2.1.min.js"></script>
    <script src="/lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid">
    <div ng-app="payroll_app" ng-controller="payroll_controller">
        <!-- navigation bar-->
        <div class="row">
            <nav class="navbar navbar-default navbar-fixed-top">
                <!-- 用户姓名和登陆 -->
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav pull-right">
                        <li>
                            <a>
                                {{ currUserId }}
                            </a>
                        </li>
                        <li>
                            <a href="/logout/">
                                <span><i class="fa fa-sign-out" aria-hidden="true"></i></span>
                                登出
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <br><br><br>
        <h1>root</h1>
    </div>
</div>

<script>
    var app = angular.module("payroll_app", []);
    app.controller("payroll_controller", function($scope){
        $scope.currUserId = "${currUserId}";
    });
</script>

</body>
</html>
