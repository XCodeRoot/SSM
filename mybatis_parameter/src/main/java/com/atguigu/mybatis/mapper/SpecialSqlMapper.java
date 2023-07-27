package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {

    /** 模糊查询
     *
     * @return
     */
    List<User> getUserByLike(String mohu);

    /** 批量删除 , 使用 in ()
     *
     * @param ids
     */
    void deleteMoreUser(@Param("ids") String ids);


    /** 动态设置表名
     *
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);


    /** 添加用户信息 ,并获取自增的主键
     *
     * @param user
     */
    void insertUser(User user);
}
