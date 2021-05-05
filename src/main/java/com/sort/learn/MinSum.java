package com.sort.learn;

/**
 * @Description: 小和问题
 * @author: liyong
 */

 /**
  * 给定一个数组，将每个数据左边比自己小的数进行累加，最终累加到sum,求这个值
  * arr 2 1 0 8 6 3
  * 0 + 0 + 0 + 3 + 3 + 3 = 9
  * 利用归并排序解题
  */

public class MinSum {
    /**
     * 思路：
     * 相等时，先拷贝左边
     * 拷贝右组数时不产生小和，左组拷贝产生小和
     */
    private static int sum = 0;
    public static void merge(int arr[], int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] == arr[p2]) {
                help[i++] = arr[p2++];
            } else if (arr[p1] > arr[p2]) {
                help[i++] = arr[p2++];
            } else if (arr[p1] < arr[p2]){
                sum += arr[p1] * (R - p2 + 1);
                help[i++] = arr[p1++];
            }
//            help[i++] = (arr[p1] <= arr[p2])?arr[p1++]:arr[p2++];
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
    public static int getMinSum() {
        int arr[] = {4,3,5,7,2,8,6,4};
        int arr1[] = {2,1,0,8,6,3};
        mergeSort(arr1);
       return sum;
    }

     public static void main(String[] args) {
         getMinSum();
         System.out.println("\n");
         System.out.println(sum);
     }
}
