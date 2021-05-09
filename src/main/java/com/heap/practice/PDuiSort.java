package com.heap.practice;

import java.util.Arrays;

public class PDuiSort {
    public static int limitSize;
    public static int [] data;
    public static void swap(int arr[],int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void  heapInsert(int arr[], int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr,index,(index - 1) / 2 );
            index = (index - 1) / 2;
        }
    }
    public static void  heapify(int arr[],int index,int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int biggerIndex = (left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left;
            biggerIndex = (arr[biggerIndex] > arr[index]) ? biggerIndex : index;
            if (biggerIndex == index) {
                break;
            }
            swap(arr,biggerIndex,index);
            index = biggerIndex;
            left = biggerIndex * 2 + 1;
        }
    }
    public static void heapSort(int arr[]) {
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            heapify(arr,i,arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr,0,i);
            heapify(arr,0,i);
        }
    }
    // 生成随机数组（用于测试）
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    // 对比两个数组（用于测试）
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
    // 拷贝数组（用于测试）
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
    public static void main(String[] args) {
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int arr1[] = generateRandomArray(1000,1000);
            int  arr2[] = copyArray(arr1);
            Arrays.sort(arr1);
            heapSort(arr2);
            if (!isEqual(arr1,arr2)) {
                System.out.println("error!");
            }
        }
    }
}
