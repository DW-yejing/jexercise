package com.yejing.exercise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldProxy implements InvocationHandler {
    private Object target;

    public HelloWorldProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始");
        Object result = method.invoke(target, args);
        System.out.println("动态代理结束");
        return result;
    }
}
