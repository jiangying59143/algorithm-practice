package class10_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Code02_RecursiveTraversal {
    enum TraversalOrder{
        preOrder, inOrder,posOrder;
    }

    public static void binaryTraversal(Node root, TraversalOrder order, List<Node> list){
        if(root == null){
            return;
        }
        if(order == TraversalOrder.preOrder){
            list.add(root);
        }
        binaryTraversal(root.left, order, list);
        if(order == TraversalOrder.inOrder){
            list.add(root);
        }
        binaryTraversal(root.right, order, list);
        if(order == TraversalOrder.posOrder){
            list.add(root);
        }
    }

}
