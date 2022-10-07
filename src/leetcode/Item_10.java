package leetcode;

public class Item_10 {
    public static void main(String[] args) {
        Item_10 obj = new Item_10();
        System.out.println(obj.index("abcde", "cde"));
    }

    public boolean isMatch(String s, String p) {
        return process(s, p, 0);
    }

    private boolean process(String s, String p, int index){
        if(index == s.length()){
            if(index == p.length()){
                return true;
            }else{
                boolean res = true;
                for (int i = index; i < p.length(); i++) {
                    res = p.charAt(index) == '*' && res;
                }
                return res;
            }
        }

        if(p.charAt(index) != '.' && p.charAt(index) != '*'){
            return s.charAt(index) == p.charAt(index) && process(s, p, index + 1);
        }else{
            return p.charAt(index) == '.' && process(s, p, index + 1)
                    || p.charAt(index) == '*' && process(s, p, s.length());
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
