package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/") //只要 浏览器的请求 和当前设置的请求映射 路径是一样的 ,就会执行这个portal方法
    public String portal(){//portal 入口 , " / " 被 服务器解析为 http://localhost:8080/SpringMVC/
        //返回逻辑视图 ,由视图解析器 , 在其前面补上 视图前缀 ,在后面补上 视图后缀
        //这个路径是 /WEB-INF/templates/目录下的index.html ,不是 webapp里的首页index.html
        return "index";
    }

    @RequestMapping("/hello") // 会被服务器解析成 http://localhost:8080/SpringMVC/hello
    public String hello(){
        return "success";//返回的逻辑视图 会交给视图解析器 ,打包成完好物理路径(就是当前工程路径) ,然后渲染页面,实现页面跳转
    }
}


