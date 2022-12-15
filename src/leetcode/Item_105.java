package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Item_105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer[]> nodeIndex = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            Integer[] indexes = new Integer[2];
            indexes[0] = i;
            nodeIndex.put(preorder[i], indexes);
        }
        for (int i = 0; i < inorder.length; i++) {
            nodeIndex.get(inorder[i])[1] = i;
        }

        return process(nodeIndex, preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private static TreeNode process(Map<Integer, Integer[]> nodeIndex, int[] preorder, int[] inorder, int preFrom, int preTo, int inFrom, int inTo){
        if(preFrom > preTo){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preFrom]);

        int leftInFrom = inFrom;
        int leftInTo = nodeIndex.get(root.val)[1] - 1 < inFrom ? -1 : nodeIndex.get(root.val)[1] - 1;
        int leftLen = leftInTo - leftInFrom + 1;
        int leftPreFrom = preFrom+1;
        int leftPreTo = preFrom + leftLen -1;

        root.left = process(nodeIndex, preorder, inorder, leftPreFrom, leftPreTo, leftInFrom, leftInTo);

        int rightInFrom = nodeIndex.get(root.val)[1] + 1 > inTo ? Integer.MAX_VALUE : nodeIndex.get(root.val)[1] + 1;
        int rightInTo = inTo;
        int rightLen = rightInTo - rightInFrom + 1;
        int rightPreFrom = leftLen <= 0 ? preFrom + 1 : leftPreTo + 1;
        int rightPreTo = rightPreFrom + rightLen -1;
        root.right = process(nodeIndex, preorder, inorder, rightPreFrom, rightPreTo, rightInFrom, rightInTo);
        return root;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> nodeIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            nodeIndex.put(inorder[i], i);
        }

        return process2(nodeIndex, preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private static TreeNode process2(Map<Integer, Integer> nodeIndex, int[] preorder, int[] inorder, int preFrom, int preTo, int inFrom, int inTo){
        int inOrderHeadIndex = nodeIndex.get(preorder[preFrom]);
        int leftLen = inOrderHeadIndex - inFrom;
        int rightLen = inTo - inOrderHeadIndex;
        TreeNode root = new TreeNode(inorder[inOrderHeadIndex]);

        if (leftLen > 0) {
            root.left = process2(nodeIndex, preorder, inorder, preFrom + 1, preFrom + leftLen, inFrom, inOrderHeadIndex - 1);
        }
        if(rightLen > 0) {
            root.right = process2(nodeIndex, preorder, inorder, preTo - rightLen + 1, preTo, inOrderHeadIndex + 1, inTo);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder , inorder;
        TreeNode root;

        preorder = new int[]{3,9,20,15,7};
        inorder = new int[]{9,3,15,20,7};
        root = buildTree2(preorder, inorder);
        TreeNode.print(root);

        preorder = new int[]{-1};
        inorder = new int[]{-1};
        root = buildTree2(preorder, inorder);
        TreeNode.print(root);

        preorder = new int[]{1, 2};
        inorder = new int[]{1, 2};
        root = buildTree2(preorder, inorder);
        TreeNode.print(root);

        preorder = new int[]{1, 2, 3};
        inorder = new int[]{3, 2, 1};
        root = buildTree2(preorder, inorder);
        TreeNode.print(root);

        preorder = new int[]{1, 2, 3};
        inorder = new int[]{2, 3, 1};
        root = buildTree2(preorder, inorder);
        TreeNode.print(root);
    }
}
