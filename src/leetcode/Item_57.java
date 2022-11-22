package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int slowIndex = 0;
        if(newInterval[0] < intervals[slowIndex][0]){
            intervals[slowIndex][0] = newInterval[0];
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] item = new int[2];

        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
