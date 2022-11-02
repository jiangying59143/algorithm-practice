package leetcode;

public class Item_122 {
    public static int maxProfit(int[] prices) {
        int sum = process(prices, 0, -1);
        return sum;
    }

    private static int process(int[] prices, int i, int buyIndex){
        if(i == prices.length){
           return 0;
        }
        int sum;
        if(buyIndex == -1){
            //当前买或者不买取最大
            sum = Math.max(-prices[i] + process(prices, i+1, i),
                    process(prices, i+1, buyIndex));
        }else{
            // 当前卖或者不卖取最大
            sum = Math.max(prices[i] + process(prices, i, -1),
                    process(prices, i+1, buyIndex));
        }
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
