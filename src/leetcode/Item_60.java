package leetcode;

public class Item_60 {

    public static void main(String[] args) {
        System.out.println( getPermutation(3, 3));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int factorial = getFactorial(n-1);
        int number = k / factorial;
        while(number != 0 || k != 0){
            if(number != 0){
                sb.append(number+1);
            }else{
                sb.append(k);
            }

            k = k % factorial;
            factorial = factorial / --n;

            number = k / factorial;
        }

        return sb.toString();
    }

    private static int getFactorial(int n){
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
