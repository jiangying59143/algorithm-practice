package leetcode_review;

import java.util.HashMap;
import java.util.Map;

public class Item_146 {
    static class LRUCache {

        static class DBEndNode{
            public int key;
            public int value;
            public DBEndNode pre;
            public DBEndNode next;

            public DBEndNode() {
            }

            public DBEndNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, DBEndNode> map;
        private DBEndNode head, tail;
        private int capacity;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new DBEndNode();
            tail = new DBEndNode();
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
        }

        public int Get(int key) {
            if(map.containsKey(key)){
                moveToHead(map.get(key));
                return map.get(key).value;
            }
            return -1;
        }

        public void Put(int key, int value) {
            if(map.containsKey(key)){
                map.get(key).value = value;
                moveToHead(map.get(key));
            }else{
                if(capacity > 0){
                    map.put(key, new DBEndNode(key, value));
                    insertToHead(map.get(key));
                    capacity--;
                }else{
                    map.remove(tail.pre.key);
                    removeNode(tail.pre);
                    map.put(key, new DBEndNode(key, value));
                    insertToHead(map.get(key));
                }
            }
        }

        private void moveToHead(DBEndNode node) {
            removeNode(node);
            insertToHead(node);
        }

        private void removeNode(DBEndNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void insertToHead(DBEndNode node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

    }
}
