package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_52 {

    public static int totalNQueens(int n) {
        return process(0, n, new ArrayList<>(), true);
    }

    public static int process(int i, int n, List<String> grid, boolean preResult){
        int sum = 0;
        for (int j = 0; j < n; j++) {
            String rowString = getRow(j, n);
            grid.add(rowString);
            if(isValid(grid, i, j) && preResult) {
                if(i==n-1) {
                    sum += 1;
                }else{
                    sum += process(i+1, n, grid, isValid(grid, i, j) && preResult);
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
        System.out.println(totalNQueens(3));
    }
}
