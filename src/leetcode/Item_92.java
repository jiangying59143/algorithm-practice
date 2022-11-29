package leetcode;

public class Item_92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(), pre = dummyHead;
        dummyHead.next = head;
        int i = 1;
        while(i < left){
            pre = pre.next;
            head = head.next;
            i++;
        }

        while(i < right){
            ListNode next = pre.next;
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = next;
            i++;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head, res;
        head = ListNode.generate(new int[]{1,2,3,4,5});
        res = reverseBetween(head, 2, 4);
        ListNode.print(res);

        head = ListNode.generate(new int[]{5});
        res = reverseBetween(head, 1, 1);
        ListNode.print(res);

        head = ListNode.generate(new int[]{1,2,3,4,5});
        res = reverseBetween(head, 1, 5);
        ListNode.print(res);
    }
}
