package com.mycomp.antstoreadmin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImproveServlet")
public class ImproveServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    /*
     * 能够使用反射找到这些方法的前提是,这些方法的名称必须与request传入的参数值一样
     */

    public String add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("添加");
        return "add.jsp";
    }

    public String update(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("修改");
        return "update.jsp";
    }

    public String delete(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("删除");
        return "delete.jsp";
    }
}
