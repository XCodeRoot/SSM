package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /** 查询员工所有信息
     *
     * @return
     */
    List<Employee> getAllEmployee();
}
