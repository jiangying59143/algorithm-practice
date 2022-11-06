package leetcode;

public class Item_123 {
    public static int maxProfit(int[] prices){
        return process(prices, 0, 0, 0);
    }

    private static int process(int[] prices, int buyIndex, int i, int tnTime){
        if(i == prices.length || tnTime == 2){
            return 0;
        }
        int sum;
        if(buyIndex == 0){
            //当前买或者不买取最大
            sum = Math.max(-prices[i] + process(prices, 1, i+1, tnTime),
                    process(prices,  0,i+1, tnTime));
        }else{
            // 当前卖或者不卖取最大
            sum = Math.max(prices[i] + process(prices,  0,i+1, tnTime+1),
                    process(prices,  1,i+1, tnTime));
        }
        return sum;
    }
    public static int maxProfit2(int[] prices){
        int[][][] dp = new int[2][prices.length+1][3];

        for (int i = dp[0].length-2; i >= 0; i--) {
            //当前买或者不买取最大
            dp[0][i][0] = Math.max(-prices[i] + dp[1][i+1][0],
                    dp[0][i+1][0]);
            dp[0][i][1] = Math.max(-prices[i] + dp[1][i+1][1],
                    dp[0][i+1][1]);
            // 当前卖或者不卖取最大
            dp[1][i][0] = Math.max(prices[i] + dp[0][i+1][1],
                    dp[1][i+1][0]);
            dp[1][i][1] = Math.max(prices[i] + dp[0][i+1][2],
                    dp[1][i+1][1]);
        }
        return dp[0][0][0];
    }

    public static int maxProfit3(int[] prices){
        int[][][] dp = new int[2][prices.length+1][3];
        for (int i = dp[0].length-2; i >= 0; i--) {
            //当前买或者不买取最大
            dp[0][i][0] = Math.max(-prices[i] + dp[1][i+1][0],
                    dp[0][i+1][0]);
            dp[0][i][1] = Math.max(-prices[i] + dp[1][i+1][1],
                    dp[0][i+1][1]);
            // 当前卖或者不卖取最大
            dp[1][i][0] = Math.max(prices[i] + dp[0][i+1][1],
                    dp[1][i+1][0]);
            dp[1][i][1] = Math.max(prices[i] + dp[0][i+1][2],
                    dp[1][i+1][1]);
        }
        return dp[0][0][0];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit2(arr));
        arr = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit2(arr));
    }
}
