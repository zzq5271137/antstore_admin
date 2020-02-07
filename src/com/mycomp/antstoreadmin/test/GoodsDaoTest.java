package com.mycomp.antstoreadmin.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.mycomp.antstoreadmin.dao.GoodsDao;
import com.mycomp.antstoreadmin.domain.Goods;

public class GoodsDaoTest {
    private GoodsDao goodsDao = new GoodsDao();

    @Test
    public void testGetAllGoods() throws SQLException {
        List<Goods> allGoods = goodsDao.getAllGoods();
        System.out.println(allGoods);
    }

    @Test
    public void testAddGoods() throws SQLException {
        Goods goods = new Goods();
        goods.setName("zzq");
        goods.setPrice(35.5);
        goods.setImage("zzq.png");
        goods.setGdesc("zzq");
        goods.setIs_hot(1);
        goods.setCid(2);
        goodsDao.addGoods(goods);
    }

    @Test
    public void testUpdateGoods() throws SQLException {
        Goods goods = new Goods();
        goods.setId(24);
        goods.setName("zzq2233");
        goods.setPrice(100.5);
        goods.setImage("zzq2233.png");
        goods.setGdesc("zzq2233");
        goods.setIs_hot(0);
        goods.setCid(2);
        goodsDao.updateGoods(goods);
    }

    @Test
    public void testDeleteGoods() throws SQLException {
        goodsDao.deleteGoods(24);
    }
}
