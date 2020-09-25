package com.yejing.exercise.Object;

import com.yejing.exercise.service.HelloWorld;

public class ObjectInstance {
    // new方式实例化对象
    public void newInstance(){

    }

    //
    public void forNameInstance(){
        try {
            Class c = Class.forName("com.yejing.exercise.service.HelloWorld");
            c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
