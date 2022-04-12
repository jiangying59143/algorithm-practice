package common;

public class MyGenerator {
    public static int[] generateRandomArr(int maxLen){
        return generateRandomArr(maxLen, false);
    }

    public static int[] generateRandomPositiveArr(int maxLen){
        return generateRandomArr(maxLen, true);
    }

    public static int[] generateRandomArr(int maxLen, boolean isPositive) {
        int[] arr = new int[(int)(maxLen*Math.random())+1];
        for (int i = 0; i < arr.length; i++) {
            if(isPositive){
                arr[i] = (int) (Integer.MAX_VALUE * Math.random());
            }else {
                arr[i] = (int) (Integer.MAX_VALUE * Math.random() + Integer.MIN_VALUE * Math.random());
            }
        }
        return arr;
    }


}
