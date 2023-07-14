package com.atguigu.spring.proxy;

import org.junit.Test;

public class ProxyTest {
    @Test
    public void test(){
//        CalculatorStaticProxy proxy=new CalculatorStaticProxy(new CalculatorImpl());
//        proxy.add(1,3);

        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        //此时我们并不知道获取到的代理类的类型,但是我们知道这个代理类实现了什么接口,所以用向下转型,使用接口接收这个代理对象
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(1,0);
    }
}
