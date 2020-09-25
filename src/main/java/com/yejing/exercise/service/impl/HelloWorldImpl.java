package com.yejing.exercise.service.impl;

import com.yejing.exercise.service.HelloWorld;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class HelloWorldImpl extends ArrayList<String> implements HelloWorld, RandomAccess {

    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
