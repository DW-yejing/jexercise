package com.yejing.exercise.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloWorldCGLibProxy implements MethodInterceptor {
    private Object target;

    public HelloWorldCGLibProxy(Object target){
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib动态代理开始");
        Object result = method.invoke(target, objects);
        System.out.println("CGLib动态代理结束");
        return result;
    }
}
