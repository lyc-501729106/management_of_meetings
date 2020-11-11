package com.etc.managemeetings.filter;

import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllUsersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserService us = new UserServiceImpl();
        try {
            List<User> userList = us.allUsers();
            request.setAttribute("users",userList);
            System.out.println(userList);
            filterChain.doFilter(request,response); //放行
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
