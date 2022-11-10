package leetcode;

import java.util.Arrays;

public class Item_34 {
    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = findNearestLeft(nums, target);
        int rightIndex = findNearestLeft(nums, target+1);

        if(leftIndex == -1 || leftIndex != -1 && nums[leftIndex] != target){
            return new int[]{-1, -1};
        }

        if(rightIndex == -1){
            return new int[]{leftIndex, nums.length-1};
        }
        return new int[]{leftIndex, rightIndex-1};
    }

    public static int findNearestLeft(int[] nums, int target){
        int L = 0, R = nums.length-1, mid, res=-1;
        while(L <= R){
            mid = L + ((R-L)>>1);
            if(nums[mid] == target){
                res = mid;
                R = mid -1;
            }else if(nums[mid] < target){
                L = mid+1;
            }else{
                res = mid;
                R = mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 7)));
        arr = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));
        arr = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 6)));
        arr = new int[]{};
        System.out.println(Arrays.toString(searchRange(arr, 0)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2,4,5}, 2)));
    }
}
