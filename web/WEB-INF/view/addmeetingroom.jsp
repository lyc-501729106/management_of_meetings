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
        <script type="text/javascript">
            function meetingroom() {
                // alert("aa")
                var roomnumber = $('#roomnumber');
                var roomnumberspan = $('#roomnumberspan');
                $.ajax({
                    type: "POST",
                    url: "RoomnumberServ",
                    data: "roomnumber=" + roomnumber.val(),
                    success: function(msg){
                        // alert( "Data Saved: " + msg );
                        if (msg == 1) roomnumberspan.html('已有人使用此房间，请换个')
                        else if (msg == 0) roomnumberspan.html('此房间没人预订，你可以使用')
                        else roomnumberspan.html('房间号不能为空！')
                    }
                });
            }
        </script>
    </head>
    <body>
        <jsp:include page="top.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="left.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 添加会议室
                </div>
                <form>
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input id="roomnumber" name="roomnumber" class="easyui-numberbox" type="text" placeholder="例如：201" maxlength="10" onblur="meetingroom()"/>
                                    <span id="roomnumberspan" style="color: #2e29ff"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input id="capacity" name="capacity" type="text" placeholder="例如：第一会议室" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input id="roomcapacity" class="easyui-numberbox" name="roomcapacity" type="text" placeholder="填写一个正整数"/>
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea id="description" name="description" maxlength="200" rows="5" cols="60" placeholder="200字以内的文字描述"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="添加" class="clickbutton" onclick="action='AddMeetingRoomServ';method='post';submit();"/>
                                    <input type="reset" value="重置" class="clickbutton"/>
                                    <span style="color: brown">${addmeetingroom}</span>
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