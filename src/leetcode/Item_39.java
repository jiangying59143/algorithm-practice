package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, 0,  target, list, new ArrayList<>());
        return list;
    }

    private void process(int[] candidates, int index, int target, List<List<Integer>> res, List<Integer> subList){
        if(target< 0){
            return;
        }else if(target == 0){
            res.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            subList.add(candidates[i]);
            process(candidates, i, target-candidates[i], res, subList);
            if(subList.size() > 0)subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args) {
        Item_39 item_39 = new Item_39();
        List<List<Integer>> list = item_39.combinationSum(new int[]{2,3,6,7}, 7);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}
