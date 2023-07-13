package com.atguigu.spring.test;

import com.atguigu.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    @Test
    public void test(){
        //获取IOC容器
        //因为 resources 和 java 会被加载到同一个目录下 ,就是类路径下  ,所以可以直接访问咯
        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
        //以 id 获取 IOC容器中的 bean对象
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        helloworld.sayHello();
    }
}
