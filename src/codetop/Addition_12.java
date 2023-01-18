package codetop;

/**
 * 给定二叉树其中的一个结点，请找出其中序遍历顺序的下一个结点并且返回。
 *
 * 注意，树中的结点不仅包含左右子结点，而且包含指向父结点的指针。
 */
public class Addition_12 {
    public static TreeLinkNode getNext(TreeLinkNode node){
        if(node == null){
            return null;
        }
        TreeLinkNode next = null;
        // head
        if(node.right != null){
            next = node.right;
            while(next.left != null){
                next = next.left;
            }
        }else{
            if(node.parent != null){
                //left
                if(node.parent.left == node) {
                    next = node.parent;
                }
                //right
                else if(node.parent.right == node){
                    while(node.parent != null && node.parent.right == node){
                        node = node.parent;
                    }
                    if(node.parent != null && node.parent.left == node){
                        next = node.parent;
                    }
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        TreeLinkNode[] nodes = TreeLinkNode.generate(new Integer[]{1,2,3,4,5,null, 6, 7, null, 8, 9});
        TreeLinkNode.print(nodes[0]);
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i] + " " + getNext(nodes[i]));
        }
    }
}
