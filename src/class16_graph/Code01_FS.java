package class16_graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Code01_FS {
    public static void BFS(Node head){
        LinkedList<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.add(head);
        set.add(head);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.value);
            for (Node next : node.nexts) {
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    public static void DFS(Node head){
        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        stack.push(head);
        set.add(head);
        System.out.println(head.value);
        while(!stack.isEmpty()){
            Node node  = stack.pop();
            for (Node next : node.nexts) {
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

    public static void DFS_R(Node head){
        processDfs(head, new HashSet<>());
    }


    public static void processDfs(Node node, Set<Node> set){
        set.add(node);
        System.out.println(node.value);
        for (Node next : node.nexts) {
            if(!set.contains(next)) {
                processDfs(next, set);
            }
        }

    }

    public static void main(String[] args) {
        Node node = Node.generateRandomNode();
        System.out.println("BFS");
        BFS(node);
        System.out.println("-------------");
        System.out.println("DFS");
        DFS(node);
        System.out.println("-------------");
        DFS_R(node);
    }
}
