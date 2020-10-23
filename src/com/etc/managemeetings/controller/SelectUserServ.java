package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SelectUserServ",urlPatterns = "/SelectUserServ")
public class SelectUserServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SelectUserServ post");
        String employeename = request.getParameter("employeename");
        String accountname = request.getParameter("accountname");
        String status = request.getParameter("status");
        int state = Integer.parseInt(status);
        System.out.println(employeename);
        System.out.println(accountname);
        System.out.println(state); //注意当status == 0 的时候，查询另一张表
        UserService us = new UserServiceImpl();
        List<User> userList = new ArrayList<>();
            try {
                userList = us.selectUsers(employeename,accountname,state);
                System.out.println(userList.toString());
                request.setAttribute("users",userList);
                request.getRequestDispatcher("searchemployees.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
