package com.sort.learn;

public class LowerToUpper {

    /**
     * 给定一个数组arr
     * 给定区间[lower,upper]
     * 返回多少个子数组累加和，在这个区间
     */

    /**
     * 思路：
     * 准备一个等长的数组记录前缀和，第i位置表示0 - i的累加和
     * 0            1            2            3            4
     * 以0结尾的子数组 以1结尾的子数组 以1结尾的子数组 以1结尾的子数组 以1结尾的子数组
     * 达标a         b            c            d            e
     * 假设0 - i 位置的累加和为x,求x落在[lower,upper]等价于求以i位置结尾的数组，求i之前有多少前缀和落在[x - up,x -l]上
     */
    public static int countRangeSum(int nums[], int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i]  = sum[i - 1] + nums[i];
        }
        return count(sum,0,sum.length - 1,lower,upper);
    }
    public static int count(int[] arr, int L, int R, int lower,int upper) {
       if (L == R) {
           return (arr[L] >= lower && arr[L] <= upper) ? 1 : 0;
       }
       int mid = L + ((R - L) >> 2);
       return count(arr, L, mid, lower, upper) + count(arr, mid + 1, R, lower, upper) + merge(arr,L,mid,R,lower,upper);
    }
    public static int merge(int arr[], int L, int M, int R,int lower,int upper) {
        int[] help = new int[R - L + 1];
        int ans = 0;
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int windowL = L;
        int windowR = L;
        for (int j = M + 1; j <= R; j++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += windowR - windowL;
        }

        p2 = M + 1;
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
        return ans;
    }
    public static void main(String[] args) {
    }
}
