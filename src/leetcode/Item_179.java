package leetcode;

public class Item_179 {
    public static String largestNumber(int[] nums) {
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
        System.out.println(getBit(101, 1));
    }
}
