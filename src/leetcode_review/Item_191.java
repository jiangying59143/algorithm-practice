package leetcode_review;

public class Item_191 {
    public static int hammingWeight(int n) {
        int count = 0;
        for (; n != 0; n >>>= 1) {
            count += ((n & 1) == 1 ? 1 : 0);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
