package com.mycomp.antstoreadmin.service;

import java.sql.SQLException;
import java.util.List;

import com.mycomp.antstoreadmin.dao.CategoryDao;
import com.mycomp.antstoreadmin.domain.Category;

public class CategoryService {

    public List<Category> getAllCategories() throws SQLException {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.getAllCategories();
    }

}
