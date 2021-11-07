package Job.PDD;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 中餐种数
        int M = sc.nextInt();   // 晚餐种数
        int T = sc.nextInt();   // 需要的最少美味值
        int[][] arrayN = new int[N][2];
        int[][] arrayM = new int[M][2];
        for (int i = 0; i < N; i++) {
            arrayN[i][0] = sc.nextInt();
            arrayN[i][1] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            arrayM[i][0] = sc.nextInt();
            arrayM[i][1] = sc.nextInt();
        }
        // 对数组内进行排序，按照美味值来排序
        Arrays.sort(arrayN, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.sort(arrayM, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int[] ints : arrayN) {
            System.out.println(ints[0]+" "+ints[1]);
        }
        for (int[] ints : arrayM) {
            System.out.println(ints[0]+" "+ints[1]);
        }
        int ans = Integer.MAX_VALUE;
        int num = method(ans, T, arrayN, arrayM);
        System.out.println(num);
    }

    private static int method(int ans, int T, int[][] arrayN, int[][] arrayM) {
        if (T == 0)
            return 0;
        // 双指针，两个数组一个从头遍历，一个从尾遍历
        int i = arrayN.length-1, j = 0;
        while (i >= 0 && j < arrayM.length) {
            if (arrayN[i][1] >= T){
                ans = Math.min(ans, arrayN[i][0]);
            }
            if (arrayM[j][1] >= T)
                ans = Math.min(ans, arrayN[j][0]);
            if (arrayN[i][1] + arrayM[j][1] >= T) {
                ans = Math.min(ans, arrayN[i][0] + arrayM[j][0]);
                i--;
            } else {
                j++;
            }
        }


/*        for (int i = 0; i < arrayN.length; i++) {
            if (arrayN[i][1] >= T)
                ans = Math.min(ans, arrayN[i][0]);
            for (int j = 0; j < arrayM.length; j++) {
                if (arrayM[j][1] >= T)
                    ans = Math.min(ans, arrayN[j][0]);
                if (arrayN[i][1] + arrayM[j][1] >= T)
                    ans = Math.min(ans, arrayN[i][0] + arrayM[j][0]);
            }
        }*/
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
