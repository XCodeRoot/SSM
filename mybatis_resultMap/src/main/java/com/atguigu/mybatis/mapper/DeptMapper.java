package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /** 通过分步查询 ,员工和其部门的信息 第二步
     *
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId")Integer deptId);


    /** 处理一对多 , 根据部门查询其部门的所有员工信息
     *
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId")Integer deptId);


    /** 通过分步查询  查询部门及 其部门里所有员工的信息 第一步
     *
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId")Integer deptId);
}
