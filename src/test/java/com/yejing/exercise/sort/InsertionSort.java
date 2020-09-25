package com.yejing.exercise.sort;

import org.junit.Test;

public class InsertionSort {

    @Test
    public void test1() {
        int[] a = {5, 1, 6, 2, 7, 3, 8};
        sort(a);
        System.out.println(a);
    }

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
