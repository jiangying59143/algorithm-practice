package leetcode_review;

import java.util.*;

public class Item_187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        //只用前20位
        int M = 0x000fffff;
        Map<Character, Integer> convertMap = new HashMap<>();
        convertMap.put('A', 0);
        convertMap.put('C', 1);
        convertMap.put('G', 2);
        convertMap.put('T', 3);
        Map<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(i < 9){
                temp = temp<<2 | convertMap.get(s.charAt(i));
            }else{
                temp = (temp<<2 | convertMap.get(s.charAt(i))) & M;
                if(!map.containsKey(temp)){
                    map.put(temp, 1);
                }else{
                    map.put(temp, map.get(temp)+1);
                    if(map.get(temp) == 2){
                        ans.add(s.substring(i-9, i+1));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans;
        ans = findRepeatedDnaSequences("AAAAAAAAAA");
        System.out.println(Arrays.toString(ans.toArray()));

        ans = findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(Arrays.toString(ans.toArray()));

        ans = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
