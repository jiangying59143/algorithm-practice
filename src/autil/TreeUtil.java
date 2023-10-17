package autil;

import aDataStructrue.BinaryTreeNode;
import aDataStructrue.TreeNode;
import zview.Color;
import zview.PrettyPrintTree;

public class TreeUtil {

    public static BinaryTreeNode generateRandomBinaryTreeNode(int maxLayer, int maxValue){
        return generateRandomBinaryTreeNode(1, maxLayer, maxValue);
    }

    private static BinaryTreeNode generateRandomBinaryTreeNode(int level, int maxLayer, int maxValue){
        if(level > maxLayer || Math.random() > 0.9){
            return null;
        }

        BinaryTreeNode head = new BinaryTreeNode((int)(maxValue * Math.random()));
        head.setLeft(generateRandomBinaryTreeNode(level + 1, maxLayer, maxValue));
        head.setRight(generateRandomBinaryTreeNode(level + 1, maxLayer, maxValue));
        return head;
    }

    public static TreeNode<Integer> generateRandomTreeNode(int maxLayer, int maxBranches, int maxValue){
        return generateRandomTreeNode(1, maxLayer, maxBranches, maxValue);
    }

    private static TreeNode<Integer> generateRandomTreeNode(int level, int maxLayer, int maxBranches, int maxValue){
        if(level > maxLayer || Math.random() > 0.9){
            return null;
        }

        TreeNode head = new TreeNode((int)(maxValue * Math.random()));

        int branches = (int)(maxBranches*Math.random());
        for (int i = 0; i < branches; i++) {
            head.getChildren().add(generateRandomTreeNode(level + 1, maxLayer, maxBranches, maxValue));
        }
        return head;
    }

    public static void printTree(TreeNode tree){
        printTree(tree, Color.GRAY, false);
    }

    public static void printTree(TreeNode tree, Color color, boolean isBorder){
        System.out.println("Model: + " + (tree != null ? tree.getClass().getName() : "null") + "  Color:" + color.toString() + "  isBorder:" + isBorder);
        var pt = new PrettyPrintTree<TreeNode>(
                (x) -> x.getChildren(),
                (x) -> x.getValue().toString()
        );
        pt.setBorder(isBorder);
        pt.setColor(color);
        pt.display(tree);
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root  = generateRandomTreeNode(5, 4, 100);
        printTree(root);
        TreeNode binaryTreeNode  = generateRandomBinaryTreeNode(5, 100);
        printTree(binaryTreeNode, Color.PINK, false);

        root  = generateRandomTreeNode(5, 4, 100);
        printTree(root, Color.RED, true);
        binaryTreeNode  = generateRandomBinaryTreeNode(5, 100);
        printTree(binaryTreeNode, Color.BLUE, true);

    }
}
