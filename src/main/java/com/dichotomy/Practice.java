package com.dichotomy;

public class Practice {
    public static int exists(int arr[],int value) {
        if (arr == null) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R - L)  >> 2);
            if (arr[mid] == value) {
                return mid;
             } else if (arr[mid] > value) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }
    public static int nearLeft(int arr[], int value) {
        if (arr == null) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = 0;
        while (L <= R) {
            int mid = L + ((R - L)  >> 2);
            if (arr[mid] >= value) {
                ans = mid;
            }  else {
                L = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
