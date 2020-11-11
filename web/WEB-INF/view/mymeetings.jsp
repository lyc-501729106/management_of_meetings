<%@page contentType="text/html;charset=UTF-8" language="java" %>
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
                    个人中心 > 我的会议  ${msg1}
                </div>
                <table class="listtable">
                    <caption>我将参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${mymeetings}" var="mymeeting">
                        <tr>
                            <td>${mymeeting.meetingName}</td>
                            <td>${mymeeting.conferenceRoom.name}</td>
                            <td>${mymeeting.startTime}</td>
                            <td>${mymeeting.endtime}</td>
                            <td>${mymeeting.createtime}</td>
                            <td>${mymeeting.create_peo}</td>
                            <td>
                                <a class="clickbutton" href="MeetingdetailsServ?meetingname=${mymeeting.meetingName}">查看详情</a>
                            </td>
                        </tr>
                    </c:forEach>
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