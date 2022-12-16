package leetcode;

public class Item_137 {
    public static int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(num != 0){
                int mostRightOne = num & -num;
                int position = Integer.bitCount(mostRightOne-1);
                bits[position] += 1;
                num -= 1 << position;
            }
        }

        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            if(bits[i] % 3 == 1){
                res |= (1 << i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(3));
//        System.out.println(Integer.toBinaryString(-3));
//        System.out.println(3 & -3);

        int[] nums;
        nums = new int[]{2,2,3,2};
        System.out.println(singleNumber(nums));

        nums = new int[]{0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }
}
