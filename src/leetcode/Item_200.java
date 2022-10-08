package leetcode;

public class Item_200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numOfIsland(grid));
        grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numOfIsland2(grid));

        grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numOfIsland(grid));
        grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numOfIsland2(grid));
    }

    public static int numOfIsland2(char[][] grid){
        int count = 0;
        int[] queue = new int[grid.length * grid[0].length];
        int size = 0;
        int endIndex = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    queue[endIndex++] = i*grid[0].length + j;
                    size++;
                    grid[i][j] = '2';
                    while(size > 0){
                        int gridIndex = queue[endIndex-size];
                        size--;
                        int x =gridIndex / grid[0].length;
                        int y = gridIndex % grid[0].length;
                        if(x-1 >=0 && grid[x-1][y] == '1'){
                            queue[endIndex++] = (x-1)*grid[0].length + y;
                            size++;
                            grid[x-1][y] = '2';
                        }
                        if(x+1 < grid.length && grid[x+1][y] == '1') {
                            queue[endIndex++] = (x+1)*grid[0].length + y;
                            size++;
                            grid[x+1][y] = '2';
                        }
                        if(y-1 >=0 && grid[x][y-1] == '1'){
                            queue[endIndex++] = x*grid[0].length + y-1;
                            size++;
                            grid[x][y-1] = '2';
                        }
                        if(y+1 < grid[0].length && grid[x][y+1] == '1'){
                            queue[endIndex++] = x*grid[0].length + y+1;
                            size++;
                            grid[x][y+1] = '2';
                        }
                    }
                    endIndex = 0;
                    count++;
                }
            }
        }
        return count;
    }

    public static int numOfIsland(char[][] grid){
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return;
        }
        if(grid[x][y] == '1'){
            grid[x][y] = '2';
            dfs(grid, x-1, y);
            dfs(grid, x+1, y);
            dfs(grid, x, y-1);
            dfs(grid, x, y+1);;
        }
    }
}
