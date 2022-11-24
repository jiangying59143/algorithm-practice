package leetcode;

public class Item_32 {
    public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] stack = new int[s.length()+1];
        int size = 0;
        stack[size++] = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack[size++] = i;
            }else{
                size--;
                if(size == 0){
                    stack[size++] = i;
                }else{
                    ans = Math.max(ans, i-stack[size-1]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }
}
