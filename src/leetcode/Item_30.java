package leetcode;

import java.util.*;

public class Item_30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        process(s, words, new boolean[words.length], new StringBuilder(), res);
        return res;
    }

    public static void process(String s, String[] words, boolean[] visited, StringBuilder sb, List<Integer> res){
        if(sb.length() == words.length*words[0].length()){
            res.add(s.indexOf(sb.toString()));
        }
        for (int k = 0; k < words.length; k++) {
            if(visited[k]){
                continue;
            }
            sb.append(words[k]);
            if(s.indexOf(sb.toString()) == -1){
                sb.delete(sb.length()-words[k].length(),sb.length());
                continue;
            }
            visited[k] = true;
            process(s, words, visited, sb, res);
            sb.delete(sb.length()-words[k].length(),sb.length());
            visited[k] = false;
        }
    }

    public static void main(String[] args) {
        List<Integer> res;
        res = findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        System.out.println(Arrays.toString(res.toArray()));
        res = findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        System.out.println(Arrays.toString(res.toArray()));
        res = findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(Arrays.toString(res.toArray()));
    }
}
