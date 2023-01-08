package review;

import leetcode.TreeNode;

public class Binary {
    public static void morris(TreeNode root){
        TreeNode rightMost, cur = root;
        while(cur != null){
            rightMost = cur.left;
            if(rightMost != null){
                while(rightMost.right != null && rightMost.right != cur){
                    rightMost = rightMost.right;
                }
                if(rightMost.right == null){
                    System.out.print(cur.val + " ");
                    rightMost.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    rightMost.right = null;
                }
            }else{
                System.out.print(cur.val + " ");
            }
//            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root;
        root = TreeNode.generate(new Integer[]{1, 2,3 ,4,5,6,7});
        TreeNode.print(root);
        morris(root);
    }
}
