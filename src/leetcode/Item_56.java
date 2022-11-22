package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Item_56 {
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int slowIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[slowIndex][1] >= intervals[i][0]){
                if(intervals[slowIndex][1] < intervals[i][1]) {
                    intervals[slowIndex][1] = intervals[i][1];
                }
            }else{
                intervals[++slowIndex] = intervals[i];
            }
        }
        int[][] res = new int[slowIndex+1][2];
        for (int index = slowIndex; index >= 0; index--) {
            res[index] = intervals[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr;
        arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        arr = merge(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
        }
        System.out.println();

        arr = new int[][]{{1,4},{4,5}};
        arr = merge(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
        }
        System.out.println();

        arr = new int[][]{{1,4},{0,4}};
        arr = merge(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
