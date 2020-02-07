package com.mycomp.antstoreadmin.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycomp.antstoreadmin.domain.PageBean;
import org.apache.commons.beanutils.BeanUtils;

import com.mycomp.antstoreadmin.domain.Category;
import com.mycomp.antstoreadmin.domain.Goods;
import com.mycomp.antstoreadmin.service.CategoryService;
import com.mycomp.antstoreadmin.service.GoodsService;

/*
 * 采用继承BaseServlet的方式使Servlet的数量大大减少
 */
@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    // 获取所有商品
    public String getGoodsList(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {
        GoodsService goodsService = new GoodsService();
        try {
            // 所有商品的数据
            List<Goods> allGoods = goodsService.getAllGoods();
            Collections.reverse(allGoods);
            // 分页信息的数据封装
            PageBean pageBean = new PageBean();
            pageBean.setGoodsList(allGoods);
            pageBean.setTotalCount(10);
            pageBean.setTotalPage(10);
            request.setAttribute("pageBean", pageBean);
            return "admin/main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取分页商品
    public String getPageData(HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String currentPage = request.getParameter("currentPage");
            GoodsService goodsService = new GoodsService();
            PageBean pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
            request.setAttribute("pageBean", pageBean);
            return "admin/main.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 删除一个商品
    public String delGoods(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        GoodsService goodsService = new GoodsService();
        try {
            goodsService.deleteGoods(id);
            return "/GoodsServlet?action=getPageData&currentPage=1";
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取新增商品页面的相关参数
    public String getAddUI(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        try {
            List<Category> allCategories = categoryService.getAllCategories();
            request.setAttribute("allCategories", allCategories);
            return "/admin/add.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    // 添加一个商品
    public String addGoods(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
            goods.setImage("goods_11.png");
            GoodsService goodsService = new GoodsService();
            goodsService.addGoods(goods);
            return "/GoodsServlet?action=getPageData&currentPage=1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取编辑商品页面的相关参数
    public String getEditUI(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        GoodsService goodsService = new GoodsService();
        CategoryService categoryService = new CategoryService();
        try {
            Goods goods = goodsService.getGoodsWithId(id);
            List<Category> allCategories = categoryService.getAllCategories();
            request.setAttribute("goods", goods);
            request.setAttribute("allCategories", allCategories);
            return "admin/edit.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 更新商品
    public String editGoods(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
            goods.setImage("goods_11.png");
            GoodsService goodsService = new GoodsService();
            goodsService.updateGoods(goods);
            return "/GoodsServlet?action=getPageData&currentPage=1";
        } catch (IllegalAccessException | InvocationTargetException
                | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
