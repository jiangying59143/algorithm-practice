package leetcode;

public class Item_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, sum = 0, left = 0, right=0;
        while(sum < target && right < nums.length){
            sum += nums[right++];
            while(sum >= target && left < right){
                ans = Math.min(ans, right-left);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums;
        nums= new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
        nums= new int[]{1,4,4};
        System.out.println(minSubArrayLen(4, nums));
        nums= new int[]{1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(9, nums));
    }
}
