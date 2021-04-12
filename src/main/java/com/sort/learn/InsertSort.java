package com.sort.learn;

import java.util.Arrays;

public class InsertSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] generator(int maxValue, int maxSize) {
        int size = (int) (Math.random() * maxValue);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]  = (int)(Math.random() * maxSize * maxValue) - (int) (Math.random() * 1000) + (int) (Math.random() * maxValue);
        }
        return arr;
    }
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j -1);
            }
        }
    }
    public static void main(String[] args) {
        int maxValue = 1000;
        int testTime = 100000;
        int maxSize = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generator(maxValue, maxSize);
            int[] arr2 = copyArray(arr1);
            comparator(arr1);
            insertSort(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("error!");
            }
        }
        System.out.println("finsh!");
    }
}
