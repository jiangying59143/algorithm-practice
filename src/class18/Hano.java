package class18;

import java.util.LinkedList;

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
        public String from;
        public String mid;
        public String to;

        public HanoiRecord(int n, String from, String mid, String to) {
            this.n = n;
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
        stack.push(new HanoiRecord(n, "from", "mid", "to"));
        while(!stack.isEmpty()){
            HanoiRecord hanoiRecord = stack.pop();
            if(hanoiRecord.n < 1){
                continue;
            }else if(hanoiRecord.n == 1){
                System.out.println("move 1 from " + hanoiRecord.from +" to " + hanoiRecord.to);
            }else{
                stack.push(new HanoiRecord(hanoiRecord.n-1, "from", "to", "mid"));
                System.out.println("move " + hanoiRecord.n + " from " + hanoiRecord.from +" to " + hanoiRecord.to);
                stack.push(new HanoiRecord(hanoiRecord.n-1, "mid", "from", "to"));
            }
        }
    }


    public static void main(String[] args) {
        hanoi(3);
        System.out.println("---------");
        hanoiWithoutRecursion(3);
    }

}
