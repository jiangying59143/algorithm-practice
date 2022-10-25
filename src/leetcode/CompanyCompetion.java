package leetcode;

import java.io.*;
import java.util.Arrays;

public class CompanyCompetion {

    public static void main(String[] args) throws IOException {
        CompanyCompetion obj = new CompanyCompetion();
        char[][] map = {
                {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@'},
                {'@', '.', '#', '.', '.', '.', '.', '#', '#', '.', '.', '.', '@'},
                {'@', '@', '@', '.', '#', '#', '.', 'Z', '#', '#', '.', '.', '@'},
                {'@', '.', '.', '@', '.', '@', '@', '@', '@', '.', '.', '.', '@'},
                {'@', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '@'},
                {'@', '.', '.', 'O', '.', '.', '.', '.', '#', '#', '.', '.', '@'},
                {'@', '.', '.', '#', '.', '@', '@', '.', '.', '.', '.', '.', '@'},
                {'@', '.', '@', '@', '@', '.', '.', 'X', '.', '.', '.', '.', '@'},
                {'@', '.', '.', '@', '@', '.', '.', '.', '.', '.', '.', '.', '@'},
                {'@', '.', '.', '.', '.', '@', '@', '.', '.', '.', '.', '.', '@'},
                {'@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '@'},
                {'@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@', '@'}};
        map = obj.getInput();
        System.out.println(Arrays.toString(obj.run(map, 432, 411)));

    }

    public char[][] getInput() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("data/CompanyCompetion.txt"));
        char[][] res = new char[1024][];

        String s = in.readLine();
        int i=0;
        while( s != null){
            res[i++] = s.toCharArray();
            s = in.readLine();
        }

        return res;
    }

    public int[] run(char[][] map, int x, int y) {
        //找出所有能走的点
        process(map, x, y, x, y);
        int maxSign = 0;
        int[] maxPosition = new int[]{-1,-1};
        //从能走的点中找出信号最强的点
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if('1' == map[i][j]){
                    int count = process2(map, i, j);
                    if(count > maxSign){
                        maxSign = count;
                        maxPosition = new int[] {i, j};
                    }
                }
            }
        }
        return maxPosition;
    }

    public void process(char[][] map, int x, int y, int startX, int startY){
        if(x < 0 || y < 0 || x > map.length-1 || y > map[x].length-1 ||
                map[x][y] == '@' && !(x == startX && y == startY) || map[x][y] == '#'  && !(x == startX && y == startY) || map[x][y] == '1'){
            return;
        }
        map[x][y] = '1';
        process(map, x, y-1, startX, startY);
        process(map, x, y+1, startX, startY);
        process(map, x-1, y, startX, startY);
        process(map, x + 1, y, startX, startY);
    }
    public int process2(char[][] map, int x, int y){
        int count = 0;
        for(int i=x+1; i< map.length; i++){
            if('@' == map[i][y]){
                break;
            }
            if('#' == map[i][y]){
                count++;
            }
        }

        for(int i=x-1; i>=0; i--){
            if('@' == map[i][y]){
                break;
            }
            if('#' == map[i][y]){
                count++;
            }
        }

        for(int i=y+1; i< map[x].length; i++){
            if('@' == map[x][i]){
                break;
            }
            if('#' == map[x][i]){
                count++;
            }
        }

        for(int i=y-1; i>=0; i--){
            if('@' == map[x][i]){
                break;
            }
            if('#' == map[x][i]){
                count++;
            }
        }

        return count;
    }
}
