package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        for (int level = triangle.size()-2; level >= 0; level--) {
            for (int index = triangle.get(level).size() - 1; index >= 0; index--) {
                triangle.get(level).set(index, triangle.get(level).get(index) + Math.min(triangle.get(level+1).get(index), triangle.get(level+1).get(index+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int triangleSize = triangle.size(),maxLevelSize = triangle.get(triangleSize-1).size(), orgin = Integer.MAX_VALUE, orgin2 = Integer.MAX_VALUE ;

        //最后一层的大小
        int[] dp = new int[maxLevelSize];
        for (int level = triangle.size()-1; level >= 0; level--) {
            for (int index = triangle.get(level).size() - 1; index >= 0; index--) {
                if(level == triangle.size()-1){
                    dp[index] = triangle.get(level).get(index);
                }else{
                    if(index == triangle.get(level).size() - 1) {
                        orgin2 = dp[index];
                        dp[index] = triangle.get(level).get(index) + Math.min(dp[index], dp[index + 1]);
                    }else{
                        orgin = dp[index];
                        dp[index] = triangle.get(level).get(index) + Math.min(dp[index], orgin2);
                        orgin2 = orgin;
                    }
                }
            }
        }
        return dp[0];
    }

    public static int minimumTotal1(List<List<Integer>> triangle) {
        return process(triangle, 0, 0);
    }

    public static int process(List<List<Integer>> triangle, int level, int index){
        if(level == triangle.size()){
            return 0;
        }
        return triangle.get(level).get(index) + Math.min(process(triangle, level+1, index), process(triangle, level+1, index+1));
    }

    private static List<List<Integer>> getList(int[][] arr){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                sublist.add(arr[i][j]);
            }
            res.add(sublist);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr;
        arr = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
        System.out.println(minimumTotal(getList(arr)));

        arr = new int[][]{{-10}};
        System.out.println(minimumTotal(getList(arr)));
    }
}
