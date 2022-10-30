package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        if(numRows <  1){
            return list;
        }
        list.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastLevList = list.get(list.size()-1);
            int levelLen = lastLevList.size()+1;
            List<Integer> itemList = new ArrayList<>();
            for (int j = 0; j < levelLen; j++) {
                if(j == 0){
                    itemList.add(1);
                }else if(j == levelLen -1){
                    itemList.add(1);
                }else{
                    itemList.add(lastLevList.get(j-1) + lastLevList.get(j));
                }
            }
            list.add(itemList);
        }

        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list=generate(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }
}
