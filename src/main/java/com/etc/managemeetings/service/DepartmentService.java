package com.etc.managemeetings.service;

import java.sql.SQLException;

public interface DepartmentService {
    //添加一个部门
    void addDepartment (String department) throws SQLException;
    //删除一个部门
    void delDepartment (String department) throws SQLException;
}
