package com.atguigu.spring.proxy;

public class CalculatorStaticProxy implements Calculator{

    CalculatorImpl target;

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int result = target.add(i, j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int result = target.sub(i,j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int result = target.mul(i,j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return 0;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int result = target.div(i,j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return 0;
    }
}
