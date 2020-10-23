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

@WebServlet(name = "UpdateUserStateServ",urlPatterns = "/UpdateUserStateServ")
public class UpdateUserStateServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateUserStateServ get");
        String account = request.getParameter("account");
        String state1 = request.getParameter("state");
        int state = Integer.parseInt(state1);//状态
        System.out.println(account);
        System.out.println(state);
        UserService us = new UserServiceImpl();
        if (state == 1){ //为1 表示开启，关闭账号
            try {
                us.closeUser(account);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("closeUser","账号关闭成功!");
            request.getRequestDispatcher("searchemployees.jsp").forward(request,response);
        }else { //不为1 表示关闭，则开启账号
            try {
                us.openUser(account);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("openUser","账号启用成功!");
            request.getRequestDispatcher("searchemployees.jsp").forward(request,response);
        }
    }
}
