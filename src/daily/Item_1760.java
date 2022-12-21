package daily;

public class Item_1760 {
    public static int minimumSize(int[] nums, int maxOperations) {
        int[] numsConv = new int[nums.length+maxOperations];
        for (int i = 0; i < nums.length; i++) {
            numsConv[i] = nums[i];
        }
        return process(numsConv, nums.length, 0, maxOperations);
    }

    private static int process(int[] nums, int length, int index, int maxOperations){

        int maxIndex = getIndexWithMaxValue(nums, length+index);
        int max = nums[maxIndex];
        if(index  == maxOperations){
            return max;
        }

        int maxHalf = nums[maxIndex] >> 1;
        int res = max;
        for (int i = 1; i <= maxHalf; i++) {
            nums[maxIndex] = i;
            nums[length+index] = max-i;
            res = Math.min(res, process(nums, length, index+1, maxOperations));
            nums[maxIndex] = max;
            nums[length+index] = 0;
        }
        return res;
    }

    private static int getIndexWithMaxValue(int[] nums, int length){
        int maxNum = 0;
        int maxIndex = 0;
        for (int j = 0; j < length; j++) {
            if(nums[j] > maxNum){
                maxNum = nums[j];
                maxIndex = j;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums;
        int maxOperations;

        nums = new int[]{9};
        maxOperations=2;
        System.out.println(minimumSize(nums, maxOperations));

        nums = new int[]{2,4,8,2};
        maxOperations=4;
        System.out.println(minimumSize(nums, maxOperations));

        nums = new int[]{7,17};
        maxOperations=2;
        System.out.println(minimumSize(nums, maxOperations));
    }
}
