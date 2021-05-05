package com.sort.learn;

/**
 * 快速排序
 */

import java.util.Stack;

/** 最差空间复杂度O(N)
 *  最好空间复杂度O(logN)
 * **/
public class QuickSort {

    /**
     * 当前数 <= 目标 当前数和<= 下一个数交换，<= 区域向右扩
     * 当前数 > 目标  当前数直接跳下一个
     */
     // 在arr[L..R]中以arr[R]做划分值


    /**
     * 加强版
     * 1）当前数 < 目标 当前数和<= 下一个数交换，<= 区域向右扩
     * 2）当前数 > 目标 当前数与大于区域前一个交换，当前数停在原地
     * 3） 当前数 == 目标 跳过
     */

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // arr[L..R]上，以arr[R]位置的数做划分值
    // <= X > X
    // <= X X
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    // <arr[R] ==arr[R] > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) { // L...R L>R
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1; // < 区 右边界
        // 最后一个数不参与
        int more = R; // > 区 左边界
        int index = L;
        while (index < more) { // 当前位置，不能和 >区的左边界撞上
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
//				swap(arr, less + 1, index);
//				less++;
//				index++;
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R); // <[R]   =[R]   >[R]
        return new int[]{less + 1, more};
    }
    public static void quickSort1(int arr[]) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process1(arr,0, arr.length-1);
    }
    public static void process1(int arr[], int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = partition(arr,L,R);
        process1(arr,L, mid - 1);
        process1(arr,mid + 1, R);
    }
    public static void quickSort2(int arr[]) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process2(arr,0,arr.length -1);
    }
    public static void process2(int arr[], int L, int R) {
        if (L >= R) {
            return;
        }
        int bound[] = netherlandsFlag(arr,L,R);
        process1(arr,L, bound[0] - 1);
        process1(arr,bound[1] + 1, R);
    }
    public static void main(String[] args) {
        int arr[] = {5,1,2,8,3,9,4};
        quickSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
    public static void quickSort3(int arr[]) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process3(arr,0,arr.length -1);
    }

    private static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr,(L + (int)(Math.random() * (R - L + 1))), R);
        int[] bound = netherlandsFlag(arr, L, R);
        process1(arr,L, bound[0] - 1);
        process1(arr,bound[1] + 1, R);
    }
    public static class Op {
        public int l;
        public int r;

        public Op(int left, int right) {
            l = left;
            r = right;
        }
    }
    // 快排3.0 非递归版本
    public static void quickSort4(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        swap(arr, (int) (Math.random() * N), N - 1);
        int[] equalArea = netherlandsFlag(arr, 0, N - 1);
        int el = equalArea[0];
        int er = equalArea[1];
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, el - 1));
        stack.push(new Op(er + 1, N - 1));
        while (!stack.isEmpty()) {
            Op op = stack.pop(); // op.l  ... op.r
            if (op.l < op.r) {
                swap(arr, op.l + (int) (Math.random() * (op.r - op.l + 1)), op.r);
                equalArea = netherlandsFlag(arr, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new Op(op.l, el - 1));
                stack.push(new Op(er + 1, op.r));
            }
        }
    }
}
