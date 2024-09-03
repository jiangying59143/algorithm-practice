package knapsack;

import java.util.Arrays;

public class knapsack {

    /**
     *
     * @param wgt
     * @param val
     * @param i index
     * @param c capacity
     * @return
     */
    public static int knapsackDFS(int[] wgt, int[] val, int i, int c){
        if(i == wgt.length) return 0;

        if(wgt[i] > c) return 0;

        int no = knapsackDFS(wgt, val, i+1, c);
        int yes =  knapsackDFS(wgt, val, i+1, c - wgt[i]) + val[i];

        return Math.max(no, yes);
    }

    public static int knapsackDFSMem(int[] wgt, int[] val, int c){
        int[][] mem = new int[wgt.length+1][c+1];
        for (int[] memSub : mem) {
            Arrays.fill(memSub, -1);
        }
        return process(wgt, val, 0, c, mem);
    }

    public static int process(int[] wgt, int[] val, int i, int c, int[][] mem){
        if(mem[i][c] != -1) return mem[i][c];
        if(i == wgt.length || wgt[i] > c){
            mem[i][c] = 0;
            return 0;
        }

        int no = process(wgt, val, i+1, c,mem);
        int yes =  process(wgt, val, i+1, c - wgt[i], mem) + val[i];
        mem[i][c] = Math.max(no, yes);
        return mem[i][c];
    }

    public static int dp(int[] wgt, int[] val, int cap){
        int n =  wgt.length;
        int[][] dp = new int[n+1][cap+1];
        for (int i = n; i >=1; i--) {
            for (int c = 0; c < cap; c++) {
                if(wgt[i] > c){
                    dp[i][c] = dp[i-1][c];
                }else{
                    dp[i][c] = Math.max(dp[i+1][c], dp[i+1][c-wgt[i]]) + val[i];
                }
            }
        }

        return dp[n][cap];
    }

    public static void main(String[] args) {
        int[] wgt = new int[]{10,20,30,40,50};
        int[] val = new int[]{50,120,150,210,240};
        int c = 50;
//        System.out.println(knapsackDFS(wgt, val, 0, c));
//        System.out.println(knapsackDFSMem(wgt, val, c));
        System.out.println(dp(wgt, val, c));
    }
}
