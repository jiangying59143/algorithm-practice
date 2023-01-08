package leetcode_review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Item_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        TreeNode curLevelTail = root, nextLevelTail = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
                nextLevelTail = node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextLevelTail = node.right;
            }
            if(node == curLevelTail && !queue.isEmpty()){
                curLevelTail = nextLevelTail;
                list.add(curLevelTail.val);
            }
        }
        return list;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(i == levelSize-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }
}
