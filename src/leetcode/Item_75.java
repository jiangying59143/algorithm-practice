package leetcode;

import java.util.Arrays;

public class Item_75 {
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int left = -1, right = nums.length, i=0;
        while(i < right){
            if(nums[i] == 0){
                swap(nums, ++left, i);
                i++;
            }else if(nums[i] == 2){
                swap(nums, --right, i);
            }else{
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        if(i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{2,0,1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
