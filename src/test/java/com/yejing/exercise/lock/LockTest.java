package com.yejing.exercise.lock;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.*;

public class LockTest {
    private static final String el = "/exclusive_lock/lock";
    private static ZkClient zkClient = new ZkClient("127.0.0.1:2181", 3000);
    private static ExecutorService pool = new ThreadPoolExecutor(5,100, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    public static void main(String[] args) throws Exception {
        for(int i=0; i<20; i++){
            pool.execute(new Thread(){
                @Override
                public void run() {
                    while(true){
                        if(getLock()){
                            //todo 获取锁进行操作
                            System.out.println("正在进行运算操作：" + System.currentTimeMillis());
                            zkClient.delete(el);
                            break;
                        }
                    }
                }
            });
        }


    }

    public  static boolean getLock(){
        try{
            zkClient.createEphemeral(el, null);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
