package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.mapper.SpecialSqlMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSqlMapperTest {

    @Test
    public void TestGetUserByLike(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void TestDeleteMoreUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        mapper.deleteMoreUser("6,7,8");
    }

    @Test
    public void TestGetUserList(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> list = mapper.getUserList("t_user");
        System.out.println(list);
    }

    @Test
    public void TestInsertUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "xiaoming", "123", 23,"女" ,"12@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
