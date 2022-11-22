package leetcode;

import java.util.List;

public class Item_82 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(), pre=dummyHead, cur = head, curNext;
        dummyHead.next = head;
        while(cur != null){
            curNext = cur.next;
            while(curNext != null && cur.val == curNext.val){
                curNext = curNext.next;
            }
            if(cur.next == curNext){
                pre = cur;
            }else{
                pre.next = curNext;
            }
            cur = curNext;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head;
        head = ListNode.generate(new int[]{1,2,3,3,4,4,5});
        head = deleteDuplicates(head);
        ListNode.print(head);

        head = ListNode.generate(new int[]{1,1,1,2,3});
        head = deleteDuplicates(head);
        ListNode.print(head);
    }
}
