package com.etc.managemeetings.dao.Impl;

import com.etc.managemeetings.dao.BaseDao;
import com.etc.managemeetings.util.DbInfo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

public class BaseDaoImpl implements BaseDao {
    public Connection con ;
    public PreparedStatement ps ;
    public ResultSet rs;
    public Statement st;
    @Override
    public void openDb() throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
        //创建DbInfo实例
        DbInfo dbInfo = DbInfo.getInstance() ;
        //获取ConfigInfo实例
        DbInfo.ConfigInfo configInfo = dbInfo.getProperties() ;
        Class.forName(configInfo.getDbdriver()) ;
        con = DriverManager.getConnection(configInfo.getDbURL() , configInfo.getUname() , configInfo.getPwd()) ;
//        System.out.println("数据库连接成功");
    }

    @Override
    public void closeResource() throws SQLException {
        if (con != null) con.close();
        if (rs != null) rs.close();
        if (st != null) st.close();
        if (ps != null) ps.close();
    }

    @Override
    public void openTransaction() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        openDb();
        if (con != null) con.setAutoCommit(false);
    }

    @Override
    public void commitTransaction() throws SQLException {
        if (con != null) con.commit();
    }

    @Override
    public void rollbackTransaction() throws SQLException {
        if (con != null) con.rollback();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        BaseDaoImpl b = new BaseDaoImpl();
        b.openDb();
    }
}
