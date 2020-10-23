package com.etc.managemeetings.dao.Impl;

import com.etc.managemeetings.dao.DepartmentDao;

import java.sql.SQLException;

public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {
    /**
     * 添加一个部门
     * @param department
     * @throws SQLException
     */
    @Override
    public void addDepartment(String department) throws SQLException {
        String sql = " insert into DEPARTMENT(denum, name) VALUES (departmentsadd.nextval,?) ";
        ps = con.prepareStatement(sql);
        ps.setString(1,department);
        ps.executeUpdate();
    }

    /**
     * 删除一个部门
     * @param department
     * @throws SQLException
     */
    @Override
    public void delDepartment(String department) throws SQLException {
        String sql = " delete from department where name = '"+department+"' ";
        st = con.createStatement();
        st.executeUpdate(sql);
    }
}
