package leetcode;

import java.util.*;

public class Item_133 {
    public static Node cloneGraph(Node node) {
        Map<Node,Node> map = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        if(node != null){
            map.put(node, new Node(node.val));
        }
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n == null || n.neighbors == null){
                continue;
            }
            for (int i = 0; i < n.neighbors.size(); i++) {
                Node neighborNode = n.neighbors.get(i);
                if(map.containsKey(neighborNode)){
                    map.get(n).neighbors.add(map.get(neighborNode));
                    continue;
                }
                queue.add(neighborNode);
                map.put(neighborNode, new Node(neighborNode.val));
                map.get(n).neighbors.add(map.get(neighborNode));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        Node.print(node1);
        Node resNode = cloneGraph(node1);
        Node.print(resNode);
    }
}
