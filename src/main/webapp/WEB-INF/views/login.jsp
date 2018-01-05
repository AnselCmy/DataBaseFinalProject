<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/1/4
  Time: 下午8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>工资管理系统</title>
    <link rel="stylesheet" href="/lib/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="/lib/angular-1.6.8/angular.min.js"></script>
    <script src="/lib/jquery-3.2.1.min.js"></script>
    <script src="/lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, Noto Sans CJK SC, WenQuanYi Micro Hei, Arial, sans-serif;
            font-size: 15px;
            color: #262626;
            background: #f7f8fa;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
        }
        .login-header {
            font-size: 150%;
            margin-bottom: 20px;
        }
        .login {
            margin-bottom: 10px;
            background: #FFFFFF;
            border: 1px solid #e7eaf1;
            border-radius: 2px;
            box-shadow: 0 1px 3px rgba(0,37,55,.05);
            box-sizing: border-box;
            line-height: 2;
            margin-top: 20px;
            padding: 5px 5px;
        }
        .login-header a:link{
            text-decoration:none;
            color: gray;
            /*background-color: #ffffff;*/
        }
        .login-header a:visited {
            color: gray;
            /*background-color: #ffffff;*/
        }
        .login-header a:hover {
            text-decoration:none;
            /*background-color: #fafafa;*/
            color: gray;
        }
        .login-header a.active {
            color: #0090ef;
        }
    </style>
</head>

<body>

<div class="container-fluid">
    <div ng-app="payroll_app" ng-controller="payroll_controller">
        <div class="col-md-4 col-md-offset-4 login">
            <div class="row login-header">
                <div class="col-md-offset-4 col-md-6">
                    <a>工资管理系统</a>
                </div>
            </div>
            <form class="form-horizontal" action="/login/check" method="post">
                <!-- Username -->
                <div class="form-group">
                    <label for="id" class="col-md-3 control-label">工号</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" id="id" name="id" placeholder="">
                    </div>
                </div>
                <!-- Password -->
                <div class="form-group">
                    <label for="password" class="col-md-3 control-label">密码</label>
                    <div class="col-md-7">
                        <input type="password" class="form-control" id="password" name="password" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-3 col-md-2">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                    <div class="col-md-7">
                        <h5>{{ note }}</h5>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    var app = angular.module("payroll_app", []);
    app.controller("payroll_controller", function($scope){
        $scope.state = "${state}";
        if($scope.state === "redirect") {
            $scope.note = "用户不存在或密码错误！";
        }
        else {
            $scope.note = "";
        }
    });
</script>

</body>
</html>
