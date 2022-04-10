package class16_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Code01_FS {
    public static void BFS(GraphNode head){
        LinkedList<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();
        queue.add(head);
        set.add(head);
        while(!queue.isEmpty()){
            GraphNode node = queue.poll();
            System.out.println(node.value);
            for (GraphNode next : node.nexts) {
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    public static void DFS(GraphNode head){
        LinkedList<GraphNode> stack = new LinkedList<>();
        Set<GraphNode> set = new HashSet<>();
        stack.push(head);
        set.add(head);
        System.out.println(head.value);
        while(!stack.isEmpty()){
            GraphNode node  = stack.pop();
            for (GraphNode next : node.nexts) {
                if(!set.contains(next)){
                    set.add(next);
                    stack.push(node);
                    stack.push(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    public static void DFS_R(GraphNode head){
        processDfs(head, new HashSet<>());
    }


    public static void processDfs(GraphNode node, Set<GraphNode> set){
        set.add(node);
        System.out.println(node.value);
        for (GraphNode next : node.nexts) {
            if(!set.contains(next)) {
                processDfs(next, set);
            }
        }

    }

    public static void main(String[] args) {
        GraphNode graphNode = GraphNode.generateRandomNode();
        System.out.println("BFS");
        BFS(graphNode);
        System.out.println("-------------");
        System.out.println("DFS");
        DFS(graphNode);
        System.out.println("-------------");
        DFS_R(graphNode);
    }
}
