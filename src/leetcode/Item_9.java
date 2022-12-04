package leetcode;

public class Item_9 {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int maxBit = getMaxBit(x);
        int right = maxBit, left = 1;
        while(left < right){
            if(getBitDigit(x, left, maxBit) != getBitDigit(x, right, maxBit)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int revertNumber = 0;
        while(x > revertNumber){
            revertNumber = revertNumber * 10 + x % 10;
            x = x / 10;
        }
        return revertNumber == x || x == revertNumber / 10;
    }

    public static int getMaxBit(int x){
        int maxBit = 0;
        while(x != 0){
            maxBit++;
            x = x / 10;
        }
        return maxBit == 0 ? 1 : maxBit;
    }

    public static int getBitDigit(int x, int bit, int maxBit){
        return x / (int)Math.pow(10, bit-1) % 10;
    }

    public static void main(String[] args) {
        System.out.println(getBitDigit(100, 3, 3));
//        System.out.println(isPalindrome(0));
//        System.out.println(isPalindrome(10));
//        System.out.println(isPalindrome(101));
//        System.out.println(isPalindrome(1001));
//        System.out.println(isPalindrome(11001));

        System.out.println(isPalindrome(1111));
    }
}
