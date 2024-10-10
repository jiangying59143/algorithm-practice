package aDataStructrue;

import java.util.ArrayList;

public class TreeNode<T>{
    private final T val;
    private final ArrayList<TreeNode<T>> children;
    public TreeNode(T val){
        this.val = val;
        children = new ArrayList<>();
    }
    public TreeNode<T> addChild(TreeNode<T> child){
        children.add(child);
        return child;
    }
    public T getValue(){ return this.val; }
    public ArrayList<TreeNode<T>> getChildren() { return this.children; }
}
