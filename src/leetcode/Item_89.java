package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Item_89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>(), res = new ArrayList<>();
        for (int i = 0; i < ((int) Math.pow(2, n)); i++) {
            list.add(i);
        }

        boolean flag = graySort(list, 1);
        System.out.println("  " + flag);
        return list;
    }

    private static boolean graySort(List<Integer> list, int i){

        if(i == list.size()){
            return true;
        }

        for (int j = i; j < list.size(); j++) {
            if(Integer.bitCount(list.get(j) ^ list.get(i-1)) != 1 || i == list.size() - 1 && Integer.bitCount(list.get(i) ^ list.get(0)) != 1){
                continue;
            }

            swap(list, i, j);
            if(!graySort(list, i+1)){
                swap(list, i, j);
            }else{
                return true;
            }
        }
        return false;
    }

    private static void swap(List<Integer> list, int a, int b){
        if(a == b){
            return;
        }
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    private static boolean validateRes(List<Integer> res){
        boolean flag = true;
        for (int i = 1; i < res.size(); i++) {
            flag = flag && Integer.bitCount(res.get(i) ^ res.get(i-1)) == 1;
            if(i == res.size()-1){
                flag = flag && Integer.bitCount(res.get(i) ^ res.get(0)) == 1;
            }
        }
        return flag;
    }

    private static void printRes(List<Integer> res){
        for (int i = 1; i < res.size(); i++) {
            System.out.println(Integer.toBinaryString(res.get(i)));
        }
    }

    public static void main(String[] args) {
        List<Integer> res;
        res = grayCode(2);
        System.out.println(validateRes(res));

        res = grayCode(1);
        System.out.println(validateRes(res));;

        res = grayCode(3);
        System.out.println(validateRes(res));

        res = grayCode(4);
        System.out.println(validateRes(res));
    }
}
