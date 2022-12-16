package leetcode;

public class Item_169 {
    public static int majorityElement(int[] nums) {
        int left = 0, right=nums.length;
        while(left+1 < right){
            if(nums[left] != nums[left+1]){
                nums[left] = nums[--right];
                nums[left+1] = nums[--right];
                if(left > 0) left--;
            }else{
                left++;
            }
        }
        return nums[right-1];
    }

    public static void main(String[] args) {
        int[] nums;
//        nums = new int[]{3,2,3};
//        System.out.println(majorityElement(nums));
        nums = new int[]{2,2,1,1,1,2,2,2};
        System.out.println(majorityElement(nums));
    }
}
