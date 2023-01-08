package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Item_179 {
    public static String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        if(numStrs[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStrs.length; i++) {
            sb.append(numStrs[i]);
        }
        return sb.toString();
    }

    public static String largestNumber0(int[] nums) {
        for (int num : nums) {
        }
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }



    private static int getBitCount(int n){
        while(n / 10 != 0){
            n = n/10;
        }
        return n;
    }

    private static int getBit(int n, int bit){
        if(n / (int)(Math.pow(10, bit-1)) == 0){
            return -1;
        }
        return n / (int)(Math.pow(10, bit-1)) % 10;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
