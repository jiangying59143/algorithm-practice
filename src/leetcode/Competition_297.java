package leetcode;

import java.util.Arrays;
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
        int[][] resArr = new int[grid.length][grid[0].length];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[grid.length-1].length; i++) {
            ans = Math.min(ans, processMinPathCost(grid, moveCost, grid.length-1, i, resArr));
        }
        for (int[] ints : resArr) {
            System.out.println(Arrays.toString(ints));
        }
        return ans;
    }

    public int processMinPathCost(int[][] grid, int[][] moveCost, int rowIndex, int columnIndex, int[][] resArr){
        if(resArr[rowIndex][columnIndex] != 0){
            return resArr[rowIndex][columnIndex];
        }
        if(rowIndex == 0){
            return grid[rowIndex][columnIndex];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) {
            ans = Math.min( ans, moveCost[grid[rowIndex-1][k]][columnIndex]
                    + processMinPathCost(grid, moveCost, rowIndex-1, k, resArr));
        }
        ans = grid[rowIndex][columnIndex] + ans;
        resArr[rowIndex][columnIndex] = ans;
        return ans;
    }

    public int minPathCost2(int[][] grid, int[][] moveCost) {
        int[] resArr = new int[grid[0].length];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = grid[0][i];
        }
        int[] tempArr = new int[grid[0].length];
        for (int rowIndex = 1; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < resArr.length; columnIndex++) {
                tempArr[columnIndex] = moveCost[grid[rowIndex - 1][0]][columnIndex]
                        + resArr[0];
                for (int k = 1; k < grid[0].length; k++) {
                    tempArr[columnIndex] = Math.min(tempArr[columnIndex], moveCost[grid[rowIndex - 1][k]][columnIndex]
                            + resArr[k]);
                }
                tempArr[columnIndex] += grid[rowIndex][columnIndex];
            }
            System.out.println(Arrays.toString(tempArr));
            for (int i = 0; i < resArr.length; i++) {
                resArr[i] = tempArr[i];
            }
        }

        int ans = resArr[0];
        for (int i = 1; i < resArr.length; i++) {
            ans = Math.min(ans, resArr[i]);
        }
        return ans;
    }

    public int minPathCost1(int[][] grid, int[][] moveCost) {
        int[][] memo = new int[grid.length][grid[0].length];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            ans = Math.min(ans, dfs(grid, moveCost, 0, j, memo));
        }
        return ans;
    }
    int dfs(int[][] grid, int[][] moveCost, int x, int y, int[][] memo) {
        if (memo[x][y] != 0) return memo[x][y];
        int cost = grid[x][y];
        if (x == grid.length - 1) return grid[x][y];
        int ret = Integer.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            // 选择最优路线
            ret = Math.min(ret, moveCost[cost][j]+dfs(grid, moveCost, x+1, j, memo));
        }
        memo[x][y] = ret+cost;
        return ret+cost;
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
//        System.out.println(obj.minPathCost2(grid, moveCost));
//        grid = new int[][]{{5,1,2},{4,0,3}};
//        moveCost = new int[][]{{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}};
//        System.out.println(obj.minPathCost2(grid, moveCost));
        grid = new int[][]{{28,35,29,5,13,17,18,23,14},{30,15,12,27,2,26,25,19,7},{1,16,34,21,9,3,20,24,8},{4,33,22,11,31,0,6,10,32}};
        moveCost = new int[][]{{87,46,11,33,55,26,26,56,23},{77,56,72,49,35,18,37,66,37},{54,40,62,1,64,49,95,81,77},{80,7,76,71,91,67,75,84,52},{65,11,13,15,9,34,10,98,20},{1,95,100,61,33,47,28,100,44},{39,56,94,7,64,91,66,34,70},{37,99,62,7,23,78,74,89,97},{84,41,63,42,84,15,46,31,11},{60,36,27,25,37,18,4,90,43},{35,83,90,37,91,27,61,99,53},{85,2,98,99,67,70,38,91,68},{66,46,7,99,26,81,95,51,51},{41,96,66,84,61,73,78,28,63},{38,34,49,55,35,29,93,5,28},{3,30,80,20,23,10,93,40,33},{8,86,47,15,45,84,47,19,58},{72,5,76,82,60,50,13,74,38},{4,8,25,38,29,4,60,81,21},{65,50,74,32,9,47,71,55,14},{90,30,92,51,45,51,4,85,22},{30,56,1,45,63,72,91,73,60},{51,61,53,49,44,99,11,5,3},{24,54,91,11,5,30,50,89,44},{87,97,46,92,93,41,64,73,15},{94,76,90,80,30,9,88,8,33},{50,34,4,63,49,90,46,55,16},{10,46,80,21,97,69,70,85,31},{10,66,74,43,65,45,85,34,91},{82,26,77,10,2,5,89,39,4},{80,70,89,73,54,61,100,89,23},{30,66,80,51,3,34,92,100,63},{74,15,4,33,37,3,87,76,92},{44,43,77,99,27,1,23,10,8},{8,74,17,35,31,84,97,98,34},{99,9,28,43,55,39,93,64,93}};
        System.out.println(obj.minPathCost(grid, moveCost));
        System.out.println(obj.minPathCost2(grid, moveCost));

    }
}
