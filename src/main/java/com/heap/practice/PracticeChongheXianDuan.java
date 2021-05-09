package com.heap.practice;

import com.heap.learn.ChongHeXianDuan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PracticeChongheXianDuan {
    static class LineComparator implements Comparator<ChongHeXianDuan.Line> {
        @Override
        public int compare(ChongHeXianDuan.Line o1, ChongHeXianDuan.Line o2) {
            return o1.start - o2.start;
        }
    }
    public static int maxCover(int nums[][]) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ChongHeXianDuan.Line lines[] = new ChongHeXianDuan.Line[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ChongHeXianDuan.Line line = new ChongHeXianDuan.Line(nums[i][0],nums[i][1]);
            lines[i] = line;
        }
        int ans = 0;
        Arrays.sort(lines,new LineComparator());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (ChongHeXianDuan.Line e : lines) {
            while (heap.size() != 0 && heap.peek() <= e.start) {
                heap.poll();
            }
            heap.add(e.end);
            ans = Math.max(ans,heap.size());
        }
        return  ans;
    }
    public static void main(String[] args) {

    }
}
