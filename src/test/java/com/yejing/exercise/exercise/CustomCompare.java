package com.yejing.exercise.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomCompare <T>implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return -1;
    }

    public CustomCompare(String a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.sort(new CustomCompare("hello"));
        System.out.println(list);
        try {
            LockTest lockTest = LockTest.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
