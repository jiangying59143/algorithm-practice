package codetop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode parent;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode(int val) { this.val = val; }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                '}';
    }

    public static TreeLinkNode[] generate(Integer[] arr){
        TreeLinkNode[] nodes=new TreeLinkNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null) {
                nodes[i] = new TreeLinkNode(arr[i]);
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] == null){
                continue;
            }
            if(2*i+1 < nodes.length) {
                nodes[i].left = nodes[2 * i + 1];
                if(nodes[i].left != null)nodes[i].left.parent = nodes[i];
            }
            if(2*i+2 < nodes.length) {
                nodes[i].right = nodes[2*i+2];
                if(nodes[i].right != null)nodes[i].right.parent = nodes[i];
            }
        }
        return nodes;
    }

    public static void print(TreeLinkNode node){
        System.out.println("Binary Tree:");
        Printer.print(node);
    }

    static class Printer{
        private static void init(TreeLinkNode root, List<TreeLinkNode> mid, Map<TreeLinkNode, Integer> map){
            if(root == null)return;
            midOrder(root, mid);
            for (int i = 0; i < mid.size(); i++) {
                map.put(mid.get(i),i);
            }
        }

        private static void midOrder(TreeLinkNode node, List<TreeLinkNode> mid){
            if(node == null)return;
            midOrder(node.left, mid);
            mid.add(node);
            midOrder(node.right, mid);
        }

        public static void print(TreeLinkNode root){
            List<TreeLinkNode> mid = new ArrayList<>();
            Map<TreeLinkNode, Integer> map = new HashMap<>();
            init(root, mid, map);
            List<TreeLinkNode> nodes =  new ArrayList<>();
            nodes.add(root);
            treePrint(nodes, map);
        }

        private static void treePrint(List<TreeLinkNode> nodes, Map<TreeLinkNode, Integer> map){
            if(nodes.isEmpty())return;
            // nodes : 同一层节点
            printLevel(nodes, map);//打印同一层的节点
            List<TreeLinkNode> children =  new ArrayList<>();
            //顺序遍历下一层节点;
            for (TreeLinkNode node : nodes) {
                if(node.left != null)children.add(node.left);
                if(node.right != null) children.add(node.right);
            }
            treePrint(children, map);//递归打印下一层节点
        }

        private static void printLevel(List<TreeLinkNode> nodes, Map<TreeLinkNode, Integer> map){
            String VLine = "";
            String dataLine = "";
            String line = "";
            int lastNodeIndex = 0;
            int lastRightIndex = 0;
            for (TreeLinkNode node : nodes) {
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
                TreeLinkNode left  = node.left;
                TreeLinkNode right = node.right;
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

        private static String  getEmpty(int x){
            String empty ="";
            for (int i = 0; i < x; i++) {
                empty+="\t";
            }
            return empty;
        }


        //链接子线段的长度
        private static String getLineToSon(int end){
            String line = "";
            if(end ==0)return line;
            for (int i = 0; i < end; i++) {
                line+="____";
            }
            return line;
        }
    }

}
