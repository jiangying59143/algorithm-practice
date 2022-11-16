package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        process(res, 0, n, null, true);
        return res;
    }

    public static void process(List<List<String>> res, int i, int n, List<String> grid, boolean preResult){
        for (int j = 0; j < n; j++) {
            if(i == 0){
                grid = new ArrayList<>();
            }
            String rowString = getRow(j, n);
            grid.add(rowString);
            if(isValid(grid, i, j) && preResult) {
                if(i==n-1) {
                    res.add(grid);
                }else{
                    process(res, i+1, n, grid, isValid(grid, i, j) && preResult);
                }
            }else{
                grid.remove(i);
            }
        }
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
        List<List<String>> res = solveNQueens(4);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println();
        }
    }
}
