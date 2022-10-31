package leetcode;

import java.util.*;

public class Item_113 {
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

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null, null, null,5,1};
        TreeNode root = TreeNode.generate(arr);
        TreeNode.printTree(root);
        List<List<Integer>> list = pathSum(root, 22);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}
