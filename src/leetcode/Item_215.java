package leetcode;

import java.util.Arrays;

public class Item_215 {
    public static int findKthLargest(int[] nums, int k) {
        if(k >= nums.length){
            throw new RuntimeException("invalid input k");
        }
        int res = quickSelect2(nums, k-1, 0, nums.length-1);
        return res;
    }

    public static int quickSelect(int[] nums, int k,  int L, int R){
        if(L == R){
            return nums[L];
        }
        int index = L + (int)(Math.random() * (R-L+1));
        int[] equalArea = partition(nums, nums[index], L, R);
        if(equalArea[0] <= k && equalArea[1] >= k){
            return nums[k];
        }else if(k > equalArea[1]){
            return quickSelect(nums, k, equalArea[1]+1, R);
        }else{
            return quickSelect(nums, k, L, equalArea[0]-1);
        }
    }

    public static int quickSelect2(int[] nums, int k,  int L, int R){
        while(L < R){
            int index = L + (int)(Math.random() * (R-L+1));
            int[] equalArea = partition(nums, nums[index], L, R);
            if(k > equalArea[1]){
                L = equalArea[1]+1;
            }else if(k < equalArea[0]){
                R = equalArea[0]-1;
            }else{
                return nums[k];
            }
        }
        return nums[k];
    }

    private static int[] partition(int[] nums, int num, int L, int R){
        int i = L;
        L = L - 1;
        R = R + 1;
        while(i < R){
            if(nums[i] > num){
                swap(nums, i++, ++L);
            }else if(nums[i] < num){
                swap(nums, i, --R);
            }else{
                i++;
            }
        }
        return new int[]{L+1, R-1};
    }

    private static void swap(int[] nums, int i, int j){
        if(i == j){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void quickSort(int[] nums){
        process(nums, 0, nums.length-1);
    }

    private static void process(int[] nums, int L, int R){
        if(L >= R){
            return;
        }
        int randomIndex = L + (int)(Math.random() * (R-L+1));
        int pivot = nums[randomIndex];
        int[] equalArea = partition2(nums, L, R, pivot);
        process(nums, L, equalArea[0]-1);
        process(nums, equalArea[1]+1, R);
    }

    public static int[] partition2(int[] arr, int L, int R, int pivot) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < pivot) {
                swap2(arr, ++less, cur++);
            } else if (arr[cur] > pivot) {
                swap2(arr, cur, --more);
            } else {
                cur++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }

    public static void swap2(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
//        quickSort(nums);
//        System.out.println(Arrays.toString(nums));
//        int[] range = partition(nums, 2, 0, nums.length-1);
//        System.out.println(Arrays.toString(range));
        System.out.println(findKthLargest(nums, 2));
    }

}
