package com.atguigu.spring.dao;

public interface BookDao {

    Integer getPriceByBookId(Integer bookId);

    void updateBook(Integer bookId);

    void updateBalance(Integer userId, Integer price);


}
