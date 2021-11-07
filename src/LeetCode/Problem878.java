package LeetCode;

/**
 * 如果正整数可以被 A 或 B 整除，那么它是神奇的。
 * 返回第 N 个神奇数字。由于答案可能非常大，返回它模10^9 + 7的结果。
 * 示例 1：
 * 输入：N = 1, A = 2, B = 3
 * 输出：2
 * 示例2：
 * 输入：N = 4, A = 2, B = 3
 * 输出：6
 */
public class Problem878 {
    public static void main(String[] args) {

    }
}

class SolutionProblem878 {
    public int nthMagicalNumber(int N, int A, int B) {
        int countA = 1;
        int countB = 1;
        if (N == 1)
            return A < B ? A : B;
        if (N == 2)
            return A < B ? B : A;
        int num = 1;
        for (int i = 2; i < N; i++) {

        }
        return num % ((int)Math.pow(10,9)+7);
    }
}
