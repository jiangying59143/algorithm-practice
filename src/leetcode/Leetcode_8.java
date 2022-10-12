package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_8 {
    static class Solution {
        public int myAtoi(String s) {
            if(s == null || s.length() < 1) return 0;
            LinkedList<Integer> stack = new LinkedList<>();
            char[] chars = s.toCharArray();
            boolean pon = true;
            // get the start position
            int start = 0;
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '-'){
                    pon = false;
                    start = i;
                    break;
                }
                if(chars[i] >='0' && chars[i] <= '9'){
                    stack.push(chars[i]-'0');
                    start = i;
                    break;
                }
            }
            boolean continuous = true;
            for (int i = start+1; i < chars.length; i++) {
                if(chars[i] >='0' && chars[i] <= '9' && continuous){
                    stack.push(chars[i]-'0');
                }else{
                    break;
                }
            }

            long ans = 0;
            int i=0;
            while(!stack.isEmpty()){
                int v = stack.pop();
                if(pon) ans += v * (int)Math.pow(10, i++);
                else ans -= v * (int)Math.pow(10, i++);
            }

            if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return (int)ans;
        }
    }

    public static int myAtoi(String s) {
        if(s == null || s.length() < 1) return 0;
        List<Integer> list = new ArrayList<>();
        s = s.trim();
        if(s == null || s.length() < 1) return 0;
        char[] chars = s.toCharArray();
        boolean pon = true;
        if(chars[0] >='0' && chars[0] <= '9' || chars[0] == '-' || chars[0] == '+'){
            if(chars[0] == '-') pon = false;
            else if(chars[0] == '+') pon = true;
            else list.add(chars[0]-'0');
        }else{
            return 0;
        }
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] >='0' && chars[i] <= '9'){
                list.add(chars[i]-'0');
            }else{
                break;
            }
        }

        long ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans = ans * 10 + list.get(i);
            if(pon && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(!pon && 0 - ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return pon ? (int)ans : (int)(0 - ans);
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.myAtoi("42"));
        System.out.println(myAtoi("  -42"));
        System.out.println(myAtoi("+-10"));
        System.out.println(myAtoi("3.123"));
        System.out.println(myAtoi("21474836460"));
        System.out.println(myAtoi("-6147483648"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("4193 with words"));
    }
}
