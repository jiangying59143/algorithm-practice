package leetcode;

public class Item_168 {
    public static String convertToTitle(int columnNumber) {
        int plus = 'A' - 1;
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            int mode = columnNumber % 26;
            if(mode == 0){
                sb.append('Z');
                mode = 26;
            }else {
                sb.append((char) (mode + plus));
            }
            columnNumber = (columnNumber-mode)/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToTitle(52));
    }
}
