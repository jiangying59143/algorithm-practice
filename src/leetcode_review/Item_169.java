package leetcode_review;

public class Item_169 {
    public static int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                candidate = nums[i];
            }
            count += (nums[i] == candidate ? 1 : -1);
        }
        return candidate;
    }

    public static int majorityElement(int[] nums) {
        int left = 1, right=nums.length;
        while(left < right){
            if(nums[left-1] != nums[left]){
                nums[left-1] = nums[--right];
                nums[left] = nums[--right];
                if(left > 0){
                    left--;
                }
            }else{
                left++;
            }
        }
        return nums[--right];
    }

    public static void main(String[] args) {

    }
}
