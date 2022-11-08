package leetcode;

public class DoubleEndNode {
    public DoubleEndNode pre;
    public DoubleEndNode next;
    public int key;
    public int val;

    public DoubleEndNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
