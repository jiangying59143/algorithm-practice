package leetcode;

public class Item_147 {
    public static ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode initialNode = new ListNode(0),
                endPreNode = initialNode,
                endNode = head,
                preNode = initialNode,
                curNode = head;
        endPreNode.next = endNode;
        preNode.next = curNode;
        while(endNode != null){
            while(curNode != endNode
                    && curNode != null){
                if(endNode.val < curNode.val) {
                    endPreNode.next = endNode.next;
                    preNode.next = endNode;
                    endNode.next = curNode;
                    // important
                    if (curNode == head) {
                        head = endNode;
                    }
                    // important 删除后位置要前移
                    endNode = endPreNode;
                    break;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            // important
            preNode = initialNode;
            preNode.next = head;
            curNode = head;

            endPreNode = endNode;
            endNode = endNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.generate(new int[]{4,2,1,3});
        node = insertionSortList(node);
        ListNode.print(node);

        node = ListNode.generate(new int[]{-1,5,3,4,0});
        node = insertionSortList(node);
        ListNode.print(node);
    }
}
