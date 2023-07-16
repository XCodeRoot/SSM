package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect //将当前组件 标识为一个 切面
@Order(1)//将当前切面优先级 设置为最高
public class LoggerAspect {

    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){

    }

    //@Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int,int))")
    //@Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点 对应方法 的方法名
        Signature signature =  joinPoint.getSignature();
        //获取连接点 对应方法 的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,前置通知,方法:"+signature.getName()+",参数:"+ Arrays.toString(args));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点 对应方法 的方法名
        Signature signature =  joinPoint.getSignature();
        System.out.println("LoggerAspect,返回通知(在目标方法执行成功之后 执行),方法:"+signature.getName()+",结果:"+result);
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点 对应方法 的方法名
        Signature signature =  joinPoint.getSignature();
        System.out.println("LoggerAspect,后置通知(即finally里),方法:"+signature.getName()+",执行完毕");
    }

    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //获取连接点 对应方法 的方法名
        Signature signature =  joinPoint.getSignature();
        System.out.println("LoggerAspect,异常通知(即catch里),异常:"+ex);
    }

    @Around(value = "pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){//这个ProceedingJoinPoint接口相当于目标方法的执行
        //
        Object result=null;
        try {
            System.out.println("环绕通知-->前置通知");
            //等于手动版 动态代理 里 的 Object result = method.invoke(target,args)
            result = joinPoint.proceed();//表示执行了目标方法
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知,异常:"+e);
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}
