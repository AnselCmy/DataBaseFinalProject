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
                <%--<div class="nav-collapse">--%>
                    <%--<ul class="nav pull-right">--%>
                        <%----%>
                        <%--<li class="">						--%>
                            <%--<a href="signup.html" class="">--%>
                                <%--Don't have an account?--%>
                            <%--</a>--%>
                            <%----%>
                        <%--</li>--%>
                        <%----%>
                        <%--<li class="">						--%>
                            <%--<a href="index.html" class="">--%>
                                <%--<i class="icon-chevron-left"></i>--%>
                                <%--Back to Homepage--%>
                            <%--</a>--%>
                            <%----%>
                        <%--</li>--%>
                    <%--</ul>--%>
                    <%----%>
                <%--</div><!--/.nav-collapse -->	--%>
            </div> <!-- /container -->
        </div> <!-- /navbar-inner -->
    </div> <!-- /navbar -->

    <div class="account-container">
        <div class="content clearfix">
            <form action="/login/check" method="post">
                <h1>登陆</h1>
                <div class="login-fields">
                    <p>{{ note }}</p>
                    <div class="field">
                        <label for="id">Username</label>
                        <input type="text" id="id" name="id" value="" placeholder="用户名" class="login username-field" />
                    </div> <!-- /id -->
                    <div class="field">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" value="" placeholder="密码" class="login password-field"/>
                    </div> <!-- /password -->
                </div> <!-- /login-fields -->
                <div class="login-actions">
                    <%--<span class="login-checkbox">--%>
                        <%--<input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" />--%>
                        <%--<label class="choice" for="Field">Keep me signed in</label>--%>
                    <%--</span>--%>
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
