package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(value = {"/test","/abc"})
public class TestRequestMappingController {

    @RequestMapping(
            value = "/hello",
            method = {RequestMethod.GET ,RequestMethod.POST} ,
            params = "username")
    public String hello(){ //当前控制器方法 所匹配的访问路径是 /test/hello
        return "success";
    }


    @RequestMapping("/a*b/test/hello")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id ,@PathVariable("username") String username){//获取 路径中 的 参数值

        System.out.println("id="+id);
        System.out.println("username="+username);

        return "success";
    }
}
