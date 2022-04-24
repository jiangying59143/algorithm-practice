package Test;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1==o2 ? 0 : (o1 > o2 ? -1 : 1);
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 1, 4, 3};
        Arrays.sort(arr, new MyComparator());
        System.out.println(Arrays.toString(arr));
    }
}
