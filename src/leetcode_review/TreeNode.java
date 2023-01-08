package leetcode_review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) { this.val = val; }

    static void init(TreeNode root, List<TreeNode> mid, Map<TreeNode, Integer> map){
        if(root == null)return;
        midOrder(root, mid);
        for (int i = 0; i < mid.size(); i++) {
            map.put(mid.get(i),i);
        }
    }

    static void midOrder(TreeNode node, List<TreeNode> mid){
        if(node == null)return;
        midOrder(node.left, mid);
        mid.add(node);
        midOrder(node.right, mid);
    }

    public static void print(TreeNode root){
        System.out.println("Binary Tree:");
        List<TreeNode> mid = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        init(root, mid, map);
        List<TreeNode> nodes =  new ArrayList<>();
        nodes.add(root);
        treePrint(nodes, map);
    }

    public static void treePrint(List<TreeNode> nodes, Map<TreeNode, Integer> map){
        if(nodes.isEmpty())return;
        // nodes : 同一层节点
        printLevel(nodes, map);//打印同一层的节点
        List<TreeNode> children =  new ArrayList<>();
        //顺序遍历下一层节点;
        for (TreeNode node : nodes) {
            if(node.left != null)children.add(node.left);
            if(node.right != null) children.add(node.right);
        }
        treePrint(children, map);//递归打印下一层节点
    }

    static void printLevel(List<TreeNode> nodes, Map<TreeNode, Integer> map){
        String VLine = "";
        String dataLine = "";
        String line = "";
        int lastNodeIndex = 0;
        int lastRightIndex = 0;
        for (TreeNode node : nodes) {
            int x =  map.get(node);
            String addEmpty = getEmpty(x-lastNodeIndex);
            lastNodeIndex = x;
            VLine    += addEmpty+"|";//竖线拼接
            //数字拼接
            dataLine += addEmpty+node.val;
            //红黑树可以用下面打印语句，打印红色；
            //if(node.red)
            //    dataLine+= addEmpty +"\033[91;1m"+node.data+"\033[0m";//打印红色
            //else
            //    dataLine += addEmpty+node.data;
//======================组装，左右连接线=======================================
            TreeNode left  = node.left;
            TreeNode right = node.right;
            String leftLine  = null;
            String rightLine = null;
            int leftIndex  = -1;
            int rightIndex = -1;
            if(left  != null){
                leftIndex = map.get(left);
                leftLine = getLineToSon(x - leftIndex);
            }
            if(right != null){
                rightIndex = map.get(right);
                rightLine = getLineToSon(rightIndex - x);
            }
            String curLine  = (leftLine == null ? "" :leftLine)  + "|"+(rightLine == null ? "" : rightLine);
            if(leftLine == null && rightLine == null)curLine="";
            //线段之间的间隔
            int dif = (leftIndex == -1 ? x : leftIndex) - lastRightIndex;
            String difEmpty = getEmpty(dif);
            line += difEmpty + curLine;//拼接线段
            lastRightIndex = rightIndex == -1 ? x : rightIndex;
        }
        System.out.println(VLine +"\n" + dataLine +"\n" + line);
    }

    static String  getEmpty(int x){
        String empty ="";
        for (int i = 0; i < x; i++) {
            empty+="\t";
        }
        return empty;
    }


    //链接子线段的长度
    static String getLineToSon(int end){
        String line = "";
        if(end ==0)return line;
        for (int i = 0; i < end; i++) {
            line+="____";
        }
        return line;
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

    public static TreeNode[] generateNodeArr(Integer[] arr){
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
        return nodes;
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
