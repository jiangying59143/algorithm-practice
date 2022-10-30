package leetcode;

import java.util.*;

public class Item_128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        int res = 0;
        for (Integer item : numSet) {
            int len = 0;
            if(startMap.containsKey(item+1) && endMap.containsKey(item-1)){
                len = startMap.get(item+1) + endMap.get(item - 1) + 1;
                startMap.put(item - endMap.get(item - 1), len);
                endMap.remove(item - 1);
                endMap.put(item + startMap.get(item+1), len);
                startMap.remove(item+1);
            }else if(startMap.containsKey(item+1)){
                len = startMap.get(item+1)+1;
                endMap.put(item + len - 1, len);
                startMap.put(item, len);
                startMap.remove(item + 1);
            }else if(endMap.containsKey(item-1)) {
                len =  endMap.get(item - 1) + 1;
                startMap.put(item - len + 1, len);
                endMap.put(item, len);
                endMap.remove(item - 1);
            }

            if(len == 0){
                len = 1;
                startMap.put(item, len);
                endMap.put(item, len);
            }
            res = Math.max(res, len);
        }
//        for (Map.Entry<Integer, Integer> entry : startMap.entrySet()) {
//            int endKey = entry.getKey() + entry.getValue() -1;
//            System.out.println(entry + " " + endKey + "=" + endMap.get(endKey));
//        }
        return res;
    }

    public static int force(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        Arrays.sort(nums);
        int res = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                cur++;
            }else if(nums[i] - nums[i-1] != 0){
                res = Math.max(cur, res);
                cur = 1;
            }

            if(i == nums.length - 1){
                res = Math.max(cur, res);
            }
        }

//        System.out.println(Arrays.toString(nums));
        return res;
    }

    public static int[] generateArr(int maxLen){
        int[] arr = new int[(int)(Math.random()*maxLen + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*maxLen + 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testCount = 10000;
        for (int i = 0; i < testCount; i++) {
            int[] arr = generateArr(10);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            int ans1 = longestConsecutive(arr);
            int ans2 = force(arr1);
            if(ans1 != ans2){
                System.out.println("Oops!!!");
                System.out.println(Arrays.toString(arr));
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("Oops!!!");
                break;
            }
        }
        System.out.println("end!");
    }
}
