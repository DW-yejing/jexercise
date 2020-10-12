package com.yejing.exercise.reactor;

import com.yejing.exercise.exercise.ClassA;
import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactorTest {

    @Test
    public void test1(){
        Flux.just("tom", "jack", "allen")
                .filter(s->s.length()>3)
                .map(s->s.concat("@gmail.com"))
                .subscribe(System.out::println);
    }
}
