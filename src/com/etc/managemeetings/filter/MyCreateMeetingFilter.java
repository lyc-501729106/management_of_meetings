package com.etc.managemeetings.filter;

import com.etc.managemeetings.entity.Meeting;
import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.Impl.MeetingServiceImpl;
import com.etc.managemeetings.service.MeetingService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MyCreateMeetingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyCreateMeetingFilter doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        MeetingService ms = new MeetingServiceImpl();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            List<Meeting> meetingList = ms.mybookings(user.getAccount());
            for (Meeting m :
                    meetingList) {
                System.out.println(m.getCreate_peo());
            }
            request.setAttribute("mybookings",meetingList);
            filterChain.doFilter(request,response); //放行
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
