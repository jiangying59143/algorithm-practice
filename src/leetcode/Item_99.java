package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_99 {
    static class TreeNodeObject{
        public TreeNode preNode;
        public TreeNode node;

        public TreeNodeObject(TreeNode preNode, TreeNode node) {
            this.preNode = preNode;
            this.node = node;
        }
    }

    public static void recoverTree(TreeNode root) {
        process(root, null);
    }

    public static TreeNodeObject process(TreeNode root, TreeNode pre){
        if(root == null){
            return null;
        }

        TreeNodeObject leftObj = process(root.left, root);
        TreeNodeObject rightObj = process(root.right, root);

        return null;
    }

    public static void main(String[] args) {

    }
}
