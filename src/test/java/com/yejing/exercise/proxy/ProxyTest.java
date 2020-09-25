package com.yejing.exercise.proxy;

import com.yejing.exercise.service.HelloWorld;
import com.yejing.exercise.service.impl.HelloWorldImpl;
import com.yejing.exercise.util.ProxyUtils;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    public void test2(){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
        HelloWorld helloWorld = new HelloWorldImpl();
        HelloWorldCGLibProxy helloWorldCGLibProxy = new HelloWorldCGLibProxy(helloWorld);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorld.class);
        enhancer.setCallback(helloWorldCGLibProxy);
        HelloWorld a = (HelloWorld)enhancer.create();
        a.sayHello();
    }

    @Test
    public void test1(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloWorldImpl helloWorld = new HelloWorldImpl();
        InvocationHandler invocationHandler = new HelloWorldProxy(helloWorld);
        HelloWorld proxy = (HelloWorld)Proxy.newProxyInstance(this.getClass().getClassLoader(), helloWorld.getClass().getInterfaces(), invocationHandler);
        proxy.sayHello();
//        ProxyUtils.generateClassFile(helloWorld.getClass(), "HelloWorldProxyByteCode");
    }
}
