package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestRestController {

    //@RequestMapping(value = "/user",method = RequestMethod.GET )
    @GetMapping("/user")
    public String getAllUser(){
        System.out.println("查询所有用户信息--> /user --> get");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.GET )
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer userId){
        System.out.println("查询所有用户信息--> /user/"+userId+"--> get");
        return "success";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String insertUser(){
        System.out.println("添加用户信息--> /user-->post");
        return "success";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser(){
        System.out.println("修改用户信息--> /user-->put");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer userId){
        System.out.println("删除用户信息--> /user/"+userId+"-->delete");
        return "success";
    }
}
