package class10_BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code03_unRecursiveTraversal {
    public static List<Node> pre(Node head){
        List<Node> list = new ArrayList<>();
        if(head == null){
            return list;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;
    }

    public static List<Node> in(Node head){
        List<Node> list = new ArrayList<>();
        if(head == null){
            return list;
        }
        Node cur = head;
        LinkedList<Node> stack = new LinkedList<>();
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
//                Node pNode = stack.pop();
//                list.add(pNode);
//                if(pNode.right != null){
//                    cur = pNode.right;
//                }
                //important
                cur = stack.pop();
                list.add(cur);
                cur = cur.right;
            }
        }
        return list;
    }

    public static List<Node> pos(Node head){
        List<Node> list = new ArrayList<>();
        if(head == null){
            return list;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.push(head);
        LinkedList<Node> stack2 = new LinkedList<>();
        while(!stack.isEmpty()){
            Node node = stack.pop();
            stack2.push(node);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop());
        }
        return list;
    }

    public static boolean compareTwoList(List<Node> list, List<Node> list2){
        if(list.size() != list2.size()){
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node.generate(head, 1, 3, 20);

        List<Node> preOrderList = new ArrayList<>();
        Code02_RecursiveTraversal.binaryTraversal(head, Code02_RecursiveTraversal.TraversalOrder.preOrder, preOrderList);
        List<Node> preOrderList2 = pre(head);
        if(!compareTwoList(preOrderList, preOrderList2)) System.out.println(" preOrder failed!");

        List<Node> inOrderList = new ArrayList<>();
        Code02_RecursiveTraversal.binaryTraversal(head, Code02_RecursiveTraversal.TraversalOrder.inOrder, inOrderList);
        List<Node> inOrderList2 = in(head);
        if(!compareTwoList(inOrderList, inOrderList2)){
            Node.printTree(head);
            System.out.println(Arrays.toString(inOrderList.toArray()));
            System.out.println(Arrays.toString(inOrderList2.toArray()));
            System.out.println(" inOrder failed!");
        }

        List<Node> posOrderList = new ArrayList<>();
        Code02_RecursiveTraversal.binaryTraversal(head, Code02_RecursiveTraversal.TraversalOrder.posOrder, posOrderList);
        List<Node> posOrderList2 = pos(head);
        if(!compareTwoList(posOrderList, posOrderList2)) System.out.println(" posOrder failed!");
    }


}
