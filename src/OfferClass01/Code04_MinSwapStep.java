package OfferClass01;

/**
 * 一个数组中只有两种字符'G'和'B'，可以让所有的G都放在左侧，所有的B都放在右侧
 * 或者可以让所有的G都放在右侧，所有的B都放在左侧，但是只能在相邻字符之间进行交换操作，返回至少需要交换几次
 */
public class Code04_MinSwapStep {
    public static int f1(String str){
        int bStartCount = process(str, 'B');
        int gStartCount = process(str, 'G');
        return Math.min(bStartCount, gStartCount);
    }

    private static int process(String str, char c){
        int L=0,R=0;
        int count=0;
        while(L<= R && R < str.length()){
            if(str.charAt(R) == c){
                count += R-L;
                L++;
            }
            R++;
        }
        return count;
    }

    public static int f2ForTest(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int step1 = 0;
        int step2 = 0;
        int gi = 0;
        int bi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') { // 当前的G，去左边   方案1
                step1 += i - (gi++);
            } else {// 当前的B，去左边   方案2
                step2 += i - (bi++);
            }
        }
        return Math.min(step1, step2);
    }

    public static void main(String[] args) {
        String s = "GGGBBBGGGBBB";
        System.out.println(f1(s));
        System.out.println(f2ForTest(s));
    }
}
