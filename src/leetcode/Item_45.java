package leetcode;

import java.util.Arrays;

public class Item_45 {
    public static void main(String[] args) {
        Item_45 obj = new Item_45();
//        System.out.println(obj.jump(new int[]{0}));
//        System.out.println(obj.jump(new int[]{1}));
//        System.out.println(obj.jump(new int[]{2,3,1,1,4}));
//        System.out.println(obj.jump(new int[]{2,3,0,1,4}));
//        System.out.println(obj.jump(new int[]{1,2,3}));
//        System.out.println(obj.jump(new int[]{1,1,1,1}));
//        System.out.println(obj.jump(new int[]{1,2,1,1,1}));
//        System.out.println("------------------");
//        System.out.println(obj.jump2(new int[]{0}));
//        System.out.println(obj.jump2(new int[]{1}));
//        System.out.println(obj.jump2(new int[]{2,3,1,1,4}));
//        System.out.println(obj.jump2(new int[]{2,3,0,1,4}));
//        System.out.println(obj.jump2(new int[]{1,2,3}));
//        System.out.println(obj.jump2(new int[]{1,1,1,1}));
        System.out.println(obj.jump2(new int[]{1,2,1,1,1}));
    }
    public int jump(int[] nums) {
        int res = process(nums,0,0);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int process(int[] nums, int index, int steps){
        int res = Integer.MAX_VALUE;
        if(index == nums.length-1){
            return steps;
        }
        if(nums[index] == 0){
            return res;
        }
        if(index + nums[index] >=  nums.length-1){
            return steps+1;
        }
        for (int i = index+1; i<nums.length && i <= index + nums[index]; i++) {
            res = Math.min(res, process(nums, i,  steps + 1));
        }
        return res;
    }

    public int jump2(int[] nums) {
        int res = process2(nums);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int process2(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp[nums.length-1].length; i++) {
            dp[nums.length-1][i]=i;
        }
        for (int index = dp.length-2; index >= 0; index--) {
            for (int steps = index; steps >=0; steps--) {
                int res = Integer.MAX_VALUE;
                if(nums[index] == 0){
                    dp[index][steps] = Integer.MAX_VALUE;
                    continue;
                }
                if(nums[index] + index >= nums.length-1){
                    dp[index][steps] = steps + 1;
                    continue;
                }
                for (int i = index+1; i<nums.length && i <= index + nums[index]; i++) {
                    res = Math.min(res, dp[i][steps + 1]);
                }
                dp[index][steps] = res;
//                if(steps == dp[index].length-1){
//                    dp[index][steps] = Integer.MAX_VALUE;
//                    continue;
//                }
//                dp[index][steps] = Math.min(dp[index][steps+1], dp[index+1][steps+1]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][0];
    }

    private int process3(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp[nums.length-1].length; i++) {
            dp[nums.length-1][i]=i;
        }
        for (int index = dp.length-2; index >= 0; index--) {
            for (int steps = index; steps >=0; steps--) {
                int res = Integer.MAX_VALUE;
                if(nums[index] == 0){
                    dp[index][steps] = Integer.MAX_VALUE;
                    continue;
                }
                if(nums[index] + index >= nums.length-1){
                    dp[index][steps] = steps + 1;
                    continue;
                }
                for (int i = index+1; i<nums.length && i <= index + nums[index]; i++) {
                    res = Math.min(res, dp[i][steps + 1]);
                }
                dp[index][steps] = res;
//                if(steps == dp[index].length-1){
//                    dp[index][steps] = Integer.MAX_VALUE;
//                    continue;
//                }
//                dp[index][steps] = Math.min(dp[index][steps+1], dp[index+1][steps+1]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][0];
    }

}
