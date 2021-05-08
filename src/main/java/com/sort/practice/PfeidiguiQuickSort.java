package com.sort.practice;

import com.sort.learn.BubbleSort;

import java.util.Arrays;
import java.util.Stack;

public class PfeidiguiQuickSort {
    static class Bound {
        int start;
        int end;
        public Bound(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int[] partition(int arr[], int L, int R) {
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr,index++,++less);
            } else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more,R);
        return new int[] {less+ 1,more};
    }
    public static void quickSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        Stack<Bound> stack = new Stack<>();
        int [] bound = partition(arr,0, arr.length -1);
        stack.push(new Bound(0,bound[0] -1));
        stack.push(new Bound(bound[1] + 1, arr.length - 1));
        while (!stack.isEmpty()) {
            Bound op = stack.pop();
            if (op.start < op.end) {
                swap(arr,(op.start + (int)(Math.random() * (op.end - op.start + 1))), op.end);
                int subBound[] = partition(arr,op.start, op.end);
                stack.push(new Bound(op.start,subBound[0] -1));
                stack.push(new Bound(subBound[1] + 1, op.end));
            }
        }
    }
    public static void merge(int arr[], int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        // 拷贝回去
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
    public static void mergeSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < arr.length) {
            int L = 0;
            while (L < N) {
                // 左组的边界
                int M = L + mergeSize - 1;
                // 如果左组都不够，下次合并
                if (M >= N) {
                    break;
                }
                // 边界条件
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize * 2 > N) {
                break;
            }
            mergeSize *= 2;

        }
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
    public static void main(String[] args) {
      int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int arr[] = generator(1000,1000);
            int arr2[] = copyArray(arr);
            int arr3[] = copyArray(arr);
            mergeSort(arr);
            quickSort(arr2);
            Arrays.sort(arr3);
            if(!isEqual(arr,arr3) || !isEqual(arr2,arr3)) {
                System.out.println("eroor");
            }
        }
    }
}
