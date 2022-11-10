package leetcode;

import java.util.Arrays;

public class Item_37 {
    public static void solveSudoku(char[][] board) {
        boolean[][] rowArr = new boolean[9][9];
        boolean[][] columnArr = new boolean[9][9];
        boolean[][][] gridArr = new boolean[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                int index = board[i][j]-1-'0';
                if(rowArr[i][index] == true || columnArr[j][index] || gridArr[i/3][j/3][index]){
                    System.out.println("not valid");
                    return;
                }
                rowArr[i][index] = true;
                columnArr[j][index] = true;
                gridArr[i/3][j/3][index] = true;
            }
        }
        boolean res = process(board, rowArr, columnArr, gridArr, 0, 0);
        System.out.println(res);
    }

    public static boolean process(char[][] board, boolean[][] rowArr, boolean[][] columnArr, boolean[][][] gridArr, int i, int j){
        if(i == board.length){
            return true;
        }
        if(board[i][j] == '.'){
            boolean found = false;
            for (int r = 0; r < rowArr[i].length; r++) {
                if(!rowArr[i][r] && !columnArr[j][r] && !gridArr[i/3][j/3][r]){
                    found = true;
                    board[i][j] = (char)('0'+1+r);
                    rowArr[i][r] = true;
                    columnArr[j][r] = true;
                    gridArr[i/3][j/3][r] = true;
                    if(!process(board, rowArr, columnArr, gridArr, j== board[0].length-1 ? i+1 : i, j== board[0].length-1 ? 0 : j+1)){
                        found = false;
                        board[i][j] = '.';
                        rowArr[i][r] = false;
                        columnArr[j][r] = false;
                        gridArr[i/3][j/3][r] = false;
                    }
                }
            }
            return found;
        }else{
            return process(board, rowArr, columnArr, gridArr, j== board[0].length-1 ? i+1 : i, j== board[0].length-1 ? 0 : j+1);
        }
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
