package leetcode;

public class Item_109 {
    public static TreeNode sortedListToBST(ListNode head) {
        return process(head);
    }

    public static TreeNode process(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        if(head.next.next == null){
            TreeNode root = new TreeNode(head.next.val);
            root.left = new TreeNode(head.val);
            return root;
        }
        ListNode pre=null, slow = head, fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast == null){
                break;
            }
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = process(head);
        root.right = process(slow.next);
        return root;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.generate(new int[]{-10,-9,-8,-7,-6,0,5,9,11,12,13});
        TreeNode treeNode = sortedListToBST(node);
        TreeNode.printTree(treeNode);
    }
}
