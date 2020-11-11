package com.etc.managemeetings.service.Impl;

import com.etc.managemeetings.dao.Impl.UserDaoImpl;
import com.etc.managemeetings.dao.UserDao;
import com.etc.managemeetings.entity.RegisterRequest;
import com.etc.managemeetings.entity.User;
import com.etc.managemeetings.service.UserService;
import com.etc.managemeetings.util.Log;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.sql.SQLException;
import java.util.*;

public class UserServiceImpl implements UserService {
    @Override
    public User login(User user) throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user1 = new User();
        try {
            ((UserDaoImpl)dao).openDb();
           user1 = dao.login(user);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((UserDaoImpl)dao).closeResource();
        }
        return user1;
    }

    @Override
    public boolean accountname(String accountname) throws SQLException {
        UserDao dao = new UserDaoImpl();
        boolean flag = false;
        try {
            ((UserDaoImpl)dao).openDb();
            flag = dao.accountname(accountname);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((UserDaoImpl)dao).closeResource();
        }
        return flag;
    }

    @Override
    public Map<Integer, String> getAllDepartment() throws SQLException {
        UserDao dao = new UserDaoImpl();
        Map<Integer, String> map = new HashMap<>();
        try {
            ((UserDaoImpl)dao).openDb();
            map = dao.getAllDepartment();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {((UserDaoImpl)dao).closeResource();
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
        UserDao dao = new UserDaoImpl();
        boolean flag = false;
        try {
            ((UserDaoImpl)dao).openDb();
            flag = dao.register_request(deptid,accountname,password,employeename,email,phone);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {((UserDaoImpl)dao).closeResource();
        }
        return flag;
    }

    @Override
    public boolean updatepwdjiaoyan(String account, String pwd) throws SQLException {
        UserDao dao = new UserDaoImpl();
        boolean flag = false;
        try {
            ((UserDaoImpl)dao).openDb();
            flag = dao.updatepwdjiaoyan(account,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {((UserDaoImpl)dao).closeResource();
        }
        return flag;
    }

    @Override
    public int updatepwd(String account, String newpwd) throws SQLException {
        UserDao dao = new UserDaoImpl();
        int no = 0;
        try {
            ((UserDaoImpl)dao).openDb();
            no = dao.updatepwd(account,newpwd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {((UserDaoImpl)dao).closeResource();
        }
        return no;
    }

    /**
     * 注册通过表
     * @param account
     * @return
     * @throws SQLException
     */
    @Override
    public boolean register_ok(String account) throws SQLException {
        UserDao dao = new UserDaoImpl();
        boolean flag = false;
        try {
            ((UserDaoImpl)dao).openTransaction();
            int no1 = dao.register_move(account);
            int no2 = dao.del_register_request(account);
            if (no1==1 && no2==1) flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {((UserDaoImpl)dao).closeResource();
        }
        return flag;
    }

    /**
     * 获取到所有的注册申请
     * @return
     * @throws SQLException
     */
    @Override
    public List<RegisterRequest> AllRegisterRequest() throws SQLException {
        UserDao dao = new UserDaoImpl();
        List<RegisterRequest> registerRequestList = new ArrayList<>();
        try {
            ((UserDaoImpl)dao).openDb();
            registerRequestList = dao.AllRegisterRequest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {((UserDaoImpl)dao).closeResource();
        }
        return registerRequestList;
    }

    /**
     * 删除一个注册申请信息
     * @param account
     * @throws SQLException
     */
    @Override
    public void delRegisterRequest(String account) throws SQLException {
        UserDao dao = new UserDaoImpl();
        try {
            ((UserDaoImpl)dao).openDb();
            dao.del_register_request(account);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {((UserDaoImpl)dao).closeResource();
        }
    }

    /**
     * 搜索员工
     * @param name
     * @param account
     * @param state
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> selectUsers(String name, String account, int state) throws SQLException {
        UserDao dao = new UserDaoImpl();
        List<User> userList = new ArrayList<>();
        try {
            ((UserDaoImpl)dao).openDb();
            userList = dao.selectUsers(name , account , state);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {((UserDaoImpl)dao).closeResource();
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
        UserDao dao = new UserDaoImpl();
        List<User> userList = null;
        try {
            ((UserDaoImpl)dao).openDb();
            userList = dao.allUsers();
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {((UserDaoImpl)dao).closeResource();
        }
        return userList;
    }

    /**
     * 关闭用户
     * @param account
     * @throws SQLException
     */
    @Override
    public void closeUser(String account) throws SQLException {
        UserDao dao = new UserDaoImpl();
        try {
            ((UserDaoImpl)dao).openDb();
           dao.closeUser(account);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {((UserDaoImpl)dao).closeResource();
        }
    }

    /**
     * 启用用户
     * @param account
     * @throws SQLException
     */
    @Override
    public void openUser(String account) throws SQLException {
        UserDao dao = new UserDaoImpl();
        try {
            ((UserDaoImpl)dao).openDb();
            dao.openUser(account);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {((UserDaoImpl)dao).closeResource();
        }
    }

    public static void main(String[] args) throws SQLException {
        UserService us = new UserServiceImpl();
        Map<Integer,String> mapList = us.getAllDepartment();
        System.out.println(mapList);
        System.out.println(mapList.get(1));
        System.out.println(mapList.values());
        System.out.println(mapList.keySet());
        /*Set<Integer> set = mapList.keySet();
        Iterator<Integer> it1 = set.iterator() ;
        while (it1.hasNext()){
            Integer key = it1.next() ;
            System.out.println(key + " " + mapList.get(key));
        }*/
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println(us.register_ok("1233"));

    }
}
