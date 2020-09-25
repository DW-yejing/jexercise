package com.yejing.exercise.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BeanB {

    public void testB(){
        System.out.println("beanB init:"+this);
    }
}
