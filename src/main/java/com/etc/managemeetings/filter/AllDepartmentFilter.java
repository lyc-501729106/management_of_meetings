package com.etc.managemeetings.filter;

import com.etc.managemeetings.service.Impl.UserServiceImpl;
import com.etc.managemeetings.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AllDepartmentFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserService us = new UserServiceImpl();
        try {
            Map<Integer,String> mapList = us.getAllDepartment();
            Set<Integer> set = mapList.keySet();
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()){
                Integer key =  it.next();
                System.out.println(key + " " +mapList.get(key));
            }
            request.setAttribute("Department",mapList);
            filterChain.doFilter(request,response);//放行！！
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
