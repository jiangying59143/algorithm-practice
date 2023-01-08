package leetcode_review;

public class Item_171 {
    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        int base = 1;
        int baseTime = 1;
        for (int i = columnTitle.length()-1; i >= 0; i--) {
            ans += (columnTitle.charAt(i) - 'A' + 1)*base;
            base = (int)Math.pow(26, baseTime++);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
