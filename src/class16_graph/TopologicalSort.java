package class16_graph;

import java.util.*;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//有向无环图 可以想象成 spring bean 的依赖。 必须前面的做完才能做下面的
public class TopologicalSort {
    public static class GraphNode{
        public int label;
        public List<GraphNode> nexts;
        public GraphNode(int v){
            label = v;
            nexts = new ArrayList<>();
        }
    }

    public static List<GraphNode> bfs(List<GraphNode> graph){
        Map<GraphNode, Integer> inDegreeMap = new HashMap<>();
        for (GraphNode graphNode : graph) {
            inDegreeMap.put(graphNode, 0);
        }
        for (GraphNode graphNode : graph) {
            for (GraphNode next : graphNode.nexts) {
                inDegreeMap.put(next, inDegreeMap.get(next)+1);
            }
        }

        LinkedList<GraphNode> zeroQueue = new LinkedList<>();
        for (Map.Entry<GraphNode, Integer> graphNodeInDegree : inDegreeMap.entrySet()) {
            if(graphNodeInDegree.getValue() == 0) zeroQueue.add(graphNodeInDegree.getKey());
        }
        List<GraphNode> ans = new ArrayList<>();
        while(!zeroQueue.isEmpty()){
            GraphNode graphNode = zeroQueue.poll();
            ans.add(graphNode);
            for (GraphNode next : graphNode.nexts) {
                inDegreeMap.put(next, inDegreeMap.get(next)-1);
                if(inDegreeMap.get(next) == 0) zeroQueue.add(next);
            }
        }
        return ans;
    }

    public static class MyComparator implements Comparator<Map.Entry<GraphNode, Integer>>{

        @Override
        public int compare(Map.Entry<GraphNode, Integer> o1, Map.Entry<GraphNode, Integer> o2) {
            return o1.getValue() == o2.getValue() ? 0 : (o1.getValue() > o2.getValue() ? 1 : -1);
        }
    }

    public static List<GraphNode> dfs1(List<GraphNode> graph){
        Map<GraphNode, Integer> nodeCountMap = new HashMap<>();
        for (GraphNode graphNode : graph) {
            process1(graphNode, nodeCountMap);
        }
        List<GraphNode> sorted = nodeCountMap.entrySet().stream().sorted(new MyComparator()).map(e -> e.getKey()).collect(Collectors.toList());
        return sorted;
    }

    public static Integer process1(GraphNode graphNode, Map<GraphNode, Integer> nodeCountMap){
        if(nodeCountMap.containsKey(graphNode)){
            return nodeCountMap.get(graphNode);
        }
        int ans = 1;
        for (GraphNode next : graphNode.nexts) {
            ans += process1(next, nodeCountMap);
        }

        nodeCountMap.put(graphNode, ans);
        return ans;
    }

}
