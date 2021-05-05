package com.sort.learn;

/**
 * @Description: 归并排序
 * @author: liyong
 */
public class MergeSort {
    public static void merge(int arr[], int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = (arr[p1] <= arr[p2])?arr[p1++]:arr[p2++];
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
        process(arr,0,arr.length - 1);
   }
   public static void process(int arr[], int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L +((R -L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
   }
   public static void mergeSortDieDai(int arr[]) {
        int N = arr.length;
       for (int size = 1; size < arr.length; size *= 2) {
           // 一次合并
           int L = 0;
           while (L < N) {
               // 左组的边界
               int M = L + size - 1;
               // 如果左组都不够，下次合并
               if (M >= N) {
                   break;
               }
               // 边界条件
               int R = Math.min(M + size, N -1);
               merge(arr, L, M, R);
               L = R + 1;
           }
           // 防止溢出
           // 步长*2超过边界
           if (size > N / 2) {
               break;
           }
       }
   }
    public static void main(String[] args) {
        int arr[] = new int[] {4,1,3,2,5,0,88};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
