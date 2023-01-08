package leetcode_review;

import java.util.HashSet;
import java.util.Set;

public class Item_3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Set<Character> charSet = new HashSet<>();
        int left = 0, ans = 0;
        for (int right = 0; right < s.length(); right++) {
            if(!charSet.contains(s.charAt(right))){
                charSet.add(s.charAt(right));
            }else{
                ans = Math.max(ans, right-left);
                while(charSet.contains(s.charAt(right))){
                    charSet.remove(s.charAt(left++));
                }
                charSet.add(s.charAt(right));
            }
        }
        ans = Math.max(ans, s.length()-left);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
