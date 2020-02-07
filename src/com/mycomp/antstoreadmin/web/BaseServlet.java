package com.mycomp.antstoreadmin.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 所有关于goods的请求都会来到这里
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String destPath = null;

        // 使用反射来避免过多的if判断语句
        Class<?> clazz = this.getClass();
        try {
            Method method = clazz.getMethod(action, HttpServletRequest.class,
                    HttpServletResponse.class);
            if (method != null) {
                destPath = (String) method.invoke(this, request, response);
                if (action != null) {
                    request.getRequestDispatcher(destPath).forward(request,
                            response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
