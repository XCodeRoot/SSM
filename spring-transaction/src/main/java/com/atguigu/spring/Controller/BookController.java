package com.atguigu.spring.Controller;

import com.atguigu.spring.service.BookService;
import com.atguigu.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckOutService checkOutService;

    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);
    }

    public void checkOut(Integer userId,Integer[] bookIds){
        checkOutService.check(userId,bookIds );

    }
}
