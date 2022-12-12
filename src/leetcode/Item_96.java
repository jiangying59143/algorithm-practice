package leetcode;

public class Item_96 {
    public static int numTrees(int n) {
        if(n == 1 || n == 0){
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum +=procss(i, n);
        }
        return sum;
    }

    private static int procss(int i, int n){
        return numTrees(i-1) * numTrees(n-i);
    }

    public static int numTrees1(int n) {
        int[] dp = new int[n+1];
        return procss1(n, dp);
    }

    private static int procss1(int n, int[] dp){
        if(dp[n] != 0){
            return dp[n];
        }
        if(n == 1 || n == 0){
            dp[n] = 1;
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum +=procss2(i, n, dp);
        }
        dp[n] = sum;
        return sum;
    }

    private static int procss2(int i, int n, int[] dp){
        return procss1(i-1, dp) * procss1(n-i, dp);
    }

    public static void main(String[] args) {
        System.out.println(numTrees1(3));
    }
}
