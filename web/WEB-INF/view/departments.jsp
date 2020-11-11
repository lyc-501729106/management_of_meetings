<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
          <meta charset = "utf-8"/>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
        <script>
            function disable(denum){
                alert(denum)
                // $('#'+'dd'+denum).datebox('disable');
                // $('#dd').datebox('disable');
                $('#ddc').textbox('disable');
            }
            function enable(denum){
                alert(denum)
                $('#dd').datebox('enable');
            }
        </script>
    </head>
    <body>
        <jsp:include page="top.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="left.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <form>
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" id="departmentname" name="departmentname" maxlength="20"/>
                        <input type="submit" class="clickbutton" value="添加" onclick="action='AddDepartmentServlet';method='POST';submit();"/>
                        ${addDepartmentOK}
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="Department" items="${Department}">
                        <tr>
                            <td>${Department.key}</td> <%--此为部门唯一标识 --%>
                            <td><input id="dd${Department.key}"  value="${Department.value}"/></td>
                            <td>
                                <a class="clickbutton" href="#">编辑</a>
                                <a class="clickbutton" href="#" onclick="window.location.href='DelDepartmentServ?name=${Department.value}';">删除</a>
<%--                                <a class="clickbutton" href="#" onclick="enable(${Department.key})">编辑</a>--%>
                                <a class="clickbutton" href="#" onclick="disable(${Department.key})">取消</a>
                            </td>
                        </tr>
                    </c:forEach>


                    <tr>
                        <td>n</td>
                        <td>
                            <input  id="ddc" class="easyui-datebox" value="销售部" style=""/>
                        </td>
                        <td>
                            <a class="clickbutton" href="#" onclick="enable()">编辑</a>
                            <a class="clickbutton" href="#" onclick="disable()">取消</a>
                            <a class="clickbutton" href="#">删除</a>
                        </td>
                    </tr>

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