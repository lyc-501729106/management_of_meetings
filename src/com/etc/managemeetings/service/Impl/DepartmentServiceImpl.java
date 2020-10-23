package com.etc.managemeetings.service.Impl;

import com.etc.managemeetings.dao.DepartmentDao;
import com.etc.managemeetings.dao.Impl.DepartmentDaoImpl;
import com.etc.managemeetings.service.DepartmentService;
import com.etc.managemeetings.util.Log;

import java.sql.SQLException;

public class DepartmentServiceImpl implements DepartmentService {
    /**
     * 添加一个部门
     * @param department
     * @throws SQLException
     */
    @Override
    public void addDepartment(String department) throws SQLException {
        DepartmentDao dao = new DepartmentDaoImpl();
        try {
            ((DepartmentDaoImpl)dao).openDb();
            dao.addDepartment(department);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((DepartmentDaoImpl)dao).closeResource();
        }
    }

    /**
     * 删除一个部门
     * @param department
     * @throws SQLException
     */
    @Override
    public void delDepartment(String department) throws SQLException {
        DepartmentDao dao = new DepartmentDaoImpl();
        try {
            ((DepartmentDaoImpl)dao).openDb();
            dao.delDepartment(department);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        } finally {
            ((DepartmentDaoImpl)dao).closeResource();
        }
    }
}
