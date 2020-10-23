<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
          <meta charset = "utf-8"/>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <script type="text/javascript" src="./js/jquery.min.js"></script>
        <script type="text/javascript">
            function oldpasswordjiaoyan(account) {
                var origin = $("#origin").val();
                var originspan = $("#originspan");
                // var originspan = document.getElementById("originspan");
                $.ajax({
                    type: "POST",
                    url: "PwdjiaoyanServlet",
                    data: "origin="+ origin + "&account=" + account ,
                    success: function(msg){
                        if (msg == 0) {
                            originspan.html('原密码不正确')
                        }else {
                            originspan.html('')
                        }
                    }
                });
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
                    修改密码
                </div>
                <form>
                    <fieldset>
                        <legend>修改密码信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>原密码:</td>
                                <td>
                                    <input id="origin" name="origin" type="password" onblur="oldpasswordjiaoyan(${user.account})"/> <span id="originspan"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>新密码:</td>
                                <td>
                                    <input id="password" name="new" type="password" />
                                </td>
                            </tr>
                            <tr>
                                <td>确认新密码：</td>
                                <td>
                                    <input id="confirm" name="confirm" type="password" onblur="passwordjiaoyan()"/> <span id="confirmspan"></span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="确认修改" class="clickbutton" onclick="action='PwdjiaoyanServlet';method='GET';submit();"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
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