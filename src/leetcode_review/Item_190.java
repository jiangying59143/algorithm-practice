package leetcode_review;

public class Item_190 {
    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 16; i++) {
            int low = n & (1<<i);
            int up = n & (1<<(31-i));
            ans |= low != 0 ? 1<< (31-i) : 0;
            ans |= up != 0 ? 1<< i : 0;
        }
        return ans;
    }

    public static int reverseBits2(int n) {
        int M1 = 0x55555555;
        int M2 = 0x33333333;
        int M3 = 0x0f0f0f0f;
        int M4 = 0x00ff00ff;
        int M5 = 0x0000ffff;
        n = n>>>1 & M1 | (n & M1)<<1;
        n = n>>>2 & M2 | (n & M2)<<2;
        n = n>>>4 & M3 | (n & M3)<<4;
        n = n>>>8 & M4 | (n & M4)<<8;
        n = n>>>16 & M5 | (n & M5)<<16;
        return n;
    }
}
