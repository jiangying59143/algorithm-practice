package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_208 {
    static class TrieNode{
        public int pass;
        public int end;
        public Map<Character, TrieNode> next;

        public TrieNode() {
            this.pass = 1;
            this.end = 0;
            next = new HashMap<>();
        }
    }
    static class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            int wordSize = word.length();
            for (int i = 0; i < wordSize; i++) {
                char c = word.charAt(i);
                if(!node.next.containsKey(c)){
                    node.next.put(c, new TrieNode());
                }else{
                    node.next.get(c).pass++;
                }
                if(i == wordSize-1){
                    node.next.get(c).end++;
                }
                node = node.next.get(c);
            }


        }

        public boolean search(String word) {
            TrieNode node = root;
            int wordSize = word.length();
            for (int i = 0; i < wordSize; i++) {
                char c = word.charAt(i);
                if(!node.next.containsKey(c)){
                    return false;
                }
                if(i == wordSize-1 && node.next.get(c).end == 0){
                    return false;
                }
                node = node.next.get(c);
            }

            return true;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            int wordSize = prefix.length();
            for (int i = 0; i < wordSize; i++) {
                char c = prefix.charAt(i);
                if(!node.next.containsKey(c)){
                    return false;
                }
                node = node.next.get(c);
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app")); // 返回 True
    }
}
