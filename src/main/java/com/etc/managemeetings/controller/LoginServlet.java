package com.etc.managemeetings.controller;

import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;
import com.etc.managemeetings.util.Code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountname = request.getParameter("accountname");
        System.out.println(accountname);
        UserService us = new UserServiceImpl();
        PrintWriter out = response.getWriter();
        if (accountname != null && !accountname.equals("")) {
            boolean flag = false;
            try {
                 flag = us.accountname(accountname);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (flag) out.print(1);
            else out.print(0);
        } else {
            out.print(-1);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doGet 方法");
        String accountname = request.getParameter("accountname");
        String pwd = request.getParameter("new");
        UserService us = new UserServiceImpl();
        User user = new User();
        user.setAccount(accountname);
        user.setPwd(pwd);
        User user1 = null;
        try {
           user1 = us.login(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user1 != null && user1.getState() == 1){
            HttpSession session = request.getSession();
            session.setAttribute("user",user1);
            request.getRequestDispatcher("mymeetings.jsp").forward(request,response);
        }else {
            request.setAttribute("msg2","登录失败！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
