package leetcode;

import java.util.*;

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
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        Deque<Integer> path = new LinkedList<Integer>();
        if(root == null){
            return ret;
        }
        process(root, targetSum, path, ret);
        return ret;
    }

    public static void process(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> ret){
        if(root == null){
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            ret.add(new ArrayList<>(path));
        }
        process(root.left, targetSum, path, ret);
        process(root.right, targetSum, path, ret);
        path.pollLast();
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
        List<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
                nodes.add(new TreeNode(arr[i]));
            }else{
                nodes.add(null);
            }
        }

        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i) == null){
//                nodes.add(null);
//                nodes.add(null);
//                nodes.add(2 * i + 1, null);
//                nodes.add(2 * i + 2, null);
                continue;
            }
            if(2*i+1 < nodes.size() && nodes.get(2 * i + 1) != null) {
                nodes.get(i).left = nodes.get(2 * i + 1);
            }
            if(2*i+2 < nodes.size() && nodes.get(2 * i + 2) != null) {
                nodes.get(i).right = nodes.get(2*i+2);
            }
        }
        return nodes.get(0);
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = generate(arr);
        List<List<Integer>> res = levelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
        printTree(root);
        List<List<Integer>> list = pathSum(root, 22);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}
