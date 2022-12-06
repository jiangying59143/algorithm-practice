package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_8 {

    static class Automation{
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> map = new HashMap<>() {
            {
                put("start", new String[]{"start", "signed", "number", "end"});
            }

            {
                put("signed", new String[]{"end", "end", "number", "end"});
            }

            {
                put("number", new String[]{"end", "end", "number", "end"});
            }

            {
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };


        public boolean get(char c){
            state = map.get(state)[get_col(c)];
            if("signed".equals(state)){
                sign = c == '-'? -1 : 1;
            }else if("number".equals(state)){
                ans = ans * 10 + (c - '0');
                if(ans * sign < Integer.MIN_VALUE){
                    ans = Integer.MIN_VALUE;
                    return false;
                }
                if(ans * sign > Integer.MAX_VALUE){
                    ans = Integer.MAX_VALUE;
                    return false;
                }
            }else if("end".equals(state)){
                return false;
            }
            return true;
        }

        private int get_col(char c){
            if(c == ' '){
                return 0;
            }else if(c == '+' || c == '-'){
                return 1;
            }else if(Character.isDigit(c)){
                return 2;
            }
            return 3;
        }
    }




    public static int myAtoi(String s) {
        Automation automation = new Automation();
        for (int i = 0; i < s.length(); i++) {
            if(!automation.get(s.charAt(i))){
                break;
            }
        }
        return automation.sign * (int)automation.ans;
    }





    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("+4193 with words"));
    }
}
