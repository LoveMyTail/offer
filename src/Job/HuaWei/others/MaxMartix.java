package Job.HuaWei.others;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMartix {
    public static void main(String[] args) {
//        int[] w = {1,1,1,1,2,1,1};
//        int[] h = {5,2,5,4,5,1,6};

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int length = str.length();
        String s1 = str.substring(1, length / 2-1);
        String s2 = str.substring(length/2+2, length-1);
        String[] W = s1.split(",");
        String[] H = s2.split(",");
        int[] w = new int[W.length];
        int[] h = new int[H.length];
        for (int i = 0; i < W.length; i++) {
            w[i] = Integer.parseInt(W[i]);
            h[i] = Integer.parseInt(H[i]);
        }
        int i = new Solution().method(w, h);
        System.out.println(i);
    }
}

class Solution {
    public int method(int[] w, int[] h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < w.length; i++) {
            int curMax = w[i] * h[i];
            int curH = h[i];    // 当前矩阵箱子的高度
            // 以当前i位置的箱子为中心，向两边扩散
            int left = i - 1, right = i + 1;
            while (left >= 0) {
                if (h[left] >= curH) {
                    curMax += w[left] * curH;
                    left--;
                }else{
                    break;
                }
            }
            while (right < w.length) {
                if (h[right] >= curH) {
                    curMax += w[right] * curH;
                    right++;
                }else{
                    break;
                }
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}
