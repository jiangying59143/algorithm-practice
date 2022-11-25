package leetcode;

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
        
    }
}
