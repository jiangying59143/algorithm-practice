package leetcode;

public class Item_73 {
    public static void setZeroes1(int[][] matrix) {
        boolean firstRow = false, firstColumn = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == 0) {
                    firstRow |= matrix[0][j] == 0;
                }else if(j == 0){
                    firstColumn |= matrix[i][0] == 0;
                }else{
                    matrix[i][0] = (matrix[i][0] == 0 || matrix[i][j] == 0) ? 0 : matrix[i][0];
                    matrix[0][j] = (matrix[0][j] == 0 || matrix[i][j] == 0) ? 0 : matrix[0][j];
                }
            }
        }

        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = matrix[i].length-1; j >= 0 && i > 0; j--) {
                if(j > 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
                }else if(firstColumn){
                    matrix[i][j] = 0;
                }
            }
            if(firstRow && i == 0){
                for (int j = matrix[i].length-1; j >=0; j--) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean[] rowFlag = new boolean[matrix.length];
        boolean[] columnFlag = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                rowFlag[i] |= matrix[i][j] == 0;
                columnFlag[j] |= matrix[i][j] == 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(rowFlag[i] || columnFlag[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(false | true);
    }
}
