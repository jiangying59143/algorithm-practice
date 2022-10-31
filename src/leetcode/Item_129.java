package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_129 {
    public static int sumNumbers(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        process(root, path, res);
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += res.get(i);
        }
        return sum;
    }

    public static void process(TreeNode root, List<Integer> path, List<Integer> res){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            int sum = 0;
            int p = 0;
            for (int i = path.size() - 1; i >= 0; i--) {
                sum += path.get(i) * Math.pow(10, p++);
            }
            res.add(sum);
        }
        process(root.left, path, res);
        process(root.right, path, res);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
}
