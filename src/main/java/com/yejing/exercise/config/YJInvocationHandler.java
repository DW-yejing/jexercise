package com.yejing.exercise.config;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class YJInvocationHandler implements InvocationHandler {

    private Object target;

    public YJInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method :" + method.getName() + " is invoked!");
        //before();
        Object object = method.invoke(target, args); // 执行相应的目标方法
        //after();
        return object;
    }
}
