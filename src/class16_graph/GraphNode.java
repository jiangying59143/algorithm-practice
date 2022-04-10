package class16_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphNode {
    public int value;
    public List<GraphNode> nexts;

    public GraphNode(int value) {
        this.value = value;
        nexts = new ArrayList<>();
    }

    public static GraphNode generateRandomNode(){
        GraphNode graphNode = new GraphNode(0);
        GraphNode graphNode1 = new GraphNode(1);
        GraphNode graphNode2 = new GraphNode(2);
        GraphNode graphNode3 = new GraphNode(3);
        GraphNode graphNode4 = new GraphNode(4);
        GraphNode graphNode5 = new GraphNode(5);

        graphNode.nexts.addAll(Arrays.asList(graphNode1, graphNode2, graphNode3));
        graphNode1.nexts.add(graphNode);
        graphNode2.nexts.add(graphNode4);
        graphNode3.nexts.add(graphNode5);

        return graphNode;
    }
}
