package com.yejing.exercise.collection;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class ListTest {
    @Resource
    private String a;

    @Test
    public void test(){
        int[] a = {1, 2, 3, 4, 5};
        for(int e : a){
            System.out.println(e);
        }
        List<String> b = new ArrayList<>();
        b.add("a");
        b.add("b");
        b.add("c");
        for(int i=0; i<b.size(); i++){
            System.out.println(b.get(i));
        }
    }
}
