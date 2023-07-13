package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean("userController",UserController.class);
//        UserService userService = ioc.getBean("userServiceImpl",UserService.class);
//        UserDao userDao = ioc.getBean("userDaoImpl",UserDao.class);
//        System.out.println(userController+"\n"+userService+"\n"+userDao);
        userController.saveUser();
    }
}
