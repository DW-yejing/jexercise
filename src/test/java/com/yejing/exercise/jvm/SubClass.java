package com.yejing.exercise.jvm;

public class SubClass implements SubInterface {
    @Override
    public void t1127() {
        System.out.println("11");
    }

    public int t1128(){
        if(true){
            System.out.println("aa");
        }else{
            System.out.println("bb");
        }
        return 11;
    }

}
