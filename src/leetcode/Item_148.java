package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Item_148 {
    public static ListNode sortList(ListNode head) {
        return null;
    }

    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int[] help = new int[arr.length];
        int step  = 1;
        while(step <= arr.length){
            int L = 0;
            if(arr.length - 1 - step < L){
                break;
            }
            int M = L+step-1;
            int R = arr.length - 1 - step < M ? arr.length-1 : M+step;
            while(R <= arr.length-1) {
                int leftIndex = L;
                int rightIndex = M + 1;
                int helpIndex = L-1;
                while (leftIndex <= M && rightIndex <= R) {
                    if (arr[leftIndex] > arr[rightIndex]) {
                        help[++helpIndex] = arr[rightIndex++];
                    } else {
                        help[++helpIndex] = arr[leftIndex++];
                    }
                }
                while (leftIndex <= M) {
                    help[++helpIndex] = arr[leftIndex++];
                }
                while (rightIndex <= R) {
                    help[++helpIndex] = arr[rightIndex++];
                }
                if(helpIndex == arr.length-1){
                    break;
                }
                L = R+1;
                M = L+step-1;
                R = arr.length - 1 - step < M ? arr.length-1 : M+step;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = help[i];
            }
            if(Integer.MAX_VALUE-step < step){
                break;
            }
            step <<= 1;
        }
    }

    public static ListNode sortListForce(ListNode head){
        if(head == null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        list.sort((Comparator.comparingInt(o -> o.val)));
        head = list.get(0);
        ListNode res = head;
        for (int i = 1; i < list.size(); i++) {
            head.next = list.get(i);
            head = head.next;
        }
        head.next = null;
        return res;
    }

    public static boolean isEqual(int[] a, int[] b){
        if(a.length != b.length){
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testCount = 100;
        for (int i = 0; i < testCount; i++) {
            int[] arr = Data.generate(10, 1,100);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            int[] orgin = Arrays.copyOf(arr, arr.length);
            mergeSort2(arr);
            Arrays.sort(arr1);
            if(!isEqual(arr, arr1)){
                System.out.println(Arrays.toString(orgin));
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr1));
                break;
            }
        }
        System.out.println("end!!");
    }
}
