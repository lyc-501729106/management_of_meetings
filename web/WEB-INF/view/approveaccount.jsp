<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
           <meta charset = "utf-8"/>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <jsp:include page="top.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="left.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册审批
                </div>
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption> <span style="color: #2e29ff">${register_ok}${register_del}</span>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <form>
                    <c:forEach items="${registerRequest}" var="r">
                    <tr>
                        <td>${r.name}</td>
                        <td>${r.account}</td>
                        <td>${r.phone}</td>
                        <td>${r.email}</td>
                        <td>
                            <input type="button" class="clickbutton" value="通过" onclick="action='Register_okServ?account=${r.account}';method='POST';submit();"/>
                            <input type="button" class="clickbutton" value="删除" onclick="action='DelRegister_okServ?account=${r.account}';method='POST';submit();"/>
                        </td>
                    </tr>
                    </c:forEach>
                    </form>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>