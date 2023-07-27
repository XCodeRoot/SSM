package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {

    @Test
    public void TestGetUserByUsername(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("admin1");
        System.out.println(user);
    }

    @Test
    public void TestCheckLogin(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin2","123456");
        System.out.println(user);
    }

    @Test
    public void TestCheckLoginByMap(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","12345");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void TestInsertUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(null,"root","123",21,"男","1@qq.com");
        mapper.insertUser(user);
    }

    @Test
    public void TestCheckLoginByParam(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("admin2","123456");
        System.out.println(user);
    }
}
