package leetcode;

import java.util.*;

public class Item_138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public static Node generate(Integer[][] nodes){
            List<Node> list = new ArrayList<>();
            list.add(new Node(nodes[0][0]));
            for (int i = 1; i < nodes.length; i++) {
                Node node = new Node(nodes[i][0]);
                list.add(node);
                list.get(i-1).next = list.get(i);
            }
            for (int i = 0; i < nodes.length; i++) {
                if(nodes[i][1] != null){
                    list.get(i).random = list.get(nodes[i][1]);
                }
            }
            return list.get(0);
        }

        public static void print(Node node){
            Map<Node, Integer> map = new HashMap<>();
            int i = 0;
            Node head = node;
            while(node != null){
                map.put(node, i++);
                node = node.next;
            }
            node = head;
            while(node != null){
                System.out.print("[" + node.val + ","
                        + (node.random == null ? "null" : map.get(node.random)) + "]");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head, curNext, randomNext;

        // in case of loop create
        Set<Node> nodesCreated = new HashSet<>();
        while(cur != null){
            Node copyNode;
            if(nodesCreated.contains(cur)){
                copyNode = cur.next;
                curNext = copyNode.next;
            }else {
                curNext = cur.next;
                copyNode = new Node(cur.val);
                cur.next = copyNode;
                copyNode.next = curNext;
                nodesCreated.add(cur);
            }
            if(cur.random != null) {
                if (nodesCreated.contains(cur.random)) {
                    copyNode.random = cur.random.next;
                } else {
                    randomNext = cur.random.next;
                    Node copyRandom = new Node(cur.random.val);
                    cur.random.next = copyRandom;
                    copyRandom.next = randomNext;
                    copyNode.random = copyRandom;
                    nodesCreated.add(cur.random);
                }
            }
            cur = curNext;
        }
        Node ans = head.next;
        cur = head;
        curNext = head.next;
        while(cur != null){
            if(cur.next != null) {
                cur.next = cur.next.next;
            }
            if(curNext.next != null) {
                curNext.next = curNext.next.next;
            }
            cur = cur.next;
            curNext = curNext.next;
        }

        return ans;
    }

    public static Node copyRandomList1(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head, curNext;

        while(cur != null){
            curNext = cur.next;
            Node copyNode = new Node(cur.val);
            cur.next = copyNode;
            copyNode.next = curNext;
            cur = curNext;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        Node ans = head.next;
        cur = head;
        curNext = head.next;
        while(cur != null){
            if(cur.next != null) {
                cur.next = cur.next.next;
            }
            if(curNext.next != null) {
                curNext.next = curNext.next.next;
            }
            cur = cur.next;
            curNext = curNext.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[][] arr;
        Node head, copyHead;

        arr = new Integer[][]{{7,null},{13,0},{11,4},{10,2},{1,0}};
        head = Node.generate(arr);
        Node.print(head);
        copyHead = copyRandomList1(head);
        Node.print(copyHead);

        arr = new Integer[][]{{1,1},{2,1}};
        head = Node.generate(arr);
        Node.print(head);
        copyHead = copyRandomList1(head);
        Node.print(copyHead);

        arr = new Integer[][]{{3,null},{3,0},{3,null}};
        head = Node.generate(arr);
        Node.print(head);
        copyHead = copyRandomList1(head);
        Node.print(copyHead);

    }
}
