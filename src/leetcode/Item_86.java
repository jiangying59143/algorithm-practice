package leetcode;

public class Item_86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(),left=dummyHead, leftNext, pre;
        dummyHead.next = head;
        while(left.next != null && left.next.val < x){
            left = left.next;
        }
        pre = left;
        head = left.next;

        while(head != null){
            if(head.val < x){
                pre.next = head.next;

                leftNext = left.next;
                left.next = head;
                left.next.next = leftNext;
                left = left.next;

                head = pre.next;
            }else {
                pre = head;
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node, res;
        node = ListNode.generate(new int[]{1,4,3,2,5,2});
        res = partition(node, 3);
        ListNode.print(res);

        node = ListNode.generate(new int[]{2,1});
        res = partition(node, 2);
        ListNode.print(res);
    }
}
