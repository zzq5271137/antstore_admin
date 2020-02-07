package com.mycomp.antstoreadmin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mycomp.antstoreadmin.domain.Category;
import com.mycomp.antstoreadmin.utils.JDBCUtil;

public class CategoryDao {
    private QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

    public List<Category> getAllCategories() throws SQLException {
        String sql = "select * from category";
        return runner.query(sql,
                new BeanListHandler<Category>(Category.class));
    }

}
