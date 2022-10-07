package leetcode;

import java.util.LinkedList;

public class Item_108 {
    public static void main(String[] args) {
        Item_108 obj = new Item_108();
        TreeNode node = obj.sortedArrayToBST(new int[]{-10,-3,0,5,9});
//        obj.preOrder(node);
        obj.levelTraversal(node);
    }

    public void levelTraversal(TreeNode node){
        TreeNode curEnd = node, nextEnd = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.add(cur.left);
                nextEnd=cur.left;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            if(cur == curEnd){
                System.out.println();
                curEnd = nextEnd;
            }
        }
    }

    public void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        preOrder(node.left);
        System.out.println(node.val);
        preOrder(node.right);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left = process(nums, 0, nums.length/2-1);
        root.right = process(nums, nums.length/2+1, nums.length-1);
        return root;
    }

    private TreeNode process(int[] nums, int start, int end){
        if(start == end){
            return new TreeNode(nums[start]);
        }
        if(start > end){
            return null;
        }
        TreeNode node = new TreeNode(nums[start + (end-start+1)/2]);
        node.left = process(nums, start, start + (end-start+1)/2-1);
        node.right = process(nums, start + (end-start+1)/2+1, end);
        return node;
    }

  public class TreeNode {
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
}
