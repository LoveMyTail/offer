package LeetCode;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
 * （也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 若这两个字符串没有公共子序列，则返回 0。
 */
public class Problem1143 {
    public static void main(String[] args) {
        System.out.println(new SolutionProblem1143().longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }
}
// 动态规划
class SolutionProblem1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= text2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
