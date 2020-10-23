package com.etc.managemeetings.service;

import com.etc.managemeetings.entity.RegisterRequest;
import com.etc.managemeetings.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    //实现登录的功能
    User login(User user) throws SQLException;
    //AJAX实现用户名校验
    boolean accountname(String accountname) throws SQLException;
    //查询所有的部门
    Map<Integer, String> getAllDepartment() throws SQLException;
//注册审批
    boolean register_request(int deptid, String accountname, String password, String employeename, String email, String phone) throws SQLException;
    //修改用户密码时，原密码ajax校验
    boolean updatepwdjiaoyan(String account,String pwd) throws SQLException;
    //修改密码
    int updatepwd(String account,String newpwd) throws SQLException;
    //注册通过表
    boolean register_ok(String account) throws SQLException;
    //查看所有的申请注册用户
    List<RegisterRequest> AllRegisterRequest () throws SQLException;
    //删除一个注册申请信息
    void delRegisterRequest (String account) throws SQLException;
    //搜索员工
    List<User> selectUsers(String name , String account , int state) throws SQLException;
    //搜索所有的已经通过审批的用户
    List<User> allUsers() throws SQLException;
    //关闭用户
    void closeUser(String account) throws SQLException;
    //启用用户
    void openUser(String account) throws SQLException;

}
