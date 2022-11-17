package leetcode;

import java.util.Arrays;

public class Item_167 {
    public static int[] twoSum(int[] numbers, int target) {
        int l =0, r = numbers.length-1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1, r+1};
            }else if(numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
        arr = new int[]{2,3,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}
