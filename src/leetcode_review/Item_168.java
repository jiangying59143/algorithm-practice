package leetcode_review;

public class Item_168 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            if(columnNumber % 26 == 0){
                sb.append('Z');
                columnNumber -= 26;
            }else {
                sb.append((char)('A' - 1 + columnNumber % 26));
            }
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToTitle(701));
    }
}
