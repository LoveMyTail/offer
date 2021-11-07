package LeetCode;

import java.util.Arrays;

/**
 * 给出集合[1,2,3,…,n]，其所有元素共有n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定n 和k，返回第k个排列。
 * 说明：
 * 给定 n的范围是 [1, 9]。
 * 给定 k的范围是[1,n!]。
 * 示例1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 */
public class Problem60 {
    public static void main(String[] args) {

    }
}

class SolutionProblem60 {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            // factorial[i]存储的是i的阶乘
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
