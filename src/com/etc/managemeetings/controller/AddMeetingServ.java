package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.MeetingServiceImpl;
import com.etc.managemeetings.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddMeetingServ",urlPatterns = "/AddMeetingServ")
public class AddMeetingServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddMeetingServ post 方法");
        String meetingname = request.getParameter("meetingname"); //会议名称
        String numofattendents = request.getParameter("numofattendents");//预计参加人数
        String startdate = request.getParameter("startdate");//开始日期
        String enddate = request.getParameter("enddate");
        String endtime = request.getParameter("endtime");
        String starttime = request.getParameter("starttime");//开始时间
        System.out.println("date and time : " + startdate+" "+starttime);
        String startdateandtime = startdate+" "+starttime ;
        String enddateandtime = enddate + " " + endtime;
        String roomid   = request.getParameter("roomid");//会议室名称id
        String description = request.getParameter("description");//会议说明
        String[]  selSelectedEmployees = request.getParameterValues("selSelectedEmployees");
        if (meetingname != null && !meetingname.equals("")
                && numofattendents != null && !numofattendents.equals("")
                && startdate != null && !startdate.equals("")
                && starttime != null && !starttime.equals("")
                && endtime != null && !endtime.equals("")
                && enddate != null && !enddate.equals("")
                && roomid != null && !roomid.equals("")
                && description != null && !description.equals("")
                && selSelectedEmployees != null && !selSelectedEmployees.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date startdateutil = new Date() ;
            Date enddateutil = new Date();
            try {
                 startdateutil = sdf.parse(startdateandtime) ;
                 enddateutil = sdf.parse(enddateandtime) ;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int no = 0;
            for (String account :
                    selSelectedEmployees) {
                System.out.println(account);//所选员工的account
                MeetingService ms = new MeetingServiceImpl();
                try {
                    HttpSession session = request.getSession();
                    User user = (User) session.getAttribute("user");
                    no = ms.addMeetings(Integer.parseInt(roomid),account,meetingname,Integer.parseInt(numofattendents),startdateutil,enddateutil,description,user.getAccount());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (no ==1) request.setAttribute("bookmeetingok","会议预订成功");
            else request.setAttribute("bookmeetingok","会议预订失败！请检查您的预订时间点，是否有人占用会议室！");
            request.getRequestDispatcher("searchmeetings.jsp").forward(request,response);
        } else {
            System.out.println("您提交的表单中有空值！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
