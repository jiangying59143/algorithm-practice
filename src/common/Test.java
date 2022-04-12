package common;

public class Test {
    public static void main(String[] args) {
        Integer b = 10;
        add(10, b);
        System.out.println(b);
    }

    private static void add(Integer a, Integer b){
        b = a+b;
        System.out.println("add" + b);
    }
}
