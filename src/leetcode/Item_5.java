package leetcode;

import java.util.Arrays;

public class Item_5 {

    public static void main(String[] args) {
        Item_5 obj = new Item_5();
        String s = "babad";
        System.out.println(obj.longestPalindrome1(s) + " " + obj.longestPalindrome(s));
        s = "cbbd";
        System.out.println(obj.longestPalindrome1(s) + " " + obj.longestPalindrome(s));

        System.out.println(-1 >> 1);
        System.out.println(((0-1)/2));
    }

    // manacher
    public String longestPalindrome1(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        s = getSpeArr(s);
        int c = 0, r = 0;
        int[] parr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            //i-2*(i-c)
            // r 是第一个违规的点
            parr[i] = i<r ? Math.min(parr[2*c-i], r-i) : 1;
            while(i-parr[i] >= 0 && i+parr[i] < s.length()){
                if(s.charAt(i-parr[i]) == s.charAt(i+parr[i])){
                    parr[i]++;
                }else{
                    break;
                }
            }
            if(i + parr[i]- 1 > r){
                r = i + parr[i]- 1;
                c = i;
            }
        }
        int max = 0;
        for (int i = 0; i < parr.length; i++) {
            if(parr[i] > max){
                max = parr[i];
                c = i;
            }
        }
        return s.substring(c - (parr[c] - 1), c + parr[c] - 1).replace("#", "");
    }

    //中心扩展
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        s = getSpeArr(s);
        int c=0;
        int r=0;
        for (int i = 1; i < s.length(); i++) {
            int cr = 0;
            while(i-cr >= 0 && i+cr < s.length() && s.charAt(i-cr) == s.charAt(i+cr)){
                cr++;
            }
            cr--;
            if(cr > r){
                c = i;
                r = cr;
            }
        }
        String res = s.substring(c-r, c+r+1).replace("#", "");
        return res;
    }

    private String getSpeArr(String s){
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        sb.append("#");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append("#");
        }
        sb.append("#");
        return sb.toString();
    }
}
