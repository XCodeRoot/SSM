package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id,@RequestBody String requestBody,  HttpServletResponse response) throws IOException {
        System.out.println("requestBody"+requestBody);
        System.out.println("id:"+id);
        response.getWriter().write("hello,axios");//输出到浏览器控制台
    }

    //@RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        //这个注解 就可以把json字符串转换为java对象,不需要我们手动转换,太复杂了
        System.out.println(user);
        response.getWriter().write("hello,RequestBody");//输出到浏览器控制台
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        //这个注解 就可以把json字符串转换为java对象,不需要我们手动转换,太复杂了
        System.out.println(map);
        response.getWriter().write("hello,RequestBody");//输出到浏览器控制台
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    /*@RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public Map<String,Object> testResponseBodyJson(){
        User user1=new User(1001,"admin","123456",20,"女");
        User user2=new User(1002,"admin","123456",20,"女");
        Map<String,Object> map=new HashMap<>();
        map.put("1001",user1);
        map.put("1002",user2);
        return map;
    }*/
    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson(){
        User user1=new User(1001,"admin","123456",20,"女");
        User user2=new User(1002,"admin","123456",20,"女");
        List<User> list = Arrays.asList(user1, user2);
        return list;
    }
    /*@RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBodyJson(){
        User user=new User(1001,"admin","123456",20,"女");
        return user;
    }*/

}
