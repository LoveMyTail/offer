package Job.WangYi.JobInterview;

public class Fibonacci {
}

/**
 * 解题思路：
 * 给定斐波那契数列的前两项，求该斐波那契数列中某一位置的数是否能被3整除。
 * <p>
 * 由于int能表示的数值范围不够，所以用数组来记录。
 */
class SolutionFibonacci {
    public boolean judge(int n) {
        if (n <= 1)
            return false;
        long[] dp = new long[n + 1];
        dp[0] = 7;
        dp[1] = 11;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 3;
        }
        return dp[n] % 3 == 0;
    }
}
