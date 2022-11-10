package leetcode;

public class Item_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] =-1;
            }
        }
        return process(obstacleGrid, 0, 0, dp);
    }

    public static int process(int[][] obstacleGrid, int i, int j, int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(obstacleGrid[i][j] == 1){
            dp[i][j] = 0;
            return 0;
        }
        if(i == obstacleGrid.length-1 && j == obstacleGrid[i].length-1){
            dp[i][j] = 1;
            return 1;
        }
        int res = 0;
        if(i < obstacleGrid.length-1){
            res += process(obstacleGrid, i+1, j, dp);
        }
        if(j < obstacleGrid[i].length-1){
            res += process(obstacleGrid, i, j+1, dp);
        }
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][]{{0,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
