package com.dichotomy.learn;
/**
 * 局部最小值
 **/
public class LocalMin {
    /**
     * 条件：
     * 1 数据为无序数组
     * 2 值可正可负，任意相邻数据不等
     * 3 0位置小于1位置则为局部最小，最后一个数小于倒数第二个数为局部最小
     * 4 非边界则需要比左右都小的数为局部最小
     * 5 找到任意一个局部最小返回
     **/
    public static int getLocalMin(int arr[]) {
        // 边界条件
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length -1] < arr[arr.length -2]) {
            return arr[arr.length - 1];
        }
        int L = 1;
        int R = arr.length - 2;
        int mid;
        // 等号可以用，也可以不用
        // 如果不使用等号，最后的返回值 return arr[low] == value
        // while l < r
        while (L <= R) {
            // 防止溢出
            mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                L = mid + 1;
            } else if (arr[mid] > arr[mid + 1]){
                R = mid - 1;
            } else {
                return arr[mid];
            }
        }
        // return arr[l] == value
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {13,45,89,88,7,90};
    }
}
