package class18_recursion;

public class Hano {
    public static void hano(int n){
        process(n, "plate1", "plate2", "plate3");
    }

    public static void process(int n, String plate1, String plate2, String plate3){
        if(n == 1){
            System.out.println("move 1 from " + plate1 + " to " + plate3);
        }else{
            process(n-1, plate1, plate3, plate2);
            System.out.println("move " + n + " from " + plate1 + " to " + plate3);
            process(n-1, plate2, plate1, plate3);
        }
    }

    public static void main(String[] args) {
        hano(4);
    }
}
