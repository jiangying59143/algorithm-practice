package leetcode;

public class Item_38 {
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");
        int i=2;
        while(i <= n){
            StringBuilder tempSb = new StringBuilder();
            int count = 0;
            for (int j = sb.length()-1; j >= 0; j--) {
                if(j == sb.length()-1){
                    count = 1;
                    tempSb.append(sb.charAt(j));
                }else if(sb.charAt(j) == sb.charAt(j+1)){
                    count++;
                }else{
                    tempSb.append(count);
                    tempSb.append(sb.charAt(j));
                    count = 1;
                }

                if(j == 0){
                    tempSb.append(count);
                }
            }
            sb = tempSb.reverse();
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
