package leetcode;

import java.util.Arrays;

public class Item_122 {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][prices.length+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int sum = process(prices, 0, prices.length, dp);
        return sum;
    }

    private static int process(int[] prices, int i, int buyIndex, int[][] dp){
        if(dp[i][buyIndex] != -1){
            return dp[i][buyIndex];
        }
        if(i == prices.length){
            dp[i][buyIndex] = 0;
           return 0;
        }
        int sum;
        if(buyIndex == prices.length){
            //当前买或者不买取最大
            sum = Math.max(-prices[i] + process(prices, i+1, i, dp),
                    process(prices, i+1, buyIndex, dp));
        }else{
            // 当前卖或者不卖取最大
            sum = Math.max(prices[i] + process(prices, i+1, prices.length, dp),
                    process(prices, i+1, buyIndex, dp));
        }
        dp[i][buyIndex] = sum;
        return sum;
    }

    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length+1][prices.length+1];
        for (int i = 0; i < dp.length-1; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = dp.length-2; i >= 0; i--) {
            for (int j = dp[i].length-1; j >= 0; j--) {
                int sum;
                if(j == prices.length){
                    //当前买或者不买取最大
                    sum = Math.max(-prices[i] + dp[i+1][i],
                            dp[i+1][prices.length]);
                }else{
                    // 当前卖或者不卖取最大
                    sum = Math.max(prices[i] + dp[i+1][prices.length],
                            dp[i+1][j]);
                }
                dp[i][j] = sum;
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][prices.length];
    }

    public static int maxProfit3(int[] prices) {
        int[] dp = new int[prices.length+1];
        int index = prices.length-1;
        while(index >= 0) {
            int indexVal = dp[index];
            for (int i = 0; i < dp.length; i++) {
                int sum;
                if (i == prices.length) {
                    sum = Math.max(-prices[index] + indexVal,
                            dp[prices.length]);
                } else {
                    sum = Math.max(prices[index] + dp[prices.length],
                            dp[i]);
                }
                dp[i] = sum;
            }
//            System.out.println(Arrays.toString(dp));
            index--;
        }
        return dp[prices.length];
    }

    public static int maxProfit4(int[] prices){
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i-1] > 0 ? prices[i] - prices[i-1] : 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit2(arr));
        System.out.println(maxProfit3(arr));
        System.out.println(maxProfit4(arr));
        arr = new int[]{1,2,3,4,5};
        System.out.println(maxProfit2(arr));
        System.out.println(maxProfit3(arr));
        System.out.println(maxProfit4(arr));
        arr = new int[]{7,6,4,3,1};
        System.out.println(maxProfit2(arr));
        System.out.println(maxProfit3(arr));
        System.out.println(maxProfit4(arr));
    }
}
