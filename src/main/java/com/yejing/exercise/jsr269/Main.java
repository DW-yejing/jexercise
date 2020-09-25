package com.yejing.exercise.jsr269;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("success");
        test();
    }

    @Yejing(value = "method is test")
    public static void test()throws Exception{

    }
}
