package com.etc.managemeetings.dao;

import com.etc.managemeetings.entity.RegisterRequest;
import com.etc.managemeetings.entity.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {
    //实现登录功能
    User login(User user) throws SQLException, URISyntaxException, IOException, ClassNotFoundException;
//AJAX实现用户名校验
    boolean accountname(String accountname) throws SQLException;
//获取到所有的部门
Map<Integer, String> getAllDepartment() throws SQLException;
//注册审批
    boolean register_request(int deptid, String accountname, String password, String employeename, String email, String phone) throws SQLException;
    //修改用户密码时，原密码ajax校验
    boolean updatepwdjiaoyan(String account, String pwd) throws SQLException;
//修改密码
    int updatepwd(String account, String newpwd) throws SQLException;
    //注册审批转移到user表
    int register_move(String account) throws SQLException;
    //删除审批表中的记录
    int del_register_request(String account) throws SQLException;
    //获取到所有的注册 申请
    List<RegisterRequest> AllRegisterRequest() throws SQLException;
//查询用户
    List<User> selectUsers(String name, String account, int state) throws SQLException;
//获取到所有的已经注册通过的用户
    List<User> allUsers() throws SQLException;
//关闭用户
    void closeUser(String account) throws SQLException;
//启用用户
    void openUser(String account) throws SQLException;
}
