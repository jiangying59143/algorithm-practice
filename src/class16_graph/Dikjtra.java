package class16_graph;

import java.util.*;

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

    public static Map<Node, Integer> dikjtra2(Node node){
        DikHeap heap = new DikHeap();
        heap.addOrUpdate(node, 0);
        Map<Node, Integer> ansMap = new HashMap<>();
        while(heap.nodes.size() != 0){
            NodeRecord nodeRecord = heap.pop();
            for (Edge edge : nodeRecord.node.edges) {
                heap.addOrUpdate(edge.to, nodeRecord.distance + edge.weight);
            }
            ansMap.put(nodeRecord.node, nodeRecord.distance);
        }
        return ansMap;
    }

    public static class NodeRecord{
        public Node node;
        public Integer distance;

        public NodeRecord(Node node, Integer distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class DikHeap{
        private List<NodeRecord> nodes;
        private Map<Node, Integer> heapIndexMap;

        public DikHeap() {
            nodes = new ArrayList<>();
            heapIndexMap = new HashMap<>();
        }

        public void addOrUpdate(Node node, int distance){
            if(heapIndexMap.containsKey(node)){
                int nodeIndex = heapIndexMap.get(node);
                nodes.get(nodeIndex).distance = Math.min(nodes.get(nodeIndex).distance, distance);
                insert(nodeIndex);
                heapify(nodeIndex);
            }else{
                nodes.add(new NodeRecord(node, distance));
                heapIndexMap.put(node, nodes.size()-1);
                insert(nodes.size()-1);
            }
        }

        public NodeRecord pop(){
            NodeRecord record = nodes.get(0);
            swap(0, nodes.size()-1);
            nodes.remove(nodes.size()-1);
            heapIndexMap.remove(record.node);

            heapify(0);

            return record;
        }

        public void insert(int index){
            while(nodes.get(index).distance < nodes.get((index-1)/2).distance){
                swap(index, (index-1)/2);
                index = (index-1)/2;
            }
        }

        public void heapify(int index){
            int leftIndex = 2*index + 1;
            while(leftIndex < nodes.size()){
                int rightIndex = leftIndex+1;
                int minChildIndex = rightIndex>=nodes.size() || nodes.get(leftIndex).distance < nodes.get(rightIndex).distance ? leftIndex : rightIndex;
                if(nodes.get(minChildIndex).distance >= nodes.get(index).distance){
                    break;
                }
                swap(minChildIndex, index);
                index = minChildIndex;
                leftIndex = 2*index + 1;
            }
        }

        public void swap(int x, int y){
            heapIndexMap.put(nodes.get(x).node, y);
            heapIndexMap.put(nodes.get(y).node, x);

            NodeRecord temp = nodes.get(x);
            nodes.set(x, nodes.get(y));
            nodes.set(y, temp);
        }
    }

    public static void print(Map<Node, Integer> map){
        for (Map.Entry<Node, Integer> nodeDistance : map.entrySet()) {
            System.out.print("[" + nodeDistance.getKey().value + ", " + nodeDistance.getValue() + "]");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node node = Node.generateRandomNodeWithEdge();
        Map<Node, Integer> map;
        map = dikjtra1(node);
        print(map);
        map = dikjtra2(node);
        print(map);
    }
}
