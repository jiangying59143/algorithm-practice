package leetcode;

public class Item_114 {
    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;

            TreeNode tempNode = root.right;
            while(tempNode.right != null){
                tempNode = tempNode.right;
            }
            tempNode.right = right;

            flatten(root.right);
        }else{
            flatten(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.generate(new Integer[]{1,2,5,3,4,null,6});
        flatten(node);
        TreeNode.printPre(node);
    }
}
