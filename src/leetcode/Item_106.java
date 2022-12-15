package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_106 {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderValueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderValueIndexMap.put(inorder[i], i);
        }
        return buildTree(inOrderValueIndexMap, inorder, postorder, 0, inorder.length-1, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(Map<Integer, Integer> inOrderValueIndexMap, int[] inorder, int[] postorder, int inFrom, int inTo, int postFrom, int postTo){
        int inOrderHeadIndex = inOrderValueIndexMap.get(postorder[postTo]);
        int leftLen = inOrderHeadIndex - inFrom;
        int rightLen = inTo - inOrderHeadIndex;
        TreeNode root = new TreeNode(inorder[inOrderHeadIndex]);

        if(leftLen > 0){
            root.left = buildTree(inOrderValueIndexMap, inorder, postorder, inFrom, inOrderHeadIndex-1, postFrom, postFrom+leftLen-1);
        }

        if(rightLen > 0){
            root.right = buildTree(inOrderValueIndexMap, inorder, postorder, inOrderHeadIndex+1, inTo, postTo - rightLen, postTo-1);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] inorder, postorder;
        TreeNode root;

        inorder = new int[]{9,3,15,20,7};
        postorder = new int[]{9,15,7,20,3};
        root = buildTree(inorder, postorder);
        TreeNode.print(root);

        inorder = new int[]{-1};
        postorder = new int[]{-1};
        root = buildTree(inorder, postorder);
        TreeNode.print(root);
    }
}
