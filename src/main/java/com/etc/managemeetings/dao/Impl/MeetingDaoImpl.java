package com.etc.managemeetings.dao.Impl;

import com.etc.managemeetings.dao.MeetingDao;
import com.etc.managemeetings.entity.ConferenceRoom;
import com.etc.managemeetings.entity.Meeting;
import com.etc.managemeetings.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingDaoImpl extends BaseDaoImpl implements MeetingDao {
    /**
     * 预订会议
     * @param houseno
     * @param account
     * @param name
     * @param peopleno
     * @param starttime
     * @param endtime
     * @param meetinginfo
     */
    @Override
    public int addMeetings(int houseno, String account, String name, int peopleno, Date starttime, Date endtime, String meetinginfo,String user) throws SQLException {
        System.out.println(starttime);
        System.out.println(endtime);
        String sql1 = " select * from meeting where HOUSENO = "+houseno+" and to_timestamp('"+new java.sql.Timestamp(endtime.getTime()).toString()+"','yyyy-mm-dd hh24:mi:ss.ff') between STARTTIME and ENDTIME  "; //结束时间
        System.out.println(sql1);
        st = con.createStatement();
        rs = st.executeQuery(sql1);
        boolean flag1 = true;
        if (rs.next()){
            flag1 = false;
        }
        sql1 = " select * from meeting where HOUSENO = "+houseno+" and to_timestamp('"+new java.sql.Timestamp(starttime.getTime()).toString()+"','yyyy-mm-dd hh24:mi:ss.ff')  between STARTTIME and ENDTIME  ";
        System.out.println(sql1);
        rs = st.executeQuery(sql1);
        boolean flag2 = true;
        if (rs.next()){
            flag2 = false;
        }
        if (flag1 && flag2){
            String sql = " insert into MEETING(houseno,account,name,peopleno,meetinginfo,STARTTIME,ENDTIME,create_peo) values (?,?,?,?,?,?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,houseno);
            ps.setString(2,account);
            ps.setString(3,name);
            ps.setInt(4,peopleno);
            ps.setString(5,meetinginfo);
            ps.setTimestamp(6, new java.sql.Timestamp(starttime.getTime()));//时间戳
            ps.setTimestamp(7, new java.sql.Timestamp(endtime.getTime()));//时间戳
            ps.setString(8,user);
            return ps.executeUpdate();
        }
        return 0;
    }

    /**
     * 条件查询会议
     * @param meetingname
     * @param meetingroomname
     * @param peoname
     * @param createdate
     * @param stopdate
     * @param startdate
     * @param enddate
     * @return
     */
    @Override
    public List<Meeting> selectMeeting(String meetingname, String meetingroomname, String peoname, String createdate, String stopdate, String startdate, String enddate) throws SQLException {
        String sql = " select m.name meetingname , c.NAME meetingroomname,m.STARTTIME ,m.ENDTIME,m.CREATETIME, u.name username  from MEETING m , users u  ,CONFERENCEROOM c  where m.ACCOUNT = u.ACCOUNT and c.HOUSENO = m.HOUSENO  ";
        if (meetingname != null && !meetingname.equals("")) sql += " and m.name = '"+meetingname+"' ";
        if (meetingroomname != null && !meetingroomname.equals("")) sql += " and c.NAME = '"+meetingroomname+"' ";
        if (peoname != null && !peoname.equals("")) sql += " and u.NAME = '"+peoname+"' ";
        if (createdate != null && !createdate.equals("")) sql += " and m.CREATETIME > to_date('"+createdate+"','yyyy-mm-dd')   ";
        if (stopdate != null && !stopdate.equals("")) sql += " and m.CREATETIME < to_date('"+stopdate+"','yyyy-mm-dd')  ";
        if (startdate != null && ! startdate.equals("")) sql += " and m.STARTTIME > to_date('"+startdate+"','yyyy-mm-dd') ";
        if (enddate != null && ! enddate.equals("")) sql += " and m.endtime < to_date('"+enddate+"','yyyy-mm-dd') ";
        System.out.println(sql);
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List<Meeting> meetingList = new ArrayList<>();
        Meeting meeting = null ;
        User user = null;
        ConferenceRoom conferenceRoom;
        while (rs.next()){
            meeting = new Meeting();
            user = new User();
            conferenceRoom = new ConferenceRoom();
            meeting.setMeetingName(rs.getString("meetingname"));
            meeting.setStartTime(rs.getTimestamp("starttime"));
            meeting.setEndtime(rs.getTimestamp("endtime"));
            meeting.setCreatetime(rs.getTimestamp("createtime"));
            user.setName(rs.getString("username"));
            meeting.setUser(user);
            conferenceRoom.setName(rs.getString("meetingroomname"));
            meeting.setConferenceRoom(conferenceRoom);
            meetingList.add(meeting);
        }
        return meetingList;
    }

    /**
     * 查看会议详情
     * @param meetingname
     * @return
     * @throws SQLException
     */
    @Override
    public List meetingdetail(String meetingname) throws SQLException {
        String sql = " select * from MEETING where NAME = '"+meetingname+"' " ;
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List meetingList = new ArrayList<>();
        Meeting meeting = null ;
        if (rs.next()){
            meeting = new Meeting();
            meeting.setMeetingName(rs.getString("name"));
            meeting.setPeopleNo(rs.getInt("peopleno"));
            meeting.setStartTime(rs.getTimestamp("starttime"));
            meeting.setEndtime(rs.getTimestamp("endtime"));
            meeting.setMeetinginfo(rs.getString("meetinginfo"));
            meetingList.add(meeting);
        }
        sql = " select u.NAME,u.PHONE,u.EMAIL from MEETING m , users u where m.ACCOUNT = u.ACCOUNT and m.NAME = '"+meetingname+"' ";
        rs = st.executeQuery(sql);
        User user = null;
        while (rs.next()){
            user = new User();
            user.setName(rs.getString("name"));
            user.setPhone(rs.getString("phone"));
            user.setEmail(rs.getString("email"));
            meetingList.add(user);
        }
        return meetingList;
    }

    /**
     * mymeetings
     * @param mymeetings
     * @return
     * @throws SQLException
     */
    @Override
    public List<Meeting> mymeetings(String mymeetings) throws SQLException {
        String sql = " select c.NAME housename,m.NAME meetingname,m.STARTTIME,m.ENDTIME,m.CREATETIME,m.CREATE_PEO from meeting m ,CONFERENCEROOM c where m.HOUSENO=c.HOUSENO and ACCOUNT = '"+mymeetings+"'  ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List<Meeting> meetingList = new ArrayList<>();
        Meeting meeting = null;
        ConferenceRoom conferenceRoom = null;
        while (rs.next()){
            meeting = new Meeting();
            conferenceRoom = new ConferenceRoom();
            conferenceRoom.setName(rs.getString("housename"));
            meeting.setConferenceRoom(conferenceRoom);
            meeting.setMeetingName(rs.getString("meetingname"));
            meeting.setStartTime(rs.getTimestamp("starttime"));
            meeting.setEndtime(rs.getTimestamp("endtime"));
            meeting.setCreatetime(rs.getTimestamp("createtime"));
            meeting.setCreate_peo(rs.getString("create_peo"));
            meetingList.add(meeting);
        }
        return meetingList;
    }

    @Override
    public List<Meeting> mybookings(String account) throws SQLException {
        String sql = " select c.NAME housename,m.NAME meetingname,m.STARTTIME,m.ENDTIME,m.CREATETIME,m.CREATE_PEO from meeting m ,CONFERENCEROOM c where m.HOUSENO=c.HOUSENO and create_peo = '"+account+"'  ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List<Meeting> meetingList = new ArrayList<>();
        Meeting meeting = null;
        ConferenceRoom conferenceRoom = null;
        while (rs.next()){
            meeting = new Meeting();
            conferenceRoom = new ConferenceRoom();
            conferenceRoom.setName(rs.getString("housename"));
            meeting.setConferenceRoom(conferenceRoom);
            meeting.setMeetingName(rs.getString("meetingname"));
            meeting.setStartTime(rs.getTimestamp("starttime"));
            meeting.setEndtime(rs.getTimestamp("endtime"));
            meeting.setCreatetime(rs.getTimestamp("createtime"));
            meeting.setCreate_peo(rs.getString("create_peo"));
            meetingList.add(meeting);
        }
        return meetingList;
    }
}
