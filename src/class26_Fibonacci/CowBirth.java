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

    public static void main(String[] args) {
        CowBirth cb = new CowBirth();
        System.out.println(cb.f(10));
        System.out.println(cb.f1(10));
    }
}
