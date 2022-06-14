package leetcode;

import java.util.HashSet;

public class Competition_297 {

    public double calculateTax(int[][] brackets, int income) {
        double sum = 0d;
        int leftIncome = income;
        for (int i = 0; i < brackets.length; i++) {
            if(income > brackets[i][0]){
                sum += (brackets[i][0]-(i>0?brackets[i-1][0] : 0))*brackets[i][1]/100d;
                leftIncome = income-brackets[i][0];
            }else{
                sum += leftIncome*brackets[i][1]/100d;
                break;
            }
        }
        return sum;
    }

    public long distinctNames(String[] ideas) {
        HashSet<String> ideaSet = new HashSet<>();
        for (int i = 0; i < ideas.length; i++) {
            ideaSet.add(ideas[i]);
        }
        HashSet<String> ans = new HashSet<>();
        String x1, x2, x3, x4;
        for (int i = 0; i < ideas.length-1; i++) {
            for (int j = i+1; j < ideas.length; j++) {
                 x1 = ideas[i];
                 x2 = ideas[j];
                 x3 = x1.substring(0,1) + x2.substring(1);
                 x4 = x2.substring(0,1) + x1.substring(1);
                 if(!ideaSet.contains(x3) && !ideaSet.contains(x4)){
                     ans.add(x1 + " " + x2);
                     ans.add(x2 + " " + x1);
                 }
            }
        }
        return ans.size();
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] resArr = new int[grid.length][grid[0].length+1];
        for (int i = 0; i < resArr.length; i++) {
            for (int j = 0; j < resArr.length; j++) {
                resArr[i][j] = -1;
            }
        }
        return processMinPathCost(grid, moveCost, grid.length-1,  0, resArr);
    }

    public int processMinPathCost(int[][] grid, int[][] moveCost, int rowIndex,  int columnIndex, int[][] resArr){
        if(resArr[rowIndex][columnIndex] != -1){
            return resArr[rowIndex][columnIndex];
        }
        if(rowIndex == 0){
            resArr[rowIndex][columnIndex] = 0;
            return 0;
        }
        if(columnIndex == grid[0].length){
            resArr[rowIndex][columnIndex] = 0;
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) {
            ans = Math.min( ans,grid[rowIndex-1][k] + moveCost[grid[rowIndex-1][k]][columnIndex] + processMinPathCost(grid, moveCost, rowIndex-1, k, resArr));
        }

        int res = Math.min(grid[rowIndex][columnIndex] + ans, grid[rowIndex][columnIndex+1] + processMinPathCost(grid, moveCost, rowIndex, columnIndex+1, resArr));
        resArr[rowIndex][columnIndex] = res;
        return res;

    }

    public static void main(String[] args) {
        Competition_297 obj = new Competition_297();
//        int[][] brackets = new int[3][];
//        brackets[0] = new int[]{1,0};
//        brackets[1] = new int[]{4,25};
//        brackets[2] = new int[]{5,50};
//        System.out.println(obj.calculateTax(brackets,2));

        int[][] grid = new int[][]{{5,3},{4,0},{2,1}};
        int[][] moveCost = new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        System.out.println(obj.minPathCost(grid, moveCost));
    }
}
