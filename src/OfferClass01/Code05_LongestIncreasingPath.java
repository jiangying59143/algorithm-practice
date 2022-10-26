package OfferClass01;

/**
 * 给定一个二维数组matrix，你可以从任何位置出发，
 * 走向上、下、左、右四个方向，返回能走出来的最长的递增链长度
 */
public class Code05_LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {11,12,13,17,16},
                {11,12,13,14,15},
                {10,9 ,8 ,7 ,6 },
                {1 ,2 ,3 ,4 ,5 },
        };
        System.out.println(f1(matrix));
        System.out.println(f2(matrix));
    }

    public static int f1(int[][] matrix){
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                count = Math.max(count, process(matrix, i, j));
            }
        }
        return count;
    }

    private static int process(int[][] matrix, int x, int y){
        int up = y >0 && matrix[x][y] - matrix[x][y-1] == -1
                ? 1+ process(matrix, x, y-1) : 1;
        int down = y < matrix[0].length-1 && matrix[x][y] - matrix[x][y+1] == -1
                ? 1+ process(matrix, x, y+1) : 1;
        int left = x > 0 && matrix[x][y] - matrix[x-1][y] == -1
                ? 1+ process(matrix, x-1, y) : 1;
        int right = x < matrix.length-1 && matrix[x][y] - matrix[x+1][y] == -1
                ? 1+ process(matrix, x+1, y) : 1;
        return Math.max(Math.max(up, down), Math.max(left, right));
    }

    public static int f2(int[][] matrix){
        int count = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                count = Math.max(count, process2(matrix, i, j, dp));
            }
        }
        return count;
    }

    //杀缓存
    private static int process2(int[][] matrix, int x, int y, int[][] dp){
        if(dp[x][y] != 0){
            return dp[x][y];
        }
        int up = y >0 && matrix[x][y] - matrix[x][y-1] == -1
                ? 1+ process2(matrix, x, y-1, dp) : 1;
        int down = y < matrix[0].length-1 && matrix[x][y] - matrix[x][y+1] == -1
                ? 1+ process2(matrix, x, y+1, dp) : 1;
        int left = x > 0 && matrix[x][y] - matrix[x-1][y] == -1
                ? 1+ process2(matrix, x-1, y, dp) : 1;
        int right = x < matrix.length-1 && matrix[x][y] - matrix[x+1][y] == -1
                ? 1+ process2(matrix, x+1, y, dp) : 1;
        int res = Math.max(Math.max(up, down), Math.max(left, right));
        dp[x][y] = res;
        return res;
    }
}
