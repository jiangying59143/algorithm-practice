package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Item_113 {
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


    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>  res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.add(new ArrayList<>());
        process(root, null, targetSum, res);
        if(res.get(res.size()-1).isEmpty()){
            res.remove(res.size()-1);
        }
        return res;
    }

    public static void process(TreeNode root, TreeNode pre, int targetSum, List<List<Integer>> res){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && root.val == targetSum){
            res.get(res.size() - 1).add(root.val);
            res.add(new ArrayList<>());
        }
        process(root.left, root, targetSum - root.val, res);
        process(root.right, root, targetSum - root.val, res);
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

    public static TreeNode generate(Integer[] arr){
        TreeNode[] nodes=new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
                nodes[i] = new TreeNode(arr[i]);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] == null){
                continue;
            }
            if(2*i+1 < nodes.length) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if(2*i+2 < nodes.length) {
                nodes[i].right = nodes[2*i+2];
            }
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = generate(arr);
        List<List<Integer>> res = levelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
        List<List<Integer>> list = pathSum(root, 22);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}
