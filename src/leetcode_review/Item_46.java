package leetcode_review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Item_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        process(numsList, 0, ans);
        return ans;
    }

    private static void process(List<Integer> numsList, int start, List<List<Integer>> ans){
        if(start == numsList.size()){
            ans.add(new ArrayList<>(numsList));
        }

        for (int i = start; i < numsList.size(); i++) {
            Collections.swap(numsList, start, i);
            process(numsList, start+1, ans);
            Collections.swap(numsList, start, i);
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,2,3};
        List<List<Integer>> ans = permute(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(Arrays.toString(ans.get(i).toArray()));
        }
    }
}
