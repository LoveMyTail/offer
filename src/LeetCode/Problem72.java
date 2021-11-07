package LeetCode;

/**
 * 编辑距离
 * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class Problem72 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println();
    }
}

// 递归 会超时
class SolutionProblem72 {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());
        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
            return minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        }
        return 1 + Math.min(
                Math.min(minDistance(word1, word2.substring(0, word2.length() - 1)), minDistance(word1.substring(0, word1.length() - 1), word2)),
                minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1)));
    }
}

/**
 * 动态规划
 * dp[i][j] 表示由 word1[0...i] 转换到 word2[0...j] 的转换次数
 * 如果 word[i] == word[j] , 那么dp[i][j] = dp[i-1][j-1]
 * 否则 dp[i][j] = 1 + min( dp[i][j-1] , dp[i-1][j] , dp[i-1][j-1] )
 */
class SolutionProblem72Two {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0)
            return n + m;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                // 如果相等，则直接进行下一步计算，如果不相等，则+1，表示进行字符替换
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n][m];
    }
}
