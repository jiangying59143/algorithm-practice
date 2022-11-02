package leetcode;

public class Item_122 {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][prices.length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int sum = process(prices, 0, -1, dp);
        return sum;
    }

    private static int process(int[] prices, int i, int buyIndex, int[][] dp){
        int dp_y = buyIndex+1;
        if(dp[i][dp_y] != -1){
            return dp[i][dp_y];
        }
        if(i == prices.length){
            dp[i][dp_y] = 0;
           return 0;
        }
        int sum;
        if(buyIndex == -1){
            //当前买或者不买取最大
            sum = Math.max(-prices[i] + process(prices, i+1, i, dp),
                    process(prices, i+1, buyIndex, dp));
        }else{
            // 当前卖或者不卖取最大
            sum = Math.max(prices[i] + process(prices, i, -1, dp),
                    process(prices, i+1, buyIndex, dp));
        }
        dp[i][dp_y] = sum;
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
        arr = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(arr));
        arr = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }
}
