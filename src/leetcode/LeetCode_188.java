package leetcode;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode_188 {
    public int maxProfit(int k, int[] prices) {
        int[][] res = new int[prices.length+1][k+1];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = -1;
            }
        }
        int ans = process(prices, 0, k, res);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        return ans;
    }

    public int process(int[] prices, int index, int k, int[][] res){
        if(res[index][k] != -1){
            return res[index][k];
        }

        if(index==prices.length || k == 0){
            res[index][k] = 0;
            return 0;
        }

        int notBuyRes = process(prices, index + 1, k, res);

        int buyRes = 0;
        for (int i = index+1; i < prices.length; i++) {
            buyRes = Math.max(buyRes, prices[i]-prices[index] + process(prices, i+1, k-1, res));
        }

        int ans = Math.max(notBuyRes, buyRes);
        res[index][k] = ans;
        return ans;
    }

    public int maxProfit1(int k, int[] prices) {
        int[][] res = new int[prices.length+1][k+1];
        for (int i = 0; i < res.length-1; i++) {
            for (int j = 1; j < res[i].length; j++) {
                res[i][j] = -1;
            }
        }
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                int notBuyRes = res[i+1][j];
                int buyRes = 0;
                for (int i1 = i+1; i1 < prices.length; i1++) {
                    buyRes = Math.max(buyRes, prices[i1]-prices[i] + res[i1+1][j-1]);
                }
                int ans = Math.max(notBuyRes, buyRes);
                res[i][j] = ans;
            }
        }

        return res[0][k];
    }

    public static void main(String[] args) {
        LeetCode_188 obj = new LeetCode_188();
        System.out.println(obj.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(obj.maxProfit1(2, new int[]{2, 4, 1}));
    }
}
