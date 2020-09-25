package com.yejing.exercise.controller;

import com.yejing.exercise.model.ResponseTarget;
import com.yejing.exercise.service.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private HelloWorld userService;

    @GetMapping("/user/queryUserById")
    @ResponseBody
    private String queryUserById(){
        userService.sayHello();
        return null;
    }


    @RequestMapping("/{a}/test")
    @ResponseBody
    public ResponseTarget add(HttpServletRequest httpServletRequest, @PathVariable("a") String a){
        System.out.println("hello world");
        return null;
    }
}
