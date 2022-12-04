package leetcode;

public class Item_7 {
    public static int reverse(int x) {
        boolean isPositive = x > 0;
        x = isPositive ? -x : x;
        int res = 0;
        while(true){
            res = res * 10 + x % 10;
            x = x / 10;
            if(x == 0){
                break;
            }
            if(res < Integer.MIN_VALUE / 10){
                return 0;
            }else if(res == Integer.MIN_VALUE / 10){
                if(x % 10 < -8){
                    return 0;
                }
            }
        }

        return isPositive ? (res == Integer.MIN_VALUE ? 0 : -res) : res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(1463847412));
        System.out.println(reverse(-1463847412));
    }
}
