package leetcode;

import java.util.Arrays;

public class Leetcode_16 {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int distance = Integer.MAX_VALUE;
            int ans = target;
            for (int i = 0; i < nums.length-2; i++) {
                int L = i+1;
                int R = nums.length-1;
                while(L < R) {
                    while(L+1 < R && nums[L+1] == nums[L]){
                        L++;
                    }
                    while(R-1 > L && nums[R-1] == nums[R]){
                        R--;
                    }
                    if (nums[i] + nums[L] + nums[R] < target) {
                        if(distance > target - (nums[i] + nums[L] + nums[R])){
                            distance =  target - (nums[i] + nums[L] + nums[R]);
                            ans = nums[i] + nums[L] + nums[R];
                        }
                        L++;
                    }else if(nums[i] + nums[L] + nums[R] == target){
                        return nums[i] + nums[L] + nums[R];
                    }else{
                        if(distance > nums[i] + nums[L] + nums[R] - target){
                            distance =  nums[i] + nums[L] + nums[R] - target;
                            ans = nums[i] + nums[L] + nums[R];
                        }
                        R--;
                    }
                }
            }
            return ans;
        }


    }
}
