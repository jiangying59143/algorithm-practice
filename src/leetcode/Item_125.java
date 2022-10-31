package leetcode;

import java.util.Locale;

public class Item_125 {
    public static boolean isPalindrome(String s) {
        String ss = s.toLowerCase();
        int L = 0;
        int R = ss.length()-1;
        while(L < R){
            int leftValue = (int)ss.charAt(L) - (int)'0';
            int rightValue = (int)ss.charAt(R) - (int)'0';
            while(!(leftValue >= 0 && leftValue <= 9
                    || leftValue >=49 && leftValue <= 74) && L < R){
                leftValue = (int)ss.charAt(++L) - (int)'0';
            }
            while(!(rightValue >= 0 && rightValue <= 9
                    || rightValue >=49 && rightValue <= 74) && L < R){
                rightValue = (int)ss.charAt(--R) - (int)'0';
            }

            if(leftValue == rightValue){
                L++;
                R--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int)'0');
        System.out.println((int)'a');
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("0P"));
    }
}
