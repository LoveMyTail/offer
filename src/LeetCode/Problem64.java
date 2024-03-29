package LeetCode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Problem64 {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new SolutionProblem64().minPathSum(grid));

    }
}
// 动态规划
class SolutionProblem64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (i != grid.length - 1 && j == grid[0].length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if (i != grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                else
                    dp[i][j] = grid[i][j];
            }
        }

        return dp[0][0];
    }

}
