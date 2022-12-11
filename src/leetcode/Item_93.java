package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        process(s, 0, new ArrayList<>(), res);
        return res;
    }

    private static void process(String s, int i, List<String> temp, List<String> res){
        if(i == s.length()){
            if(temp.size() == 4) {
                res.add(String.join(".", temp));
            }
            return;
        }

        if(temp.size() == 3 && s.length() - i > 3){
            return;
        }
        temp.add(String.valueOf(s.charAt(i)));
        process(s, i+1, temp, res);
        temp.remove(temp.size()-1);
        if(i + 1 < s.length() && s.charAt(i) > '0') {
            temp.add(s.substring(i, i+2));
            process(s, i + 2, temp, res);
            temp.remove(temp.size()-1);
        }
        if(s.charAt(i) > '0' && i + 2 < s.length()
                && (s.charAt(i) - '0') * 100 + (s.charAt(i+1) - '0') * 10 + (s.charAt(i+2) - '0') < 256) {
            temp.add(s.substring(i, i+3));
            process(s, i + 3, temp, res);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args) {
        String s;
        List<String> res;
        s = "25525511135";
        res = restoreIpAddresses(s);
        System.out.println(Arrays.toString(res.toArray()));

        s = "0000";
        res = restoreIpAddresses(s);
        System.out.println(Arrays.toString(res.toArray()));

        s = "101023";
        res = restoreIpAddresses(s);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
