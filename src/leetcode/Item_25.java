package leetcode;

import java.util.LinkedList;

public class Item_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode[] headTailNext;
        ListNode prev = dummyHead, next = head;
        while(next != null){
            headTailNext = reverse(next, k);
            prev.next = headTailNext[0];
            prev = headTailNext[1];
            next = headTailNext[2];
        }

        return dummyHead.next;
    }

    /**
     *
     * @param node
     * @param k
     * @return head tail and next head.
     */
    private static ListNode[] reverse(ListNode node, int k) {
        ListNode tail = node, next = null, prev = null;
        int count = 1;
        while(count <= k){
            // at last, if left nodes are less than k, need to revert it back.
            if(node == null){
                return reverse(prev, count-1);
            }
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            count++;
        }

        return new ListNode[]{prev, tail, next};
    }



    public static ListNode reverseKGroup0(ListNode head, int k) {
        int count = 0;
        ListNode headFake = new ListNode(0);
        headFake.next = head;

        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode startPre = headFake;
        ListNode dbPoint = head;
        while(dbPoint != null) {
            while (dbPoint != null && startPre != null && count < k/2) {
                stack.push(startPre);
                startPre = startPre.next;
                dbPoint = dbPoint.next;
                if (dbPoint != null) {
                    dbPoint = dbPoint.next;
                }else{
                    count--;
                }
                count++;
            }
            //important
            if(dbPoint == null && ((k & 1) == 1 || (k & 1) == 0 && count * 2 != k) || startPre == null || startPre.next == null){
                break;
            }
            if ((k & 1) == 1) {
                startPre = startPre.next;
                dbPoint = dbPoint.next;
            }
            while (!stack.isEmpty()) {
                ListNode pre = stack.pop();

                ListNode pn = pre.next;
                ListNode pnn = pre.next.next;
                ListNode snn = startPre.next.next;

                // important
                pre.next = startPre.next;
                if(pn != startPre) {
                    pre.next.next = pnn;
                    startPre.next = pn;
                    startPre.next.next = snn;
                    startPre = startPre.next;
                }else{
                    pre.next.next = startPre;
                    startPre.next = snn;
                }
            }
            count = 0;
        }

        return headFake.next;
    }

    public static void main(String[] args) {
        ListNode res;
        res= reverseKGroup0(ListNode.generate(new int[]{1,2,3,4,5}), 1);
        ListNode.print(res);
        res= reverseKGroup(ListNode.generate(new int[]{1,2,3,4,5}), 2);
        ListNode.print(res);
        res = reverseKGroup(ListNode.generate(new int[]{1,2,3,4,5}), 3);
        ListNode.print(res);
        res = reverseKGroup(ListNode.generate(new int[]{1,2,3,4,5}), 4);
        ListNode.print(res);
        res = reverseKGroup(ListNode.generate(new int[]{1,2,3,4,5}), 5);
        ListNode.print(res);
        res= reverseKGroup(ListNode.generate(new int[]{1}), 1);
        ListNode.print(res);
        res= reverseKGroup(ListNode.generate(new int[]{1,2}), 2);
        ListNode.print(res);
        res = reverseKGroup(ListNode.generate(new int[]{1,2,3,4,5,6}), 3);
        ListNode.print(res);
        res = reverseKGroup(ListNode.generate(new int[]{1,2,3,4,5,6}), 2);
        ListNode.print(res);
        res = reverseKGroup(ListNode.generate(new int[]{1,2,3,4,5,6,7}), 4);
        ListNode.print(res);
    }
}
