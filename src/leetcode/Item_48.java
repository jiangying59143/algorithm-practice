package leetcode;

import java.util.Arrays;

public class Item_48 {
    public static void main(String[] args) {
        Item_48 item_48 = new Item_48();
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
//        printMatrix(matrix);
//        item_48.rotate(matrix);
//        printMatrix(matrix);
//
//        matrix = new int[][]{
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}};
//        printMatrix(matrix);
//        item_48.rotate(matrix);
//        printMatrix(matrix);

        System.out.println("=========================");
        matrix = new int[][]{{2,29,20,26,16,28},
            {12,27,9,25,13,21},
            {32,33,32,2,28,14},
            {13,14,32,27,22,26},
            {33,1,20,7,21,7},
            {4,24,1,6,32,34}};
        printMatrix(matrix);
        item_48.rotate(matrix);
        System.out.println("------------------------------");
        printMatrix(matrix);

    }
    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length && matrix.length-2*i > 1; i++) {
            circle(matrix, i);
        }
    }

    private void circle(int[][] matrix, int x){
        for (int i = x; i < matrix.length-x-1; i++) {
            for (int j = 1 + x; j < matrix[x].length - x; j++) {
                swap(matrix, x, x, j);
            }
            for (int k = 1 + x; k < matrix.length - x; k++) {
                swap(matrix, x, k, matrix[x].length - 1 - x);
            }
            for (int l = matrix[matrix.length - x - 1].length - x - 2; l >= x; l--) {
                swap(matrix, x, matrix.length - x - 1, l);
            }
            for (int m = matrix.length - x - 2; m >= x; m--) {
                swap(matrix, x, m, x);
            }
        }
    }

    private void swap(int[][] matrix, int start, int i, int j){
        int cur = matrix[i][j];
        matrix[i][j]=matrix[start][start];
        matrix[start][start] = cur;
    }
}
