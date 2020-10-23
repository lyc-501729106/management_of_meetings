<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
          <meta charset = "utf-8"/>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body>
        <jsp:include page="top.jsp"></jsp:include>
        <div class="page-body">
            <jsp:include page="left.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 查看会议室
                </div>
                <table class="listtable">
                    <caption>所有会议室:</caption>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${conferenceRooms}" var="meetingRoom">
                        <tr>
                            <td>${meetingRoom.houseNo}</td>
                            <td>${meetingRoom.name}</td>
                            <td>${meetingRoom.peopleNumber}</td>
                            <td><c:if test="${meetingRoom.state == '1'}">启用</c:if><c:if test="${meetingRoom.state =='0'}">停用</c:if> <c:if test="${meetingRoom.state =='-1'}">删除</c:if></td>
                            <td>
                                <a class="clickbutton" href="RoomdetailsServ?houseNo=${meetingRoom.houseNo}">查看详情</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                ${updateConfRoom}
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>