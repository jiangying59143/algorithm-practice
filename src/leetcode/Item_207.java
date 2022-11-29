package leetcode;

import java.util.*;

public class Item_207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if(!graph.containsKey(prerequisites[i][1])){
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }else{
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            if(!graph.containsKey(prerequisites[i][0])){
                List<Integer> list = new ArrayList<>();
                graph.put(prerequisites[i][0], list);
            }
        }

        Map<Integer, Integer> in_degreeMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> node : graph.entrySet()) {
            in_degreeMap.put(node.getKey(), 0);
        }

        for (Map.Entry<Integer, List<Integer>> node : graph.entrySet()) {
            for (Integer next : node.getValue()) {
                in_degreeMap.put(next, in_degreeMap.get(next)+1);
            }
        }

        LinkedList<Integer> zeroQueue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> nodeIn_Degree : in_degreeMap.entrySet()) {
            if(nodeIn_Degree.getValue() == 0){
                zeroQueue.add(nodeIn_Degree.getKey());
            }
        }

        int visited = 0;
        while(!zeroQueue.isEmpty()){
            Integer zero = zeroQueue.poll();
            in_degreeMap.remove(zero);
            visited++;
            for (Integer next : graph.get(zero)) {
                in_degreeMap.put(next, in_degreeMap.get(next)-1);
                if(in_degreeMap.get(next) == 0){
                    zeroQueue.add(next);
                }
            }
        }
        return visited == graph.size() || prerequisites.length==0;
        //根据题目中的限制下面的也对， 就用不到 numCourses 了
//        return in_degreeMap.size() == 0;
    }

    public static void main(String[] args) {
        int[][] prerequisites;
//        prerequisites = new int[][]{{1,0}};
//        System.out.println(canFinish(2, prerequisites));
//
//        prerequisites = new int[][]{{1,0},{0,1}};
//        System.out.println(canFinish(2, prerequisites));
//
//        prerequisites = new int[][]{{0,0}};
//        System.out.println(canFinish(1, prerequisites));
//
//        prerequisites = new int[][]{};
//        System.out.println(canFinish(1, prerequisites));

        prerequisites = new int[][]{{1,4},{2,4},{3,1},{3,2}};
        System.out.println(canFinish(5, prerequisites));
    }
}
