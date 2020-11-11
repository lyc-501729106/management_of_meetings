package com.etc.managemeetings.dao;

import java.sql.SQLException;

public interface DepartmentDao {
    //添加一个部门
    void addDepartment(String department) throws SQLException;
//删除一个部门
    void delDepartment(String department) throws SQLException;
}
