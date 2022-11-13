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
        while(step < arr.length){
            step <<= 1;
            int L = 0;
            int R = L + step -1;
            int M = L + ((R-L)>>1);
            while(R < arr.length) {
                int leftIndex = L;
                int rightIndex = M + 1;
                int helpIndex = L;
                while (leftIndex <= M && rightIndex <= R) {
                    if (arr[leftIndex] > arr[rightIndex]) {
                        help[helpIndex++] = arr[rightIndex++];
                    } else {
                        help[helpIndex++] = arr[leftIndex++];
                    }
                }
                while (leftIndex <= M) {
                    help[helpIndex++] = arr[leftIndex++];
                }
                while (rightIndex <= R) {
                    help[helpIndex++] = arr[rightIndex++];
                }
                L = R;
                R = L + step - 1;
                M = L + ((R - L) >> 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = help[i];
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

    public static void main(String[] args) {
//        ListNode node = ListNode.generate(new int[]{4,2,1,3});
//        node = sortListForce(node);
//        ListNode.print(node);

        int[] arr = new int[]{5,3,1,6,4,2};
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
