package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

    /** 通过用户名 获取用户信息
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);


    /** 验证登录信息
     *
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /** 验证登录 ( 以map集合作为参数)
     *
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);


    /** 添加用户信息
     *
     * @param user
     */
    void insertUser(User user);


    /** 检查登录信息
     * 通过注解 设置自定义的 key
     *
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username") String username , @Param("password") String password);

}
