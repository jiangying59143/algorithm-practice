package leetcode;

public class Item_1779 {
    public static int nearestValidPoint(int x, int y, int[][] points) {
        int resIndex = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if((points[i][0] == x || points[i][1] == y)){
                int newDistance = Math.abs(points[i][0]-x) + Math.abs(points[i][1]-y);
                if(newDistance < distance){
                    distance = newDistance;
                    resIndex = i;
                }
            }
        }

        return resIndex;
    }

    public static void main(String[] args) {
        int[][] points;
        points = new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}};

        System.out.println(nearestValidPoint(3, 4, points));

        points = new int[][]{{3,4}};
        System.out.println(nearestValidPoint(3, 4, points));

        points = new int[][]{{2,3}};
        System.out.println(nearestValidPoint(3, 4, points));
    }
}
