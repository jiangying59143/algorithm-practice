package leetcode;

public class Item_23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, tail=null;
        int endCount = 0;
        while(endCount != lists.length) {
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) {
                    endCount++;
                    continue;
                }
                lists[i] = node.next;
                if (head == null) {
                    head = node;
                    tail = node;
                    continue;
                }
                if (node.val <= head.val) {
                    node.next = head;
                    head = node;
                } else if (node.val >= tail.val) {
                    tail.next = node;
                    node.next = null;
                    tail = node;
                } else { // head < node < tail
                    ListNode cur = head;
                    while (cur.next.val < node.val) {
                        cur = cur.next;
                    }
                    node.next = cur.next;
                    cur.next = node;
                }
            }
            if(endCount != lists.length){
                endCount = 0;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode res = mergeKLists(new ListNode[]{
                ListNode.generate(new int[]{1,4,5}),
                ListNode.generate(new int[]{1,3,4}),
                ListNode.generate(new int[]{2,6})});
        ListNode.print(res);
        res = mergeKLists(new ListNode[0]);
        ListNode.print(res);
        res = mergeKLists(new ListNode[]{null});
        ListNode.print(res);
    }
}
