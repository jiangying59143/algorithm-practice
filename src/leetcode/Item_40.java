package leetcode;

import java.util.*;

public class Item_40 {
    public static void main(String[] args) {
        Item_40 item_40 = new Item_40();
        List<List<Integer>> res = item_40.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println("-----------------");
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

    private class Candidate{
        public int item;
        public int size;

        public Candidate(int item, int size) {
            this.item = item;
            this.size = size;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(new Candidate(candidates[0], 1));
        for (int i = 1; i < candidates.length; i++) {
            if(candidates[i] == candidates[i-1]){
                candidateList.get(candidateList.size()-1).size++;
            }
            else{
                candidateList.add(new Candidate(candidates[i], 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        process(candidateList, 0, target, new Integer[candidates.length], 0, res);
        return res;
    }
    private void process(List<Candidate> candidateList, int index, int target,Integer[] path, int pathSize, List<List<Integer>> res){
        if(target == 0){
            res.add(Arrays.asList(Arrays.copyOf(path, pathSize)));
            return;
        }else if(target < 0){
            return;
        }
        for (int i = index; i < candidateList.size(); i++) {
            if(target-candidateList.get(i).item < 0) continue;
            for (int j = candidateList.get(i).size; j >= 1; j--) {
                for (int k = 0; k < j; k++) {
                    path[pathSize++] = candidateList.get(i).item;
                }
                process(candidateList, i+1, target-candidateList.get(i).item*j, path, pathSize, res);
                for (int k = 0; k < j; k++) {
                    pathSize--;
                }
            }
        }
    }
}
