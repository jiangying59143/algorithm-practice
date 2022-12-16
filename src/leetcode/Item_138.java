package leetcode;

import java.util.ArrayList;
import java.util.List;

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
    }

    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head, curNext, randomNext;

        // in case of loop create
        List<Node> nodesCreated = new ArrayList<>();
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
            cur = curNext.next;
            if(cur.random == null) {
                continue;
            }
            if(nodesCreated.contains(cur.random)) {
                copyNode.random = cur.random.next;
            }else {
                randomNext = cur.random.next;
                Node copyRandom = new Node(cur.random.val);
                cur.random.next = copyRandom;
                copyRandom.next = randomNext;
                nodesCreated.add(cur.random);
            }
        }

        Node ans = nodesCreated.get(0).next;
        for (int i = 0; i < nodesCreated.size(); i++) {
            curNext = nodesCreated.get(i).next;
            nodesCreated.get(i).next = nodesCreated.get(i).next.next;
            curNext.next = nodesCreated.get(i).next.next;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
