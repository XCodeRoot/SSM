package com.atguigu.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {//构造器是关键,一切步骤都是围绕,构造器获取到的目标对象来进行代理
        this.target = target;
    }

    public Object getProxy(){
        /**
         * newProxyInstance()：创建一个代理实例
         * 其中有三个参数：
         * 1、classLoader：加载动态生成的代理类的类加载器(应用类加载器)
         * 2、interfaces：目标对象实现的所有接口的class对象所组成的数组
         * 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
         */
        ClassLoader classLoader =target.getClass().getClassLoader();//目标对象的类加载器
        Class<?>[] interfaces = target.getClass().getInterfaces();//目标类实现的接口的class对象 ,组成的数组
        InvocationHandler h=new InvocationHandler() { //这里是用匿名内部类实现 InvocationHandler接口
            //invoke这个方法,就是在使用代理对象调用目标方法的过程中,进行功能追加
            //代理方法的实际功能,就是写在这个invoke方法里
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy表示当前的代理对象,method表示目标方法,args[]表示目标方法所需的参数列表
                Object result = null;
                try {
                    System.out.println("日志,方法:"+method.getName()+",参数:"+ Arrays.toString(args));
                    result = method.invoke(target, args);//method.invoke()表示调用目标方法,args表示目标方法的参数列表
                    System.out.println("日志,方法:"+method.getName()+",结果:"+ result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("日志,方法:"+method.getName()+",异常:"+e);
                }finally {
                    System.out.println("日志,方法:"+method.getName()+",方法执行完毕");
                }
                return result;
            }
        };

        return   Proxy.newProxyInstance(classLoader,interfaces,h);

    }
}
