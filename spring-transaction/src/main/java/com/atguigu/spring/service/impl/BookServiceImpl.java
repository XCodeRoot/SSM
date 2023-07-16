package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    @Transactional(
            //isolation = Isolation.DEFAULT
            //propagation事务的传播行为
            //本质是 不使用当前线上已有的事务,而是自己使用一个新开辟的事务,执行注解下的方法
            propagation = Propagation.REQUIRES_NEW //最终表现就是 : 不使用结账的事务,而是使用买书本身的事务
    )
    public void buyBook(Integer userId,Integer bookId){
        //查询图书价格
        Integer price =bookDao.getPriceByBookId(bookId);
        //更新图书库存
        bookDao.updateBook(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
