package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_52 {

    public static int totalNQueens(int n) {
        return process(0, n, 0, 0,0);
    }

    public static int process(int i, int n, int column, int diagonals1, int diagonals2){
        if(i == n){
            return 1;
        }
        int sum = 0;
        int availablePositions = ((1<<n)-1) & (~(column | diagonals1 | diagonals2));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions-1);
            sum += process(i+1, n,column | position, (diagonals1 | position)<<1, (diagonals2 | position)>>1);
        }
        return sum;
    }

    public static int process1(int i, int n, List<String> grid, boolean preResult){
        int sum = 0;
        for (int j = 0; j < n; j++) {
            String rowString = getRow(j, n);
            grid.add(rowString);
            if(isValid(grid, i, j) && preResult) {
                if(i==n-1) {
                    sum += 1;
                }else{
                    sum += process1(i+1, n, grid, isValid(grid, i, j) && preResult);
                }
            }
            grid.remove(i);
        }
        return sum;
    }

    private static String getRow(int i, int n){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if(j == i){
                sb.append('Q');
                continue;
            }
            sb.append('.');
        }
        return sb.toString();
    }

    private static boolean isValid(List<String> grid, int x, int y){
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).length(); j++) {
                if(i == x && j == y){
                    continue;
                }
                if((i == x || j == y || Math.abs(x-i) == Math.abs(y-j)) && grid.get(i).charAt(j) == grid.get(x).charAt(y)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(5));
    }
}
