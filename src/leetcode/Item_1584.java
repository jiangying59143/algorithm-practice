package leetcode;

public class Item_1584 {

    public static int minCostConnectPoints(int[][] points) {
        int nodeLength = points.length;
        //每一行的第一个数是from, 第二个为to, 第三个是weight
        int[][] edges = new int[(nodeLength * (nodeLength-1))>>1][3];
        int k = 0;
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                edges[k][0] = i;
                edges[k][1] = j;
                edges[k++][2] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] points;
        points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
        points = new int[][]{{3,12},{-2,5},{-4,1}};
        System.out.println(minCostConnectPoints(points));

    }
}
