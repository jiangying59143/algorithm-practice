package leetcode;

import java.math.BigDecimal;

public class Item_172 {
    public static int trailingZeroes(int n) {
        int maxFiveCount = 0;
        int divident = n;
        while(n / 5 != 0){
            maxFiveCount++;
            n /= 5;
        }

        int count = 0;
        for (int fiveCount = maxFiveCount; fiveCount > 0; fiveCount--) {
            int divisor = 1;
            for (int i = 0; i < fiveCount; i++) {
                divisor *= 5;
            }
            count += divident / divisor;
        }

        return count;
    }

    private static int getFactorialZero(int n){
        if(n == 0){
            return 0;
        }
        BigDecimal i = new BigDecimal(1);
        for (int j = 1; j <= n; j++) {
            i = i.multiply(new BigDecimal(j));
        }
        String s = i.toString();
        int count = 0;
        for (int k = s.length()-1; k >= 0; k--) {
            if(s.charAt(k) != '0'){
                break;
            }
            count++;
        }
        return count;
    }

    private static void investigate(int n){
        for (int i = 0; i <= n; i++) {
            if(trailingZeroes(i) != getFactorialZero(i)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        investigate(10000);
    }

}
