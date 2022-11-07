package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_146 {

    static class LRUCache {
        Map<Integer, Integer> valueMap = new HashMap<>();
        Map<Integer, Integer> mapToKey = new HashMap<>();
        int[] keyArr;
        int start = 0, end = 0, size = 0;
        public LRUCache(int capacity) {
            keyArr = new int[capacity];
        }

        public int get(int key) {
            int res;
            if(valueMap.containsKey(key)) {
                int preIndex = mapToKey.get(key);
                int lastIndex = end-1 < 0 ? size-1 : end-1;
                mapToKey.put(key, lastIndex);
                mapToKey.put(keyArr[lastIndex], preIndex);
                swap(keyArr, preIndex, lastIndex);
                res = valueMap.get(key);
            }else{
                res = -1;
            }
            System.out.println(res);
            return res;
        }

        public void put(int key, int value) {
            if(valueMap.containsKey(key)){
                valueMap.put(key, value);
                int preIndex = mapToKey.get(key);
                int lastIndex = end-1 < 0 ? size-1 : end-1;
                mapToKey.put(key, lastIndex);
                mapToKey.put(keyArr[lastIndex], preIndex);
                swap(keyArr, preIndex, lastIndex);
            }else{
                if(size == keyArr.length) {
                    valueMap.remove(keyArr[start]);
                    mapToKey.remove(keyArr[start]);
                    start = (start+1) % keyArr.length;
                }
                valueMap.put(key, value);
                mapToKey.put(key, end);
                keyArr[end] = key;
                if(size < keyArr.length) {
                    size++;
                }
                end = (end+1) % keyArr.length;
            }
        }

        private void swap(int[] arr, int i, int j){
            if(i == j){
                return;
            }
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
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

        System.out.println("--------------");
        lRUCache = new LRUCache(3);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.put(3, 3);
        lRUCache.put(4, 4); // 2, 3, 4
        lRUCache.get(4); // 2, 3, 4
        lRUCache.get(3); // 2, 4, 3
        lRUCache.get(2); // 4, 3, 2
        lRUCache.get(1);
        lRUCache.put(5, 5); // 5, 3, 2
        lRUCache.get(1);
        lRUCache.get(2);
        lRUCache.get(3);
        lRUCache.get(4);
        lRUCache.get(5);
    }
}
