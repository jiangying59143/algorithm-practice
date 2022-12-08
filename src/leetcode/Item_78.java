package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            process(nums, i, 0, list, ans);
            list.clear();
        }
        return ans;
    }

    public static void process(int[] nums, int k, int nIndex, List<Integer> list, List<List<Integer>> res){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(nums.length - nIndex < k - list.size()){
            return;
        }

        for (int i = nIndex; i < nums.length; i++) {
            list.add(nums[i]);
            process(nums, k, i+1, list, res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res;
        int[] nums = new int[]{1,2,3};
        res= subsets(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(Arrays.toString(res.get(i).toArray()));
        }
        System.out.println();
    }
}
