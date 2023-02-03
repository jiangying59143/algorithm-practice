package leetcode;

public class Item_124 {
    static class Solution {
        private int ans = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return ans;
        }

        private int maxGain(TreeNode root){
            if(root == null){
                return 0;
            }
            int leftGain = Math.max(maxGain(root.left), 0);
            int rightGain = Math.max(maxGain(root.right), 0);

            ans = Math.max(ans, leftGain + rightGain + root.val);

            return root.val + Math.max(leftGain, rightGain);
        }
    }

    public static void main(String[] args) {
        Solution obj;
        TreeNode root;

        obj = new Solution();
        root = TreeNode.generate(new Integer[]{-10,9,20,null,null,15,7});
        TreeNode.print(root);
        System.out.println(obj.maxPathSum(root));

        obj = new Solution();
        root = TreeNode.generate(new Integer[]{1,2,3});
        TreeNode.print(root);
        System.out.println(obj.maxPathSum(root));
    }
}
