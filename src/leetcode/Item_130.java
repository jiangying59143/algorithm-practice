package leetcode;

import java.util.Arrays;

public class Item_130 {
    public static void solve(char[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if((x == 0 || y == 0 || x == board.length-1 || y == board[x].length-1) && board[x][y] == 'O'){
                    process(board, x, y);
                }
            }
        }

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if(board[x][y] == 'Y'){
                    board[x][y] = 'O';
                }else if(board[x][y] == 'O'){
                    board[x][y] = 'X';
                }
            }
        }
    }

    private static void process(char[][] board, int x, int y){
        if(x < 0 || y < 0 || x > board.length-1 || y > board[x].length-1
                || board[x][y] == 'X' || board[x][y] == 'Y'){
            return;
        }
        board[x][y] = 'Y';
        process(board, x, y-1);
        process(board, x, y+1);
        process(board, x-1, y);
        process(board, x+1, y);
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        solve(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        arr = new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}};
        solve(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}
