package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static TreeNode generate(Integer[] arr){
        TreeNode[] nodes=new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
                nodes[i] = new TreeNode(arr[i]);
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

    public static void printPre(TreeNode head){
        if(head == null){
            System.out.print("null ");
            return;
        }
        System.out.print(head.val + " ");
        printPre(head.left);
        printPre(head.right);
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        List<String> list = new ArrayList<>();
        printInOrder(head, 0, "H", 17, list);

        int maxLen = 0;
        for (int i = 0; i < list.size(); i++) {
            maxLen = Math.max(maxLen, list.get(i).length());
        }

        char[][] chars = new char[maxLen][list.size()];
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < list.size(); j++) {
                chars[i][j] = i < list.get(j).length() ? list.get(j).charAt(i) : ' ';
            }
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len, List<String> list) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len, list);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        list.add(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len, list);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

}
