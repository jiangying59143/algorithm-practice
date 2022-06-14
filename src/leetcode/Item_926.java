package leetcode;

import java.util.Arrays;

/**
 * 926. 将字符串翻转到单调递增
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 *
 * 返回使 s 单调递增的最小翻转次数。
 *
 * 示例 1：
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flip-string-to-monotone-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Item_926 {
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int[][] results = new int[2][chars.length+1];
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                results[i][j] = -1;
            }
        }
        return process(chars, 0, 0, results);
    }

    public int process(char[] chars, int preChar, int index, int[][] results){
        if(results[preChar][index] != -1){
            return results[preChar][index];
        }
        if(index == chars.length){
            results[preChar][index] = 0;
            return 0;
        }
        int ans = 0;
        if(preChar == 1){
            if(chars[index] == '0'){
                ans = 1+ process(chars, 1, index + 1, results);
            }else{
                ans = process(chars, 1, index + 1, results);
            }
        }else{
            if(chars[index] == '0'){
                ans = process(chars, 0, index + 1, results);
            }else{
                // 前一个字符是 0， 当前字符为 1
                ans = 1 + process(chars, 0, index + 1, results);
                ans = Math.min( ans, process(chars, 1, index + 1, results));
            }

        }
        results[preChar][index] = ans;
        for (int i = 0; i < results.length; i++) {
            System.out.println(Arrays.toString(results[i]));
        }
        System.out.println();
        return ans;
    }

    public int minFlipsMonoIncr1(String s) {
        char[] chars = s.toCharArray();
        return process1(chars, '1', chars.length-1);
    }

    public int process1(char[] chars, char aftChar, int index){
        if(index < 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if(aftChar == '1'){
            if(chars[index] == '0'){
                ans = Math.min( ans, 1+ process1(chars, '1', index - 1));
                ans = Math.min( ans, process1(chars, '0', index - 1));
            }else{
                ans = Math.min( ans, process1(chars, '1', index - 1));
            }
        }else{
            if(chars[index] == '0'){
                ans = Math.min( ans, process1(chars, '0', index - 1));
            }else{
                ans = Math.min( ans, 1 + process1(chars, '0', index - 1));
            }

        }
        return ans;
    }

    public int minFlipsMonoIncr2(String s) {
        char[] chars = s.toCharArray();
        int ans0 = 0, ans1 = 0;
        for (int index = chars.length-1; index >= 0; index--) {
            if(chars[index] == '0'){
                ans1 = 1 + ans1;
            }else{
                ans0 = 1 + ans0;
                ans0 = Math.min( ans0, ans1);
            }
        }
        return Math.min(ans0, ans1);
    }



    public static void main(String[] args) {
        System.out.println(new Item_926().minFlipsMonoIncr2("00110"));
        System.out.println(new Item_926().minFlipsMonoIncr2("010110"));
        System.out.println(new Item_926().minFlipsMonoIncr2("00011000"));
    }
}
