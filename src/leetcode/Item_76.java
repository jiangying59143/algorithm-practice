package leetcode;

public class Item_76 {
    public static String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()){
            return "";
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < str2.length; i++) {
            map[str2[i]]++;
        }
        int all = str2.length;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        while(right != str1.length){
            map[str1[right]]--;
            if(map[str1[right]] >= 0){
                all--;
            }
            if(all == 0){
                while(map[str1[left]] < 0){
                    map[str1[left++]]++;
                }
                if(minLen > right-left+1){
                    minLen = right-left+1;
                    ans = s.substring(left, right+1);
                }
                all++;
                map[str1[left++]]++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
