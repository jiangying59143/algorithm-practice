package leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 */
public class Item_50 {

    public static double myPow(double x, int n){
        if(n == 0){
            return 1D;
        }
        double ans = 1D;
        int pow = n == Integer.MIN_VALUE ? n+1 : n;

        if(pow < 0){
            pow = -pow;
        }

        double t = x;
        for(;pow != 0; pow>>=1){
            if((pow & 1) == 1){
                ans *= t;
            }
            t *=t;
        }
        if(n == Integer.MIN_VALUE){
            ans *= x;
        }

        return n < 0 ? 1D/ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,10));
        System.out.println(myPow(2,Integer.MIN_VALUE));
        System.out.println(myPow(2,-2));
        System.out.println(myPow(42.38803d, 1));
    }
}
