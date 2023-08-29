package autil;

import java.util.Arrays;

public class ArrayUtil {
    public static void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
    public static void printIndex(int[] arr){
        int[] indexArr = new int[arr.length];
        for (int i = 0; i < indexArr.length; i++) {
            indexArr[i] = i;
        }
        System.out.println(Arrays.toString(indexArr));
    }
}
