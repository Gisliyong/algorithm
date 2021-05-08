package com.sort.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: 归并排序
 * @author: liyong
 */
public class MergeSort {
    public static void merge(int arr[], int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
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
    }

    public static void mergeSort(int arr[]) {
        process(arr, 0, arr.length - 1);
    }

    public static void process(int arr[], int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void mergeSortDieDai(int arr[]) {
        int N = arr.length;
        for (int size = 1; size < arr.length; size *= 2) {
            // 一次合并
            int L = 0;
            while (L < N) {
                // 左组的边界
                int M = L + size - 1;
                // 如果左组都不够，下次合并
                if (M >= N) {
                    break;
                }
                // 边界条件
                int R = Math.min(M + size, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止溢出
            // 步长*2超过边界
            if (size > N / 2) {
                break;
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 4}, {0, 4}});
    }
}

