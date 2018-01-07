<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>工资管理系统</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <link href="/lib/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/lib/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
    <link href="/lib/css/font-awesome.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    <link href="/lib/css/style.css" rel="stylesheet" type="text/css">
    <link href="/lib/css/pages/signin.css" rel="stylesheet" type="text/css">

</head>

<body>
<div ng-app="payroll_app" ng-controller="payroll_controller">
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="index.html">
                    工资管理系统
                </a>
            </div> <!-- /container -->
        </div> <!-- /navbar-inner -->
    </div> <!-- /navbar -->

    <div class="account-container">
        <div class="content clearfix">
            <form action="/setting/password" method="post">
                <h1>登陆</h1>
                <div class="login-fields">
                    <p>{{ note }}</p>
                    <div class="field">
                        <label for="password">Username</label>
                        <input type="password" id="password" name="password" value="" placeholder="新密码" class="login username-field" />
                    </div> <!-- /id -->
                    <div class="field">
                        <label for="rpassword">Password:</label>
                        <input type="password" id="rpassword" name="rpassword" value="" placeholder="重复新密码" class="login password-field"/>
                    </div> <!-- /password -->
                </div> <!-- /login-fields -->
                <input type="hidden" id="ENo" name="ENo" value="{{ currEmployee.ENo }}">
                <div class="login-actions">
                    <button type="submit" class="button btn btn-success btn-large">确认</button>
                </div> <!-- .actions -->
            </form>
        </div> <!-- /content -->
    </div> <!-- /account-container -->
</div> <!-- /angular-js -->

<script src="/lib/js/jquery-1.7.2.min.js"></script>
<script src="/lib/js/bootstrap.js"></script>
<script src="/lib/js/signin.js"></script>
<script src="/lib/angular-1.6.8/angular.min.js"></script>
<script>
    var app = angular.module("payroll_app", []);
    app.controller("payroll_controller", function($scope){
        $scope.currEmployee = JSON.parse('${currEmployee}')[0];
    });
</script>


</body>

</html>
