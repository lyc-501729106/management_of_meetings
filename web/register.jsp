<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
          <meta charset = "utf-8"/>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="./js/jquery.min.js"></script>
        <style type="text/css">
            
        </style>
        <script type="text/javascript">
            function accountnamejiaoyan() {
                var msgSpan = document.getElementById("msgSpan");
                var accountname = document.getElementById("accountname");
                //jquery异步提交
                $.ajax({
                    type: "POST",
                    url: "LoginServlet",
                    data: "accountname=" + accountname.value,
                    success: function (msg) {
                        if (msg == 1) {
                            msgSpan.innerHTML = "该用户名已经被使用...";
                        } else if (msg == 0) {
                            msgSpan.innerHTML = "可以使用此用户名...";
                        } else {
                            msgSpan.innerHTML = "请输入...";
                        }
                    }
                });
            }
            function emailjiaoyan() {
                var email = document.getElementById("email");
                var emailspan = document.getElementById("emailspan");
                var pattern = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/ ;
                console.log(pattern.test(email.value));
                if (!pattern.test(email.value)) {
                    emailspan.innerHTML = 'email地址格式错误！';
                    email.value = '';
                }else {
                    emailspan.innerHTML = '';
                }
            }
            function phonejiaoyan() {
                var phone = document.getElementById("phone");
                var phonespan = document.getElementById("phonespan");
                var pattern = /0?(13|14|15|18|17)[0-9]{9}/ ;
                if (!pattern.test(phone.value)){
                    phonespan.innerHTML = '电话号码格式错误！' ;
                    phone.value = '';
                }else {
                    phonespan.innerHTML = '' ;
                }
            }
            function passwordjiaoyan() {
                // alert("adsf")
                var password = document.getElementById("password");
                var confirm = document.getElementById("confirm");
                var confirmspan = document.getElementById("confirmspan");
                // console.log(password.test(confirm.value));
                if (password.value != confirm.value){
                    confirmspan.innerHTML = '密码输入不一致' ;
                    confirm.value = '';
                    password.value = '';
                }else {
                    confirmspan.innerHTML = '' ;
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="top.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="left.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 员工注册
                </div>
                <form>
                    <fieldset>
                        <legend>员工信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" id="employeename" name="employeename" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>账户名：</td>
                                <td>
                                    <input type="text" id="accountname" name="accountname" maxlength="20" onkeyup="accountnamejiaoyan()"/><span id="msgSpan" style="color: brown;"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>密码：</td>
                                <td>
                                    <input type="password" id="password" name="password" maxlength="20" placeholder="请输入6位以上的密码"/>
                                </td>
                            </tr>
                            <tr>
                                <td>确认密码：</td>
                                <td>
                                    <input type="password" id="confirm"  maxlength="20" onblur="passwordjiaoyan()"/> <span id="confirmspan" style="color: #7b42a5;"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>联系电话：</td>
                                <td>
                                    <input type="text" id="phone" name="phone" maxlength="20" onblur="phonejiaoyan()"/> <span id="phonespan" style="color: #7b42a5;"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>电子邮件：</td>
                                <td>
                                    <input type="text" id="email" name="email" maxlength="20" onblur="emailjiaoyan()"/> <span id="emailspan" style="color: #7b42a5;"></span>
                                </td>
                            </tr>
                            <td>所在部门：</td>
                            <td>
                                <select name="deptid">
                                    <c:forEach var="Department" items="${Department}">
                                        <option value="${Department.key}">${Department.value}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="注册" onclick="action='RegisterServlet';method='get';submit();"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>