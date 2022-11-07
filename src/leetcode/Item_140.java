package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        process(s, wordDict, 0, new StringBuilder(), res);
        return res;
    }

    public static void process(String str, List<String> wordDict, int si, StringBuilder sb, List<String> list){
        if(si >= str.length()){
            list.add(sb.toString());
        }
        for (int i = 0; i < wordDict.size(); i++) {
            if(si+wordDict.get(i).length() <= str.length()
                    && wordDict.get(i).equals(str.substring(si, si+wordDict.get(i).length()))){
                sb.append(wordDict.get(i));
                if(si + wordDict.get(i).length() < str.length()){
                    sb.append(" ");
                }
                process(str, wordDict, si+wordDict.get(i).length(), sb, list);
                if(si + wordDict.get(i).length() < str.length()){
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.delete(sb.length()-wordDict.get(i).length(), sb.length());
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
        System.out.println(Arrays.toString(res.toArray()));
        res = wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));
        System.out.println(Arrays.toString(res.toArray()));
        res = wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println(Arrays.toString(res.toArray()));
    }
}
