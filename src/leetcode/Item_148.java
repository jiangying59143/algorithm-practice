package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Item_148 {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode leftHead = head, dummyHead = new ListNode(), rightHead, nextLeftHead;
        int mergeSize  = 1, size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        while(mergeSize < size){
            while(leftHead != null) {
                rightHead = getNextMergePartHead(leftHead, mergeSize);
                if(rightHead == null){
                    break;
                }
                nextLeftHead = getNextMergePartHead(rightHead, mergeSize);
                ListNode tail = merge(leftHead,rightHead);
                tail.next = nextLeftHead;
                if(dummyHead.next == null){
                    dummyHead.next = leftHead;
                }
                leftHead = nextLeftHead;
            }
            if(mergeSize > size /2){
                break;
            }
            leftHead = dummyHead.next;
            dummyHead.next = null;
            mergeSize <<= 1;
        }
        return dummyHead.next;
    }

    private static ListNode getNextMergePartHead(ListNode head, int mergeSize){
        ListNode tail = head.next;
        while(mergeSize > 0 && head != null){
            tail = head;
            head = head.next;
            mergeSize--;
        }
        if(head != null){
            head.next = null;
        }
        return tail.next;
    }

    private static ListNode merge(ListNode h1, ListNode h2){
        ListNode preH1=null, curH1 = h1, tail = h2;
        while(curH1 != null && h2 != null){
            if(curH1.val <= h2.val){
                tail = preH1;
                preH1 = curH1;
                curH1 = curH1.next;
            }else{
                if(preH1 == null){
                    preH1 = h2;
                    preH1.next = curH1;
                }else{
                    preH1.next = h2;
                    preH1.next.next = curH1;
                }
                tail = h2;
                h2 = h2.next;
            }
        }
        while(curH1 != null){
            preH1 = curH1;
            tail = preH1;
            curH1 = curH1.next;
        }

        if(h2 != null){
            preH1.next = h2;
        }

        while(h2 != null){
            tail = h2;
            h2 = h2.next;
        }
        return tail;
    }

    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int[] help = new int[arr.length];
        int step  = 1, L, M, R;
        while(step < arr.length){
            L = 0;
            while(L < arr.length) {
                if(arr.length - step < L){
                    break;
                }
                M = L+step-1;
                R = arr.length - 1 - step < M ? arr.length-1 : M+step;

                int leftIndex = L;
                int rightIndex = M + 1;
                int helpIndex = L;
                while (leftIndex <= M && rightIndex <= R) {
                    help[helpIndex++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
                }
                while (leftIndex <= M) {
                    help[helpIndex++] = arr[leftIndex++];
                }
                while (rightIndex <= R) {
                    help[helpIndex++] = arr[rightIndex++];
                }
                L = R+1;
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = help[i];
            }
//            if(Integer.MAX_VALUE-step < step){
//                break;
//            }
            if(step > arr.length /2){
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

    public static void testArrSort(){
        int testCount = 1000;
        for (int i = 0; i < testCount; i++) {
            int[] arr = Data.generate(1000, 1,100);
            int[] arr1 = Arrays.copyOf(arr, arr.length);
            int[] orgin = Arrays.copyOf(arr, arr.length);
            try {
                mergeSort2(arr);
                Arrays.sort(arr1);
                if (!isEqual(arr, arr1)) {
                    System.out.println(Arrays.toString(orgin));
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(arr1));
                    break;
                }
            }catch (Exception e){
                System.out.println(Arrays.toString(orgin));
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr1));
                e.printStackTrace();
                break;
            }
        }
        System.out.println("end!!");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,5,3,4,0};
        System.out.println(Arrays.toString(arr));
        ListNode head = ListNode.generate(arr);
        ListNode head2 = ListNode.generate(arr);
        sortListForce(head2);
        ListNode.print(head2);
        sortList(head);
        ListNode.print(head);
    }
}
