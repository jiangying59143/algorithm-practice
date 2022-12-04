package leetcode;

public class Item_28 {
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        int[] next = getNextArr(needle);

        int x = 0;
        int y = 0;
        while(x < haystack.length() && y < needle.length()){
            if(haystack.charAt(x) == needle.charAt(y)){
                x++;
                y++;
            }else if(next[y] == -1){
                x++;
            }else{
                y = next[y];
            }
        }

        return y == needle.length() ? x-y : -1;
    }

    /**
     * 不能取整体，并且不包括当前字符
     * @param str2
     * @return
     */
    public static int[] getNextArr(String str2){
        int N = str2.length();
        if(N == 1){
            return new int[]{-1};
        }

        int[] next = new int[N];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while(i < N){
            if(str2.charAt(cn) == str2.charAt(i-1)){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("sadbutsad", "uts"));
        System.out.println(strStr("leetcode", "leeto"));
    }
}
