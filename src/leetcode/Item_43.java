package leetcode;

public class Item_43 {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String sb = "0";
        StringBuilder multiplySb = new StringBuilder(), addSb = new StringBuilder();
        for (int r1 = num1.length()-1; r1 >= 0; r1--) {
            int zeroCount = num1.length()-1 - r1;
            while(zeroCount > 0){
                multiplySb.append(0);
                zeroCount--;
            }
            int addition = 0;
            int r2 = num2.length()-1;
            while (r2 >= 0 || addition != 0) {
                int a = r2 < 0 ? 0 : num2.charAt(r2)-'0';
                int b = num1.charAt(r1)-'0';
                int res = a * b + addition;
                multiplySb.append(res%10);
                addition = res/10;
                r2--;
            }

            addition = 0;
            int i=0, sbLength = sb.length(), j=0, multiLength = multiplySb.length();
            while(i < sbLength || j <multiLength || addition != 0){
                int a = i >= sbLength ? 0 : sb.charAt(i)-'0';
                int b = j >= multiLength ? 0 : multiplySb.charAt(j)-'0';
                int res = a + b + addition;
                addSb.append(res%10);
                addition = res/10;
                i++;
                j++;
            }

            sb = addSb.toString();
            addSb.delete(0, addSb.length());
            multiplySb.delete(0, multiplySb.length());
        }

        return new StringBuilder(sb).reverse().toString();
    }

    public static String multiply1(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String sb = "0";
        StringBuilder multiplySb = new StringBuilder(), addSb = new StringBuilder();
        for (int r1 = num1.length()-1; r1 >= 0; r1--) {
            int zeroCount = num1.length()-1 - r1;
            while(zeroCount > 0){
                multiplySb.append(0);
                zeroCount--;
            }
            int addition = 0;
            int r2 = num2.length()-1;
            while (r2 >= 0 || addition != 0) {
                int a = r2 < 0 ? 0 : num2.charAt(r2)-'0';
                int b = num1.charAt(r1)-'0';
                int res = a * b + addition;
                multiplySb.append(res%10);
                addition = res/10;
                r2--;
            }

            addition = 0;
            int i=0, sbLength = sb.length(), j=0, multiLength = multiplySb.length();
            while(i < sbLength || j <multiLength || addition != 0){
                int a = i >= sbLength ? 0 : sb.charAt(i)-'0';
                int b = j >= multiLength ? 0 : multiplySb.charAt(j)-'0';
                int res = a + b + addition;
                addSb.append(res%10);
                addition = res/10;
                i++;
                j++;
            }

            sb = addSb.toString();
            addSb.delete(0, addSb.length());
            multiplySb.delete(0, multiplySb.length());
        }

        return new StringBuilder(sb).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("9133", "0"));
    }
}
