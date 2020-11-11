<%--
  Created by IntelliJ IDEA.
  User: 译辰哥哥
  Date: 2020/10/12
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="notifications.jsp">最新通知</a></li>
            <li class="sidebar-menuitem active"><a href="mybookings.jsp">我的预定</a></li>
            <li class="sidebar-menuitem"><a href="mymeetings.jsp">我的会议</a></li>
        </ul>
    </div>
        <c:if test="${user.name=='admin'}">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">人员管理</div>
        <ul class="sidebar-menu">
<%--            <li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>--%>

            <li class="sidebar-menuitem"><a href="departments.jsp">部门管理</a></li>
            <li class="sidebar-menuitem"><a href="approveaccount.jsp">注册审批</a></li>
            <li class="sidebar-menuitem"><a href="searchemployees.jsp">搜索员工</a></li>
        </ul>
    </div>
        </c:if>
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">会议预定</div>
        <ul class="sidebar-menu">
            <c:if test="${user.name == 'admin'}">
            <li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
            </c:if>
            <li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>

            <li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>

            <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
        </ul>
    </div>
</div>
</body>
</html>
