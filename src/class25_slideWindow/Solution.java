package class25_slideWindow;

import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];

        LinkedList<Integer> deque = new LinkedList<>();
        int L=0;
        for (int R = 0; R < nums.length; R++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] >= nums[R]){
                deque.pollLast();
            }
            deque.addLast(R);
            // 序号过期
            if(deque.peekFirst() == R - k){
                deque.pollFirst();
            }

            // 窗口形成后
            if(R>=k-1){
                ans[L++] = deque.pollLast();
            }
        }

        return ans;
    }
}
