package com.atguigu.controller;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id")Integer id,Model model){
        //根据id查询员工信息
        Employee employee = employeeDao.get(id);
        //共享到域中
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        //保存修改
        employeeDao.save(employee);
        //重定向到列表功能
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id")Integer id){
        //删除
        employeeDao.delete(id);
        return "redirect:/employee";
    }
}
