package leetcode_review;

public class Item_172 {
    public static int trailingZeroes(int n) {
        int base = 5;
        int ans = 0;
        int num = 1;
        while(n/base != 0){
            ans += n/base;
            base = (int)Math.pow(5, ++num);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(100));
    }
}
