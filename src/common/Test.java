package common;

public class Test {
    Object c, d;
    public static void main(String[] args) {

    }

    private static void add(){
        Object a, b, e;
        e = new Object();
        a = b = e;
        e = new Object();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(e.hashCode());
    }
}
