package leetcode;

public class Item_44 {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        return process(s, p, 0, 0, dp);
    }

    private static boolean process(String s, String p, int si, int pi, boolean[][] dp){
        if(dp[si][pi]){
            return dp[si][pi];
        }
        if(si == s.length()  && pi == p.length()){
            dp[si][pi] = true;
            return true;
        }
        if(si == s.length() && p.charAt(pi) != '*' || si != s.length() && pi == p.length()){
            dp[si][pi] = false;
            return false;
        }
        boolean res = false;
        if(p.charAt(pi) == '*'){
            if(si == s.length()){
                res = process(s, p, si, pi+1, dp);
            }else{
                res = process(s, p, si, pi+1, dp) || process(s, p, si+1, pi, dp);
            }
        }else if(charMatch(s.charAt(si), p.charAt(pi))){
            res = process(s, p, si+1, pi+1, dp);
        }
        dp[si][pi] = res;
        return res;
    }

    private static boolean charMatch(char a, char b){
        return a == b || b == '?';
    }

    private static boolean process0(String s, String p, int si, int pi, boolean[][] dp){
        if(dp[si][pi]){
            return dp[si][pi];
        }
        if(si == s.length()  && pi == p.length()){
            dp[si][pi] = true;
            return true;
        }
        if(si != s.length() && pi == p.length()){
            dp[si][pi] = false;
            return false;
        }

        if(si == s.length() && pi != p.length()){
            dp[si][pi] = false;
            return false;
        }

        boolean res = false;
        if(p.charAt(pi) == '*'){
            int leftLength = s.length()-si;
            for (int i = 0; i <= leftLength; i++) {
                if(process0(s, p, si + i, pi+1, dp)){
                    res = true;
                    break;
                }
            }
        }else if(charMatch(s.charAt(si), p.charAt(pi))){
            res = process0(s, p, si+1, pi+1, dp);
        }
        dp[si][pi] = res;
        return res;
    }

    public static boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        int sl = s.length(), pl = p.length();
        for (int si = sl; si >= 0; si--) {
            for (int pi = pl; pi >= 0; pi--) {
                if(pi == pl) {
                    if (si == sl) {
                        dp[si][pi] = true;
                    } else {
                        dp[si][pi] = false;
                    }
                }else if(si == sl && p.charAt(pi) != '*'){
                    dp[si][pi] = false;
                }else if(p.charAt(pi) == '*'){
                    if(si == sl){
                        dp[si][pi] = dp[si][pi+1];
                    }else{
                        dp[si][pi] = dp[si][pi+1] || dp[si+1][pi];
                    }
                }else if(charMatch(s.charAt(si), p.charAt(pi))){
                    dp[si][pi] = dp[si+1][pi+1];
                }
            }
        }
        return dp[0][0];
    }

    public static boolean isMatch1(String s, String p) {
        boolean[][] dp = new boolean[2][p.length()+1];
        int sl = s.length(), pl = p.length();
        for (int si = sl; si >= 0; si--) {
            for (int pi = pl; pi >= 0; pi--) {
                dp[si % 2][pi] = false;
                if(pi == pl) {
                    if (si == sl) {
                        dp[si % 2][pi] = true;
                    } else {
                        dp[si % 2][pi] = false;
                    }
                }else if(si == sl && p.charAt(pi) != '*'){
                    dp[si % 2][pi] = false;
                }else if(p.charAt(pi) == '*'){
                    if(si == sl){
                        dp[si % 2][pi] = dp[si % 2][pi+1];
                    }else{
                        dp[si % 2][pi] = dp[si % 2][pi+1] || dp[(si+1) % 2][pi];
                    }
                }else if(charMatch(s.charAt(si), p.charAt(pi))){
                    dp[si % 2][pi] = dp[(si+1) % 2][pi+1];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(isMatch1("aa", "a"));
        System.out.println(isMatch1("aa", "?a"));
        System.out.println(isMatch1("aa", "*"));
        System.out.println(isMatch1("aa", "?a*"));
        System.out.println(isMatch1("acdcb", "a*d?b"));
        System.out.println(isMatch1("", "**"));
        System.out.println(isMatch1("bbbaab", "a**?***"));
    }
}
