package com.etc.managemeetings.dao;

import com.etc.managemeetings.entity.ConferenceRoom;

import java.sql.SQLException;
import java.util.List;

public interface ConferenceRoomDao {
    //ajax校验是否有门牌号
    boolean houseNo(String roomnumber) throws SQLException;
//添加一个会议室
    int addConRoom(boolean houseNo, int houseNo1, String name, String peoNum, String info) throws SQLException;
//获取到所有的会议室
    List<ConferenceRoom> allConfRoom() throws SQLException;
//获取一个单个会议室信息
    ConferenceRoom oneConfRoom(int houseNo) throws SQLException;
//更新一个会议室信息
    boolean updateConfRoom(boolean houseNo, int newhouseno, String name, String peolnum, String info, int state,int oldhouseno) throws SQLException;
}
