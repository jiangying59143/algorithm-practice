package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        boolean startInserted = false, endInserted = false;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i].length == 0){
                break;
            }
            if(!startInserted) {
                // 新区间 开始位置未插入 并且小于 存在区间 的末尾 =》 新区间的开始位置和存在区间的开始位置取最小
                if (newInterval[0] <= intervals[i][1]){
                    int[] interval = new int[2];
                    interval[0] = Math.min(newInterval[0], intervals[i][0]);
                    list.add(interval);
                    startInserted = true;
                }else{
                    list.add(intervals[i]);
                }
            }
            if(startInserted){
                if (!endInserted && (newInterval[1] < intervals[i][0] || newInterval[1] <= intervals[i][1])){
                    list.get(list.size() - 1)[1] = intervals[i][1];
                    if(newInterval[1] < intervals[i][0]) {
                        list.get(list.size() - 1)[1] = newInterval[1];
                        list.add(intervals[i]);
                    }
                    endInserted = true;
                }else if(endInserted){
                    list.add(intervals[i]);
                }
            }

        }

        if(startInserted && !endInserted){
            list.get(list.size() - 1)[1] = newInterval[1];
        }

        if(!startInserted && !endInserted){
            list.add(newInterval);
        }

        return list.toArray(new int[][]{new int[list.size()]});
    }

    private static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] intervals, res;
        int[] newInterval;
        intervals = new int[][]{{1,3},{6,9}};
        newInterval = new int[]{2,5};
        res = insert(intervals, newInterval);
        print(res);

        intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}; newInterval = new int[]{4,8};
        res = insert(intervals, newInterval);
        print(res);

        intervals = new int[][]{{}}; newInterval = new int[]{5,7};
        res = insert(intervals, newInterval);
        print(res);

        intervals = new int[][]{{1,5}}; newInterval = new int[]{2,3};
        res = insert(intervals, newInterval);
        print(res);

        intervals = new int[][]{{1,5}}; newInterval = new int[]{2,7};
        res = insert(intervals, newInterval);
        print(res);
    }
}
