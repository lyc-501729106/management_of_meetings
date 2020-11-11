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
        <script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
    </head>
    <body>
        <div class="page-header">
            <jsp:include page="top.jsp"></jsp:include>
        </div>
        <div class="page-body">
            <jsp:include page="left.jsp"></jsp:include>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索会议     <span style="color: #2e29ff">${bookmeetingok}</span>
                </div>
                <form>
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="meetingname" name="meetingname" maxlength="20"/>
                                </td>
                                <td>会议室名称：</td>
                                <td>
                                    <input type="text" id="roomname" name="roomname" maxlength="20"/>
                                </td>
                                <td>预定者姓名：</td>
                                <td>
                                    <input type="text" id="reservername" name="reservername" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预定日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" id="reservefromdate" name="reservefromdate" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" id="reservetodate" name="reservetodate" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" id="meetingfromdate" name="meetingfromdate" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" id="meetingtodate" name="meetingtodate" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="button" class="clickbutton" value="查询" onclick="action='SelectMeetingsServ';method='POST';submit();"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">54</span>条结果，
                            分成<span class="info-number">6</span>页显示，
                            当前第<span class="info-number">1</span>页
                        </div>
                        <div class="header-nav">
                            <input type="button" class="clickbutton" value="首页"/>
                            <input type="button" class="clickbutton" value="上页"/>
                            <input type="button" class="clickbutton" value="下页"/>
                            <input type="button" class="clickbutton" value="末页"/>
                            跳到第<input type="text" id="pagenum" class="nav-number"/>页
                            <input type="button" class="clickbutton" value="跳转"/>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${meetings}" var="meeting">
                        <tr>
                            <td>${meeting.meetingName}</td>
                            <td>${meeting.conferenceRoom.name}</td>
                            <td>${meeting.startTime}</td>
                            <td>${meeting.endtime}</td>
                            <td>${meeting.createtime}</td>
                            <td>${meeting.user.name}</td>
                            <td>
                                <a class="clickbutton" href="MeetingdetailsServ?meetingname=${meeting.meetingName}">查看详情</a>
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