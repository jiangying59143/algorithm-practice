package leetcode;

public class Item_79 {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(process(board, word, i, j, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean process(char[][] board, String word, int x, int y, int i, boolean[][] visited){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length
                || word.charAt(i) != board[x][y] || visited[x][y]){
            return false;
        }
        if(i == word.length()-1){
            return true;
        }
        visited[x][y] = true;
        boolean up = process(board, word, x-1, y, i+1, visited);
        if(up){
            return up;
        }
        boolean down = process(board, word, x+1, y, i+1, visited);
        if(down){
            return down;
        }
        boolean left = process(board, word, x, y-1, i+1, visited);
        if(left){
            return left;
        }
        boolean right = process(board, word, x, y+1, i+1, visited);
        visited[x][y] = false;
        return right;
    }

    public static void main(String[] args) {
        char[][] board;
        String word;
        board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        word = "ABCCED";
        System.out.println(exist(board, word));
        word = "SEE";
        System.out.println(exist(board, word));
        word = "ABCB";
        System.out.println(exist(board, word));
        board = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        word="ABCESEEEFS";
        System.out.println(exist(board, word));
    }
}
