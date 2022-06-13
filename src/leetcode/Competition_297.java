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
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] brackets = new int[3][];
        brackets[0] = new int[]{1,0};
        brackets[1] = new int[]{4,25};
        brackets[2] = new int[]{5,50};
        System.out.println(new Competition_297().calculateTax(brackets,2));

    }
}
