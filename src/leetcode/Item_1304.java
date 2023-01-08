package leetcode;

import java.util.Arrays;

public class Item_1304 {
    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        if((n & 1) == 1){
            ans[n >> 1] = 0;
        }
        int leftHalfCount = n >> 1;
        for (int i = 0; i < leftHalfCount; i++) {
            ans[i] = -(i+1);
            if((n & 1) == 1){
                ans[leftHalfCount+1+i] = i+1;
            }else{
                ans[leftHalfCount+i] = i+1;
            }
        }
        return ans;
    }

    public static int fibo(int n){
        if(n == 1 || n==2) return 1;
        return fibo(n-1) + fibo(n-2);
    }


    public static void main(String[] args) {
        int[] ans;
        ans = sumZero(3);
        System.out.println(Arrays.toString(ans));

        ans = sumZero(2);
        System.out.println(Arrays.toString(ans));

        System.out.println(fibo(4));
    }
}
