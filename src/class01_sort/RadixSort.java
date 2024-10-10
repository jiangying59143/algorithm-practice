package class01_sort;

import common.MyGenerator;

import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] arr){
        processRadix(arr, getMaxBit(arr));
    }

    public static int getMaxBit(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        int res = 0;
        while(max != 0){
            res++;
            max /=10;
        }
        return res;
    }

    public static void processRadix(int[] arr, int bit){
        int buckets[] = new int[10];
        int[] help = new int[arr.length];
        for (int b = 1; b <= bit; b++) {
            for (int i = 0; i < arr.length; i++) {
                buckets[getBitNumber(arr[i], b)]++;
            }
            for (int i = 1; i < buckets.length; i++) {
                buckets[i] += buckets[i-1];
            }
            for (int i = arr.length-1; i >= 0; i--) {
                help[buckets[getBitNumber(arr[i], b)]-- -1] = arr[i];
            }
            System.arraycopy(help, 0, arr, 0, help.length);

            Arrays.fill(buckets, 0);

            System.out.println("-----------");
            System.out.println(Arrays.toString(arr));
            System.out.println("-----------");
        }
    }

    public static int getBitNumber(int x, int b){
        return x / (int)Math.pow(10, b-1) % 10;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{27,12,13,34,35,47,46};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr2);
        sort(arr3);
        for (int i = 0; i < arr.length; i++) {
            if(arr2[i] != arr3[i]){
                System.out.println(i);
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr2));
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
    }
}
