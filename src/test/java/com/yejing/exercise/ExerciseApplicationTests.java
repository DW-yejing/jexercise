package com.yejing.exercise;

import com.yejing.exercise.config.YJAspectConfigTest;
import com.yejing.exercise.service.HelloWorld;
import com.yejing.exercise.service.impl.HelloWorldImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.yejing"})
public class ExerciseApplicationTests {

    @Autowired
    private HelloWorld helloWorld;
    @Test
    public void contextLoads() {
        helloWorld.sayHello();
    }

    @Test
    public void test1(){
        String a = "adsa.adsf";
        Pattern pattern = Pattern.compile("(.)");
        Matcher matcher = pattern.matcher(a);
        while (matcher.find()){
            String c = matcher.group();
            System.out.println(c);
        }
        return;
    }

}
