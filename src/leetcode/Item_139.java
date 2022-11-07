package leetcode;

import java.util.Arrays;
import java.util.List;

public class Item_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
        return process(s, wordDict, 0, dp);
    }

    public static boolean process(String str, List<String> wordDict, int si, Boolean[] dp){
        if(dp[si] != null){
            return dp[si];
        }
        if(si >= str.length()){
            dp[si] = true;
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            boolean res = false;
            if(si+wordDict.get(i).length() <= str.length()
                    && wordDict.get(i).equals(str.substring(si, si+wordDict.get(i).length()))){
                res = process(str, wordDict, si+wordDict.get(i).length(), dp);
            }
            if(res){
                dp[si] = true;
                return true;
            }
        }
        dp[si] = false;
        return false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
        dp[s.length()] = true;
        for (int si = dp.length - 2; si >= 0; si--) {
            dp[si] = false;
            for (int i = 0; i < wordDict.size(); i++) {
                if(si+wordDict.get(i).length() <= s.length()
                        && wordDict.get(i).equals(s.substring(si, si+wordDict.get(i).length()))){
                    if(dp[si+wordDict.get(i).length()]){
                        dp[si] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")) == wordBreak2("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")) == wordBreak2("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")) == wordBreak2("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
