package com.yejing.exercise.proxy;

import com.yejing.exercise.service.HelloWorld;
import com.yejing.exercise.service.impl.HelloWorldImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProxyFactoryTest {

    @Test
    public void newInstance() throws Exception{
        Class helloworld = Class.forName("com.yejing.exercise.service.HelloWorld");
        ProxyFactory<HelloWorld> proxyFactory = new ProxyFactory<>(helloworld);
        ProxyHandler proxyHandler = new ProxyHandler(new HelloWorldImpl());
        HelloWorld h = proxyFactory.newInstance(proxyHandler);
        h.sayHello();

    }
}