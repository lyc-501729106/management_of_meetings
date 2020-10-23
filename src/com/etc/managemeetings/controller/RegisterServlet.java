package com.etc.managemeetings.controller;

import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegisterServlet get ");
        String employeename = request.getParameter("employeename");
        String accountname = request.getParameter("accountname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String deptid = request.getParameter("deptid");
        System.out.println(deptid);
        UserService us = new UserServiceImpl();
        try {
            boolean flag = us.register_request(Integer.parseInt(deptid),accountname,password,employeename,email,phone);
            if (flag){
                request.setAttribute("msg","申请已提交，等待管理员处理！");
                request.getRequestDispatcher("login.jsp").forward(request,response); //申请成功 跳到登录页
            }else {
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
