package LeetCode;

/**
 * 给定两个单词word1和word2，找到使得word1和word2相同所需的最小步数，
 * 每步可以删除任意一个字符串中的一个字符。
 * 示例：
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 */
public class Problem583 {
    public static void main(String[] args) {
        SolutionProblem583 s = new SolutionProblem583();
        System.out.println(s.minDistance("a", "ab"));
    }
}
// 转换为最长公共子序列问题即可
class SolutionProblem583 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int num = dp[word1.length()][word2.length()];
        return word1.length() - num + word2.length() - num;
    }
}
