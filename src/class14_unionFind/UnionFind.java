package class14_unionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionFind {
    public static class Node<T>{
        public T value;
        public Node(T v){
            value = v;
        }
    }

    public static class UF<T>{
        public Map<T, Node<T>> nodes = new HashMap<>();
        public Map<Node<T>, Node<T>> parents = new HashMap<>();
        public Map<Node<T>, Integer> sizeMap = new HashMap<>();

        public UF(List<T> list){
            for (T t : list) {
                Node<T> node = new Node<>(t);
                nodes.put(t, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<T> findParent(Node<T> node){
            Stack<Node<T>> stack = new Stack<>();
            while(parents.get(node) != node){
                stack.push(node);
                node = parents.get(node);
            }
            while(!stack.isEmpty()){
                parents.put(stack.pop(), node);
            }

            return node;
        }

        public void union(Node<T> a, Node<T> b){
            Node<T> aHead = findParent(a);
            Node<T> bHead = findParent(b);
            if(aHead != bHead){
                Node<T> small = aHead;
                Node<T> big = bHead;
                if(sizeMap.get(aHead) > sizeMap.get(bHead)){
                    big = aHead;
                    small = bHead;
                }

                parents.put(small, big);
                sizeMap.put(big, sizeMap.get(aHead) + sizeMap.get(bHead));
                sizeMap.remove(small);
            }
        }
    }

    public static void cal(Node<Integer> a, Node<Integer> b){
        b.value = a.value+b.value;
    }

    public static void main(String[] args) {
        Node<Integer> b = new Node<>(2);
        cal(new Node<>(1), b);
        System.out.println(b.value);
    }
}
