package com.etc.managemeetings.service.Impl;

import com.etc.managemeetings.dao.ConferenceRoomDao;
import com.etc.managemeetings.dao.Impl.ConferenceRoomDaoImpl;
import com.etc.managemeetings.entity.ConferenceRoom;
import com.etc.managemeetings.service.ConferenceRoomService;
import com.etc.managemeetings.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRoomServiceImpl implements ConferenceRoomService {
    /**
     * ajax校验是否已有门牌号
     * @param roomnumber
     * @return
     * @throws SQLException
     */
    @Override
    public boolean houseNo(String roomnumber) throws SQLException {
        ConferenceRoomDao dao = new ConferenceRoomDaoImpl();
        boolean flag = false;
        try {
            ((ConferenceRoomDaoImpl)dao).openDb();
            flag = dao.houseNo(roomnumber);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((ConferenceRoomDaoImpl) dao).closeResource();
        }
        return flag;
    }

    /**
     * 添加一个会议室
     * @param houseNo
     * @param name
     * @param peoNum
     * @param info
     * @return
     * @throws SQLException
     */
    @Override
    public int addConRoom(int houseNo, String name, String peoNum, String info) throws SQLException {
        ConferenceRoomDao dao = new ConferenceRoomDaoImpl();
        int no = 0 ;
        try {
            ((ConferenceRoomDaoImpl)dao).openDb();
            no = dao.addConRoom(houseNo(houseNo+""),houseNo,name,peoNum,info);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((ConferenceRoomDaoImpl) dao).closeResource();
        }
        return no;
    }

    /**
     * 获取到所有的会议室
     * @return
     * @throws SQLException
     */
    @Override
    public List<ConferenceRoom> allConfRoom() throws SQLException {
        ConferenceRoomDao dao = new ConferenceRoomDaoImpl();
        List<ConferenceRoom> conferenceRoomList = new ArrayList<>();
        try {
            ((ConferenceRoomDaoImpl)dao).openDb();
            conferenceRoomList = dao.allConfRoom();
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((ConferenceRoomDaoImpl) dao).closeResource();
        }
        return conferenceRoomList;
    }

    @Override
    public ConferenceRoom oneConfRoom(int houseNo) throws SQLException {
        ConferenceRoomDao dao = new ConferenceRoomDaoImpl();
        ConferenceRoom conferenceRoom = null;
        try {
            ((ConferenceRoomDaoImpl)dao).openDb();
            conferenceRoom = dao.oneConfRoom(houseNo);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((ConferenceRoomDaoImpl) dao).closeResource();
        }
        return conferenceRoom;
    }

    /**
     * 修改一个会议室的信息
     * @param newhouseno
     * @param name
     * @param peolnum
     * @param info
     * @param state
     * @param oldhouseno
     * @return
     * @throws SQLException
     */
    @Override
    public boolean updateConfRoom(int newhouseno, String name, String peolnum, String info, int state,int oldhouseno) throws SQLException {
        ConferenceRoomDao dao = new ConferenceRoomDaoImpl();
        boolean flag = false;
        try {
            ((ConferenceRoomDaoImpl)dao).openDb();
            flag = dao.updateConfRoom(houseNo(newhouseno+""),newhouseno,name,peolnum,info,state,oldhouseno);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((ConferenceRoomDaoImpl) dao).closeResource();
        }
        return flag;
    }
}
