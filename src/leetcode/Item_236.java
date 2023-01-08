package leetcode;

public class Item_236 {
    static class Result{
        public boolean pFlag;
        public boolean qFlag;
        public TreeNode lowestCommonAncestor;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        return process(root, p, q).lowestCommonAncestor;
    }

    private static Result process(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return new Result();
        }
        Result res = new Result();
        Result leftRes = process(root.left, p, q);
        Result rightRes = process(root.right, p, q);
        if(leftRes.lowestCommonAncestor != null){
            return leftRes;
        }
        if(rightRes.lowestCommonAncestor != null){
            return rightRes;
        }
        if(root != p && root != q){
            res.pFlag = leftRes.pFlag || rightRes.pFlag;
            res.qFlag = leftRes.qFlag || rightRes.qFlag;
        }else if(root == p){
            res.pFlag = true;
            res.qFlag = leftRes.qFlag || rightRes.qFlag;
        }else{
            res.qFlag = true;
            res.pFlag = leftRes.pFlag || rightRes.pFlag;
        }
        if(res.pFlag && res.qFlag){
            res.lowestCommonAncestor = root;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
