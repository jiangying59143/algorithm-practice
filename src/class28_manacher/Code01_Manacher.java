package class28_manacher;

public class Code01_Manacher {
    public static void main(String[] args) {
        System.out.println(longestPardline("xabccbaxyyxxxddddxxx"));
    }
    public static int longestPardline(String a){
        String ms = getManacherString(a);
        int[] parr = new int[ms.length()];
        int C = 0, R = 0;
        int max_r = 0;
        for (int i = 0; i < ms.length(); i++) {
            parr[i] = R > i ? Math.min(parr[2*C-R],R-i+1): 1;
            while(i-parr[i] >= 0 && i+parr[i] < ms.length()){
                if(ms.charAt(i-parr[i]) == ms.charAt(i+parr[i])){
                    parr[i]++;
                }else{
                    break;
                }
            }
            if(i+parr[i] > R){
                R = i+parr[i]-1;
                C = i;
                max_r = Math.max(parr[i], max_r);
            }
        }
        return (2*max_r-1)/2;
    }

    public static String getManacherString(String a){
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }
}
