package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_3 {
    public static int lengthOfLongestSubstring(String s) {
        Integer L = 0, R = 0;
        Integer res = 0;
        Map<Character, Integer> windowCharMap = new HashMap();
        while(R < s.length()){
            if(windowCharMap.containsKey(s.charAt(R))){
                Integer removeEndIndex = windowCharMap.get(s.charAt(R));
                for (Integer i = L; i <= removeEndIndex; i++) {
                    windowCharMap.remove(s.charAt(i));
                }
                L = removeEndIndex+1;
            }
            windowCharMap.put(s.charAt(R), R++);
            res = Math.max(res, R-L);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
