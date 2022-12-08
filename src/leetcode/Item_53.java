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

}
