package leetcode;

public class Item_29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }
        boolean dividendPositiveFlag = dividend > 0;
        boolean divisorPositiveFlag = divisor > 0;
        if(!dividendPositiveFlag){
            dividend = -dividend;
        }
        if(!divisorPositiveFlag){
            divisor = -divisor;
        }
        if(dividend < divisor){
            return 0;
        }
        int res = 0, count = 0;
        for (int i = 31; i >= 0; i--) {
            int tempRes = divisor, tempCount=1;
            for (int j = 1; j <= i; j++) {
                tempRes <<= 1;
                tempCount <<= 1;
                if(res > dividend){
                    tempRes >>= 1;
                    tempCount >>= 1;
                    break;
                }
            }
            res += tempRes;
            count += tempCount;
        }
        return !(dividendPositiveFlag ^ divisorPositiveFlag) ? count : -count;
    }

    public static void main(String[] args) {
//        System.out.println(divide(-1, -1));
        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(Integer.MIN_VALUE, -1));
//        System.out.println(divide(Integer.MIN_VALUE, 1));
//        System.out.println(divide(0, 1));
//        System.out.println(divide(1, 1));
//        System.out.println(divide(Integer.MAX_VALUE, 1));
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
