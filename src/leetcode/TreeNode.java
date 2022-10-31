package leetcode;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static Item_113.TreeNode generate(Integer[] arr){
        Item_113.TreeNode[] nodes=new Item_113.TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
                nodes[i] = new Item_113.TreeNode(arr[i]);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] == null){
                continue;
            }
            if(2*i+1 < nodes.length) {
                nodes[i].left = nodes[2 * i + 1];
            }
            if(2*i+2 < nodes.length) {
                nodes[i].right = nodes[2*i+2];
            }
        }
        return nodes[0];
    }
}
