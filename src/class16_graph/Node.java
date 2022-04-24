package class16_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    public int value;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public static Node generateRandomNode(){
        Node graphNode = new Node(0);
        Node graphNode1 = new Node(1);
        Node graphNode2 = new Node(2);
        Node graphNode3 = new Node(3);
        Node graphNode4 = new Node(4);
        Node graphNode5 = new Node(5);

        graphNode.nexts.addAll(Arrays.asList(graphNode1, graphNode2, graphNode3));
        graphNode1.nexts.add(graphNode);
        graphNode2.nexts.add(graphNode4);
        graphNode3.nexts.add(graphNode5);

        return graphNode;
    }
}
