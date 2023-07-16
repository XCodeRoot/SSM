package com.atguigu.spring.test;

import com.atguigu.spring.Controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-annotation.xml")
public class TxByAnnotationTest {

    @Autowired
    BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.checkOut(1,new Integer[]{1,2});
    }


}
