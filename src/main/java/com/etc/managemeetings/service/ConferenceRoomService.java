package com.etc.managemeetings.service;

import com.etc.managemeetings.entity.ConferenceRoom;

import java.sql.SQLException;
import java.util.List;

public interface ConferenceRoomService {
    //ajax校验是否已有门牌号
    boolean houseNo(String roomnumber) throws SQLException;
    //添加一个会议室
    int addConRoom(int houseNo,String name,String peoNum,String info) throws SQLException;
    //查看所有的会议室
    List<ConferenceRoom> allConfRoom() throws SQLException;
    //查询单个的会议室
    ConferenceRoom oneConfRoom(int houseNo) throws SQLException;
    //更新一个会议室信息
    boolean updateConfRoom(int newhouseno, String name, String peolnum, String info, int state,int oldhouseno) throws SQLException;
}
