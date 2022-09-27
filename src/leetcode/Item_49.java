package leetcode;

import java.util.*;

public class Item_49 {
    public static void main(String[] args) {
        Item_49 obj = new Item_49();
        List<List<String>> res = obj.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);
            String keyStr = Arrays.toString(strArr);
            if(map.containsKey(keyStr)){
                map.get(keyStr).add(strs[i]);
            }else{
                map.put(keyStr, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}

