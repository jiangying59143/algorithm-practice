package leetcode_review;

public class Item_198 {
    public static int rob(int[] nums) {
        return process(nums, nums.length-1);
    }

    private static int process(int[] nums, int i){
        if(i == 0){
            return nums[i];
        }
        if(i == 1){
            return Math.max(nums[0], nums[i]);
        }

        return Math.max(process(nums, i-1), process(nums, i-2) + nums[i]);
    }

    public static int rob2(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }

        int pre = nums[0], after = Math.max(nums[0], nums[1]), res = Math.max(pre, after);
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(pre + nums[i], after);
            pre = after;
            after = res;
        }

        return res;
    }

    public static int rob3(int[] nums){
        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[3];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[2] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[1];
    }
}
