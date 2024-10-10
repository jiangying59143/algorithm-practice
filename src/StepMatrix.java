import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StepMatrix {
    public static int process(int[][] arr, int i, int j, int lastStep, int[][] walks, List<int[][]> allWalked){
        int m = 0;

        if(i == 0 && j == arr[0].length-1 ){
            int[][] newWalks = getCloneArr(walks);
            allWalked.add(newWalks);
            return 1;
        }

        if(i < 0 || j < 0 || i == arr.length || j == arr[i].length || walks[i][j] != -1 || arr[i][j] != lastStep + 1){
            return 0;
        }

        walks[i][j] = arr[i][j];

        m += process(arr, i, j-1, arr[i][j], walks, allWalked);
        m += process(arr, i, j+1, arr[i][j], walks, allWalked);
        m += process(arr, i-1, j, arr[i][j], walks, allWalked);
        m += process(arr, i+1, j, arr[i][j], walks, allWalked);

        walks[i][j] = -1;
        return m;
    }

    private static int[][] getCloneArr(int[][] walks){
        int[][] newWalks = new int[walks.length][walks[0].length];
        for (int i = 0; i < walks.length; i++) {
            newWalks[i]=Arrays.copyOf(walks[i],walks[i].length);
        }
        return newWalks;
    }

    public static void main(String[] args) {
        int[][] arr;
        arr = new int[][]{
                {3,4,5,0},
                {2,3,3,5},
                {1,2,2,4},
                {0,1,2,3}
        };

        int m = arr.length, n = arr[0].length;
        int[][] walks = new int[m][n];
        for (int[] walk : walks) {
            Arrays.fill(walk,-1);
        }
        walks[0][n-1] = 0;

        List<int[][]> res = new ArrayList<>();


        System.out.println(process(arr, m-1, 0, -1, walks, res));

        for (int[][] re : res) {
            for (int[] r : re) {
                System.out.println(Arrays.toString(r));
            }
            System.out.println();
        }
    }
}
