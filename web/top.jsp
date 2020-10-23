<%--
  Created by IntelliJ IDEA.
  User: 译辰哥哥
  Date: 2020/10/10
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="page-header">
        <div class="header-banner">
            <img src="images/header.png" alt="CoolMeeting"/>
        </div>
        <div class="header-title">
            欢迎访问Cool-Meeting会议管理系统
        </div>
        <div class="header-quicklink">
            欢迎您，<strong>${user.name}</strong>
            <c:if test="${user != null}">
            <a href="changepassword.jsp">[修改密码]</a>
            </c:if>
            <c:if test="${user == null}">
                <a href="register.jsp">注册</a>
            </c:if>
            <c:if test="${user != null}">
                <a href="ExitLoginServlet">注销</a>
            </c:if>
        </div>
    </div>
</body>
</html>
