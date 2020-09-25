package com.yejing.exercise.sort;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort {
    @Test
    public void tset1(){
        int[] a = {5,1,6,2,7,3,8};
        a = sort(a);
        System.out.println(a);
    }

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        int lastParentNodeIndex = len/2-1;
        for (int i = lastParentNodeIndex; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int c1 = 2*i+1;
        int c2 = 2*i+2;
        if(c1<len && arr[i]<arr[c1]){
            swap(arr, c1, i);
        }
        if(c2<len && arr[i]<arr[c2]){
            swap(arr, c2, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
