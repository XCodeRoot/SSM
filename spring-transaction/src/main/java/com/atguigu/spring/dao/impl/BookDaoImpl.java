package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;//使用JdbcTemplate 来获取数据源 ,自动装配到ioc了

    /** 根据图书编号 获取价格
     *
     * @param bookId
     * @return
     */
    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql="select price from t_book where book_id=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,bookId);
    }

    /** 根据图书编号 , 修改库存
     *
     * @param bookId
     */
    @Override
    public void updateBook(Integer bookId) {
        String sql="update t_book set stock=stock-1 where book_id=?";
        jdbcTemplate.update(sql,bookId);
    }

    /** 修改用户余额
     *
     * @param userId
     * @param price
     */
    @Override
    public void updateBalance(Integer userId, Integer price) {
        String sql="update t_user set balance=balance-? where user_id=?";
        jdbcTemplate.update(sql,price,userId);
    }
}
