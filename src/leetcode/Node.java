package leetcode;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[" + this.val + "->");
        for (int i = 0; i < this.neighbors.size(); i++) {
            sb.append(this.neighbors.get(i).val + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void print(Node node){
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> nodeSet = new HashSet<>();
        queue.add(node);
        nodeSet.add(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node == null ? "null" : node.toString());
            for (int i = 0; i < node.neighbors.size(); i++) {
                if(nodeSet.contains(node.neighbors.get(i))){
                    continue;
                }
                queue.add(node.neighbors.get(i));
                nodeSet.add(node.neighbors.get(i));
            }
        }
        System.out.println();
    }
}
