package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /** 根据id 查询用户信息
     *
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /** 查询所有用户信息
     *
     * @return
     */
    List<User> getAllUser();


    /** 查询总记录数
     *
     * @return
     */
    Integer getCount();


    /** 将一行多列的数据 放在 Map集合里 , 而没有对应的实体类
     *
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);


    /** 将多行多列的数据 放在 以map为对象的List集合里 , 而不是使用 实体类集合
     *
     * @return
     */
    List<Map<String,Object>> getAllUserToMap();
   /* @MapKey("id")
    Map<String,Object> getAllUserToMap();*/
}
