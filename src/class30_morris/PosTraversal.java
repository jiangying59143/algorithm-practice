package class30_morris;

import leetcode.TreeNode;

import java.util.LinkedList;

public class PosTraversal {
    public static void normal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null, cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if(node.right != null && node.right != prev){
                stack.push(node);
                cur = node.right;
            }else{
                System.out.print(node.val + " ");
                prev = node;
                cur = null;
            }
        }
    }

    public static void morris(TreeNode root){
        TreeNode mostRight, cur = root;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }

                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    mostRight.right = null;
                    printMorrisPos(cur.left);
                }
            }
//            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        printMorrisPos(root);
    }

    private static void printMorrisPos(TreeNode node){
        TreeNode tail = reverse(node);
        node = tail;
        while(node != null){
            System.out.print(node.val + " ");
            node = node.right;
        }
        reverse(tail);
    }

    private static TreeNode reverse(TreeNode node){
        TreeNode prev = null, next;
        while(node != null){
            next = node.right;
            node.right = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generate(new Integer[]{1,2,3,4,5,6,7});
        TreeNode.print(root);
        normal(root);
        System.out.println();
        morris(root);

        root = TreeNode.generate(new Integer[]{1,2,3,null,null,6,7});
        TreeNode.print(root);
        normal(root);
        System.out.println();
        morris(root);
    }
}
