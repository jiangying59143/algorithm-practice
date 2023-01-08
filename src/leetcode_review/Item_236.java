package leetcode_review;

public class Item_236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[1];
        dfs(root, p, q, res);
        return res[0];
    }

    private static boolean dfs(TreeNode treeNode, TreeNode p, TreeNode q, TreeNode[] res){
        if(treeNode == null){
            return false;
        }
        boolean leftFlag = dfs(treeNode.left, p, q, res);
        boolean rightFlag = dfs(treeNode.right, p, q, res);
        if((leftFlag && rightFlag || (treeNode == p || treeNode == q) && (leftFlag || rightFlag))
                && res[0] == null){
            res[0] = treeNode;
        }
        return treeNode == p || treeNode == q || leftFlag || rightFlag;
    }

    public static void main(String[] args) {
        TreeNode[] treeNodes;
        TreeNode res;
        treeNodes = TreeNode.generateNodeArr(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        res = lowestCommonAncestor(treeNodes[0], treeNodes[1], treeNodes[2]);
        System.out.println(res.val);

        res = lowestCommonAncestor(treeNodes[0], treeNodes[1], treeNodes[treeNodes.length-1]);
        System.out.println(res.val);
    }
}
