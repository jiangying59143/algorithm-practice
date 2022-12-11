package leetcode;

import java.util.LinkedList;

public class Item_116 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public static Node connect(Node root) {
        if(root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node curLevelLast = root;
        Node nextLevelLast = root;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                nextLevelLast = node.left;
            }
            if(node.right != null){
                queue.add(node.right);
                nextLevelLast = node.right;
            }
            if(node == curLevelLast){
                curLevelLast = nextLevelLast;
            }else{
                node.next = queue.peek();
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
