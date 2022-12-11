package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int i = 2; i <= n; i++) {
            int preSize = res.size();
            for (int r = preSize - 1; r >= 0; r--) {
                res.add((res.get(r) | (1 << i-1)));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> res;
        res = grayCode(3);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
