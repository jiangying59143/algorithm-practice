package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Item_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length * matrix[0].length, k=1, i=0, j=0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] directions = new int[][]{
                {0,1},//左
                {1,0}, //下
                {0,-1}, // 右
                {-1,0} //上
        };
        int directionIndex = 0;
        while(k <= n){
            res.add(matrix[i][j]);
            visited[i][j] = true;
            int x = i+directions[directionIndex][0];
            int y = j+directions[directionIndex][1];
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y]){
                directionIndex = (directionIndex+1) % directions.length;
            }
            i = i+directions[directionIndex][0];
            j = j+directions[directionIndex][1];
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println(Arrays.toString(list.toArray()));
    }
}
