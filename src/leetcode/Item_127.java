package leetcode;

import java.util.Arrays;
import java.util.List;

public class Item_127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        int res = process(beginWord, endWord, wordList, new boolean[wordList.size()], 0, 0);
        return res == Integer.MAX_VALUE ? 0 : res+1;
    }

    private static int process(String beginWord, String endWord, List<String> wordList,
                               boolean[] visited, int visitSize, int fulfillSize){
        if(beginWord.equals(endWord)){
            return fulfillSize;
        }
        if(visitSize == wordList.size()){
            return Integer.MAX_VALUE;
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size(); i++) {
            if(visited[i]){
               continue;
            }
            visited[i] = true;
            visitSize = visitSize+1;
            if(isDiffWithOneChar(beginWord, wordList.get(i))) {
                sum = Math.min(sum, process(wordList.get(i), endWord, wordList, visited, visitSize, fulfillSize+1));
            }
            visitSize = visitSize-1;
            visited[i] = false;
        }
        return sum;
    }

    private static boolean isDiffWithOneChar(String word1, String word2){
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            diff += word1.charAt(i) != word2.charAt(i) ? 1 : 0;
            if(diff > 1){
                return false;
            }
        }

        if(diff == 1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(ladderLength("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log")));
    }
}
