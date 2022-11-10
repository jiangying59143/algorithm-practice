package leetcode;

public class Item_62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process(1,1, m, n, dp);
    }

    public static int process(int i, int j, int m, int n, int[][] dp){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == m && j == n){
            dp[i][j] = 1;
            return 1;
        }
        int res = 0;
        if(i < m) {
            res += process(i + 1, j, m, n, dp);
        }
        if(j < n){
            res += process(i, j+1, m, n, dp);
        }
        dp[i][j] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 1));
    }
}
