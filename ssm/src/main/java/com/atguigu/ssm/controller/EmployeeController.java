package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.atguigu.ssm.service.impl.EmployeeServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/** 所有功能的 rest风格路径
 *
 *      查询所有员工信息 /employee  --> get
 *      查询所有员工的分页信息 /employee/page/1  --> get
 *      根据id查询所有员工信息 /employee/1  --> get
 *      跳转到添加页面 /to/add  --> get
 *      添加员工信息 /employee  --> post
 *      修改员工信息 /employee  --> put
 *      删除员工信息 /employee/1  --> delete
 *
 */


@Controller
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    /** 查询所有员工的分页信息 /employee/page/1  --> get
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getAllEmployee(@PathVariable("pageNum")Integer pageNum, Model model){
        //获取分页信息 , 通过调用service查询结果,返回分页好的数据
        PageInfo<Employee> page=employeeService.getEmployeePage(pageNum);//查出来的结果集 返回给分页功能的对象
        //将分页信息 , 共享到域中
        model.addAttribute("page",page);
        //跳转
        return "employee_list";
    }


    /** 查询所有员工信息 /employee  --> get
     *
     * @param model
     * @return
     */
//    @RequestMapping(value = "/employee",method = RequestMethod.GET)
//    public String getAllEmployee(Model model){
//        //查询所有员工信息
//        List<Employee>list = employeeService.getAllEmployee();
//        model.addAttribute("list",list);
//        //跳转 到 employee_list.html
//        return "employee_list";
//    }
}
