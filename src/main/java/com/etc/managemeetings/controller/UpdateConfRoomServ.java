package com.etc.managemeetings.controller;

import com.etc.managemeetings.service.ConferenceRoomService;
import com.etc.managemeetings.service.Impl.ConferenceRoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateConfRoomServ",urlPatterns = "/UpdateConfRoomServ")
public class UpdateConfRoomServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldroomnumber = request.getParameter("oldroomnumber");
        String newroomnumber = request.getParameter("newroomnumber");//门牌号
        String status = request.getParameter("status");
        String description = request.getParameter("description"); //info
        String roomcapacity = request.getParameter("roomcapacity");//人数
        String capacity = request.getParameter("capacity");//会议室名称
        ConferenceRoomService crs = new ConferenceRoomServiceImpl();
        // newhouseno,  name,  peolnum,  info,  state, oldhouseno
        boolean flag = false;
        try {
            flag = crs.updateConfRoom(Integer.parseInt(newroomnumber),capacity,roomcapacity,description,Integer.parseInt(status),Integer.parseInt(oldroomnumber));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (flag){
            //更新成功！
            request.setAttribute("updateConfRoom","更新成功！");
            request.getRequestDispatcher("meetingrooms.jsp").forward(request,response);
        }else {
            //更新失败！
            request.setAttribute("updateConfRoom","更新失败！");
            request.getRequestDispatcher("meetingrooms.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
