package com.yejing.exercise.sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {
    @Test
    public void test1(){
        int[] a = {5,1,6,2,7,8};
        a = sort(a);
        System.out.println(a);
    }

    public int[] sort(int[] arr){
        if(arr.length<2){
            return arr;
        }
        int index = arr.length>>1;
        int[] left = Arrays.copyOfRange(arr, 0, index);
        int[] right = Arrays.copyOfRange(arr, index, arr.length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int r = 0, i = 0, j = 0;
        while(i<left.length && j<right.length){
            result[r++] = left[i]<right[j]? left[i++] : right[j++];
        }
        while(i<left.length){
            result[r++] = left[i++];
        }
        while(j<right.length){
            result[r++] = right[j++];
        }
        return result;

    }
}
