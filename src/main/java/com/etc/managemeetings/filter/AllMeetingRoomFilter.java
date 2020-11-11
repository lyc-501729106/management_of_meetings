package com.etc.managemeetings.filter;

import com.etc.managemeetings.entity.ConferenceRoom;
import com.etc.managemeetings.service.ConferenceRoomService;
import com.etc.managemeetings.service.Impl.ConferenceRoomServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllMeetingRoomFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ConferenceRoomService crs = new ConferenceRoomServiceImpl();
        try {
            List<ConferenceRoom> conferenceRoomList = crs.allConfRoom();
            if (conferenceRoomList != null){
                System.out.println(conferenceRoomList);
                request.setAttribute("conferenceRooms",conferenceRoomList);
                filterChain.doFilter(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
