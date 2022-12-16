package leetcode;

public class Item_143 {
    public static void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode(), slow = dummyHead, fast = dummyHead, cur = head;
        dummyHead.next = head;
        // find the mid position
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //change the pointer direction from mid
        ListNode lastHead = slow;
        while(slow != null && slow.next != null){
            ListNode pre = slow, slowNext = slow.next;

            pre.next = slow.next.next;
            slowNext.next = lastHead;

            lastHead = slowNext;
            slow = pre;
        }

        while(cur != null && lastHead != null && cur != lastHead){
            ListNode preCur = cur, preLastHead = lastHead;
            cur = cur.next;
            lastHead = lastHead.next;

            preCur.next = preLastHead;
            preLastHead.next = cur;
        }
    }

    public static void main(String[] args) {
        ListNode head;

        head = ListNode.generate(new int[]{1,2,3,4});
        reorderList(head);
        ListNode.print(head);

        head = ListNode.generate(new int[]{1,2,3,4,5});
        reorderList(head);
        ListNode.print(head);

        head = ListNode.generate(new int[]{1});
        reorderList(head);
        ListNode.print(head);

        head = ListNode.generate(new int[]{1,2});
        reorderList(head);
        ListNode.print(head);

        head = ListNode.generate(new int[]{1,2,3});
        reorderList(head);
        ListNode.print(head);
    }
}
