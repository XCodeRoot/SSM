package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {


    /** 根据empId 查询员工信息
     *
     * @param empId
     * @return
     */
    Emp getEmpById(@Param("empId") Integer empId);
}
