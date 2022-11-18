package leetcode;

public class Item_179 {
    public static String largestNumber(int[] nums) {
        for (int num : nums) {
        }
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    public static int getFirstBit(int n){
        while(n / 10 != 0){
            n = n/10;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(getFirstBit(501));
        System.out.println(getFirstBit(3));
    }
}
