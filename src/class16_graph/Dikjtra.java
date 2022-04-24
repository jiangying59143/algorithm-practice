package class16_graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dikjtra {
    public static Map<Node, Integer> dikjtra1(Node node){
        Map<Node, Integer> distanceMap = new HashMap<>();
        Set<Node> touchedSet = new HashSet<>();
        distanceMap.put(node, 0);
        while(node != null){
            for (Edge edge : node.edges) {
                if(distanceMap.get(edge.to) == null){
                    distanceMap.put(edge.to, distanceMap.get(node) + edge.weight);
                }else{
                    distanceMap.put(edge.to, Math.min(distanceMap.get(edge.to), distanceMap.get(node) + edge.weight));
                }
            }
            touchedSet.add(node);
            node = getNodeWithMinDistance(distanceMap, touchedSet);

        }
        return distanceMap;
    }

    private static Node getNodeWithMinDistance(Map<Node, Integer> distanceMap, Set<Node> touchedSet) {
        Node node = null;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : distanceMap.entrySet()) {
            if(!touchedSet.contains(nodeIntegerEntry.getKey()) && nodeIntegerEntry.getValue() < min){
                min = nodeIntegerEntry.getValue();
                node = nodeIntegerEntry.getKey();
            }
        }
        return node;
    }

    public static class DikHeap{
        private Node[] nodes = null;
        private Map<Node, Integer> heapIndexMap;
        private Map<Node, Integer> distanceMap;
        private int heapSize;

        public DikHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
        }

//        public void insert(Node node, int distance){
//            // never added
//            if(heapIndexMap.containsKey(node)){
//                nodes[heapSize] = node;
//                heapIndexMap.put(node, heapSize);
//                distanceMap.put(node, )
//            }
//        }
    }
}
