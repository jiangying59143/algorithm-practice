package leetcode;

import java.util.List;

public class Item_127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord)){
            return 0;
        }
        boolean[] visited = new boolean[wordList.size()];

        return 0;
    }

    private static int process(String beginWord, String endWord, List<String> wordList,boolean[] visited, int visitSize){
        if(visitSize == wordList.size()){
            return 0;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if(beginWord.equals(endWord)){

            }
            if(!visited[i] && isdiffWithOneChar(beginWord, wordList.get(i))){

            }
        }
        return 0;
    }

    private static boolean isdiffWithOneChar(String word1, String word2){
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            diff += word1.charAt(i) == word2.charAt(i) ? 1 : 0;
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

    }
}
