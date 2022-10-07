package leetcode;

import java.util.LinkedList;

public class Item_155 {
    class MinStack {
        LinkedList<Integer> stack;
        LinkedList<Integer> minStack;
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
            stack.push(val);
            if(minStack.isEmpty() || val <= minStack.peek()){
                minStack.push(val);
            }
        }

        public void pop() {
            if(stack.isEmpty()){
                return;
            }
            int val = stack.pop();
            if(!minStack.isEmpty() && val == minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
