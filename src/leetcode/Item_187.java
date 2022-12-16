package leetcode;

import java.util.*;

public class Item_187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length()-10; i++) {
            for (int j = i+1; j < s.length()-9; j++) {
                if(s.substring(i, i+10).equals(s.substring(j, j+10))
                        && !res.contains(s.substring(i, i+10))){
                    res.add(s.substring(i, i+10));
                }
            }
        }
        return res;
    }

    public static List<String> findRepeatedDnaSequences1(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length()-9; i++) {
            if(!map.containsKey(s.substring(i, i+10))){
                map.put(s.substring(i, i+10), 1);
            }else{
                map.put(s.substring(i, i+10), map.get(s.substring(i, i+10))+1);
                if(map.get(s.substring(i, i+10)) == 2){
                    res.add(s.substring(i, i+10));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s;
        List<String> res;
        s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        res = findRepeatedDnaSequences1(s);
        System.out.println(Arrays.toString(res.toArray()));

        s = "AAAAAAAAAAAAA";
        res = findRepeatedDnaSequences1(s);
        System.out.println(Arrays.toString(res.toArray()));

        s = "AAAAAAAAA";
        res = findRepeatedDnaSequences1(s);
        System.out.println(Arrays.toString(res.toArray()));

        s = "AAAAAAAAAAA";
        res = findRepeatedDnaSequences1(s);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
