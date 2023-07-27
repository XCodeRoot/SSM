package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流 org.apache.ibatis.io  的 Resources
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取 SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        //获取 SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql 的会话对象sqlSession ,是MyBatis提供的操作数据库的对象
        //参数设置为自动提交事务 ,这样就不用每次执行完一个sql语句就执行一次手动提交了
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//以上将会被封装=========================================================================
        //获取UserMapper接口的 代理实现对象 (提供代理模式,创建了UserMapper的代理实现类
        //其实底层实现接口,就是重写方法,这里底层自动 通过UserMapper接口的全类名 找到 对应的映射文文件
        //再根据 接口里的方法 找到 映射文件里的sql语句 ,来执行 ,并返回结果
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//底层 会创建接口的实现类 ,然后返回这个实现类的对象
        //调用Mapper接口中的方法,实现添加用户信息的功能
        int result= mapper.insertUser();
        System.out.println("结果= " +result);
        //sqlSession.commit();//如果事务没有提交,则自动回滚事务 ,需要在获取sqlSession时,开启自动提交,即,参数设置为true
        sqlSession.close();//关闭会话
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();//封装好了,直接调用
        //或去UserMapper接口的代理实现对象,自动完成方法重写
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser();
        System.out.println("结果="+result);
        sqlSession.close();
    }

    @Test
    public void testdelete(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();//封装好了,直接调用
        //或去UserMapper接口的代理实现对象,自动完成方法重写
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser();
        System.out.println("结果="+result);
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();//封装好了,直接调用
        //或去UserMapper接口的代理实现对象,自动完成方法重写
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User result = mapper.getUserById();
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession= SqlSessionUtil.getSqlSession();//封装好了,直接调用
        //或去UserMapper接口的代理实现对象,自动完成方法重写
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
        sqlSession.close();
    }
}
