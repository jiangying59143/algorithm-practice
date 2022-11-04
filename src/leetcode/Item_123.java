package leetcode;

public class Item_123 {
    public static int maxProfit2(int[] prices){
        int[][][] dp = new int[prices.length+1][2][3];
        int sum = process(prices, 2,0, 0, 0, dp);
        return sum;
    }

    private static int process(int[] prices, int maxTnTimes, int i, int buyFlag, int tnTimes,int[][][] dp){
        if(dp[i][buyFlag][tnTimes] != 0){
            return dp[i][buyFlag][tnTimes];
        }
        if(i == prices.length || tnTimes == maxTnTimes){
            dp[i][buyFlag][tnTimes] = 0;
            return 0;
        }
        int sum;
        if(buyFlag == 0){
            //当前买或者不买取最大
            sum = Math.max(-prices[i] + process(prices, maxTnTimes, i+1, 1, tnTimes, dp),
                    process(prices, maxTnTimes, i+1, 0, tnTimes, dp));
        }else{
            // 当前卖或者不卖取最大
            sum = Math.max(prices[i] + process(prices, maxTnTimes, i, 0, tnTimes+1, dp),
                    process(prices, maxTnTimes, i+1, 1, tnTimes, dp));
        }
        dp[i][buyFlag][tnTimes] = sum;
        return sum;
    }
    public static int maxProfit(int[] prices){
        int[][][] dp = new int[prices.length+1][2][3];

        int sum = process(prices, 2,0, 0, 0, dp);
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit2(arr));
        arr = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit2(arr));
    }
}
