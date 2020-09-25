package com.yejing.exercise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    public void testA(){
        System.out.println("beanA init:"+this);
        getBeanB().testB();
    }
    @Lookup
    public BeanB getBeanB(){
        return null;
    }
}
