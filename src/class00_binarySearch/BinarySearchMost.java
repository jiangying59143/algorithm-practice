package class00_binarySearch;

import autil.ArrayUtil;

import java.util.Arrays;

public class BinarySearchMost {
    public static int leftMost(int[] arr, int k){
        int i=0,j=arr.length-1, mid;
        while(i <= j){
            mid = (i+j) >>> 1;
            if(k <= arr[mid]){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }

    public static int rightMost(int[] arr, int k){
        int i=0,j=arr.length-1, mid;
        while(i <= j){
            mid = (i+j) >>> 1;
            if(arr[mid] <= k){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return i-1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4,4,4, 5, 6, 8};
        ArrayUtil.printArr(arr);
        ArrayUtil.printIndex(arr);
        System.out.println(leftMost(arr, 4) == 2);
        System.out.println(rightMost(arr, 4) == 4);

        System.out.println("7 插入位置 : " + leftMost(arr, 7));
        System.out.println("3 插入位置 : " + leftMost(arr, 3));
        System.out.println("7 的前任是 : " + rightMost(arr, 7));
    }
}
