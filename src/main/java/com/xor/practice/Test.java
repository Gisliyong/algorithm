package com.xor.practice;

public class Test {
    public static int getOddNum(int arr[]) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
    public static int[] generator(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        for (int i = 0; i < len; i++) {

        }
        return null;
    }
    public static void main(String[] args) {
        int arr[] = {11,11,12,13,13,34,34};
        System.out.println(getOddNum(arr));
    }
}
