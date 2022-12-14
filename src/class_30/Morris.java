package class_30;

import leetcode.TreeNode;

public class Morris {
    public static void morrisTraversal(TreeNode cur){
        while(cur != null){
            if(cur.left == null){
                cur = cur.right;
            }else{
                TreeNode leftMostRight = cur.left;
                while(leftMostRight.right != null && leftMostRight.right != cur){
                    leftMostRight = leftMostRight.right;
                }

                //第一次到
                if(leftMostRight.right == null && leftMostRight.right != cur){
                    System.out.println(cur.val);
                }

                if(leftMostRight.right == null){
                    leftMostRight.right = cur;
                    cur = cur.left;
                }else if(leftMostRight.right == cur){
                    leftMostRight.right = null;
                    cur = cur.right;
                }
            }

        }
    }

    public static void main(String[] args) {
        TreeNode cur;
        cur = TreeNode.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.print(cur);
        morrisTraversal(cur);
    }
}
