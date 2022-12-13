package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_99 {

    public static void recoverTree(TreeNode root) {
        List<TreeNode> listNodes = new ArrayList<>();
        listNodes(root, listNodes);
        TreeNode[] wrongNodes = new TreeNode[2];
        for (int i = 0; i < listNodes.size()-1; i++) {
            if(listNodes.get(i).val > listNodes.get(i+1).val){
                if(wrongNodes[1] == null) {
                    wrongNodes[0] = listNodes.get(i);
                    wrongNodes[1] = listNodes.get(i + 1);
                }else{
                    wrongNodes[1] = listNodes.get(i + 1);
                }
            }
        }
        int temp = wrongNodes[0].val;
        wrongNodes[0].val = wrongNodes[1].val;
        wrongNodes[1].val = temp;
    }

    public static void listNodes(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }

        listNodes(root.left, list);
        list.add(root);
        listNodes(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root;
        root = TreeNode.generate(new Integer[]{1, 3, null, null, 2});
        recoverTree(root);
        TreeNode.printTree(root);

        root = TreeNode.generate(new Integer[]{3,1,4,null,null,2});
        recoverTree(root);
        TreeNode.printTree(root);
    }
}
