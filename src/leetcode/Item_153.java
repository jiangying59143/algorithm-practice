package leetcode;

public class Item_153 {
    //wrong
    public static int findMin(int[] nums) {
        int L = 0, R = nums.length-1, mid;
        if(nums[R] >= nums[0]){
            return nums[0];
        }

        while(L <= R){
            mid = L + ((R - L) >> 1);
            if(nums[mid] < nums[0] && (mid == nums.length-1 || nums[mid] <= nums[mid+1])){
                return nums[mid];
            }else if(nums[mid] > nums[0] && nums[mid] >= nums[nums.length-1]){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }

        return -1;
    }

    public static int findMin2(int[] nums){
        int L=0, R=nums.length-1, mid;
        while(L <= R){
            mid = L+ ((R-L)>>1);
            if(nums[mid] < nums[0] && nums[mid] < nums[mid-1]){
                return nums[mid];
            }else if(nums[mid] > nums[nums.length-1]){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(findMin2(new int[]{3,4,5,1,2}));
        System.out.println(findMin2(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin2(new int[]{11,13,15,17}));
        System.out.println(findMin2(new int[]{2,1}));
    }

}
