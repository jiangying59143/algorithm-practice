package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Item_148 {
    static class HeadTailNode{
        public ListNode head;
        public ListNode tail;
    }
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode leftHead = head, rightHead, nextLeftHead, dummyHead = new ListNode(), preNode = dummyHead;
        int mergeSize  = 1, size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        //16 17 10 9 6 1 18 4 6 15
        while(mergeSize < size){
            while(leftHead != null) {
                rightHead = getNextMergePartHead(leftHead, mergeSize);
                if(rightHead == null){
                    preNode.next = leftHead;
                    break;
                }
                nextLeftHead = getNextMergePartHead(rightHead, mergeSize);
                HeadTailNode tempheadTailNode = merge(leftHead,rightHead);
                preNode.next = tempheadTailNode.head;
                preNode = tempheadTailNode.tail;
                leftHead = nextLeftHead;
            }
            if(mergeSize > size /2){
                break;
            }
            leftHead = dummyHead.next;
            preNode = dummyHead;
            mergeSize <<= 1;
        }
        return dummyHead.next;
    }

    private static ListNode getNextMergePartHead(ListNode head, int mergeSize){
        ListNode tail = null;
        while(mergeSize > 0 && head != null){
            tail = head;
            head = head.next;
            mergeSize--;
        }
        ListNode nextPartHead = tail.next;
        if(head != null){
            tail.next = null;
        }
        return nextPartHead;
    }

    private static HeadTailNode merge(ListNode h1, ListNode h2){
        HeadTailNode res = new HeadTailNode();
        res.head = new ListNode();
        ListNode preNode = res.head;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                preNode.next = h1;
                h1 = h1.next;
            }else{
                preNode.next = h2;
                h2 = h2.next;
            }
            preNode = preNode.next;
        }

        if(h1 != null){
            preNode.next = h1;
        }else{
            preNode.next = h2;
        }
        while(preNode != null){
            res.tail = preNode;
            preNode = preNode.next;
        }
        res.head = res.head.next;
        return res;
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
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = null;
            list.add(head);
            head = next;
        }
        list.sort((Comparator.comparingInt(o -> o.val)));
        ListNode dummyHead = new ListNode();
        head = list.get(0);
        dummyHead.next = head;
        for (int i = 1; i < list.size(); i++) {
            head.next = list.get(i);
            head = head.next;
        }
        return dummyHead.next;
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
        int testCount = 1000;
        for (int i = 0; i < testCount; i++) {
            int[] arr = Data.generate(1000, 10000);
            ListNode head = ListNode.generate(arr);
            ListNode head2 = ListNode.generate(arr);
            head2 = sortListForce(head2);
            head = sortList(head);
            if(!ListNode.isEqual(head, head2)){
                System.out.println("Oops!!");
                ListNode.print(head);
                ListNode.print(head2);
                break;
            }
        }
        System.out.println("End!!");
    }
}
