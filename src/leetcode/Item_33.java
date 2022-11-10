package leetcode;

import java.util.Arrays;

public class Item_33 {
    public static int search(int[] nums, int target) {
        int indexOfMinValue = findK(nums);
        int leftRes = findTarget(nums, 0, indexOfMinValue-1, target);
        int rightRes = findTarget(nums, indexOfMinValue, nums.length-1, target);
        return Math.max(leftRes, rightRes);
    }

    public static int findK(int[] nums){
        int L=0, R=nums.length-1, mid;
        while(L <= R){
            mid = L+ ((R-L)>>1);
            if(nums[mid] < nums[0] && nums[mid] < nums[mid-1]){
                return mid;
            }else if(nums[mid] > nums[nums.length-1]){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return 0;
    }

    public static int findTarget(int[] nums, int i, int j, int target){
        if(j == -1){
            return -1;
        }
        int L=i, R=j, mid;
        while(L <= R){
            mid = L+ ((R-L)>>1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return -1;
    }

    public static int searchForce(int[] nums, int target) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return res;
    }

    public static int[] generateArr(int minLength, int maxLength, int maxStep){
        int[] arr = new int[minLength + (int)(Math.random() * (maxLength-minLength+1))];
        int k = (int)(Math.random() * arr.length);
        arr[k] = minLength;
        for (int i = k+1; i < arr.length; i++) {
            arr[i] = arr[i-1] + 1 + (int)(Math.random()*maxStep);
        }
        arr[0] = arr[arr.length-1] + 1 + (int)(Math.random()*maxStep);
        for (int i = 1; i < k; i++) {
            arr[i] = arr[i-1] + 1 + (int)(Math.random()*maxStep);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testCount = 1000000;
        for (int i = 0; i < testCount; i++) {
            int minLength = 10, maxLength=30, maxStep = 10;
            int[] arr = generateArr(minLength, maxLength, maxStep);
            int target = arr[(int)(Math.random()*arr.length)];
            int res1 = searchForce(arr, target);
            int res2 = search(arr, target);
            if(res1 != res2){
                System.out.println(Arrays.toString(arr));
                System.out.println("correct : " + res1);
                System.out.println("wrong : " + res2);
                break;
            }
        }
        System.out.println("end!");
    }
}
