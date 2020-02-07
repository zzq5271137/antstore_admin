package com.mycomp.antstoreadmin.service;

import java.sql.SQLException;
import java.util.List;

import com.mycomp.antstoreadmin.dao.GoodsDao;
import com.mycomp.antstoreadmin.domain.Goods;
import com.mycomp.antstoreadmin.domain.PageBean;

public class GoodsService {
    private GoodsDao goodsDao = new GoodsDao();

    public List<Goods> getAllGoods() throws SQLException {
        return goodsDao.getAllGoods();
    }

    public void deleteGoods(String id)
            throws NumberFormatException, SQLException {
        goodsDao.deleteGoods(Integer.parseInt(id));
    }

    public void addGoods(Goods goods) throws SQLException {
        goodsDao.addGoods(goods);
    }

    public Goods getGoodsWithId(String id)
            throws NumberFormatException, SQLException {
        return goodsDao.getGoodsWithId(Integer.parseInt(id));
    }

    public void updateGoods(Goods goods) throws SQLException {
        goodsDao.updateGoods(goods);
    }

    public PageBean getPageBean(Integer currentPage) throws SQLException {
        PageBean pageBean = new PageBean();

        // 设置当前页码
        pageBean.setCurrentPage(currentPage);

        // 获取一共多少条数据
        Long count = goodsDao.getCount();
        pageBean.setTotalCount(count.intValue());

        // 计算一共多少页
        double totalPage = Math.ceil(1.0 * pageBean.getTotalCount() / PageBean.PAGE_SIZE);
        pageBean.setTotalPage((int) totalPage);

        // 获取当前页的数据
        Integer index = (pageBean.getCurrentPage() - 1) * PageBean.PAGE_SIZE;
        List<Goods> pageData = goodsDao.getPageData(index, PageBean.PAGE_SIZE);
        pageBean.setGoodsList(pageData);

        return pageBean;
    }
}
