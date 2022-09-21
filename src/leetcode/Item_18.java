package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_18 {
    public static void main(String[] args) {
//        List<List<Integer>> res = fourSum(new int[]{2,2,2,2,2},8);
//        List<List<Integer>> res = fourSum(new int[]{1,0,-1,0,-2,2},0);
        List<List<Integer>> res = fourSum(new int[]{-1,0,1,2,-1,-4},-1);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if((long)nums[nums.length-4] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target) break;
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            if((long)nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target) continue;
            for(int j=i+1; j<nums.length-2; j++ ){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                if((long)nums[i] + nums[j] + nums[nums.length-1] + nums[nums.length-2] < target) continue;
                int left = j+1, right=nums.length-1;
                while(left < right){
                    if((long)nums[i] + nums[j] + nums[left] + nums[right] == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left+1 < right && nums[left+1] == nums[left]){
                            left++;
                        }
                        left++;
                        while(left < right-1 && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if((long)nums[i] + nums[j] + nums[left] + nums[right] > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }

        }
        return res;
    }
}
