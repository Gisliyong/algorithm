package com.xor.learn;

public class EvenTimesOddTimes {
    public static int printOddNum(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
    public static void printTwoOddsNum(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int rightOne = xor & (~xor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println("the first is :" + onlyOne + " the second is :" + (xor ^ onlyOne));
    }

    public static int countOdd(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int oneNum = arr[0];
        int count = 0;
        int otherNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == oneNum) {
                count ++;
            } else {
                otherNum = arr[i];
            }
        }
        if (count % 2 == 0) {
            return otherNum;
        } else {
            return oneNum;
        }
    }
    public static int[] generator(int maxValue, int maxSize) {
        int odd = (int) (Math.random() * maxValue);
        int even = (int) (Math.random() * maxValue);
        int len = (int) (Math.random() * maxSize);
        len = (len % 2 == 0) ? len + 1 : len;
        int oneNumTimes = (int) (Math.random() * len);
        oneNumTimes = oneNumTimes % 2 == 0 ? oneNumTimes : oneNumTimes + 1;
        int[] arr = new int[len];
        for (int i = 0; i < oneNumTimes; i++) {
            arr[i] = even;
        }
        for (int i = oneNumTimes; i < len; i++) {
            arr[i] = odd;
        }
        return arr;
    }
    public static  void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
    public static void main(String[] args) {
        int testTime = 10000000;
       int maxValue = 1000;
       int maxSize = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generator(maxValue,maxSize);
            if (countOdd(arr) != printOddNum(arr)) {
                printArray(arr);
                System.out.println("error!");
            }
        }
        System.out.println("finsh!");
    }
}
