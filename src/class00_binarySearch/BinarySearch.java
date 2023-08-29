package class00_binarySearch;

public class BinarySearch {

    public static int search(int[] arr, int k){
        int i = 0, j = arr.length-1, mid;
        while(i <= j){
            mid = (i+j)>>>1;
            if(k < arr[mid]){
                j = mid - 1;
            }else if(arr[mid] < k){
                i = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int searchAlternative(int[] arr, int k){
        int i = 0, j = arr.length, mid;
        while(i < j){
            mid = (i+j)>>>1;
            if(k < arr[mid]){
                j = mid;
            }else if(arr[mid] < k){
                i = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int searchBalance(int[] arr, int k){
        int i = 0, j = arr.length, mid;
        while(j-i > 1){
            mid = (i+j)>>>1;
            // TODO
            if(k < arr[mid]){
                j = mid;
            }else{
                i = mid;
            }
        }
        if(arr[i] == k){
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 4, 5, 6, 8};
        System.out.println(search(arr, 0) == searchAlternative(arr,0)
                && search(arr, 0) == searchBalance(arr,0));
        System.out.println(search(arr, 4) == searchAlternative(arr,4)
                && search(arr, 4) == searchBalance(arr,4));
        System.out.println(search(arr, 8) == searchAlternative(arr,8)
                && search(arr, 8) == searchBalance(arr,8));
    }


}
