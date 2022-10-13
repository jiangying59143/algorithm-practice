package class27_KMP;

public class Code01_KMP {
    public static void main(String[] args) {
        Code01_KMP obj = new Code01_KMP();
        System.out.println(obj.kmp("abcdabcdXY", "cdX"));
        System.out.println(obj.kmp("abcdabcdXY", "abcdX"));
    }
    public int kmp(String a, String b){
        int[] next = getNextArr(b);
        int x=0,y=0;
        while(x < a.length() && y < b.length()){
            if(a.charAt(x) == b.charAt(y)){
                x++;
                y++;
            }else if(next[y] == -1){
                x++;
            }else{
                y = next[y];
            }
        }
        return y == b.length() ? x-y : -1;
    }

    public int[] getNextArr(String b){
        int[] next = new int[b.length()];
        next[0] = -1;
        next[1] = 0;
        int i=2, cn=0;
        while(i < b.length()){
            if(b.charAt(i-1) == b.charAt(cn)){
                next[i++] = next[++cn];
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++]=0;
            }
        }
        return next;
    }
}
