package leetcode;

import java.util.Arrays;

public class Item_64 {
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int res = process(grid, 0, 0, dp);
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }

    public static int process(int[][] grid, int i, int j, int[][] dp){
//        if(dp[i][j] != -1){
//            return dp[i][j];
//        }
        if(i == grid.length-1 && j == grid[0].length-1){
            dp[i][j] = grid[i][j];
            return grid[i][j];
        }
        int res1 = grid[i][j];
        if(i+1 < grid.length){
            res1 = grid[i][j] + process(grid, i+1, j, dp);
        }
        int res2 = grid[i][j];
        if(j+1 < grid[i].length){
            res2 = grid[i][j] + process(grid, i, j+1, dp);
        }
        int res = Math.min(res1, res2);
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
