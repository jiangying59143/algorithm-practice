package leetcode;

public class Item_41 {
    public static int firstMissingPositive(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
                temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{1,1}));
    }
}
