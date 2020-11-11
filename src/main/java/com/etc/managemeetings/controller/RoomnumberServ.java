package com.etc.managemeetings.controller;

import com.etc.managemeetings.service.ConferenceRoomService;
import com.etc.managemeetings.service.Impl.ConferenceRoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RoomnumberServ",urlPatterns = "/RoomnumberServ")
public class RoomnumberServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RoomnumberServ post");
        String roomnumber = request.getParameter("roomnumber");
        PrintWriter out = response.getWriter();
        if (roomnumber!=null && !roomnumber.equals("")) {
            System.out.println(roomnumber);
            ConferenceRoomService crs = new ConferenceRoomServiceImpl();
            boolean flag = false;

            try {
                flag = crs.houseNo(roomnumber);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (flag) out.print(1);
            else out.print(0);
        }else {
            out.print(-1);
            System.out.println("输入了空值！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
