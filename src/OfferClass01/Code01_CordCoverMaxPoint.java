package OfferClass01;

import java.util.Arrays;

/**
 * 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子的长度，返回绳子最多压中几个点？
 * 即使绳子边缘处盖住点也算盖住
 */
public class Code01_CordCoverMaxPoint {
    public static int f1(int[] arr, int l){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = nearestLeft(arr, arr[i]-l, i);
            count = Math.max(i-index+1, count);
        }
        return count;
    }

    private static int nearestLeft(int[] arr, int target, int R){
        int L = 0, mid=0;
        while(L <= R){
            mid = L + ((R-L)>>1);
            if(arr[mid] >= target){
                R = mid-1;
            }else{
                L = mid+1;
            }
        }
        return mid;
    }

    public static int f2(int[] arr, int l){
        int L = 0, R = 0;
        int count = 0;
        while(R < arr.length){
            while(R < arr.length && arr[R]-arr[L] <= l){
                R++;
            }
            count = Math.max(R-L, count);
            L++;
        }
        return count;
    }

    public static int force(int[] arr, int l){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] >= arr[i]-l){
                    count = Math.max(count, i-j+1);
                    break;
                }
            }
        }
        return count;
    }

    public static int[] generateArr(int maxLength, int maxDistance){
        int[] arr = new int[(int)(Math.random()*maxLength+1)];
        arr[0] = (int)(Math.random()*maxDistance+1);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + (int)(Math.random()*maxDistance+1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testCount = 10000;
        System.out.println("start!");
        for (int i = 0; i < testCount; i++) {
            int maxLength = 1000;
            int maxDistance = 10;
            int[] arr = generateArr(maxLength, maxDistance);
            int cordLength = (int)(Math.random()*100+1);

            int ans1 = f1(arr, cordLength);
            int ans2 = f2(arr, cordLength);
            int ans3 = force(arr, cordLength);

            if(!(ans1 == ans2 && ans2 == ans3)){
                System.out.println("Oops!!");
                System.out.println(Arrays.toString(arr));
                System.out.println(cordLength);

                System.out.println("--------------");

                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(ans3);
                break;
            }
        }
        System.out.println("end!");
    }
}
