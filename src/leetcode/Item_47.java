package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Item_47 {
    public static void main(String[] args) {
        Item_47 item_47 = new Item_47();
//        List<List<Integer>> res = item_47.permuteUnique(new int[]{0, 0, 0, 1, 9});
        List<List<Integer>> res = item_47.permuteUnique(new int[]{1, 1, 2, 2});
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        process(nums, res, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void process(int[] nums, List<List<Integer>> res, boolean[] visited, List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] || i > 0 && nums[i-1] == nums[i] && !visited[i-1]) continue;
            visited[i]=true;
            path.add(nums[i]);
            process(nums, res, visited, path);
            visited[i]=false;
            path.remove(path.size()-1);
        }
    }
}