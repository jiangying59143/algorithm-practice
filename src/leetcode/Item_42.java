package leetcode;

public class Item_42 {
    public static int trap(int[] height) {
        int[] stack = new int[height.length];
        int size = 0;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while(size > 0 && height[stack[size-1]]  < height[i]){
                res += size-2 >= 0 ?
                    (Math.min(height[stack[size-2]], height[i]) - height[stack[size-1]])*(i-1-stack[size-2]) : 0;
                size--;
            }
            stack[size++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height;
        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height) + " " + trap(height));
        height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height) + " " + trap(height));
        height = new int[]{5,2,1,2,1,5};
        System.out.println(trap(height) + " " + trap(height));
    }
}
