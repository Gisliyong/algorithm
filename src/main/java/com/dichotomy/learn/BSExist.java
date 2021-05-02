package com.dichotomy.learn;

import java.util.Arrays;
/**
 * 查找某个元素是否存在
 **/
public class BSExist {
    public static boolean isExist(int arr[], int value) {
        if (arr.length == 0 || arr == null) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid;
        // 等号可以用，也可以不用
        // 如果不使用等号，最后的返回值 return arr[low] == value
        // while l < r
        while (L <= R) {
            // 防止溢出
            mid = L + ((R - L) >> 1);
            if (arr[mid] == value) {
                return true;
            } else if (arr[mid] < value) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        // return arr[l] == value
        return false;
    }

    public static int[] generator(int maxValue, int maxSize) {
        int size = (int) (Math.random() * maxValue);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * maxSize * maxValue) - (int) (Math.random() * 1000) + (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static Boolean isEqual(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int maxValue = 1000;
        int testTime = 100000;
        int maxSize = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generator(maxValue, maxSize);
            int value = (int) (Math.random() * maxValue) + (int) (Math.random() * i);
            Arrays.sort(arr);
            if (!(isEqual(arr, value) == isExist(arr, value))) {
                System.out.println("eroor!");
            } else {
                System.out.println("exist!");
            }
        }
        System.out.println("finsh!");
    }
}
