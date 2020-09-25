package com.yejing.exercise.config;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect // FOR AOP
//@Order(-99) // 控制多个Aspect的执行顺序，越小越先执行
@Component
public class YJAspectConfig {
    @Before("execution(* com.yejing.exercise.service.impl.HelloWorldImpl.sayHello())")
    public void beforeTest() {
        System.out.println("执行 方法 之前 调用----");
    }

    @After("execution(* com.yejing.exercise.service.impl.HelloWorldImpl.sayHello())")
    public void afterTest() {
        System.out.println("执行 方法 之后 调用----");
    }



}
