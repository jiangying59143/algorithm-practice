package leetcode;

import java.util.Arrays;

public class Item_283 {
    public static void moveZeroes(int[] nums) {
        int L = -1, R = nums.length, i = 0;
        while(i < R){
            if(nums[i] != 0){
                swap(nums, i++, ++L);
            }else{
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
