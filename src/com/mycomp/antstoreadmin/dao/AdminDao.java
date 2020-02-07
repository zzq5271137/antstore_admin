package com.mycomp.antstoreadmin.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mycomp.antstoreadmin.domain.Admin;
import com.mycomp.antstoreadmin.utils.JDBCUtil;

public class AdminDao {

    public Admin checkAdmin(String username, String password)
            throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from admin where username = ? and password = ?";
        return runner.query(sql, new BeanHandler<Admin>(Admin.class), username,
                password);
    }

}
