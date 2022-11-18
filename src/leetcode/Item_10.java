package leetcode;

public class Item_10 {
    public static void main(String[] args) {
        Item_10 obj = new Item_10();
        System.out.println(obj.index("abcde", "cde"));
    }

    public boolean isMatch(String s, String p) {
        return process(s, p, 0, 0);
    }

    private boolean process(String s, String p, int si, int pi){
        if(p.charAt(pi) == '*'){
            if(p.charAt(pi-1) == '.' || s.charAt(si) == s.charAt(si-1)){

            }
        }
        if(s.charAt(si) == p.charAt(pi)){

        }else if(p.charAt(pi) == '.'){

        }

    }

    public int index(String s, String p) {
        int[] next = getNext(p);
        int x = 0, y = 0;
        while(x < s.length() && y < p.length()){
            if(s.charAt(x) == p.charAt(y)){
                x++;
                y++;
            }else if(next[y] == -1){
                x++;
            }else{
                y = next[y];
            }
        }
        return y == p.length() ? x - y : -1;
    }

    public int[] getNext(String p){
        int[] next = new int[p.length()];
        int i=2, cn=0;
        next[0] = -1;
        next[1] = 0;
        while(i < p.length()){
            if(next[i-1] == next[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }

        return next;
    }
}
