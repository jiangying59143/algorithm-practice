package leetcode;

public class Item_91 {
    public static int numDecodings(String s) {
        return process(s, 0);
    }

    private static int process(String s, int i){
        if(i == s.length()){
            return 1;
        }
        if(s.charAt(i) == '0'){
            return 0;
        }

        int sum = 0;
        sum += process(s, i+1);
        if(i < s.length()-1){
            int a = s.charAt(i) - '0';
            int b = s.charAt(i+1) - '0';
            if(a * 10 + b <= 26){
                sum += process(s, i+2);
            }
        }
        return sum;
    }

    public static int numDecodings1(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            dp[i] += dp[i+1];
            if(i < s.length()-1 && 10 * (s.charAt(i) - '0') + s.charAt(i+1) - '0' <= 26){
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }

    public static int numDecodings2(String s) {
        int[] dp = new int[2];
        dp[s.length()%2] = 1;
        int sum = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0'){
                dp[i%2] = 0;
                continue;
            }
            sum = 0;
            sum += dp[(i+1) % 2];
            if(i < s.length()-1 && 10 * (s.charAt(i) - '0') + s.charAt(i+1) - '0' <= 26){
                sum += dp[(i+2) % 2];
            }
            dp[i%2] = sum;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings2("226"));
        System.out.println(numDecodings2("12"));
        System.out.println(numDecodings2("012"));
    }
}
