package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_95 {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n+1][n+1];
        return procss(1, n, dp);
    }

    private static List<TreeNode> procss(int start, int n, List<TreeNode>[][] dp){
        if(dp[start][n] != null){
            return dp[start][n];
        }
        List<TreeNode> res = new ArrayList<>();
        if(start == n){
            res.add(new TreeNode(start));
            dp[start][n] = res;
            return res;
        }

        for (int i = start; i <= n; i++) {
            List<TreeNode> leftList = start < i ? procss(start, i-1, dp) : null;
            List<TreeNode> rightList = i < n ? procss(i+1, n, dp) : null;
            buildTrees(i, leftList, rightList, res);
        }
        dp[start][n] = res;
        return res;
    }

    private static void buildTrees(int headValue, List<TreeNode> leftList, List<TreeNode> rightList, List<TreeNode> res) {
        if(leftList != null && rightList != null ) {
            for (int li = 0;li < leftList.size(); li++) {
                for (int ri = 0;ri < rightList.size(); ri++) {
                    TreeNode head = new TreeNode(headValue);
                    head.left = leftList.get(li);
                    head.right = rightList.get(ri);
                    res.add(head);
                }
            }
        }

        int li = 0;
        while(leftList != null && rightList == null && li < leftList.size()){
            TreeNode head = new TreeNode(headValue);
            head.left = leftList.get(li++);
            res.add(head);
        }

        int ri = 0;
        while(leftList == null && rightList != null && ri < rightList.size()){
            TreeNode head = new TreeNode(headValue);
            head.right = rightList.get(ri++);
            res.add(head);
        }
    }

    public static void main(String[] args) {
        List<TreeNode> res = generateTrees(4);
        for (int i = 0; i < res.size(); i++) {
            TreeNode.printTree(res.get(i));
        }
        System.out.println(res.size());
    }
}
