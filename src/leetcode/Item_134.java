package leetcode;

public class Item_134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int curGas = 0, start = 0,
                //需要把前面缺的补上的量
                needGas = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas = curGas + gas[i] - cost[i];
            if(curGas < 0){
                needGas += Math.abs(curGas);
                curGas = 0;
                start = i+1;
            }
            if(i == gas.length-1 && curGas >= needGas){
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas, cost;
        gas = new int[]{1,2,3,4,5};
        cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
