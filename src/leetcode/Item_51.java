package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        process(res, 0, n, new int[n], 0, 0, 0);

//        System.out.println(3 & (-3));
//        System.out.println(Integer.toBinaryString(-3));
//        System.out.println(Integer.bitCount(8-1));
        return res;
    }

    public static void process(List<List<String>> res, int i, int n, int[] queues, int column, int diagonals1, int diagonals2){
        if(i == n){
            res.add(generateBoard(queues, n));
            return;
        }
        int availablePositions = ((1<<n)-1) & (~(column | diagonals1 | diagonals2));
        System.out.println(Integer.toBinaryString(availablePositions));
        while (availablePositions != 0) {
            int position = availablePositions & (-availablePositions);
            availablePositions = availablePositions & (availablePositions-1);
            queues[i] = Integer.bitCount(position-1);
            process(res, i+1, n, queues,column | position, (diagonals1 | position)<<1, (diagonals2 | position)>>1);
        }
    }
    
    private static List<String> generateBoard(int[] queue, int n){
        List<String> board = new ArrayList<>();
        for (int i : queue) {
            char[] column = new char[n];
            Arrays.fill(column, '.');
            column[i] = 'Q';
            board.add(new String(column));
        }
        return board;
    }

    public static void process2(List<List<String>> res, int i, int n, List<String> grid, boolean preResult){
        for (int j = 0; j < n; j++) {
            String rowString = getRow(j, n);
            grid.add(rowString);
            if(isValid(grid, i, j) && preResult) {
                if(i==n-1) {
                    res.add(new ArrayList<>(grid));
                }else{
                    process2(res, i+1, n, grid, isValid(grid, i, j) && preResult);
                }
            }
            grid.remove(i);
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
        for (int i = 0; i <= x; i++) {
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
