package class10_BinaryTree;

public class Code02_RecursiveTraversal {
    enum TraversalOrder{
        preOrder, inOrder,posOrder;
    }

    public void binaryTraversal(Node root, TraversalOrder order){
        if(root == null){
            return;
        }
        if(order == TraversalOrder.preOrder){
            System.out.println(root.val);
        }
        binaryTraversal(root.left, order);
        if(order == TraversalOrder.inOrder){
            System.out.println(root.val);
        }
        binaryTraversal(root.right, order);
        if(order == TraversalOrder.posOrder){
            System.out.println(root.val);
        }
    }

}
