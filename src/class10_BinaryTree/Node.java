package class10_BinaryTree;

public class Node {
    public Node left;
    public Node right;
    public int val;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public static void generate(Node node, int level, int limit, int max){
        if(node == null){
            return;
        }
        if(level == limit){
            return;
        }
        node.left = new Node((int)(Math.random() * max + 1));
        generate(node.left, level+1, limit, max);
        node.right = new Node((int) (Math.random() * max + 1));
        generate(node.right, level+1, limit, max);
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        generate(head, 1, 5, 50);
        printTree(head);
    }
}
