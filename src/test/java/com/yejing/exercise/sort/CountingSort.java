package com.yejing.exercise.sort;

import org.junit.Test;

public class CountingSort {
    @Test
    public void test2(){
        Integer b = 4;
        Integer c = Integer.parseInt("5")+b;
        int a = Math.round(5.5F);
        System.out.println(a);
    }


    @Test
    public void test1(){
        int[] a = {5,1,6,2,7,3,1,2,1,8};
        sort(a);
        System.out.println(a);
    }

    public void sort(int[] arr){
        int maxNumber = getMaxNumber(arr)+1;
        int[] bucket = new int[maxNumber];
        for(int i=0; i<arr.length; i++){
            bucket[arr[i]]++;
        }
        int index = 0;
        for(int i=0; i<bucket.length; i++){
            if(bucket[i]<1){
                continue;
            }
            for(; bucket[i]>0; bucket[i]--){
                arr[index++] =  i;
            }
        }
    }

    public int getMaxNumber(int[] arr){
        int max = arr[0];
        for(int item : arr){
            if(item>max){
                max = item;
            }
        }
        return max;
    }
}
