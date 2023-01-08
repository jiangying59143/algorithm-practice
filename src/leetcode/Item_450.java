package leetcode;

import com.sun.source.tree.Tree;

public class Item_450 {
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null, cur=root;
        while(cur != null && cur.val != key){
            parent = cur;
            if(cur.val < key){
                cur = cur.right;
            }else if(cur.val > key){
                cur = cur.left;
            }
        }
        if(cur == null){
            return root;
        }

        if(cur.left == null && cur.right == null){
            cur = null;
        }else if(cur.left == null){
            cur = cur.right;
        }else if(cur.right == null){
            cur = cur.left;
        }else{
            TreeNode successor = cur.right;
            while(successor.left != null){
                successor = successor.left;
            }
            successor.left = cur.left;
            cur = cur.right;
        }
        if(parent == null){
            return cur;
        }else if(parent.left != null && parent.left.val == key){
            parent.left = cur;
        }else{
            parent.right = cur;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode;

//        treeNode = TreeNode.generate(new Integer[]{5,3,6,2,4,null,7});
//        TreeNode.print(treeNode);
//        deleteNode(treeNode, 3);
//        TreeNode.print(treeNode);

        treeNode = TreeNode.generate(new Integer[]{5,3,6,2,4,null,7});
        TreeNode.print(treeNode);
        deleteNode(treeNode, 0);
        TreeNode.print(treeNode);
    }
}
