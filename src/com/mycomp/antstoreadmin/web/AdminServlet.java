package com.mycomp.antstoreadmin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mycomp.antstoreadmin.domain.Admin;
import com.mycomp.antstoreadmin.service.AdminService;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminService adminService = new AdminService();
        try {
            Admin admin = adminService.login(username, password);
            HttpSession session = request.getSession();
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(60 * 30); // 30分钟过期,和session默认的过期时间一样
            response.addCookie(cookie);
            session.setAttribute("admin", admin);
            response.sendRedirect(
                    request.getContextPath() + "/admin/admin_index.jsp");
        } catch (Exception e) {
            if (e.getMessage().equals("用户名或密码错误")) {
                request.setAttribute("errorMsg", e.getMessage());
                request.getRequestDispatcher("admin/admin_login.jsp")
                        .forward(request, response);
            } else {
                e.printStackTrace();
            }
        }
    }

}
