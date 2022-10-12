package leetcode;

public class Leetcode_85 {
    public static int maximalRectangle(char[][] matrix) {
        int[][] convertArr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i==0) convertArr[i][j] = matrix[i][j]-'0';
                else convertArr[i][j] = matrix[i][j]=='0' ? 0 : (convertArr[i-1][j]+1);
            }
        }
        int area = 0;
        int[] stack = new int[matrix[0].length];
        int stackIndex = -1;
        for (int i = 0; i < convertArr.length; i++) {
            for (int j = 0; j < convertArr[i].length; j++) {
                while(stackIndex != -1 && convertArr[i][stack[stackIndex]] >= convertArr[i][j]){
                    int index = stack[stackIndex--];
                    int height = convertArr[i][index];
                    int width = stackIndex == -1 ? j-1 -(-1) : j-1 - stack[stackIndex];
                    area = Math.max(area, height * width);
                }
                stack[++stackIndex] = j;
            }
            while(stackIndex != -1){
                int index = stack[stackIndex--];
                int height = convertArr[i][index];
                int width = stackIndex == -1 ? convertArr[i].length-1 -(-1) : convertArr[i].length-1 - stack[stackIndex];
                area = Math.max(area, height * width);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
