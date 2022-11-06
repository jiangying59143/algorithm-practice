package leetcode;

public class Item_151 {
    public static String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int L = 0;
        int R = ss.length-1;
        while(L < R && ss[L] == ' '){
            L++;
        }
        int start = L;
        while(L < R && ss[R] == ' '){
            R--;
        }
        int end = R;
        while(L < R){
            swap(ss, L++, R--);
        }
        int wordStart = start;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if(ss[i] == ' ' || i == end){
                for (int j = i == end ? i : i-1; j >= wordStart; j--) {
                    sb.append(ss[j]);
                }
                if(i == end){
                    break;
                }
                while(i < end && ss[i] == ' '){
                    i++;
                }
                i -= 1;
                sb.append(' ');
                wordStart = i + 1;
            }
        }
        return sb.toString();
    }

    public static void swap(char[] ss, int i, int j){
        if(i == j){
            return;
        }
        char temp = ss[i];
        ss[i] = ss[j];
        ss[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" the sky is blue "));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }
}
