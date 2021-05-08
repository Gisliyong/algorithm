package com.sort.practice;

public class PMerge {
    public static void mergeSort(int arr[]) {
        if (arr == null || arr.length == 1) {
            return;
        }
        process(arr,0, arr.length -1);
    }
    public static void merge(int arr[], int L, int mid, int R) {
        int help[] = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int cnt = 0;
        while (p1 <= mid && p2 <= R) {
            help[cnt++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[cnt++] = arr[p1++];
        }
        while (p2 <= R) {
            help[cnt++] = arr[p2++];
        }
        for (cnt = 0;cnt < help.length;cnt++) {
            arr[cnt + L] = help[cnt];
        }
    }
    public static void process(int arr[], int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr,L,mid );
        process(arr,mid + 1, R);
        merge(arr,L,mid, R);
    }
    public static int[] generator(int maxValue, int maxSize) {
        int size = (int) (Math.random() * maxValue);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * maxSize * maxValue) - (int) (Math.random() * 1000) + (int) (Math.random() * maxValue);
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[]  = generator(30,30);
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

}
