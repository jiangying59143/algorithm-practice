package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        if(((numerator & Integer.MIN_VALUE) ^ (denominator & Integer.MIN_VALUE)) != 0){
            sb.append("-");
        }
        Long numeratorLong = Math.abs(Long.valueOf(numerator));
        Long denominatorLong = Math.abs(Long.valueOf(denominator));
        sb.append(numeratorLong / denominatorLong);
        numeratorLong = numeratorLong % denominatorLong;

        if(numeratorLong != 0){
            sb.append(".");
        }else{
            return sb.toString();
        }

        Map<Long, Integer> numberPosMap = new HashMap<>();
        while(numeratorLong != 0){
            if(numberPosMap.containsKey(numeratorLong)){
                sb.insert(numberPosMap.get(numeratorLong), "(");
                sb.append(")");
                break;
            }
            numberPosMap.put(numeratorLong, sb.length());
            sb.append(numeratorLong * 10 / denominatorLong);
            numeratorLong = numeratorLong * 10 % denominatorLong;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println((1^0));
//        System.out.println(((-1 & Integer.MIN_VALUE) ^ (2 & Integer.MIN_VALUE)));
        System.out.println(fractionToDecimal(1,2));
        System.out.println(fractionToDecimal(2,1));
        System.out.println(fractionToDecimal(4,333));
        System.out.println(fractionToDecimal(1,333));
        System.out.println(fractionToDecimal(-50,8));
        System.out.println(fractionToDecimal(1, Integer.MIN_VALUE));

        System.out.println(fractionToDecimal(Integer.MIN_VALUE, -1));
    }
}
