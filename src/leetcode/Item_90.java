package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            boolean[] visited = new boolean[nums.length];
            process(nums, i, 0, list, res, visited);
            list.clear();
        }
        return res;
    }

    private static void process(int[] nums, int count, int index,
                                List<Integer> list, List<List<Integer>> res, boolean[] visited){
        if(list.size() == count){
            res.add(new ArrayList<>(list));
            return;
        }

        if(nums.length - index < count - list.size()){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            process(nums, count, i+1, list, res, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(Arrays.toString(res.get(i).toArray()));
        }
        System.out.println();
    }
}
