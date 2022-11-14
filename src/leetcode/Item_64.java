package leetcode;

import java.util.Arrays;

public class Item_64 {
    public static int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //第一行只依赖左边的数据
                if(i == 0){
                    dp[j] = j ==0 ?  grid[i][j] : dp[j-1] + grid[i][j];
                }
                // 除了第一个的第一列 只依赖上面的数据
                else if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                }
                // 其他位置与左边dp[j-1]和上面dp[j]有关
                else{
                    dp[j] = Math.min(dp[j-1],dp[j]) + grid[i][j];
                }
            }
        }
        return dp[grid[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
