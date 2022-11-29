package leetcode;

public class Item_165 {
    public static int compareVersion(String version1, String version2) {
        int index1 = 0, index2 = 0, x1=0, x2=0;
        while(index1 < version1.length() || index2 < version2.length()){
            //去掉前导0
            while(index1 < version1.length() && version1.charAt(index1) == '0'){
                index1++;
            }
            while(index2 < version2.length() && version2.charAt(index2) == '0'){
                index2++;
            }

            // 到下一个点或者结尾的整数大小
            for(;index1 < version1.length(); index1++){
                if(version1.charAt(index1) == '.'){
                    index1++;
                    break;
                }
                x1 = x1 * 10 + (version1.charAt(index1) - '0');
            }

            for(;index2 < version2.length(); index2++){
                if(version2.charAt(index2) == '.'){
                    index2++;
                    break;
                }
                x2 = x2 * 10 + (version2.charAt(index2) - '0');
            }

            if(x1 > x2){
                return 1;
            }else if(x1 < x2){
                return -1;
            }
            x1 = 0;
            x2 = 0;
        }

        return 0;
    }
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("1.0", "0.1"));
        System.out.println(compareVersion("0.0.1", "0.1"));
    }
}
