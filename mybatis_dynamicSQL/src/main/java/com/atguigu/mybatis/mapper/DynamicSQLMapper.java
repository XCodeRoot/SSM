package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {


    /** 根据条件查询员工信息 ,
     *
     * @param emp 因为不确定用户到底需要什么条件 拼接到查询语句 , 所以参数为宽泛的类类型,这样可以涵盖所有拼接条件
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);


    /** 使用choose标签 查询员工信息
     *
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);



    /** 批量添加员工信息
     *
     * @param emps
     */
    void insertMoreEmp(@Param("emps") List<Emp> emps);


    /** 批量删除员工信息
     *
     * @param empIds
     */
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
