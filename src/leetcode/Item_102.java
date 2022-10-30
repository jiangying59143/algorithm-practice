package leetcode;

import class10_BinaryTree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Item_102 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        TreeNode curLevelEnd = root, nextLevelEnd = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res.add(new ArrayList<>());
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.get(res.size()-1).add(node.val);
            if(node.left != null){
                queue.add(node.left);
                nextLevelEnd = node.left;
            }
            if(node.right != null){
                queue.add(node.right);
                nextLevelEnd = node.right;
            }
            if(node == curLevelEnd){
                curLevelEnd = nextLevelEnd;
                res.add(new ArrayList<>());
            }
        }
        if(res.get(res.size()-1).isEmpty()){
            res.remove(res.size()-1);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

}
