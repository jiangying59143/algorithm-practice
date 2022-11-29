package leetcode;

public class Item_162 {
    public static int findPeakElement(int[] nums) {
        int L = 0, R = nums.length-1, mid = 0;
        while(L <= R){
            mid = L + ((R-L) >> 1);
            if(mid == 0 && mid+1 < nums.length && nums[mid] > nums[mid+1]
                    || mid == nums.length-1 && mid-1>=0 && nums[mid] > nums[mid-1]
                    || mid+1 < nums.length && mid-1>=0 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(mid+1 < nums.length && nums[mid] < nums[mid+1]){
                L = mid+1;
            }else {
                R = mid-1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{1,2,3,1};
        System.out.println(findPeakElement(arr));
        arr = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));

        arr = new int[]{0};
        System.out.println(findPeakElement(arr));
    }
}
