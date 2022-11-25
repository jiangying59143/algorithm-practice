package leetcode;

import java.util.Arrays;

public class Item_142 {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(true){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node, res;
        int[] arr;
        int pos;
        arr = new int[]{3,2,0,-4};
        pos = 1;
        node = ListNode.generateCircle(arr, pos);
        res = detectCycle(node);
        System.out.println(Arrays.toString(arr) + " 环位置" + pos + ": 初始节点 " + node.val + " 入环节点 " + res.val);

        arr = new int[]{1,2};
        pos = 0;
        node = ListNode.generateCircle(arr, pos);
        res = detectCycle(node);
        System.out.println(Arrays.toString(arr) + " 环位置" + pos + ": 初始节点 " + node.val + " 入环节点 " + res.val);

        arr = new int[]{1};
        pos = -1;
        node = ListNode.generate(arr);
        res = detectCycle(node);
        System.out.println(Arrays.toString(arr) + " 环位置" + pos + ": 初始节点 " + node.val + " 入环节点 " + (res == null ? null : res.val));
    }
}
