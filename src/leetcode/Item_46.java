package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_46{
    public static void main(String[] args) {
        Item_46 item_46 = new Item_46();
        List<List<Integer>> list = item_46.permute(new int[]{1,2,3});
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Integer[] numsConv = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsConv[i] = nums[i];
        }
        process(numsConv, 0, res);
        return res;
    }

    private void process(Integer[] nums, int index, List<List<Integer>> res){
        if(index == nums.length){
            res.add(Arrays.asList(Arrays.copyOf(nums,nums.length)));
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            process(nums, index+1, res);
            swap(nums, i, index);
        }
    }

    private void swap(Integer[] nums, int i, int j){
        if(i==j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
