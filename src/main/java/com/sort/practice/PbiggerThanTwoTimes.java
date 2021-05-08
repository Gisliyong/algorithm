package com.sort.practice;

/** 练习 **/

public class PbiggerThanTwoTimes {
    public static int merge(int arr[], int L, int mid, int R) {
        int help[] = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        int ans = 0;
        int windowR = mid + 1;
        for (int i = L; i <= mid; i++) {
            while (windowR <= R && arr[i] > (arr[windowR] * 2)) {
                windowR++;
            }
            ans += windowR - mid - 1;
        }
        while (p1 <= mid && p2 <= R) {
            help[index++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[i + L] = help[i];
        }
        return ans;
    }
    public static int mergeSort(int arr[]) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int arr[],int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >>1);
        return process(arr, L, mid) +
                process(arr, mid + 1, R) +
                merge(arr, L, mid, R);
    }

    // for test
    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }



    // for test
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

    // for test
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

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (mergeSort(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
        int arr[] = {1,4,5,2,0};
        System.out.println(mergeSort(arr));
    }
}
