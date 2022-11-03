package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Item_123 {
    public static int maxProfit(int[] prices) {
        int[] res = new int[3];

        int singTransactionSum = 0;
        for (int i = 1; i < prices.length; i++) {
             if(prices[i] - prices[i-1] < 0){
                 System.out.println(singTransactionSum);
                 if(singTransactionSum > res[0])res[0] = singTransactionSum;
                 Arrays.sort(res);
                 singTransactionSum = 0;
             }else{
                 singTransactionSum+= prices[i] - prices[i-1];
                 if(i==prices.length-1){
                     res[0] = singTransactionSum;
                     Arrays.sort(res);
                 }
             }
        }

        return res[1] + res[2];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(arr));
        arr = new int[]{1,2,4,2,5,7,2,4,9,0};
    }
}
