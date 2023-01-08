package leetcode_review;

import java.util.Arrays;
import java.util.Comparator;

public class Item_179 {
    public static String largestNumber(int[] nums) {
        Integer[] numsConv = new Integer[nums.length];
        for (int i = 0; i < numsConv.length; i++) {
            numsConv[i] = nums[i];
        }
        Arrays.sort(numsConv, (a, b)->{
                String s1 = a + "" + b;
                String s2 = b + "" + a;
                return s2.compareTo(s1);
        });

        if(numsConv[0] == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numsConv.length; i++) {
            sb.append(numsConv[i]);
        }
        return sb.toString();
    }
}
