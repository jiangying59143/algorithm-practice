package leetcode;

public class Item_53 {
    public static class Status{
        public int isum, lsum, rsum, msum;

        public Status(int isum, int lsum, int rsum, int msum) {
            this.isum = isum;
            this.lsum = lsum;
            this.rsum = rsum;
            this.msum = msum;
        }
    }

    public static int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length-1).msum;
    }


    private static Status getInfo(int[] nums, int start, int end){
        if(start == end){
            return new Status(nums[start], nums[start], nums[start], nums[start]);
        }
        int mid = start + ((end - start)>>1);
        Status left = getInfo(nums, start, mid),
                right = getInfo(nums, mid+1, end);

        return merge(left, right);
    }

    private static Status merge(Status l, Status r){
        int isum = l.isum + r.isum;
        int lsum = Math.max(l.lsum, l.isum+r.lsum);
        int rsum = Math.max(r.rsum, l.rsum+r.isum);
        int msum = Math.max(Math.max(l.msum, r.msum), l.rsum+r.lsum);
        return new Status(isum, lsum, rsum, msum);
    }

    /**
     * lSum 表示 [l,r] 内以 l 为左端点的最大子段和
     * rSum 表示 [l,r] 内以 r 为右端点的最大子段和
     * mSum 表示 [l,r] 内的最大子段和
     * iSum 表示 [l,r] 的区间和
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(0, sum);
            sum = num + sum;
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));

        nums = new int[]{1};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));

        nums = new int[]{5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));
    }

}
