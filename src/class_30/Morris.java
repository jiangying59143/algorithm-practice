package class_30;

import leetcode.TreeNode;

public class Morris {
    public static void morrisTraversal(TreeNode cur){
        TreeNode leftMostRight;
        while(cur != null){
            leftMostRight = cur.left;
            if(cur.left != null){
                while(leftMostRight.right != null && leftMostRight.right != cur){
                    leftMostRight = leftMostRight.right;
                }
                if(leftMostRight.right == null){
                    // pre order
//                    System.out.print(cur.val + " ");
                    leftMostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else if(leftMostRight.right == cur){
                    leftMostRight.right = null;
                }
            }else{
                // pre order
//                System.out.print(cur.val + " ");
            }
            // inorder
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode cur;
        cur = TreeNode.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.print(cur);
        morrisTraversal(cur);
    }
}
