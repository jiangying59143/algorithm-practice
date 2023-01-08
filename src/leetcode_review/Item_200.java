package leetcode_review;

public class Item_200 {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    mark(grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void mark(char[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length ||
            grid[x][y] == '0' || grid[x][y] == '2'){
            return;
        }
        grid[x][y] = '2';
        mark(grid, x, y-1);
        mark(grid, x, y+1);
        mark(grid, x-1, y);
        mark(grid, x+1, y);
    }

    public static void main(String[] args) {

    }
}
