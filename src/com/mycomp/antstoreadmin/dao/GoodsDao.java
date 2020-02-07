package com.mycomp.antstoreadmin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mycomp.antstoreadmin.domain.Goods;
import com.mycomp.antstoreadmin.utils.JDBCUtil;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class GoodsDao {
    private QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

    // 从数据库中查询所有商品
    public List<Goods> getAllGoods() throws SQLException {
        String sql = "select * from goods";
        return runner.query(sql, new BeanListHandler<Goods>(Goods.class));
    }

    // 添加商品到数据库中
    public void addGoods(Goods goods) throws SQLException {
        String sql = "insert into goods(name, price, image, gdesc, is_hot, cid) values(?, ?, ?, ?, ?, ?)";
        runner.update(sql, goods.getName(), goods.getPrice(), goods.getImage(),
                goods.getGdesc(), goods.getIs_hot(), goods.getCid());
    }

    // 根据id删除一个商品
    public void deleteGoods(Integer id) throws SQLException {
        String sql = "delete from goods where id = ?";
        runner.update(sql, id);
    }

    // 更新商品
    public void updateGoods(Goods goods) throws SQLException {
        String sql = "update goods set name = ?, price = ?, image = ?, gdesc = ?, is_hot = ?, cid = ? where id = ?";
        runner.update(sql, goods.getName(), goods.getPrice(), goods.getImage(),
                goods.getGdesc(), goods.getIs_hot(), goods.getCid(),
                goods.getId());
    }

    // 根据id获取一个商品
    public Goods getGoodsWithId(int id) throws SQLException {
        String sql = "select * from goods where id = ?";
        return runner.query(sql, new BeanHandler<Goods>(Goods.class), id);
    }

    // 查询一共有多少条数据
    public Long getCount() throws SQLException {
        String sql = "select count(*) from goods";
        Long count = (Long) runner.query(sql, new ScalarHandler());
        return count;
    }

    public List<Goods> getPageData(Integer index, int pageSize) throws SQLException {
        String sql = "select * from goods limit ?, ?";
        return runner.query(sql, new BeanListHandler<Goods>(Goods.class), index, pageSize);
    }
}
