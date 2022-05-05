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

    public static class Record{
        public Node node;
        public Integer distance;

        public Record(Node node, Integer distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class DikHeap{
        private Node[] nodes = null;
        private Map<Node, Integer> heapIndexMap;
        private Map<Node, Integer> distanceMap;
        private int heapSize;

        public DikHeap(int size) {
            nodes = new Node[size];
            this.heapSize = 0;
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
        }

        public void add(Node node, int distance){
            // never added
            if(heapIndexMap.containsKey(node)){
                nodes[heapSize] = node;
                heapIndexMap.put(node, heapSize);
                distanceMap.put(node, distance);
                heapSize++;
                insert(heapSize-1);

            }

            if(distanceMap.containsKey(node)){
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insert(heapIndexMap.get(node));
            }
        }

        public Record pop(){
            Record record = new Record(nodes[0], distanceMap.get(nodes[0]));
            distanceMap.remove(nodes[0]);
            swap(0, --heapSize);
            heapify(0);
            return record;
        }

        public void insert(int index){
            while(distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index-1)/2])){
                swap(index, (index-1)/2);
                index = (index-1)/2;
            }
        }

        public void heapify(int index){
            int leftIndex = 2*index + 1;
            while(leftIndex < heapSize){
                int minIndex = leftIndex+1>=heapSize || distanceMap.get(nodes[leftIndex]) < distanceMap.get(nodes[leftIndex+1]) ? leftIndex : leftIndex+1;
                if( distanceMap.get(minIndex) >= distanceMap.get(index)){
                    break;
                }
                swap(minIndex, index);
                index = minIndex;
                leftIndex = 2*index + 1;
            }
        }

        public void swap(int x, int y){
            heapIndexMap.put(nodes[x], y);
            heapIndexMap.put(nodes[y], x);

            Node temp = nodes[x];
            nodes[x] = nodes[y];
            nodes[y] = nodes[x];

        }
    }
}
