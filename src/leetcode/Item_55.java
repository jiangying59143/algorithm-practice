package leetcode;

public class Item_55 {
    public static boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        return process(nums, 0, dp);
    }

    public static boolean process(int[] nums, int i, int[] dp){
        if(dp[i] != 0){
            return dp[i] == 1 ? true : false;
        }
        if(i == nums.length-1){
            dp[i]=1;
            return true;
        }else if(nums[i] == 0){
            dp[i]=2;
            return false;
        }
        for (int j = 1; j <= nums[i]; j++) {
            if(process(nums, i+j, dp)){
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 2;
        return false;
    }

    public static boolean canJump2(int[] nums){
        int[] dp = new int[nums.length];
        dp[dp.length-1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            if(nums[i] == 0){
                dp[i] = 2;
                continue;
            }
            dp[i] = 2;
            for (int j = 1; j <= nums[i]; j++) {
                if(dp.length-1-j >= i && dp[i+j] == 1){
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[0] == 1 ? true : false;
    }

    public static boolean canJump3(int[] nums){
        int maxDestIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(maxDestIndex < nums.length-1 && i == maxDestIndex && nums[maxDestIndex] == 0){
                return false;
            }
            if(nums.length-1-nums[i] <= i){
                return true;
            }
            if(i + nums[i] > maxDestIndex) {
                maxDestIndex = i + nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr;
//        arr = new int[]{2,3,1,1,4};
//        System.out.println(canJump3(arr));
//        arr = new int[]{3,2,1,0,4};
//        System.out.println(canJump3(arr));
//        arr = new int[]{2,0,0};
//        System.out.println(canJump3(arr));
        arr = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump3(arr));
    }
}
