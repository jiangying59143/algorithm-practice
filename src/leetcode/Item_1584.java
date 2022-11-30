package leetcode;

import java.util.*;

// TODO 还需要优化，去掉一些边
public class Item_1584 {

    public static int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        int nodeLength = points.length;
        //每一行的第一个数是from, 第二个为to, 第三个是weight
        Map<Integer, Map<Integer,int[]>> nodeEdges = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            nodeEdges.put(i, new HashMap<>());
            for (int j = 0; j < points.length; j++) {
                if(i == j){
                    continue;
                }
                int[] edge = new int[2];
                edge[0] = i;
                edge[1] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                nodeEdges.get(i).put(j, edge);
            }
        }

        PriorityQueue<Map.Entry<Integer, int[]>> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.getValue()[1]));
        Set<Integer> touchedNodes = new HashSet<>();
        touchedNodes.add(0);
        for (Map.Entry<Integer, int[]> edge : nodeEdges.get(0).entrySet()) {
            queue.add(edge);
        }
        int ans = 0;
        while(!queue.isEmpty()){
            Map.Entry<Integer, int[]> pollEdge = queue.poll();
            if(!touchedNodes.contains(pollEdge.getKey())) {
                ans += pollEdge.getValue()[1];
                touchedNodes.add(pollEdge.getKey());
                //移除所有到from的边
//                for (Map.Entry<Integer, Map<Integer, int[]>> nodeEdge : nodeEdges.entrySet()) {
//                    nodeEdge.getValue().remove(pollEdge.getValue()[0]);
//                }
                for (Map.Entry<Integer, int[]> edge : nodeEdges.get(pollEdge.getKey()).entrySet()) {
                    queue.add(edge);
                }
            }
        }
        return ans;
    }

    public static int minCostConnectPoints1(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        int nodeLength = points.length;
        //每一行的第一个数是from, 第二个为to, 第三个是weight
        Map<Integer, int[][]> nodeEdges = new HashMap<>();
        int k = 0;
        int edgeLength = nodeLength-1;
        for (int i = 0; i < points.length; i++) {
            nodeEdges.put(i, new int[edgeLength][3]);
            for (int j = 0; j < points.length; j++) {
                if(i == j){
                    continue;
                }
                nodeEdges.get(i)[k][0] = i;
                nodeEdges.get(i)[k][1] = j;
                nodeEdges.get(i)[k++][2] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            }
            k = 0;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        Set<Integer> touchedNodes = new HashSet<>();
        touchedNodes.add(0);
        for (int[] edge : nodeEdges.get(0)) {
            queue.add(edge);
        }
        int ans = 0;
        while(!queue.isEmpty()){
            int[] pollEdge = queue.poll();
            if(!touchedNodes.contains(pollEdge[1])) {
                ans += pollEdge[2];
                touchedNodes.add(pollEdge[1]);
                for (int[] edge : nodeEdges.get(pollEdge[1])) {
                    queue.add(edge);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points;
        points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
        points = new int[][]{{3,12},{-2,5},{-4,1}};
        System.out.println(minCostConnectPoints(points));

    }
}
