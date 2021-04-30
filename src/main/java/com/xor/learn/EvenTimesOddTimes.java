package com.xor.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出现奇数次的数
 **/
public class EvenTimesOddTimes {
    /**
     * 一种数出现奇数次，其它数据出现偶数次
     **/
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
    /**
     * 两种数出现奇数次，其它数出现偶数次
     **/
    public static void printTwoOddsNum(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        // 提取最右侧的1
        // 等同于 xor & (-xor)
        int rightOne = xor & (~xor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println("the first is :" + onlyOne + " the second is :" + (xor ^ onlyOne));
    }
    /**
     * 一个数组，一个数出现K次，其它数出现M次，K < M,M > 1
     * 要求：
     * 时间复杂度为O(N),额外空间复杂度为O(1)
     * 思路：
     * 将每个数转换为二进制
     * 准备一个数组将每个数字的二进制位累加到一起
     * 该数字 % M == 0，说明出现K次的数在这个位上一定0
     **/
     public static int onlyKtimes(int[] arr, int k, int m) {
         // 准备一个长度为32的数组
         int[] t = new int[32];
         // t[0] 0位上出现了几个1
         // t[i] i位上出现了几个1
         for (int num : arr) {
             for (int i = 31; i >= 0; i--) {
                 // 等价于num & (1 << i)
                 t[i] += (num >> i) & 1;
             }
         }
         int ans = 0;
         for (int i = 0; i < 32; i++) {
             if(t[i] % m != 0) {
                 // 数字在第i位有1
                 ans |= (1 << i);
             }
         }
       return ans;
     }

     /**
      * onlyKeyTimes的对数器
      **/
    public static int testOnlyKeyTimes(int arr[],int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],1);
            } else {
                map.put(arr[i],map.get(arr[i]) + 1);
            }
        }
        for (int num : map.keySet()) {
            if (k == map.get(num)) {
                return num;
            }
        }
        return -1;
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
         int[] arr = {-4,3,1,3,3,1,1,-4};
        int re = onlyKtimes(arr, 2, 3);
        int i = testOnlyKeyTimes(arr, 2);
        System.out.printf(re + " " + i);
//        int testTime = 10000000;
//       int maxValue = 1000;
//       int maxSize = 1000;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr = generator(maxValue,maxSize);
//            if (countOdd(arr) != printOddNum(arr)) {
//                printArray(arr);
//                System.out.println("error!");
//            }
//        }
//        System.out.println("finsh!");
    }
}
