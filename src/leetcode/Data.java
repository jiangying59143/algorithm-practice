package leetcode;

public class Data {
    public static int[] generate(int maxLen,  int minVal, int maxVal){
        int[] arr = new int[(int)(Math.random()*maxLen + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minVal + (int)(Math.random()*(maxVal-minVal)+1);
        }
        return arr;
    }

    public static int[] generate(int length, int maxVal){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*(maxVal)+1);
        }
        return arr;
    }
}
