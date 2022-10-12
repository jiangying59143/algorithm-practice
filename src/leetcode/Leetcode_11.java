package leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 */
public class Leetcode_11 {
    static class Solution {
        static final Map<Integer, String> map = new LinkedHashMap<>();
        static {
            map.put(1000,"M");
            map.put(900,"CM");
            map.put(500, "D");
            map.put(400, "CD");
            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");

        }
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Integer, String> entry : map.entrySet()){
                int divideV = num / entry.getKey();
                num = num % entry.getKey();
                for(int i=0; i< divideV; i++){
                    sb.append(entry.getValue());
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.intToRoman(58));
    }
}
