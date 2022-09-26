package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Item_47 {
    public static void main(String[] args) {
        Item_47 item_47 = new Item_47();
        List<List<Integer>> res = item_47.permuteUnique(new int[]{0, 0, 0, 1, 9});
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        process(nums, 0, res);
        return res;
    }

    private void process(int[] nums, int swapPosition, List<List<Integer>> res){
        if(swapPosition == nums.length){
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        for (int i = swapPosition; i < nums.length; i++) {
            if(i > swapPosition && nums[swapPosition] == nums[i]) continue;
            swap(nums, i, swapPosition);
            if(i-swapPosition > 1) swap(nums, i-1, i);
            process(nums, swapPosition+1, res);
            if(i-swapPosition > 1) swap(nums, i-1, i);
            swap(nums, i, swapPosition);
        }
    }

    private void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}