package com.yejing.exercise.proxy;

import com.yejing.exercise.service.HelloWorld;
import com.yejing.exercise.service.impl.HelloWorldImpl;
import com.yejing.exercise.util.ProxyUtils;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void test1(){
        HelloWorldImpl helloWorld = new HelloWorldImpl();
        InvocationHandler invocationHandler = new HelloWorldProxy(helloWorld);
        HelloWorld proxy = (HelloWorld)Proxy.newProxyInstance(this.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello();
        ProxyUtils.generateClassFile(helloWorld.getClass(), "HelloWorldProxyByteCode");
    }
}
