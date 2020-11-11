package com.etc.managemeetings.filter;

import com.etc.managemeetings.entity.RegisterRequest;
import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllRegisterRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserService us = new UserServiceImpl();
        List<RegisterRequest> list = new ArrayList();
        try {
            list = us.AllRegisterRequest();
            if (list != null){
                for (Object rr :
                        list) {
                    System.out.println(rr.toString());
                }
                request.setAttribute("registerRequest",list);
                filterChain.doFilter(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
