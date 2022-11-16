package leetcode;

public class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static boolean isEqual(ListNode a, ListNode b){
        if(a == b){
            return true;
        }
        while(a != null && b != null){
            if(a.val != b.val){
                return false;
            }
            a = a.next;
            b = b.next;
        }
        if(a != b){
            return false;
        }
        return true;
    }

    public static ListNode generate(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void print(ListNode node){
        if(node == null){
            System.out.println(node);
            return;
        }
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
