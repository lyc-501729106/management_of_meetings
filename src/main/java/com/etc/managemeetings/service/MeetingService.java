package com.etc.managemeetings.service;

import com.etc.managemeetings.entity.Meeting;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface MeetingService {
    //预订一个会议
    int addMeetings (int houseno, String account, String name, int peopleno, Date starttime,Date endtime,String meetinginfo,String user) throws SQLException;
    //条件查询会议
    List<Meeting> selectMeeting(String meetingname ,String meetingroomname, String peoname,String createdate,String stopdate,String startdate,String enddate ) throws SQLException;
    //会议详情
    List meetingdetail(String meetingname) throws SQLException;
    //mymeetings
    List<Meeting> mymeetings (String mymeetings) throws SQLException;
//我的预订
    List<Meeting> mybookings(String account) throws SQLException;
}
