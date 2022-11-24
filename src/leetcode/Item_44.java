package leetcode;

public class Item_44 {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+2][p.length()+1];
        return process(s, p, 0, 0, dp);
    }

    private static boolean process(String s, String p, int si, int pi, boolean[][] dp){
        if(dp[si][pi]){
            return dp[si][pi];
        }
        if(si == s.length() && pi == p.length()){
            dp[si][pi] = true;
            return true;
        }
        if(si != s.length() && pi == p.length()){
            dp[si][pi] = false;
            return false;
        }

        if(si == s.length()+1 && pi != p.length()){
            dp[si][pi] = false;
            return false;
        }

        boolean res = false;
        if(p.charAt(pi) == '*'){
//            int leftLength = s.length()-si;
//            for (int i = 0; i <= leftLength; i++) {
//                if(process(s, p, si + i, pi+1)){
//                    return true;
//                }
//            }
            res = process(s, p, si, pi+1, dp) || process(s, p, si+1, pi, dp);
        }else if(si < s.length() && charMatch(s.charAt(si), p.charAt(pi))){
            res = process(s, p, si+1, pi+1, dp);
        }
        dp[si][pi] = res;
        return res;
    }

    private static boolean charMatch(char a, char b){
        return a == b || b == '?';
    }

    public static boolean isMatch1(String s, String p) {
        boolean res = false, diagonal = true, right = false, down = false;
        int sl = s.length(), pl = p.length();
        for (int si = sl; si >= 0; si--) {
            for (int pi = pl; pi >= 0; pi--) {
                if(p.charAt(pi) == '*'){
                    res = right || down;
                }else if(charMatch(s.charAt(si), p.charAt(pi))){
                    res = diagonal;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "?a"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "?a*"));
        System.out.println(isMatch("acdcb", "a*d?a"));
    }
}
