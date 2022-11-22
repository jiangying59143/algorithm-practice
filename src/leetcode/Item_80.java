package leetcode;

import java.util.Arrays;

public class Item_80 {
    public static int removeDuplicates(int[] nums) {
        int num=nums[0], count=1, i=1, removeItemsLeft=1, removeItemsRight = 1;
        while(i < nums.length){
            if(num == nums[i]){
                count++;
            }else{
                num = nums[i];
                count = 1;
            }
            if(count <= 2){
                swap(nums, i, removeItemsLeft++);
            }
            removeItemsRight++;
            i++;
        }
        System.out.println(removeItemsLeft + " " + removeItemsRight);
        return removeItemsLeft == removeItemsRight ? nums.length : removeItemsLeft;
    }

    private static void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] arr;
        int length;
//        arr = new int[]{1,1,1,2,2,3};
//        length = removeDuplicates(arr);
//        System.out.println(Arrays.toString(arr) + " " + length);
//        arr = new int[]{0,0,1,1,1,1,2,3,3};
//        length = removeDuplicates(arr);
//        System.out.println(Arrays.toString(arr) + " " + length);
        arr = new int[]{0,0,0,1,1,1,2,2,2,2,3,3,3,3};
        length = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr) + " " + length);
        arr = new int[]{0,0};
        length = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr) + " " + length);
    }
}
