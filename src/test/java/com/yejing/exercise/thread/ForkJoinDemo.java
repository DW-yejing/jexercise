package com.yejing.exercise.thread;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架demo
 * Created by T430 on 2017/8/14.
 */
public class ForkJoinDemo {

    private static  int THRESLOD=30000;//任务阈值

    /**
     * 求1到100万之间的和，因为需要返回结果，所以需要继承recursiverTask
     */
    static class  MC extends RecursiveTask<Long>{

        Long sum = Long.valueOf(0);

        private  int begin,end;
        private ArrayList<Long> dataList;

        public MC(int begin, int end, ArrayList<Long> dataList){
            this.begin=begin;
            this.end=end;
            this.dataList = dataList;
        }

        //表示这个任务完成后，返回的一个值
        @Override
        protected Long compute() {

            //如果任务量小于阈值，就直接计算
            if ((end-begin)<=THRESLOD){
                for (int i = begin; i <end ; i++) {
                    sum +=dataList.get(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else{//如果大于1000， 就把他拆分成两个子任务进行fork

                int mid= (end+begin)/2;

                MC left=new MC(begin,mid, dataList);//一部分小线程
                left.fork();//开启这小部分线程

                MC right= new MC(mid,end, dataList);

                right.fork();


                Long li= left.join();//让left任务完整完成

                Long lr= right.join();//让right任务完整完成

                sum=li+lr;

            }
            return sum;
        }
    }
    private ArrayList<Long> dataList = new ArrayList<>();
    private int randomSize = 10001;

    public static void main(String[] args) throws  Exception{
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo();
        for(int i=0; i<forkJoinDemo.randomSize; i++){
            forkJoinDemo.dataList.add(RandomUtils.nextLong(0, forkJoinDemo.randomSize));
        }
        long t1 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool =new ForkJoinPool();//创建他的线程池

//        Future<Long> ft=forkJoinPool.submit(new MC(0,100001));//在线程池中进行计算
        Long a = forkJoinPool.invoke(new MC(0,forkJoinDemo.randomSize, forkJoinDemo.dataList));
        long t2 = System.currentTimeMillis();
        System.out.println("多线程计算的结果是："+ a);
        System.out.println("耗时： "+(t2-t1));
        forkJoinPool.shutdown();//关闭线程池

        long sum = 0;
        t1 = System.currentTimeMillis();
        for(Long e : forkJoinDemo.dataList){
            sum += e;
            Thread.sleep(1);
        }
        t2 = System.currentTimeMillis();
        System.out.println("计算的结果是："+ sum);
        System.out.println("耗时： "+(t2-t1));

    }

    @Test
    public void test1() {
        long a = 0;
        long t1 = System.currentTimeMillis();
        for(int i=0; i<100001; i++){
            a +=i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("计算的结果是："+a);
        System.out.println("耗时： "+(t2-t1));
    }
}