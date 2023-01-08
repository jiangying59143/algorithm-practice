package leetcode_review;

import java.util.HashMap;
import java.util.Map;

public class Item_166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        StringBuilder sb = new StringBuilder();
        sb.append(numerator != 0 && (numerator & 1<<31) != (denominator & 1<< 31) ? "-" : "" );
        if(numeratorLong < 0) numeratorLong = -numeratorLong;
        if(denominatorLong < 0) denominatorLong = -denominatorLong;
        sb.append(numeratorLong / denominatorLong);
        numeratorLong = numeratorLong % denominatorLong;
        if(numeratorLong == 0){
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> moduloIndexMap = new HashMap<>();
        while(numeratorLong != 0 || moduloIndexMap.containsKey(numeratorLong)){
            if(moduloIndexMap.containsKey(numeratorLong)){
                sb.insert(moduloIndexMap.get(numeratorLong), "(");
                sb.append(")");
                break;
            }
            moduloIndexMap.put(numeratorLong, sb.length());
            sb.append(numeratorLong * 10 / denominatorLong);
            numeratorLong = numeratorLong * 10 % denominatorLong;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(1, Integer.MIN_VALUE));
        System.out.println(fractionToDecimal(-50, 8));
    }
}
