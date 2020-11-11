package com.etc.managemeetings.service.Impl;

import com.etc.managemeetings.dao.Impl.MeetingDaoImpl;
import com.etc.managemeetings.dao.MeetingDao;
import com.etc.managemeetings.entity.Meeting;
import com.etc.managemeetings.service.MeetingService;
import com.etc.managemeetings.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingServiceImpl implements MeetingService {
    /**
     * 预订一个会议
     * @param houseno
     * @param account
     * @param name
     * @param peopleno
     * @param starttime
     * @param endtime
     * @param meetinginfo
     * @throws SQLException
     */
    @Override
    public int addMeetings(int houseno, String account, String name, int peopleno, Date starttime, Date endtime, String meetinginfo,String user) throws SQLException {
        MeetingDao dao = new MeetingDaoImpl();
        int no = 0;
        try {
            ((MeetingDaoImpl)dao).openDb();
             no =  dao.addMeetings(houseno,account,name,peopleno,starttime,endtime,meetinginfo,user);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((MeetingDaoImpl) dao).closeResource();
            return no;
        }
    }

    @Override
    public List<Meeting> selectMeeting(String meetingname, String meetingroomname, String peoname, String createdate, String stopdate, String startdate, String enddate) throws SQLException {
        MeetingDao dao = new MeetingDaoImpl();
        List<Meeting> meetingList = null;
        try {
            ((MeetingDaoImpl)dao).openDb();
            meetingList = dao.selectMeeting(meetingname,meetingroomname,peoname,createdate,stopdate,
                    startdate,enddate);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((MeetingDaoImpl) dao).closeResource();
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
        MeetingDao dao = new MeetingDaoImpl();
        List meetingList = null;
        try {
            ((MeetingDaoImpl)dao).openDb();
            meetingList = dao.meetingdetail(meetingname);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((MeetingDaoImpl) dao).closeResource();
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
        MeetingDao dao = new MeetingDaoImpl();
        List<Meeting> meetingList = null;
        try {
            ((MeetingDaoImpl)dao).openDb();
            meetingList = dao.mymeetings(mymeetings);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((MeetingDaoImpl) dao).closeResource();
        }
        return meetingList;
    }

    @Override
    public List<Meeting> mybookings(String account) throws SQLException {
        MeetingDao dao = new MeetingDaoImpl();
        List<Meeting> meetingList = null;
        try {
            ((MeetingDaoImpl)dao).openDb();
            meetingList = dao.mybookings(account);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((MeetingDaoImpl) dao).closeResource();
        }
        return meetingList;
    }
}
