package leetcode;

public class Item_36 {
    public static boolean isValidSudoku(char[][] board) {
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
                    return false;
                }
                rowArr[i][index] = true;
                columnArr[j][index] = true;
                gridArr[i/3][j/3][index] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(arr));
        arr = new char[][]{{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(arr));

    }
}
