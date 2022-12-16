package leetcode;

import java.util.LinkedList;

public class Item_173 {
    static class BSTIterator {

        private LinkedList<TreeNode> stack;
        private TreeNode root;
        public BSTIterator(TreeNode root) {
            this.root = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while(!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
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

    public static void main(String[] args) {
        TreeNode root;
        BSTIterator bstIterator;
        root = TreeNode.generate(new Integer[]{7, 3, 15, null, null, 9, 20});
        TreeNode.print(root);
        bstIterator = new BSTIterator(root);
        while(bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }

    }
}
