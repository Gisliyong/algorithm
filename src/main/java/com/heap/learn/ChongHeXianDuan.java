package com.heap.learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ChongHeXianDuan {

    /**
     * 题目描述：
     * 给的那个很多线段，都有两个数[start,end],表示线段的开始和结束位置
     * 规定结束和开始都是整数值，且线段重合区域的长度必须 >= 1
     * 返回线段中最多重合了几条线段
     *
     */

    /**
     * 思路一（暴力枚举）：
     * 求出数据中最小的start，最大的end
     * 枚举[start,end] 中所以的.5,返回最大值。
     */
    public static int maxConver(int data[][]) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int minStart = data[0][0];
        int maxEnd = data[0][1];
        int max = 0;
        int ans = 0;
        for (int i = 1; i < data.length; i++) {
            minStart  = Math.min(minStart,data[i][0]);
            maxEnd = Math.max(maxEnd,data[i][1]);
        }
        for (int i = minStart; i < maxEnd ; i++) {
            max = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[j][0] < i + 0.5 && data[j][1] > i + 0.5) {
                    max++;
                }
            }
            ans = Math.max(ans,max);
        }
        return ans;
    }
    public static class Line {
        public int start;
        public int end;
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 思路二（堆）：
     * 先将数据以开始位置排序，定义一个小根堆
     *  依次考察每一个线段，把小根堆 <= 开始位置的数据全部弹出，将此时线段结束位置加入堆
     *  此时堆的大小即为重合的线段数
     */
    static class LineComparator implements Comparator<Line> {
        @Override
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }
    public static int coverMaxHeap(int data[][]) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Line[] lines = new Line[data.length];
        for (int i = 0; i < data.length; i++) {
            Line line = new Line(data[i][0],data[i][1]);
            lines[i] = line;
        }
        Arrays.sort(lines,new LineComparator());
        for (Line line : lines) {
            while (!heap.isEmpty() && heap.peek() <= line.start) {
                heap.poll();
            }
            heap.add(line.end);
            ans = Math.max(ans,heap.size());
        }
        return ans;
    }
    public static int[][] generateLines(int N, int L, int R) {
        int size = (int) (Math.random() * N) + 1;
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            int a = L + (int) (Math.random() * (R - L + 1));
            int b = L + (int) (Math.random() * (R - L + 1));
            if (a == b) {
                b = a + 1;
            }
            ans[i][0] = Math.min(a, b);
            ans[i][1] = Math.max(a, b);
        }
        return ans;
    }
    public static void main(String[] args) {
        int testTime = 10000;
        int N = 100;
        int L = 0;
        int R = 200;
        for (int i = 0; i < testTime; i++) {
            int data[][] = generateLines(N, L, R);
            int ans1 = coverMaxHeap(data);
            int ans2 = maxConver(data);
            if (ans1 != ans2) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("finsh!");

    }
}
