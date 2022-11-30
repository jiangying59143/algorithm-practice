package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item_743 {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        distanceMap.put(k, 0);

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            if(!map.containsKey(times[i][0])) {
                map.put(times[i][0], new ArrayList<>());
            }
            if(!map.containsKey(times[i][1])) {
                map.put(times[i][1], new ArrayList<>());
            }
            map.get(times[i][0]).add(times[i]);
        }

        int minNode = getMinToNode(distanceMap, visited);
        int time = Integer.MIN_VALUE;
        while(minNode != -1){
            visited[minNode] = true;
            time = Math.max(time, distanceMap.get(minNode));
            for (int[] edge : map.get(minNode)) {
                int toNode = edge[1];
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distanceMap.get(minNode) + edge[2]);
                }else{
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode),distanceMap.get(minNode) + edge[2]));
                }
            }
            minNode = getMinToNode(distanceMap, visited);
        }


        if(distanceMap.size() != n){
            return -1;
        }
        return time;
    }

    private static int getMinToNode(Map<Integer, Integer> distanceMap, boolean[] visited){
        int minNode = -1, min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
            if(!visited[entry.getKey()] && entry.getValue() <= min){
                min = entry.getValue();
                minNode = entry.getKey();
            }
        }
        return minNode;
    }

    public static void main(String[] args) {
        int[][] times;
        times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times, 4, 2));
        times = new int[][]{{1,2,1}};
        System.out.println(networkDelayTime(times, 2, 1));
        System.out.println(networkDelayTime(times, 2, 2));
    }
}
