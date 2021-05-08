package com.heap.learn;

/**
 * @Description: 堆(数组实现)
 * @author: liyong
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/** 在Java中堆其实就是优先级队列 **/
public class Heap {
    private static int limitSize = 10000;
    private static int help[] = new int[limitSize];
    public Heap(int limitSize) {
        Heap.limitSize = limitSize;
        Heap.help = new int[limitSize];
    }
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /** 堆插入数据并调整 **/
    public static void heapInsert(int arr[], int index) {
        // index = 0 (index - 1) / 2 = 0也会是0
        while (arr[index] > arr[(index - 1)/2]) {
            swap(arr,index,(index - 1) / 2);
            index = (index - 1)/2;
        }
    }
    /** 删除堆顶 用最后一个位置和堆顶交换  **/
    /** 重新调整堆，取左右子树的较大者和当前位置交换 **/

    public static void heapify(int arr[],int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            // 无法再替换，退出
            if (largest == index) {
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
    /**
     *  先将整个数据调整为大根堆
     *  然后最大值和最后一个交换
     *  左heapify 此时最大值就去了应有的位置
     **/
    public static void heapSort(int arr[]) {
        if(arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }
        for (int i = 0; i < arr.length - 1; i++) {
            heapify(arr,i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
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
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int maxSize = 1000;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime ; i++) {
            int arr[] = generateRandomArray(maxSize,maxValue);
            int arr1[]  = copyArray(arr);
            Arrays.sort(arr);
            heapSort(arr1);
            if (!isEqual(arr1,arr)) {
                printArray(arr);
                printArray(arr1);
                System.out.println("error!");
            }
        }
        System.out.println("finsh");
    }
}
