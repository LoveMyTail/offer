package Offer;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 */
public class Sixty {
    public static void main(String[] args) {

    }
}

// 动态规划
// f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6)
// https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/di-gui-huo-zhe-die-dai-du-ke-yi-python-and-javascr/
class SolutionSixty {
    public double[] twoSum(int n) {



        if (n == 0)
            return new double[0];
        double[] dp = new double[6 * n - 1];
        double[] ans = new double[5 * -1];
        double all = Math.pow(6, n);
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
            ans[i - 1] = 1.0 / 6;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 6 * n; j >= 1; j--) {
                int temp = 0;
                for (int k = 0; k < 6; k++) {
                    temp += (j >= k) ? dp[j - k] : 0;
                }
                dp[j] = temp;
                if (i == n && j >= n) {
                    ans[j - i] = dp[j] / all;
                }
            }
        }
        return ans;
    }
}
