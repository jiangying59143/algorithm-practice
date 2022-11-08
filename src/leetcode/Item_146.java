package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_146 {

    static class LRUCache {
        Map<Integer, DoubleEndNode> valueMap = new HashMap<>();
        int capacity;
        int index = 0;
        DoubleEndNode startNode = null, endNode = null;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int res;
            if(valueMap.containsKey(key)) {
                DoubleEndNode node = getNode(key);
                res = node.val;
            }else{
                res = -1;
            }
            System.out.println(res);
            return res;
        }

        public void put(int key, int value) {
            if(valueMap.containsKey(key)){
                DoubleEndNode node = getNode(key);
                node.val = value;
            }else{
                if(index == capacity) {
                    valueMap.remove(startNode.key);
                    startNode = startNode.next;
                    if(startNode != null)startNode.pre = null;
                }
                DoubleEndNode node = new DoubleEndNode(key, value);
                valueMap.put(key, node);
                if(startNode == null){
                    startNode = node;
                    endNode = node;
                }else {
                    node.pre = endNode;
                    endNode.next = node;
                    endNode = node;
                }
                if(index < capacity) {
                    index++;
                }
            }
        }

        private DoubleEndNode getNode(int key){
            DoubleEndNode node = valueMap.get(key);
            if(node == endNode){
                return node;
            }else if(node == startNode){
                startNode = startNode.next;
                startNode.pre = null;
            }else{
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }
            endNode.next = node;
            node.pre = endNode;
            node.next = null;
            endNode = node;
            return node;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//        lRUCache.get(4);    // 返回 4
//
//        System.out.println("--------------");
//        lRUCache = new LRUCache(3);
//        lRUCache.put(1, 1);
//        lRUCache.put(2, 2);
//        lRUCache.put(3, 3);
//        lRUCache.put(4, 4); // 2, 3, 4
//        lRUCache.get(4); // 2, 3, 4
//        lRUCache.get(3); // 2, 4, 3
//        lRUCache.get(2); // 4, 3, 2
//        lRUCache.get(1);
//        lRUCache.put(5, 5); // 5, 3, 2
//        lRUCache.get(1);
//        lRUCache.get(2);
//        lRUCache.get(3);
//        lRUCache.get(4);
//        lRUCache.get(5);
        System.out.println("--------------");
        lRUCache = new LRUCache(2);
        lRUCache.put(1, 0);
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.put(3, 3);
        lRUCache.get(2);
        lRUCache.put(4, 4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
    }
}
