package com.etc.managemeetings.dao.Impl;

import com.etc.managemeetings.dao.UserDao;
import com.etc.managemeetings.entity.Department;
import com.etc.managemeetings.entity.RegisterRequest;
import com.etc.managemeetings.entity.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public User login(User user) throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        String sql = " select * from USERS where account =  '"+user.getAccount()+"'  and  pwd = '"+user.getPwd()+"' ";
        System.out.println(sql);
        st = con.createStatement();
        rs = st.executeQuery(sql);
        User user1 = null;
        if (rs.next()) {
            user1 = new User();
            user1.setName(rs.getString("name"));
            user1.setAccount(rs.getString("account"));
            user1.setState(rs.getInt("state"));
        }
        return user1;
    }

    @Override
    public boolean accountname(String accountname) throws SQLException {
        String sql = " select * from USERS where account = ? ";
        ps = con.prepareStatement(sql);
        ps.setString(1,accountname);
        rs = ps.executeQuery();
        boolean flag = false;
        if (rs.next())  flag = true;
        return flag;
    }

    @Override
    public Map<Integer, String> getAllDepartment() throws SQLException {
        String sql = " select * from Department ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        Map<Integer, String> map = new HashMap<>();
        Department department = new Department();
        while (rs.next()){
            department.setDeNum(rs.getInt("denum"));
            department.setName(rs.getString("name"));
            map.put(department.getDeNum(),department.getName());
        }
        return map;
    }

    /**
     * 注册审批
     * @param deptid
     * @param accountname
     * @param password
     * @param employeename
     * @param email
     * @param phone
     * @return
     * @throws SQLException
     */
    @Override
    public boolean register_request(int deptid, String accountname, String password, String employeename, String email, String phone) throws SQLException {
        String sql = " insert into register_request (denum, account, pwd, name, phone, email) values" +
                " (?,?,?,?,?,?)  ";
        System.out.println(sql);
        ps = con.prepareStatement(sql);
        ps.setInt(1,deptid);
        ps.setString(2,accountname);
        ps.setString(3,password);
        ps.setString(4,employeename);
        ps.setString(5,phone);
        ps.setString(6,email);
        int no =  ps.executeUpdate();
        boolean flag = false;
        if (no == 1) flag = true;
        return flag;
    }

    @Override
    public boolean updatepwdjiaoyan(String account, String pwd) throws SQLException {
        String sql = " select * from USERS where account =  '"+account+"'  and  pwd = '"+pwd+"'  ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        boolean flag = false;
        if (rs.next()) flag = true;
        return flag;
    }

    @Override
    public int updatepwd(String account, String newpwd) throws SQLException {
        String sql = " update USERS set pwd = '"+newpwd+"' where ACCOUNT = '"+account+"' ";
        st = con.createStatement();
        return st.executeUpdate(sql);
    }

    /**
     * 注册通过表 将register_request 表的记录 插入users表，并且删除register_request表中的某条记录
     * @param account
     * @return
     * @throws SQLException
     */
    @Override
    public int register_move(String account) throws SQLException {
        String sql = " insert into USERS (denum, account, pwd, name, phone, email) (select r.DENUM, r.ACCOUNT,r.pwd,r.name,r.phone,r.email from REGISTER_REQUEST r where ACCOUNT = '"+account+"') ";
        st = con.createStatement();
        return st.executeUpdate(sql);
    }

    @Override
    public int del_register_request(String account) throws SQLException {
        String sql = " delete REGISTER_REQUEST where ACCOUNT = '"+account+"' ";
        st = con.createStatement();
        return st.executeUpdate(sql);
    }

    /**
     * 获取到所有的注册申请
     * @return
     * @throws SQLException
     */
    @Override
    public List<RegisterRequest> AllRegisterRequest() throws SQLException {
        String sql = " select * from REGISTER_REQUEST ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List<RegisterRequest> registerRequestList = new ArrayList<>();
        RegisterRequest rr = null;
        while (rs.next()){
            rr = new RegisterRequest();
            rr.setDenum(rs.getInt("denum"));
            rr.setAccount(rs.getString("account"));
            rr.setPwd(rs.getString("pwd"));
            rr.setName(rs.getString("name"));
            rr.setPhone(rs.getString("phone"));
            rr.setEmail(rs.getString("email"));
            registerRequestList.add(rr);
        }
        return registerRequestList;
    }

    /**
     * 搜索员工
     * @param name
     * @param account
     * @param state
     * @return
     * @throws SQLException
     *
     */
    @Override
    public List<User> selectUsers(String name, String account, int state) throws SQLException {
        String sql = "  select * from USERS where STATE = '"+state+"'  ";
            if (name != null && !name.equals("")) sql += "  and name = '"+name+"'  ";
            if (account != null && !account.equals("")) sql += " and ACCOUNT = '"+account+"' ";
            if (state == 0) {
                sql = sql.replace("USERS","REGISTER_REQUEST");  //.replace(); 将某字符串替换为 自定义的字符串
                sql = sql.replace(" where STATE = '0' ","  ");
            }
            System.out.println(sql);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            User user = null;
            List<User> userList = new ArrayList<>();
            while (rs.next()){
                user = new User();
                user.setDeNum(rs.getInt("denum"));
                user.setAccount(rs.getString("account"));
                user.setPwd(rs.getString("pwd"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setState(rs.getInt("state"));
                userList.add(user);
            }
        return userList;
    }

    /**
     * 获取到所有的已经注册的用户
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> allUsers() throws SQLException {
        String sql = " select * from users ";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        List<User> userList = new ArrayList<>();
        User user = null;
        while (rs.next()){
            user = new User();
            user.setName(rs.getString("name"));
            user.setAccount(rs.getString("account"));
            user.setDeNum(rs.getInt("denum"));
            userList.add(user);
        }
        return userList;
    }

    /**
     * 关闭用户
     * @param account
     */
    @Override
    public void closeUser(String account) throws SQLException {
        String sql = " update USERS set STATE = -1 where account = '"+account+"' " ;
        st = con.createStatement();
        st.executeUpdate(sql);
    }

    /**
     * 启用用户
     * @param account
     * @throws SQLException
     */
    @Override
    public void openUser(String account) throws SQLException {
        String sql = " update USERS set STATE = 1 where account = '"+account+"' " ;
        st = con.createStatement();
        st.executeUpdate(sql);
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
        UserDaoImpl dao = new UserDaoImpl();
        User user = new User();
        user.setAccount("123");
        user.setPwd("123");
    }
}
