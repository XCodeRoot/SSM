package com.atguigu.spring.test;


import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//指定当前类,在spring的测试环境中执行,此时就可以通过注入的方式 直接获取IOC容器中的 bean ,
// 以往是先获取ioc容器,再通过ioc容器获取bean,再进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境 的配置文件
@ContextConfiguration("classpath:spring-jdbctemplate.xml")
public class jdbcTemplateTest {

    @Autowired //自动装配
    JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        String sql="insert into t_user(username,password,age,gender,email)values(?,?,?,?,?);";
        jdbcTemplate.update(sql,"root","123",23,"女","123@qq,com");
    }

    @Test
    public void testGetUserById(){
        String sql="select username,password,age,gender,email from t_user where id=? ";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), "2");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        String sql="select username,password,age,gender,email from t_user  ";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        String sql="select count(*) from t_user ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
