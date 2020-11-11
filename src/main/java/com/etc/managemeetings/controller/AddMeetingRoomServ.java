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

@WebServlet(name = "AddMeetingRoomServ",urlPatterns = "/AddMeetingRoomServ")
public class AddMeetingRoomServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AddMeetingRoomServ post");
        String description = request.getParameter("description");//备注
        String roomcapacity = request.getParameter("roomcapacity");//最多容纳人数
        String capacity = request.getParameter("capacity");//会议室名称
        String roomnumber = request.getParameter("roomnumber");//门牌号
        System.out.println(description);
        //当门牌号和会议室名称同时不为空，进行插入操作
        ConferenceRoomService crs = new ConferenceRoomServiceImpl();
        int no = 0 ;
        if (roomnumber!=null && !roomnumber.equals("") && capacity!=null && !capacity.equals("")){
            try {
                no = crs.addConRoom(Integer.parseInt(roomnumber),capacity,roomcapacity,description);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (no == 1) {
            //添加会议室成功！！
            request.setAttribute("addmeetingroom","添加会议室成功！");
        }else {
            //添加会议室失败！！
            request.setAttribute("addmeetingroom","添加会议室失败！,请检查门牌号是否重复，或门牌号和会议名称为空！");
        }
        request.getRequestDispatcher("addmeetingroom.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
