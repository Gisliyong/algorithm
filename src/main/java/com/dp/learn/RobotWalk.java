package com.dp.learn;

public class RobotWalk {
    // start = 2 开始位置
    // end = 4 结束位置
    // N = 7 位置  1 2 3 4 5 6 7
    // k = 4 步数
    public static int ways(int N, int start, int aim, int K) {
        return process(start,K,aim,N);
    }
    // 机器人当前的位置为cur
    // 机器人还有rest步需要走
    // 最终目标
    // 有哪些位置
    public static int process(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(2, rest -1, aim, N);
        }
        if (cur == N) {
            return process(N - 1,rest -1 ,aim, N);
        }
        return process(cur - 1,rest -1 ,aim, N) +
                process(cur + 1,rest -1 ,aim, N);
    }
    // cur 1 - N
    // rest 0 - k
    public static int dpWays(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K +  1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K ; j++) {
                dp[i][j] = -1;
            }
        }
        return dpProcess(start, K, aim, N, dp);
    }
    public static int dpProcess(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = 0;
        if (rest == 0) {
            ans =  cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = dpProcess(2, rest -1, aim, N,dp);
        } else if (cur == N) {
            ans =  dpProcess(N - 1,rest -1 ,aim, N, dp);
        } else {
            ans = dpProcess(cur - 1, rest - 1, aim, N, dp) +
                    dpProcess(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }
    public static int finalDp(int N, int start, int aim, int K){
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K ; rest++) {
            dp[1][rest]  = dp[2][rest -1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur -1][rest -1] + dp[cur + 1][rest -1];
            }
            dp[N][rest] = dp[N -1][rest -1];
        }
        return dp[start][K];
    }
    public static void main(String[] args) {
      System.out.println(dpWays(4,2,4,4));
        System.out.println(ways(4,2,4,4));
        System.out.println(finalDp(4,2,4,4));
    }
}
