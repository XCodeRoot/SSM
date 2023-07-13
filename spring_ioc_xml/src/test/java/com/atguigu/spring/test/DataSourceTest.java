package com.atguigu.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {




    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);//可以用实现类的类型Druid.class获取bean,也可以用接口dataSource.class
        System.out.println(dataSource.getConnection());


    }
}
