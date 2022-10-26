package OfferClass01;

/**
 * 给定一个非负整数num，如何不用循环语句，返回>=num，并且离num最近的，2的某次方
 */
public class Code03_Near2Power {
    public static int f1(int a){
        a = a-1;
        a |= a>>1;
        a |= a>>2;
        a |= a>>4;
        a |= a>>8;
        a |= a>>16;
        return a+1;
    }
    public static void main(String[] args) {
        System.out.println(f1(7));
        System.out.println(f1(8));
        System.out.println(f1(9));
        System.out.println(f1(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE);
    }
}
