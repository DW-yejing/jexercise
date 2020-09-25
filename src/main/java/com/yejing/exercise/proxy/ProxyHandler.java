package com.yejing.exercise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler<T> implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object o){
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(object, args);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
