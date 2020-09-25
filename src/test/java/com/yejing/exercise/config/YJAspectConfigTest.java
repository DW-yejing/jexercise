package com.yejing.exercise.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
/*@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.yejing.exercise.config"})*/
@Service
public class YJAspectConfigTest {
    public void testAspect(){
        System.out.println("test aspect");
    }
}