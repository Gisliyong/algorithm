package com.sort.learn;

/**
 * @Description: 求逆序对
 * @author:
 */

public class NiXuDui {
    /**
     * arr 3 1 0 4 3 1
     * 3 3,1 3,0
     * 1 1,0
     * 0
     * 4 4,3 4,1
     * 3 3,1
     * 1
     */

    /**
     * 思路：
     * 从右往左拷贝
     * 相等时先拷贝右边
     */

    public static int merge(int arr[], int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = help.length - 1;
        int p1 = M;
        int p2 = R;
        int ans = 0;
        while (p1 >= L && p2 > M) {
            if (arr[p1] == arr[p2]) {
                help[i--] = arr[p2--];
            } else if (arr[p1] > arr[p2]) {
                ans += p2 - M;
                help[i--] = arr[p1--];
            } else if (arr[p1] < arr[p2]){
                help[i--] = arr[p2--];
            }
//            ans += arr[p1] > arr[p2] ? (p2 - M) : 0;
//            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];

        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 > M) {
            help[i--] = arr[p2--];
        }
        // 拷贝回去
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return ans;
    }
    public static int mergeSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr,0,arr.length - 1);
    }
    public static int process(int arr[], int L, int R) {
        if(L == R) {
            return 0;
        }
        int mid = L +((R -L) >> 1);
        return  process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static void main(String[] args) {

    }
}
