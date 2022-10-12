package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_15 {
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if(nums==null || nums.length < 3) return new ArrayList<>();
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if(cur > 0) return res;
                if(i>0 && nums[i] == nums[i-1]) continue;
                int L = i+1;
                int R = nums.length-1;
                while(L < R) {
                    if (cur + nums[L] + nums[R] == 0) {
                        res.add(Arrays.asList(cur, nums[L], nums[R]));
                        while (L+1 < nums.length && nums[L] == nums[L + 1]) ++L;
                        while (R-1 > L && nums[R] == nums[R - 1]) --R;
                        ++L;
                        --R;
                    } else if (cur + nums[L] + nums[R] > 0) {
                        --R;
                    }else{
                        ++L;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        List<List<Integer>> res = obj.threeSum(new int[]{0,0,0});
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
}
