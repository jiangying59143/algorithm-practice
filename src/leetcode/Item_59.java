package leetcode;

import java.util.Arrays;

public class Item_59 {
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        process(arr, 0,0, 1);
        return arr;
    }

    public static void process(int[][] arr, int i, int j, int value){
        if(i == arr.length || j == arr[0].length || i<0 || j < 0){
            return;
        }
        System.out.println(i + " " + j);
        arr[i][j] = value++;
        // 向右: 第一行 或者 左边和上边有值 并且 右边没有值
        if(i == 0 || j > 0 && i > 0 && arr[i][j-1] != 0 && arr[i-1][j] != 0 && arr[i][j+1] == 0){
            process(arr, i, j+1, value);
            // 向下: 最后一列 或者 右边和上边有值  并且 下边没值
            if(j == arr[i].length-1 ||  i > 0 && j < arr[0].length && arr[i][j+1] !=0 && arr[i-1][j] != 0 && arr[i+1][j] == 0){
                process(arr, i+1, j, value);

                // 向左: 最后一行 或者 右边和下边有值  并且 下边没值
                if(i == arr.length-1 ||  i < arr.length-1 && j < arr[0].length && arr[i][j+1] !=0 && arr[i+1][j] != 0 && arr[i][j-1] == 0){
                    process(arr, i, j-1, value);

                    // 向上: 第一列 或者 左边和下边有值  并且 下边没值
                    if((j == 0 ||  i < arr.length-1 && arr[i][j-1] !=0 && arr[i+1][j] != 0) && arr[i-1][j] == 0){
                        process(arr, i-1, j, value);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
