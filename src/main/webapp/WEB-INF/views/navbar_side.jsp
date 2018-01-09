<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2018/1/7
  Time: 上午11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">

            <li>
                <a class="{{ mngSideBar }}" href="/main"><i class="fa fa-dashboard"></i> 管理面板</a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/main#payrollLog">搜素员工</a>
                    </li>
                    <li>
                        <a href="/main#attendLog">所有员工</a>
                    </li>
                </ul>
            </li>

            <li>
                <a class="{{ depSideBar }}" href="/main/dep"><i class="fa fa-table"></i> 部门数据统计</a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/main/dep#">全年工资统计</a>
                    </li>
                    <li>
                        <a href="/main/dep#">按月工资统计</a>
                    </li>
                </ul>
            </li>

            <li>
                <a class="{{ idvSideBar }}" href="/main/idv"><i class="fa fa-desktop"></i> 个人面板</a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/main/idv#payrollLog">工资记录</a>
                    </li>
                    <li>
                        <a href="/main/idv#attendLog">考勤记录</a>
                    </li>
                    <li>
                        <a href="/main/idv#subsidyLog">津贴记录</a>
                    </li>
                </ul>
            </li>

            <%--<li>--%>
                <%--<a href="ui-elements.html"><i class="fa fa-desktop"></i> UI Elements</a>--%>
            <%--</li>--%>

            <%--<li>--%>
                <%--<a href="#"><i class="fa fa-sitemap"></i> Charts<span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li>--%>
                        <%--<a href="chart.html">Charts JS</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="morris-chart.html">Morris Chart</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>

            <%--<li>--%>
                <%--<a href="tab-panel.html"><i class="fa fa-qrcode"></i> Tabs & Panels</a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="form.html"><i class="fa fa-edit"></i> Forms </a>--%>
            <%--</li>--%>


            <%--<li>--%>
                <%--<a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>--%>
                <%--<ul class="nav nav-second-level">--%>
                    <%--<li>--%>
                        <%--<a href="#">Second Level Link</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">Second Level Link</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                        <%--<a href="#">Second Level Link<span class="fa arrow"></span></a>--%>
                        <%--<ul class="nav nav-third-level">--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Link</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Link</a>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<a href="#">Third Level Link</a>--%>
                            <%--</li>--%>

                        <%--</ul>--%>

                    <%--</li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>--%>
            <%--</li>--%>
        </ul>

    </div>

</nav>
<!-- /. NAV SIDE  -->