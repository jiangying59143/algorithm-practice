package leetcode;

import java.util.Arrays;
import java.util.List;

public class Item_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return process(s, wordDict, 0);
    }

    public static boolean process(String str, List<String> wordDict, int si){
        if(si >= str.length()){
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            boolean res = false;
            if(si+wordDict.get(i).length() <= str.length()
                    && wordDict.get(i).equals(str.substring(si, si+wordDict.get(i).length()))){
                res = process(str, wordDict, si+wordDict.get(i).length());
            }
            if(res){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
