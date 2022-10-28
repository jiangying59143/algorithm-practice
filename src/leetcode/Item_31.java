package leetcode;

import java.util.Arrays;

public class Item_31 {
    public static void nextPermutation(int[] nums) {
        int needChangeStartIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]){
                needChangeStartIndex = i;
                break;
            }
        }

        if(needChangeStartIndex != -1) {
            swap(nums, needChangeStartIndex, nearestBiger(nums, needChangeStartIndex));
        }
        reverse(nums, needChangeStartIndex+1, nums.length-1);
    }

    public static void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static int nearestBiger(int[] nums, int start){
        int L = start+1, R = nums.length-1, mid, res = start + 1;
        while(L <= R){
            mid = L + ((R-L)>>1);
            if(nums[mid] > nums[start]){
                L = mid+1;
                res = mid;
            }else{
                R = mid-1;
            }
        }
        return res;
    }

    public static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7,6,5,4,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
