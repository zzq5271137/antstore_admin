package com.mycomp.antstoreadmin.service;

import com.mycomp.antstoreadmin.dao.AdminDao;
import com.mycomp.antstoreadmin.domain.Admin;

public class AdminService {

    public Admin login(String username, String password) throws Exception {
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.checkAdmin(username, password);
        if (admin != null) {
            return admin;
        } else {
            throw new Exception("用户名或密码错误");
        }
    }

}
