package leetcode;

public class Item_204 {
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean divFlag = true;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0){
                    if(!(j==1 || j==i)) {
                        divFlag = false;
                        break;
                    }
                }

            }
            if(divFlag){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
