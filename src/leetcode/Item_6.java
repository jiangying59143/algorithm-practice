package leetcode;

public class Item_6 {
    /**
     * 第一行 第一个字符 0, 第二个字符(第一个位置+一列的字符 + 斜线的字符) 0+(numRows-1)+(numRows-1)
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        StringBuilder resStr = new StringBuilder();
        int skipLength = 2*numRows-2, i, n = s.length();
        //为一行的时候 skipLength 是 0.
        skipLength = skipLength == 0 ? 1 : skipLength;
        for (int line = 0; line < numRows && line < n; line++) {
            resStr.append(s.charAt(line));
            if(line == 0 || line == numRows-1){
                i = line;
                while(n - 1 - skipLength >= i) {
                    resStr.append(s.charAt(i + skipLength));
                    i = i + skipLength;
                }
            }else if(line > 0 && line < numRows-1){
                i = -line;
                while(n - 1 - skipLength >= i) {
                    resStr.append(s.charAt(i + skipLength));
                    if(n - 1 - skipLength - 2 * line >= i) {
                        resStr.append(s.charAt(i + skipLength + 2 * line));
                    }
                    i = i + skipLength;
                }
            }
        }

        return resStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
        System.out.println(convert("A", 2));
        System.out.println(convert("AB", 1));
        System.out.println(convert("AB", 2));
    }
}
