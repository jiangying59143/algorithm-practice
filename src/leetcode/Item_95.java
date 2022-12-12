package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_95 {
    public static List<TreeNode> generateTrees(int n) {
        return procss(1, n);
    }

    private static List<TreeNode> procss(int start, int n){
        if(start == n){
            return Arrays.asList(new TreeNode[]{new TreeNode(start)});
        }

        List<TreeNode> res = new ArrayList<>();
        for (int i = start; i <= n; i++) {
            TreeNode head = new TreeNode(i);
            List<TreeNode> leftList = i > 1 ? procss(1, i-1) : null;
            List<TreeNode> rightList = i < n ? procss(i+1, n) : null;

            int li = 0, ri = 0;

            while(leftList != null && li < leftList.size() || rightList != null && ri < rightList.size()){
                TreeNode leftTreeNode = null;
                if(leftList != null && li < leftList.size()){
                    leftTreeNode = leftList.get(li);
                }

                TreeNode rightTreeNode = null;
                if(rightList != null && ri < rightList.size()){
                    rightTreeNode = rightList.get(ri);
                }else{
                    li++;
                    ri = 0;
                }
                ri++;

                head.left = leftTreeNode;
                head.right = rightTreeNode;
                res.add(head);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(3);
        for (int i = 0; i < res.size(); i++) {
            TreeNode.printTree(res.get(i));
        }
    }
}
