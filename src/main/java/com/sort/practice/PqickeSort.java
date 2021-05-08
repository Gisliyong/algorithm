package com.sort.practice;

import com.sort.learn.QuickSort;

public class PqickeSort {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] partition(int arr[], int L, int R) {
        if (L > R) { // L...R L>R
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1; // < 区 右边界
        // 最后一个数不参与
        int more = R; // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr,more,R);
        return new int[] {less + 1,more};
    }
    public static void quickSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
       process(arr,0,arr.length - 1);
    }
    public static void process(int arr[],int L ,int R) {
        if(L >= R) {
            return;
        }
        swap(arr,(L + (int)(Math.random() * (R - L + 1))), R);
        int[] bound = partition(arr, L, R);
        process(arr,L,bound[0] - 1);
        process(arr,bound[1] + 1,R);
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,6,5};
        quickSort(arr);
        System.out.println("finsh!");
    }
}
