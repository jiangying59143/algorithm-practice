package leetcode;

import java.util.*;

public class Item_30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], 1);
            }else{
                map.put(words[i], map.get(words[i])+1);
            }
        }
        int windowSize = words.length * words[0].length();
        if(s.length() < windowSize){
            return res;
        }
        int wordSize = words[0].length();
        for (int i = windowSize; i <= s.length(); i++) {
            boolean flag = wordsMatch(s.substring(i-windowSize, i), map, wordSize, tempMap);
            tempMap.clear();
            if(flag){
                res.add(i-windowSize);
            }
        }
        return res;
    }

    private static boolean wordsMatch(String s, Map<String, Integer> wordMap, int wordSize, Map<String, Integer> tempMap){
        for (int i = wordSize; i <= s.length(); i=i+wordSize) {
            String word = s.substring(i-wordSize, i);
            if (wordMap.containsKey(word)) {
                if (!tempMap.containsKey(word)) {
                    tempMap.put(word, 1);
                } else if (wordMap.get(word) > tempMap.get(word)) {
                    tempMap.put(word, tempMap.get(word) + 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(words);
        process(s, words, new boolean[words.length], new StringBuilder(), res);
        return res;
    }

    public static void process(String s, String[] words, boolean[] visited, StringBuilder sb, List<Integer> res){
        if(sb.length() == words.length*words[0].length()){
            res.addAll(findMatcher(s, sb.toString()));
            return;
        }
        for (int k = 0; k < words.length; k++) {
            if(visited[k] || k > 0 && words[k].equals(words[k-1]) && !visited[k-1]){
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

    private static List<Integer> findMatcher(String s, String matcher){
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(sb.length() < matcher.length()) {
                sb.append(s.charAt(i));
            }
            if(sb.length() == matcher.length()){
                if(matcher.equals(sb.toString())) {
                    list.add(i + 1 - matcher.length());
                }
                sb.delete(0,1);
            }
        }
        return list;
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
