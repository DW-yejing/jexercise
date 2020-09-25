package com.yejing.exercise.thread;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class ThreadTest {
    void test2(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ExecutorService fixedThreadPoool = Executors.newFixedThreadPool(5);

        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

    }

    void test1(){
        Thread a = new Thread(()->{
            System.out.println(System.currentTimeMillis());
        });
        a.start();
    }
}
