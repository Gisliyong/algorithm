package com.greedy.learn;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {

    /**
     * 一些会议要占用会议室宣讲，会议室不能同时容纳两个会议
     * 安排最多的会议数量
     * 贪心策略
     * 结束时间最早（根据介素时间排序）
     * 之后遍历每个会议，如果开始时间小于，结束时间排除否则加入结果集
     */
    public static int bestArrange(int [][] data) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int ans = 0;
        int endTime = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] <= endTime) {
                ans++;
                endTime = data[i][1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
