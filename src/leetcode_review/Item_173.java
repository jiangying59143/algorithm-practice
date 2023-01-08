package leetcode_review;

import java.util.LinkedList;

public class Item_173 {
    static class BSTIterator {
        final LinkedList<TreeNode> stack;
        TreeNode root;
        public BSTIterator(TreeNode root) {
            this.root = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while(!stack.isEmpty() || root != null){
                if(root != null){
                    stack.push(root);
                    root = root.left;
                }else{
                    TreeNode node = stack.pop();
                    root = node.right;
                    return node.val;
                }
            }
            return -1;
        }

        public boolean hasNext() {
            return !stack.isEmpty() || root != null;
        }
    }
}
