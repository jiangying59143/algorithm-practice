package leetcode;

public class Item_97 {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        return process(s1, s2, s3, 0,0,0, dp);
    }

    private static boolean process(String s1, String s2, String s3, int i1, int i2, int i3, int[][][] dp){
        if(dp[i1][i2][i3] != 0){
            return dp[i1][i2][i3] == 1 ? true : false;
        }
        if(s1.length() == i1 && s2.length() == i2 && s3.length() == i3){
            dp[i1][i2][i3] = 1;
            return true;
        }
        boolean equalS1 = i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3),
                equalS2 = i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3);
        if(!equalS1 && !equalS2){
            dp[i1][i2][i3] = 2;
            return false;
        }else{
            boolean res;
            if(equalS1 && equalS2){
                res = process(s1, s2, s3, i1+1, i2, i3+1, dp)
                    || process(s1, s2, s3, i1, i2+1, i3+1, dp);
            }else if(equalS1){
                res = process(s1, s2, s3, i1 + 1, i2, i3+1, dp);
            }else{
                res = process(s1, s2, s3, i1, i2+1, i3+1, dp);
            }
            dp[i1][i2][i3] = res == true ? 1 : 2;
            return res;
        }
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
        s1 = "aabcc"; s2 = "dbbca"; s3 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
        s1 = ""; s2 = ""; s3 = "";
        System.out.println(isInterleave(s1, s2, s3));
        s1 = "aabc"; s2 = "abad"; s3 = "aabcabad";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
