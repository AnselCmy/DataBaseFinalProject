<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/1/9
  Time: 上午1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 工资记录 -->
<a href="#payrollLog"></a>
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

<a href="#attendLog"></a>
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
            </div>
        </div> <!-- ./panel -->
    </div>
</div> <!-- ./row -->
<!-- /考勤记录 -->


<a href="#subsidyLog"></a>
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
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="log in searchSubsidyLog">
                            <td>{{ log.SLDate }}</td>
                            <td>{{ log.SEName }}</td>
                            <td>{{ log.SLMoney }}</td>
                            <td>{{ log.SLComment }}</td>
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