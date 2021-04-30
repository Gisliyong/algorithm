package com.sort.practice;

public class Test {
    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j]  = temp;
    }
    /**
     * 选择排序
     **/
    public static void chooseSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }
    /**
     * 冒泡排序
     **/
    public static void bubbleSort(int arr[]) {
        for (int i = arr.length - 1; i >= 1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr [j + 1]) {
                    swap(arr,j,j + 1);
                }
            }
        }
    }
    /**
     * 插入排序
     **/
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j -1] ; j--) {
                swap(arr,j,j-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,7,2,5};

        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        
    }
}
