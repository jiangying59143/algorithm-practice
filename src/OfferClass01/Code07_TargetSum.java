package OfferClass01;

import java.util.Arrays;

/**
 * 给定一个数组arr，你可以在每个数字之前决定+或者-但是必须所有数字都参与，再给定一个数target
 * 请问最后算出target的方法数
 */
public class Code07_TargetSum {

    public static int f1(int[] arr, int target){
        return process1(arr, 0, target);
    }

    private static int process1(int[] arr, int index, int rest){
        if(index == arr.length){
            return rest == 0 ? 1 : 0;
        }

        return process1(arr, index + 1, rest - arr[index]) + process1(arr, index + 1, rest + arr[index]);
    }

    public static int f2(int[] arr, int target){
        //全转变为正数，结果不变
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                arr[i] = -arr[i];
            }
            sum += arr[i];
        }
        if(target > sum || target < -sum){
            return 0;
        }

        // 奇偶性 要一致
        if((target & 1) != (sum & 1) ){
            return 0;
        }

        // P-N = T  => 2P = T + P+N => P= (T+sum)/2
        int p = (target+sum)/2;
        int[][] dp = new int[arr.length+1][p+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int res = process2(arr, 0, p, dp);
        return res;
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp){
        if(rest < 0){
            return 0;
        }
        if(dp[index][rest] != -1){
            return dp[index][rest];
        }
        if(index == arr.length){
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }

        int res = process2(arr, index+1, rest, dp) + process2(arr, index + 1, rest-arr[index], dp);
        dp[index][rest] = res;
        return res;
    }

    public static int f3(int[] arr, int target){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                arr[i] = -arr[i];
            }
            sum += arr[i];
        }
        //和 比最大还大或者最小还小
        if(target > sum || target < -sum){
            return 0;
        }

        // 奇偶性 要一致
        if((target & 1) != (sum & 1) ){
            return 0;
        }
        int p = (target+sum)/2;
        int[] dp = new int[p+1];
        dp[0] = 1;

        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = dp.length - 1; j >= 0; j--) {
                int second = 0;
                if(j - arr[i] >= 0) {
                    second = dp[j-arr[i]];
                };
                dp[j] = dp[j] + second;
            }
        }
        return dp[p];
    }

    public static int f4(int[] arr, int target){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                arr[i] = -arr[i];
            }
            sum += arr[i];
        }
        if(target > sum || target < -sum){
            return 0;
        }

        // 奇偶性 要一致
        if((target & 1) != (sum & 1) ){
            return 0;
        }
        int p = (target+sum)/2;
        int[][] dp = new int[arr.length+1][p+1];
        dp[arr.length][0] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                int second = 0;
                if(j - arr[i] >= 0) {
                    second = dp[i+1][j-arr[i]];
                };
                dp[i][j] = dp[i+1][j] + second;
            }
        }

        return dp[0][p];
    }

    public static int[] generateArr(int maxLength){
        int[] arr = new int[(int)(Math.random()*maxLength+1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*maxLength+(Math.random()*-maxLength));
        }
        return arr;
    }

    public static void main(String[] args) {
        int testCount = 100000;
        for (int i = 0; i < testCount; i++) {
            int maxLength = 10;
            int[] arr1 = generateArr(maxLength);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            int[] arr3 = Arrays.copyOf(arr1, arr1.length);
            int[] arr4 = Arrays.copyOf(arr1, arr1.length);
            int target = (int)(Math.random()*maxLength+(Math.random()*-maxLength));
            int ans1 = f1(arr1, target);
            int ans2 = f2(arr2, target);
            int ans3 = f3(arr3, target);
            int ans4 = f3(arr4, target);

            if(!(ans1 == ans2 && ans2 == ans3 && ans3 == ans4)){
                System.out.println(Arrays.toString(arr1));
                System.out.println(target);
                System.out.println(ans1 +" " + ans2 + " " + ans3);
                break;
            }
        }

        System.out.println("-------end-------");
    }
}
