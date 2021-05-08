package com.sort.practice;

public class PgetSum {
    public static int mergeSort(int arr[]) {
        if (arr == null || arr.length <= 1) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print("  " + arr[i]);
                System.out.println("\n");
                System.out.println(arr.length);
            }
            return 0;
        }
        try {
            int ans = process(arr,0, arr.length -1);
            return ans;

    } catch (Exception e) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  " + arr[i]);
        }
        return 0;
    }

}
    public static int merge(int arr[], int L, int mid, int R) {
        int help[] = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int cnt = 0;
        int sum = 0;
        while (p1 <= mid && p2 <= R) {
            sum += (arr[p1] < arr[p2]) ? arr[p1] * (R - p2 + 1): 0;
            help[cnt++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[cnt++] = arr[p1++];
        }
        while (p2 <= R) {
            help[cnt++] = arr[p2++];
        }
        for (cnt = 0;cnt < help.length;cnt++) {
            arr[cnt + L] = help[cnt];
        }
        return sum;
    }
    public static int process(int arr[], int L, int R) {
            if(L == R) {
                return 0;
            }
            int mid = L + ((R - L) >> 1);
            return process(arr,L,mid ) +
                    process(arr,mid + 1, R) +
                    merge(arr,L,mid, R);

    }
    public static int getSum(int arr[]) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) {
                    ans += arr[j];
                }
            }
        }
        return ans;
    }
    public static int[] generator(int maxValue, int maxSize) {
        int size = (int) (Math.random() * maxValue);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * maxSize * maxValue) - (int) (Math.random() * 1000) + (int) (Math.random() * maxValue);
        }
        return arr;
    }
    public static int[] copy(int arr[]) {
        if (arr == null || arr.length ==0) {
            return null;
        }
        int[] newarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }
    public static void main(String[] args) {
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int arr[] = generator(100,1000);
            int arr2[] = copy(arr);
            int ans1 = mergeSort(arr);
            int ans2 = getSum(arr2);
            if (ans1 != ans2) {
                System.out.println("error!");
                break;
            }
        }
        System.out.println("finsh!");
    }
}
