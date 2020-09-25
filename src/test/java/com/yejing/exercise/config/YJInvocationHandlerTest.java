package com.yejing.exercise.config;

import com.yejing.exercise.service.HelloWorld;
import com.yejing.exercise.service.impl.HelloWorldImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class YJInvocationHandlerTest {

    public static void main(String[]args) throws Exception {
        // 这里有两种写法，采用复杂的一种写法，有助于理解。
        Class<?> proxyClass= Proxy.getProxyClass(YJInvocationHandlerTest.class.getClassLoader(), HelloWorld.class);
        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler ih = new YJInvocationHandler(new HelloWorldImpl());
        HelloWorld helloWorld = (HelloWorld)cons.newInstance(ih);
        helloWorld.sayHello();

    }

}