package class26_Fibonacci;

/**
 * 奶牛生小牛问题
 * 第一年农场有1只成熟的母牛A，往后的每年：
 * 1）每一只成熟的母牛都会生一只母牛
 * 2）每一只新出生的母牛都在出生的第三年成熟
 * 3）每一只母牛永远不会死
 * 返回N年后牛的数量
 */
public class CowBirth {

    public int f(int n){
        if(n <= 3 && n>0){
            return n;
        }
        return f(n-1) + f(n-3);
    }

    public int f1(int n){
        int[] arr = new int[3];

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if(i<3){
                arr[i] = i+1;
                ans = i+1;
            }else{
                ans = arr[(i-1)%3] + arr[(i-3)%3];
                arr[i%3] = ans;
            }
        }
        return ans;
    }

    /**
     * f(n) = f(n-1) + f(n-3)
     * |f(n),f(n-1),f(n-2)| = |f(3),f(2),f(1)||A|^(n-3)
     *
     * 推导|A|
     * f(n) = f(n-1) + 0*f(n-2) + f(n-3)
     * f(n-1) = f(n-1) + 0*f(n-2) + 0*f(n-3)
     * f(n-2) = 0*f(n-1) + f(n-2) + 0*f(n-3)
     * =>
     * |1,1,0|
     * |0,0,1|
     * |1,0,0|
     *
     * @param n
     * @return
     */
    public int f2(int n){
        int[][] base = new int[][]{
                {1,1,0},
                {0,0,1},
                {1,0,0}
        };
        int[][] res = matrixPow(base, n-3);
        return 3*res[0][0] + 2*res[1][0] + res[2][0];
    }

    private int[][] matrixPow(int[][] base, int p) {
        int[][] ans = new int[base.length][base[0].length];
        for (int j = 0; j < ans.length; j++) {
            ans[j][j] = 1;
        }
        for(;p !=0; p >>= 1){
            if((p&1)==1){
                ans = matrixMultiply(ans, base);
            }
            base = matrixMultiply(base, base);
        }
        return ans;
    }

    private int[][] matrixMultiply(int[][] a, int[][] b){
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    res[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        CowBirth cb = new CowBirth();
        System.out.println(cb.f(10));
        System.out.println(cb.f1(10));
        System.out.println(cb.f2(10));
    }
}
