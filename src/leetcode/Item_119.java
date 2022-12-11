package leetcode;

import java.util.Arrays;
import java.util.List;

public class Item_119 {
    public static List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex+1];
        res[0] = 1;
        res[res.length-1] = 1;
        for (int i = 1; i < res.length && res.length-1-i >= i; i++) {
            res[res.length-1-i] = res[i] = (int)(((long)res[i-1] * (rowIndex-i+1))/i);
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        List<Integer> res;
        res = getRow(30);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
