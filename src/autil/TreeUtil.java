package autil;

import aDataStructrue.BinaryTreeNode;
import aDataStructrue.TreeNode;
import zview.PrettyPrintTree;

public class TreeUtil {

    public static TreeNode<Integer> generateRandomTreeNode(int maxLayer, int maxBranches, int maxValue){
        return generateRandomTreeNode(1, maxLayer, maxBranches, maxValue);
    }

    private static TreeNode<Integer> generateRandomTreeNode(int level, int maxLayer, int maxBranches, int maxValue){
        if(level > maxLayer || Math.random() > 0.5){
            return null;
        }

        BinaryTreeNode head = new BinaryTreeNode((int)(maxValue * Math.random()));

        int branches = (int)(maxBranches*Math.random());
        for (int i = 0; i < branches; i++) {
            head.getChildren().add(generateRandomTreeNode(level + 1, maxLayer, maxBranches, maxValue));
        }
        return head;
    }

    public static BinaryTreeNode generateRandomBinaryTreeNode(int maxLayer, int maxValue){
        return generateRandomBinaryTreeNode(1, maxLayer, maxValue);
    }

    private static BinaryTreeNode generateRandomBinaryTreeNode(int level, int maxLayer, int maxValue){
        if(level > maxLayer || Math.random() > 0.5){
            return null;
        }

        BinaryTreeNode head = new BinaryTreeNode((int)(maxValue * Math.random()));
        head.setLeft(generateRandomBinaryTreeNode(level + 1, maxLayer, maxValue));
        head.setRight(generateRandomBinaryTreeNode(level + 1, maxLayer, maxValue));
        return head;
    }

    public static void printTree(TreeNode tree){
        var pt = new PrettyPrintTree<TreeNode>(
                (x) -> x.getChildren(),
                (x) -> x.getValue().toString()
        );
        pt.display(tree);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            TreeNode root  = generateRandomTreeNode(5, 5, 100);
            TreeNode root  = generateRandomBinaryTreeNode(5, 100);
            printTree(root);
        }
    }
}
