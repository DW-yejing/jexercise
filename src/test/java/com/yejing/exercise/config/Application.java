package com.yejing.exercise.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(InternationalConfig.class);
        Object[] params = {"a", "b", "c"};
//        String str1 = ac.getMessage("test", params, Locale.US);
        String str2 = ac.getMessage("test", params, Locale.CHINA);
//        System.out.println(str1);
        System.out.println(str2);
    }


}
