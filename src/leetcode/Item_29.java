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
        if(dividendPositiveFlag){
            dividend = -dividend;
        }
        if(divisorPositiveFlag){
            divisor = -divisor;
        }
        if(dividend > divisor){
            return 0;
        }
        int res = 0, count = 0;
        for (int i = 30; i >= 0; i--) {
            int tempRes = divisor, tempCount=1;
            for (int j = 1; j <= i; j++) {
                tempRes <<= 1;
                tempCount <<= 1;
                if(res+tempRes < dividend || res+tempRes >= 0){
                    tempRes >>>= 1;
                    tempCount >>= 1;
                    break;
                }
            }
            if(tempRes == divisor && i != 0){
                continue;
            }
            if(res+tempRes >= dividend && res+tempRes < 0) {
                res += tempRes;
                count += tempCount;
            }
        }
        return !(dividendPositiveFlag ^ divisorPositiveFlag) ? count : -count;
    }



    public static void main(String[] args) {

//        System.out.println(-1302479897 << 1);
//        System.out.println(divide(-1459848980, -1302479897) + " " + (-1459848980/-1302479897));
//        if(true){
//            return;
//        }
        int testCount = 10000000;
        for (int i = 0; i < testCount; i++) {
            int dividend = (int)(Integer.MIN_VALUE * Math.random() - 1) + (int)(Integer.MAX_VALUE * Math.random() + 1);
            int divisor = (int)(Integer.MIN_VALUE * Math.random() - 1) + (int)(Integer.MAX_VALUE * Math.random() + 1);
            if(divisor == 0){
                continue;
            }
            int res = divide(dividend, divisor);
            if(res != (dividend / divisor)){
                System.out.println(dividend + " " + divisor);
                System.out.println("correct: " + (dividend / divisor));
                System.out.println("wrong: " + res);
                break;
            }
        }
        System.out.println("end!");
    }
}
