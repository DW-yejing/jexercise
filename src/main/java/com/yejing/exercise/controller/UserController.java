package com.yejing.exercise.controller;

import com.yejing.exercise.model.ResponseTarget;
import com.yejing.exercise.service.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.servlet.http.HttpServletRequest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @RequestMapping("/reactor/msg-push")
    @ResponseBody
    public Flux<String> messagePush(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        /*return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(1)).map(t->dateTimeFormatter.format(LocalDate.now())), String.class
        );*/
//        return Mono.just(dateTimeFormatter.format(LocalDateTime.now()));
        return Flux.interval(Duration.ofSeconds(1)).map(t->dateTimeFormatter.format(LocalDateTime.now())+"<br/>");
    }
}
