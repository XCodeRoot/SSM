package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /** 添加
     *
     * @return
     */
    int insertUser();

    /** 更新
     *
     * @return
     */
    int updateUser();

    int deleteUser();

    /** 根据id 查询单个用户信息
     *
     * @return 返回单行数据
     */
    User getUserById();

    /** 查询所有用户信息
     *
     * @return
     */
    List<User> getAllUser();
}
