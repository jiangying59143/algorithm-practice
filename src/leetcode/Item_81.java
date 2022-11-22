package leetcode;

public class Item_81 {
    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int L = 0, R = nums.length-1;
        if(nums[L] == nums[R]){
            if(nums[0] == target){
                return true;
            }
            //important
            while(L <= R && nums[L] == nums[0] && nums[L] == nums[R]){
                L++;
                R--;
            }
            //important
            if(L > R){
                return false;
            }
        }

        int resIndex;
        //important 相等说明剩下的都是一个数字的重复值
        if(nums[R] == nums[L]){
            return nums[L] == target;
        }else if(nums[R] > nums[L]){
            resIndex = binarySearch(nums, L, R, target);
        }else{
            int minIndex = getIndexOfMin(nums, L, R);
            resIndex = binarySearch(nums, L, minIndex-1, target);
            if(resIndex != -1){
                return true;
            }
            resIndex = binarySearch(nums, minIndex, R, target);
        }
        return resIndex == -1 ? false : true;
    }

    public static int getIndexOfMin(int[] nums, int start, int end){
        int mid, L = start, R = end;
        while(L <= R){
            mid = L + ((R-L)>>1);
            //important
            if(nums[mid] < nums[start] && nums[mid] < nums[mid-1]){
                return mid;
            }else if(nums[mid] > nums[end]){
                L = mid+1;
            }else{
                R = mid-1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int L, int R, int target){
        int mid;
        while(L <= R){
            mid = L + ((R-L) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                L = mid +1;
            }else{
                R = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2,5,6,0,0,1,2};
        System.out.println(search(arr, 0));

        arr = new int[]{2,5,6,0,0,1,2};
        System.out.println(search(arr, 3));

        arr = null;
        System.out.println(search(arr, 3));

        arr = new int[]{1};
        System.out.println(search(arr, 3));

        arr = new int[]{3};
        System.out.println(search(arr, 3));

        arr = new int[]{2,2,2,3,2,2,2};
        System.out.println(search(arr, 3));

        arr = new int[]{3,1};
        System.out.println(search(arr, 0));
    }
}
