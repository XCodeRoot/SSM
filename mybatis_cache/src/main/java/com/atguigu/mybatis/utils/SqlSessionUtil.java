package com.atguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        try {
            //获取核心配置文件的输入流 org.apache.ibatis.io  的 Resources
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取 SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            //获取 SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取sql 的会话对象sqlSession ,是MyBatis提供的操作数据库的对象
            //参数设置为自动提交事务 ,这样就不用每次执行完一个sql语句就执行一次手动提交了
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;

    }
}
