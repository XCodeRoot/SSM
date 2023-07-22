package com.atguigu.controller;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpolyeeController {


    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        //获取员工信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        //将所有的员工信息 在请求域共享
        model.addAttribute("allEmployee",allEmployee);
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //重定向到 列表功能
        return "redirect:/employee";
    }
}
