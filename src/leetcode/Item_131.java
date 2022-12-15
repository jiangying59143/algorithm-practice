package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        process(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void process(String s, int start, List<String> temp, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(temp));
        }
        for (int i = start+1; i <= s.length(); i++) {
            if(isPardline(s.substring(start, i))){
                temp.add(s.substring(start, i));
                process(s, i, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }

    private static boolean isPardline(String str){
        int left = 0, right = str.length()-1;
        while(left <= right){
            if(str.charAt(left++) != str.charAt(right--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res;
        res = partition("aab");
        for (int i = 0; i < res.size(); i++) {
            System.out.print(Arrays.toString(res.get(i).toArray()));
        }
        System.out.println();
    }
}
