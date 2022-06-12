package leetcode;

public class Item_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            /**
             * 把长度小的数组作为第一个参数 为了时间复杂度为 O(Log min(m, n))
             */
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        /**
         * 为偶数：ans = (leftMax + rightMin)/2.0
         *       leftCount=rightCount; (3 + 5 + 1)/2 = 4;
         *  为奇数：ans = leftMax
         *       leftCount+1 = rightCount; (3 + 4 + 1)/2 = 4;
         */
        // 右边序号和， 好理解写法 (m+n+1)/2，防整型溢出写法 m + (n-m+1)/2
        int rightIndexSum = m + ((n-m+1)>>1);
        int L = 0, R = m, m1, m2, firstArrLeft = Integer.MIN_VALUE, secondArrLeft = Integer.MIN_VALUE,
                firstArrRight = Integer.MAX_VALUE, secondArrRight = Integer.MAX_VALUE;
        while(L <= R){
            m1 = L + ((R-L)>>1);
            m2 = rightIndexSum-m1;
            //防止 m1-1 = -1
            firstArrLeft = m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1];
            //防止 m2-1 = -1
            secondArrLeft = m2 == 0 ? Integer.MIN_VALUE : nums2[m2-1];
            //防止m1 = m;
            firstArrRight = m1 == m ? Integer.MAX_VALUE : nums1[m1];
            //防止m2 = n;
            secondArrRight = m2 == n ? Integer.MAX_VALUE : nums2[m2];
            /**
             * 正确的case应该是交叉小于:nums1[m1-1] <= nums2[m2] && nums2[m2-1] <= nums1[m1]
             * 取反 ： nums1[m1-1] > nums2[m2] || nums2[m2-1] > nums1[m1]
             */
            if(firstArrLeft > secondArrRight){
                R = m1 - 1;
            }else if(firstArrRight < secondArrLeft){
                L = m1 + 1;
            }else{
                break;
            }
        }

        if(((m+n) & 1) == 1 ){
            //为奇数时
            return Math.max(firstArrLeft, secondArrLeft);
        }else{
            //为偶数时
            return (Math.max(firstArrLeft, secondArrLeft) + Math.min(firstArrRight, secondArrRight))/2.0;
        }

    }
}
