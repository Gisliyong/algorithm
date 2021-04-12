package com.search;

import java.util.Arrays;

public class BSNearLeft {
    public static int nearleft(int[] arr, int value) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid;
        int index = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid -1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }
    public static int[] generator(int maxValue, int maxSize) {
        int size = (int) (Math.random() * maxValue);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * maxSize * maxValue) - (int) (Math.random() * 1000) + (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public static int isEqual(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int maxValue = 1000;
        int testTime = 100000;
        int maxSize = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generator(maxValue, maxSize);
            int value = (int) (Math.random() * maxValue) + (int) (Math.random() * i);
            Arrays.sort(arr);
            if (!(isEqual(arr, value) == nearleft(arr, value))) {
                System.out.println("eroor!");
            } else {
                System.out.println("exist!");
            }
        }
        System.out.println("finsh!");

    }

}
