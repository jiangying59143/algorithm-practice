package leetcode;

import java.util.LinkedList;

public class Leetcode_84 {
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int area = 0;
            LinkedList<Integer> stack = new LinkedList<>();
            for(int i=0; i<heights.length; i++){
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                    int index = stack.pop();
                    int height = heights[index];
                    int width = stack.isEmpty() ?  i-1-(-1) : i-1-stack.peek();
                    area = Math.max(area, height*width);
                }
                stack.push(i);
            }

            while(!stack.isEmpty()){
                int index = stack.pop();
                int height = heights[index];
                int width = stack.isEmpty() ?  heights.length-1-(-1) : heights.length-1-stack.peek();
                area = Math.max(area, height*width);
            }

            return area;
        }
    }

    // improve stack
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        int[] stack = new int[heights.length];
        int stackIndex = -1;
        for(int i=0; i<heights.length; i++){
            while(stackIndex >= 0 && heights[stack[stackIndex]] > heights[i]){
                int index = stack[stackIndex--];
                int height = heights[index];
                int width = stackIndex == -1 ?  i-1-(-1) : i-1-stack[stackIndex];
                area = Math.max(area, height*width);
            }
            stack[++stackIndex] = i;
        }

        while(stackIndex >= 0){
            int index = stack[stackIndex--];
            int height = heights[index];
            int width = stackIndex == -1 ?  heights.length-1-(-1) : heights.length-1-stack[stackIndex];
            area = Math.max(area, height*width);
        }

        return area;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.largestRectangleArea(new int[]{2,1,2}));
        System.out.println(largestRectangleArea(new int[]{2,1,2}));
    }
}
