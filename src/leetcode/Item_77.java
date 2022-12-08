package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        process(n,k, 1, new ArrayList<>(), res);
        return res;
    }

    public static void process(int n, int k, int nIndex, List<Integer> list, List<List<Integer>> res){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(n - nIndex+1 < k - list.size()){
            return;
        }
        for (int i = nIndex; i <= n; i++) {
            list.add(i);
            process(n, k, i+1, list, res);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res;
        res= combine(4, 2);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(Arrays.toString(res.get(i).toArray()));
        }
        System.out.println();
    }
}
