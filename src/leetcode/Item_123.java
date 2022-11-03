package leetcode;

public class Item_123 {
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[3][prices.length];
        // 第一行 为0笔交易 收益全0， 对第一个数据进行交易，只能买完卖掉， 所以收益依然是0.
        // 第二行是 最多进行一笔交易 dp[1][1] -> dp[0][0] dp[0][1] dp[1][0] p[1]-p[0] p[1]-p[1]
        // 第三行是 最多进行两笔交易  dp[2][5] -> dp[1][5],dp[0][5],
        return 0;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
        arr = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(arr));
    }
}
