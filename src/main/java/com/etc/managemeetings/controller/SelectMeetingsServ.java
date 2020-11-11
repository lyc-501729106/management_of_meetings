package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.Meeting;
import com.etc.managemeetings.service.Impl.MeetingServiceImpl;
import com.etc.managemeetings.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SelectMeetingsServ",urlPatterns = "/SelectMeetingsServ")
public class SelectMeetingsServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SelectMeetingsServ post 方法");
        String meetingname = request.getParameter("meetingname");
        String roomname = request.getParameter("roomname");
        String reservername = request.getParameter("reservername");
        String reservefromdate = request.getParameter("reservefromdate");
        String reservetodate = request.getParameter("reservetodate");
        String meetingfromdate = request.getParameter("meetingfromdate");
        String meetingtodate = request.getParameter("meetingtodate");
        MeetingService ms = new MeetingServiceImpl();
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date createdate =  sdf.parse(reservefromdate);
        Date stopdate = sdf.parse(reservetodate);
        Date startdate = sdf.parse(meetingfromdate);
        Date enddate = sdf.parse(meetingtodate);*/
        List<Meeting> meetingList = null ;
        try {
            meetingList = ms.selectMeeting(meetingname,roomname,reservername,reservefromdate,reservetodate,meetingfromdate,meetingtodate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Meeting m :
                meetingList) {
            System.out.println(m.toString());
        }
        request.setAttribute("meetings",meetingList);
        request.getRequestDispatcher("searchmeetings.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
