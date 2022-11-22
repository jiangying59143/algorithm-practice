package leetcode;

public class Item_10 {
    public static void main(String[] args) {
//        Item_10 obj = new Item_10();
//        System.out.println(obj.index("abcde", "cde"));
        System.out.println(isMatch2("aa", "a"));
        System.out.println(isMatch2("aa", "a*"));
        System.out.println(isMatch2("ab", ".*"));
    }

    public static boolean isMatch(String s, String p) {
        return process(s, p, s.length(), p.length());
    }

    public static boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int si = 1; si < dp.length; si++) {
            for (int pi = 1; pi < dp[si].length; pi++) {
                if(charMatch(s, p, si-1, pi-1) && dp[si-1][pi-1]){
                    dp[si][pi] = true;
                }else if(p.charAt(pi-1) == '*'){
                    if(dp[si][pi-2]){
                        dp[si][pi] = true;
                        continue;
                    }
                    for (int i = si; i > 0; i--) {
                        if(charMatch(s, p, i-1, pi-2)){
                            if(dp[i-1][pi-2]){
                                dp[si][pi] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //按照字符串长度
    private static boolean process(String s, String p, int si, int pi){
        if(si == 0 && pi == 0){
            return true;
        }
        if(si <= 0 || pi <= 0){
            return false;
        }
        if(charMatch(s, p, si-1, pi-1) && process(s, p, si-1, pi-1)){
            return true;
        }else if(p.charAt(pi-1) == '*'){
            // * 前面得字符为0个
            if(process(s, p, si, pi-2)){
                return true;
            }
            while(si > 0){
                if(charMatch(s, p, si-1, pi-2)){
                    if(process(s, p, si-1, pi-2)){
                        return true;
                    }
                }
                si--;
            }
        }
        return false;
    }

    private static boolean process2(String s, String p, int si, int pi){
        if(si == -1 && pi == -1){
            return true;
        }
        if(si < 0 || pi < 0){
            return false;
        }
        if(charMatch(s, p, si, pi) && process2(s, p, si-1, pi-1)){
            return true;
        }else if(p.charAt(pi) == '*'){
            // * 前面得字符为0个
            if(process2(s, p, si, pi-2)){
               return true;
            }

            // * 前面得字符为1个
//            if(s.charAt(si) == p.charAt(pi-1) || p.charAt(pi) == '.'){
//                return process2(s, p, si-1, pi-2);
//            }


            // * 前面得字符为2个
//            if(s.charAt(si) == p.charAt(pi-1)){
//                if(s.charAt(si-1) == p.charAt(pi-1)) {
//                    return process2(s, p, si - 2, pi - 2);
//                }
//            }
//
//            // * 前面得字符为3个
//            if(s.charAt(si) == p.charAt(pi-1)){
//                if(s.charAt(si-1) == p.charAt(pi-1)) {
//                    if(s.charAt(si-2) == p.charAt(pi-1)) {
//                        return process2(s, p, si - 3, pi - 2);
//                    }
//                }
//            }

            while(si >= 0){
                if(charMatch(s, p, si, pi-1)){
                    if(process2(s, p, si-1, pi-2)){
                        return true;
                    }
                }
                si--;
            }
        }
        return false;
    }

    private static boolean charMatch(String s, String p, int si, int pi){
        return s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.';
    }

    public int index(String s, String p) {
        int[] next = getNext(p);
        int x = 0, y = 0;
        while(x < s.length() && y < p.length()){
            if(s.charAt(x) == p.charAt(y)){
                x++;
                y++;
            }else if(next[y] == -1){
                x++;
            }else{
                y = next[y];
            }
        }
        return y == p.length() ? x - y : -1;
    }

    public int[] getNext(String p){
        int[] next = new int[p.length()];
        int i=2, cn=0;
        next[0] = -1;
        next[1] = 0;
        while(i < p.length()){
            if(next[i-1] == next[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }

        return next;
    }
}
