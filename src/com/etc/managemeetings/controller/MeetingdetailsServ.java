package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.Meeting;
import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.MeetingServiceImpl;
import com.etc.managemeetings.service.MeetingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MeetingdetailsServ",urlPatterns = "/MeetingdetailsServ")
public class MeetingdetailsServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meetingname = request.getParameter("meetingname");
        System.out.println(meetingname);
        MeetingService ms = new MeetingServiceImpl();
        List list = null;
        try {
           list =  ms.meetingdetail(meetingname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Meeting meeting = (Meeting) list.get(0);
        System.out.println(meeting);
        User user = null;
        List<User> userList = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            user = (User) list.get(i);
            userList.add(user);
            System.out.println(userList);
        }
        request.setAttribute("meeting",meeting);
        request.setAttribute("users",userList);
        request.getRequestDispatcher("meetingdetails.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
