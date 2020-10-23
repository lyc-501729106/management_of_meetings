package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "PwdjiaoyanServlet",urlPatterns = "/PwdjiaoyanServlet")
public class PwdjiaoyanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String origin = request.getParameter("origin");
        UserService us = new UserServiceImpl();
        try {
            boolean flag = us.updatepwdjiaoyan(account,origin);
            System.out.println(flag);
            PrintWriter out = response.getWriter();
            if (flag) out.print(1); //原密码校验正确
            else out.print(0); //源密码错误
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String newpwd = request.getParameter("confirm");
        System.out.println(user.getAccount());
        //更改密码
        UserService us = new UserServiceImpl();
        int no = 0;
        try {
            no = us.updatepwd(user.getAccount(),newpwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (no ==1) {
            request.setAttribute("msg1","修改密码成功");
            request.getRequestDispatcher("mymeetings.jsp").forward(request,response);
        }
        else request.getRequestDispatcher("login.jsp").forward(request,response);

    }
}
