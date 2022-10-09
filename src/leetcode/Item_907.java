package leetcode;

import java.util.Arrays;

public class Item_907 {
    static class Index{
        public int left;
        public int right;

        public Index(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public Index[] getNearestLessIndexArr(int[] arr){
        Index[] res = new Index[arr.length];
        int[] stack = new int[arr.length];
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            // arr[i] <= arr[stack[size-1]] 相同的时候需要起始位置不会漏数据
            while(size > 0 && arr[i] <= arr[stack[size-1]]){
                int x = stack[--size];
                Index index = new Index(size > 0 ? stack[size-1] : -1, i);
                res[x] = index;
            }
            stack[size++] = i;
        }
        while(size > 0){
            int x = stack[--size];
            //右侧到不了的位置应该是 arr.length，不能设置为-1
            Index index = new Index(size > 0 ? stack[size-1] : -1, arr.length);
            res[x] = index;
        }
        return res;
    }

    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        int modulo = (int)Math.pow(10, 9) + 7;
        Index[] nearestLessIndexArr = getNearestLessIndexArr(arr);
        //(long)arr[i]
        for (int i = 0; i < arr.length; i++) {
            ans += (nearestLessIndexArr[i].right - i) * (i - nearestLessIndexArr[i].left) * (long)arr[i];
            ans %= modulo;
        }
        return (int)ans;
    }

    public int sumSubarrayMinsForce(int[] arr) {
        long ans = 0;
        int modulo = (int)Math.pow(10, 9) + 7;
        for (int i = 0; i < arr.length; i++) {
            int minSum = arr[i];
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                minSum += min;
            }
            ans += minSum;
            ans %= modulo;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] arr  = new int[]{1,4,5,3,4,5,3,6,7,1};
        Item_907 obj = new Item_907();
        System.out.println(obj.sumSubarrayMinsForce(arr));
        System.out.println(obj.sumSubarrayMins(arr));
    }
}
