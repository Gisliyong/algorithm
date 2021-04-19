package com.dp.learn;

import com.graph.learn.UnionFind;

public class ChoosePuKe {
    /**
    * 给定一个整型数组arr，代表数值不同的纸牌排成一条线，
     * 玩家A和玩家B依次拿走每张纸牌，
     * 规定玩家A先拿，玩家B后拿，
     * 但是每个玩家每次只能拿走最左或最右的纸牌，
     * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。给定一个整型数组arr，代表数值不同的纸牌排成一条线，
     * 玩家A和玩家B依次拿走每张纸牌，
     * 规定玩家A先拿，玩家B后拿，
     * 但是每个玩家每次只能拿走最左或最右的纸牌，
     * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
    */
    public static int win(int[] arr) {
      int first = f(arr,0,arr.length -1);
      int second = g(arr,0,arr.length - 1);
      return Math.max(first, second);
    }
    /** 先手函数 **/
    public static int f(int[] arr,int L,int R) {
        if (L == R) {
            return arr[L];
        }
        int op1 = arr[L] + g(arr,L + 1,R);
        int op2 = arr[R] + g(arr,L,R - 1);
        return Math.max(op1,op2);
    }
    /** 后手函数 **/
    public static int g(int[] arr, int L,int R) {
        if (L == R) {
            return 0;
        }
        int op1 = f(arr,L + 1,R);
        int op2 = f(arr,L,R - 1);
        return Math.min(op1,op2);
    }
    public static int dpWin(int[] arr) {
        if (arr == null || arr.length ==0) {
            return 0;
        }
        int N = arr.length;
        int[][]fdp = new int[N][N];
        int[][] gdp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fdp[i][j] = -1;
                gdp[i][j] = -1;
            }
        }
        int first = f2(arr,0,arr.length -1,fdp,gdp);
        int second = g2(arr,0,arr.length - 1,fdp,gdp);
        return Math.max(first, second);
    }
    public static int f2(int[] arr,int L,int R,int[][] fdp,int[][] gdp) {
        if (gdp[L][R] != -1) {
             return fdp[L][R];
        }
        int ans = 0;
        if (L == R) {
            ans = arr[L];
        } else {
            int op1 = f(arr,L + 1,R);
            int op2 = f(arr,L,R - 1);
             ans = Math.min(op1,op2);
        }
        gdp[L][R] = ans;
        return ans;
    }
    public static int g2(int[] arr,int L,int R,int[][] fdp,int[][] gdp) {
        if (fdp[L][R] != -1) {
            return fdp[L][R];
        }
        int ans = 0;
        if (L != R) {
            int op1 = arr[L] + g(arr,L + 1,R);
            int op2 = arr[R] + g(arr,L,R - 1);
            ans = Math.max(op1,op2);
        }
        fdp[L][R] = ans;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {5,7,4,5,8,1,6,0,3,4,6,1,7};
        System.out.println(win(arr));
        System.out.println(dpWin(arr));
        System.out.println(finalDp(arr));
    }
    public static int finalDp(int[] arr) {
        if (arr == null || arr.length ==0) {
            return 0;
        }
        int N = arr.length;
        int[][]fdp = new int[N][N];
        int[][] gdp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fdp[i][j] = arr[i];
            }
        }
        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fdp[L][R] = Math.max(arr[L] + gdp[L + 1][R],arr[R] + gdp[L][R -1]);
                gdp[L][R] = Math.min(fdp[L + 1][R],fdp[L][R -1]);
                L++;
                R++;
            }
        }
        return Math.max(fdp[0][N -1],gdp[0][N -1]);

    }
}
