package aDataStructrue;

public class BinaryTreeNode extends TreeNode<Integer> {
    private final int val;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    public BinaryTreeNode(Integer val){
        super(val);
        this.val = val;
    }

    public Integer getValue(){ return this.val; }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode setLeft(BinaryTreeNode left) {
        this.left = left;
        super.getChildren().add(left);
        return this;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public BinaryTreeNode setRight(BinaryTreeNode right) {
        this.right = right;
        super.getChildren().add(right);
        return this;
    }
}
