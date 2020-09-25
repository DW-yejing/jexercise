package com.yejing.exercise.sort;

import org.junit.Test;

public class ShellSort {
    @Test
    public void test1(){
        int[] a = {5, 1,6,2,7,3,8,1,3,5,2,5,7,3,6,2,73,5,7,456,7};
        sort(a);
        System.out.println(a);
    }

    public void sort(int[] arr){
        int gap = arr.length>>1;
        while(gap >0){
            for(int g=0; g<gap; g++){
                for(int i=gap+g; i<arr.length; i+=gap){
                    int temp = arr[i];
                    int j = i-gap;
                    while(j>=0 && temp < arr[j]){
                        arr[j+gap] = arr[j];
                        j-=gap;
                    }
                    arr[j+gap] = temp;
                }
                gap = gap>>1;
            }
        }
    }
}
