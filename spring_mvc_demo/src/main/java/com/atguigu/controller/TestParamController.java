package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public  String getParamByServletAPI(HttpServletRequest req){
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        return "success";
    }


    @RequestMapping("/param")
    public String getParamByServletAPI(
            @RequestParam(value = "username",required = false ,defaultValue = "hello") String name,
            String password ,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionid )
    {
/*        String username = req.getParameter("username");
        String password = req.getParameter("password");*/
        System.out.println("refer="+referer);
        System.out.println("JSESSIONID="+jsessionid);
        System.out.println("username="+name +"  password="+password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPoJo(User user){ //设置一个实体类 ,将所有请求参数 自动装配进 实体里 同名的属性 中
        System.out.println(user);
        return "success";
    }
}
