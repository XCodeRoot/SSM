package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Person;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest  {


    /**
     *
     */
    @Test
    public void testDI(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        //set注入
        //Student studentTwo = ioc.getBean("studentTwo", Student.class);
        //构造器注入
        //Student studentThree = ioc.getBean("studentThree", Student.class);
        //内部bean注入类类型
        Student studentFive = ioc.getBean("studentFive", Student.class);
//        System.out.println(studentFive);
        //list注入
        //Clazz clazzOne = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(studentFive);

    }



    /** 获取bean的三种方式:
     *      1.通过id获取
     *      2.通过类型.class获取
     *      3.通过id和类型.class同时获取
     *      4.如果组件实现了接口,可以通过接口类型获取bean
     */
    @Test
    public void testIOC(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        //Student studentOne = (Student) ioc.getBean("studentOne");//返回的是Object类型
        Student student = ioc.getBean(Student.class);//用的最多的
        //Student student = ioc.getBean("studentOne", Student.class);//
        Person person=ioc.getBean(Person.class);//可以通过接口兼容的类型获取到 bean对象 ,但不能仅仅通过单接口获取bean
        System.out.println(student+" "+person);

    }
}
