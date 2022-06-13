package class18;

import java.util.LinkedList;
import java.util.Stack;

public class Hano {

    public static void hanoi(int n){
        processHanoi(n, "A", "B", "C");
    }

    public static void processHanoi(int n, String from, String mid, String to){
        if(n==1){
            System.out.println("move 1 from " + from +" to " + to);
            return;
        }
        processHanoi(n-1, from, to, mid);
        System.out.println("move " + n + " from " + from +" to " + to);
        processHanoi(n-1, mid, from, to);
    }

    static class HanoiRecord{
        public int n;
        public boolean finishedFirst;
        public String from;
        public String mid;
        public String to;

        public HanoiRecord(boolean finishedFirst, int n,  String from, String mid, String to) {
            this.n = n;
            this.finishedFirst = finishedFirst;
            this.from = from;
            this.mid = mid;
            this.to = to;
        }
    }

    public static void hanoiWithoutRecursion(int n){
        if(n<1){
            return;
        }

        LinkedList<HanoiRecord> stack = new LinkedList<>();
        stack.push(new HanoiRecord(false,  n,"from", "mid", "to"));
        while(!stack.isEmpty()){
            HanoiRecord hanoiRecord = stack.peek();
            if(hanoiRecord.n == 1){
                hanoiRecord.finishedFirst=true;
                System.out.println("move 1 from " + hanoiRecord.from +" to " + hanoiRecord.to);
            }else{
                if(!hanoiRecord.finishedFirst){
                    stack.push(new HanoiRecord(false, hanoiRecord.n-1,  "from", "to", "mid"));
                }else {
                    System.out.println("move " + hanoiRecord.n + " from " + hanoiRecord.from + " to " + hanoiRecord.to);
                    stack.push(new HanoiRecord(true, hanoiRecord.n - 1, "mid", "from", "to"));
                }
            }
        }
    }

    public static void hanoi3(int N) {
        if (N < 1) {
            return;
        }
        Stack<HanoiRecord> stack = new Stack<>();
        stack.add(new HanoiRecord(false, N, "left", "right", "mid"));
        while (!stack.isEmpty()) {
            HanoiRecord cur = stack.pop();
            if (cur.n == 1) {
                System.out.println("Move 1 from " + cur.from + " to " + cur.to);
                if (!stack.isEmpty()) {
                    stack.peek().finishedFirst = true;
                }
            } else {
                if (!cur.finishedFirst) {
                    stack.push(cur);
                    stack.push(new HanoiRecord(false, cur.n - 1, cur.from, cur.mid, cur.to));
                } else {
                    System.out.println("Move " + cur.n + " from " + cur.from + " to " + cur.to);
                    stack.push(new HanoiRecord(false, cur.n - 1, cur.mid, cur.to, cur.from));
                }
            }
        }
    }


    public static void main(String[] args) {
//        hanoi(3);
//        System.out.println("---------");
//        hanoiWithoutRecursion(3);
        hanoi3(3);
        "".toCharArray();
    }

}
