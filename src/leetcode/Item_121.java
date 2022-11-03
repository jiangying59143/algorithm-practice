package leetcode;

import java.util.Arrays;

public class Item_121 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                res = Math.max(profit, res);
            }
        }
        return res;
    }

    public static int maxProfit2(int[] prices) {
        int res = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(prices[i] - minPrice, res);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int testCount = 10000;
        for (int i = 0; i < testCount; i++) {
            int[] arr = Data.generate(1000, 0, 1000);
            int ans1 = maxProfit(arr);
            int ans2 = maxProfit2(arr);
            if(ans1 != ans2){
                System.out.println("Oops!");
                System.out.println(Arrays.toString(arr));
                System.out.println(ans1);
                System.out.println(ans2);
                break;
            }
        }
        System.out.println("End!!");
    }
}
