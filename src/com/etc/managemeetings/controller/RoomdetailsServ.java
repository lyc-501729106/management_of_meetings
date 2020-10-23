package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.ConferenceRoom;
import com.etc.managemeetings.service.ConferenceRoomService;
import com.etc.managemeetings.service.Impl.ConferenceRoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RoomdetailsServ",urlPatterns = "/RoomdetailsServ")
public class RoomdetailsServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RoomdetailsServ get");
        String houseNo = request.getParameter("houseNo");
        System.out.println(houseNo);
        ConferenceRoomService crs = new ConferenceRoomServiceImpl();
        try {
           ConferenceRoom conferenceRoom =  crs.oneConfRoom(Integer.parseInt(houseNo));
           request.setAttribute("conferenceRoom",conferenceRoom);
           request.getRequestDispatcher("roomdetails.jsp").forward(request,response);
            System.out.println(conferenceRoom);
        } catch (SQLException e) {
            e.printStackTrace();
        }//电源，机箱，固态盘
    }
}
