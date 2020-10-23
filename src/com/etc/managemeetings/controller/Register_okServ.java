package com.etc.managemeetings.controller;

import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register_okServ",urlPatterns = "/Register_okServ")
public class Register_okServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Register_okServ post");
        String account = request.getParameter("account");
        System.out.println(account);
        UserService us = new UserServiceImpl();
        try {
            us.register_ok(account);
            request.setAttribute("register_ok","已通过！");
            request.getRequestDispatcher("approveaccount.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Register_okServ get");

    }
}
