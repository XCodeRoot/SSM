package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void TestGetUserById(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
    }

    @Test
    public void TestGetAllUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users= mapper.getAllUser();
        users.forEach(System.out::println);
    }

    @Test
    public void TestGetCount(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count= mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void TestGetUserByIdToMap(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = mapper.getUserByIdToMap(2);
        System.out.println(map);
    }

    @Test
    public void TestGetAllUserToMap(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String,Object>> map = mapper.getAllUserToMap();
//        Map<String,Object> map=mapper.getAllUserToMap();
        System.out.println(map);
    }
}
