package Job.ByteDance;

import java.util.*;

/**
 * 工厂中有N台机器，每台机器由于出产的时间不同，其生产能力也不一样，某天，工厂接到任务需要生成N个产品。
 * 请你计算出一共有多少种生产方案
 * 输入N，即所需生产的产品数。输入N个正整数，第i个整数Ai表示机器i的生产能力（只能生产<=Ai的产品）。
 * 再输入N个整数，第i个整数Bi代表着产品i的编号。最后输入一个整数P，所得出结果为%P的结果
 * 例子：
 * 输入
 * 3            3
 * 1 2 3        3 3 3
 * 1 2 3        1 1 1
 * 100          100
 * 输出 1        6
 */
public class MainFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        int P = sc.nextInt();
        System.out.println(method(A, B, P));
    }

    private static long method(int[] A, int[] B, int P) {
        Arrays.sort(A);
        Arrays.sort(B);
        long res = 1;
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            while (j < B.length && A[i] >= B[j])
                j++;
            res *= (j - i);
            res = res % P;
        }
        return res;
    }
}

class SolutionMainFour {

}
