package com.etc.managemeetings.dao.Impl;

import com.etc.managemeetings.dao.ConferenceRoomDao;
import com.etc.managemeetings.entity.ConferenceRoom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRoomDaoImpl extends BaseDaoImpl implements ConferenceRoomDao {
    /**
     * ajax校验是否有门牌号
     * @param roomnumber
     * @return
     * @throws SQLException
     */
    @Override
    public boolean houseNo(String roomnumber) throws SQLException {
        String sql = " select * from CONFERENCEROOM where HOUSENO = '"+roomnumber+"' ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        boolean flag = false;
        if (rs.next()){
            flag = true;
        }
        return flag;
    }

    @Override
    public int addConRoom(boolean houseNo, int houseNo1, String name, String peoNum, String info) throws SQLException {
        int no = 0;
        if (!houseNo){
            //没有查出来此房间号，说明此房间没人使用，进行插入操作
            String sql = " insert into CONFERENCEROOM(houseno, name, peoplenumber, info) VALUES (?,?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,houseNo1);
            ps.setString(2,name);
            ps.setString(3,peoNum);
            ps.setString(4,info);
            no = ps.executeUpdate();
        }
        return no;
    }

    @Override
    public List<ConferenceRoom> allConfRoom() throws SQLException {
        String sql = " select * from CONFERENCEROOM ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List<ConferenceRoom> conferenceRoomList = new ArrayList<>();
        ConferenceRoom cr = null;
        while (rs.next()){
            cr = new ConferenceRoom();
            cr.setHouseNo(rs.getInt("houseno"));
            cr.setName(rs.getString("name"));
            cr.setPeopleNumber(rs.getInt("peoplenumber"));
            cr.setInfo(rs.getString("info"));
            cr.setState(rs.getInt("state"));
            conferenceRoomList.add(cr);
        }
        return conferenceRoomList;
    }

    /**
     * 获取一个单个的会议室信息
     * @param houseNo
     * @return
     * @throws SQLException
     */
    @Override
    public ConferenceRoom oneConfRoom(int houseNo) throws SQLException {
        String sql = " select * from CONFERENCEROOM where HOUSENO = '"+houseNo+"' ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        ConferenceRoom conferenceRoom = new ConferenceRoom();
        if (rs.next()){
            conferenceRoom.setHouseNo(rs.getInt("houseno"));
            conferenceRoom.setName(rs.getString("name"));
            conferenceRoom.setPeopleNumber(rs.getInt("peopleNumber"));
            conferenceRoom.setInfo(rs.getString("info"));
            conferenceRoom.setState(rs.getInt("state"));
        }
        return conferenceRoom;
    }

    @Override
    public boolean updateConfRoom(boolean houseNo, int newhouseno, String name, String peolnum, String info, int state,int oldhouseno) throws SQLException {
        boolean flag = false;
        int no = 0;
        if (!houseNo){ //为假，则表示里面没有这个值，可以改为这个值！！
            //update CONFERENCEROOM c set c.HOUSENO = ?, c.NAME=?,c.PEOPLENUMBER=?,c.INFO=?,c.STATE=? where HOUSENO = '1' ;
            String sql = "  update CONFERENCEROOM c set c.HOUSENO =  '"+oldhouseno+"',  ";
            if (newhouseno != oldhouseno && newhouseno != 0)    sql = sql.replace(""+oldhouseno+"",""+newhouseno+"");//修改houseNo
            if (name != null && !name.equals(""))   sql += " c.NAME='"+name+"', ";//修改会议室名称
            if (peolnum != null && !peolnum.equals("")) sql += " c.PEOPLENUMBER='"+peolnum+"', ";//修改会议人数
            if (info != null && !info.equals("")) sql += " c.INFO='"+info+"', ";//修改说明信息
            sql += " c.STATE='"+state+"' ";//修改状态！
            sql += " where HOUSENO = '"+oldhouseno+"' ";
            System.out.println(sql);
            st =con.createStatement();
            no = st.executeUpdate(sql);
        }else {
            String sql = "  update CONFERENCEROOM c set c.HOUSENO =  '"+oldhouseno+"',  ";
            if (name != null && !name.equals(""))   sql += " c.NAME='"+name+"', ";//修改会议室名称
            if (peolnum != null && !peolnum.equals("")) sql += " c.PEOPLENUMBER='"+peolnum+"', ";//修改会议人数
            if (info != null && !info.equals("")) sql += " c.INFO='"+info+"', ";//修改说明信息
            sql += " c.STATE='"+state+"' ";//修改状态！
            sql += " where HOUSENO = '"+oldhouseno+"' ";
            System.out.println(sql);
            st =con.createStatement();
            no = st.executeUpdate(sql);
        }
        if (no == 1) flag = true;
        return flag;
    }
}
