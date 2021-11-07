package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，
 * 但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，
 * 返回空数组。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 */
public class Problem08_02 {
    public static void main(String[] args) {

    }
}

// 深度优先
class SolutionProblem08_02 {
    int m, n;
    List<List<Integer>> list = new ArrayList<>();
    int[][] array;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.array = obstacleGrid;
        m = array.length;
        n = array[0].length;
        dfs(0, 0, new boolean[m][n]);
        return list;
    }

    private boolean dfs(int i, int j, boolean[][] visited) {
        if (i >= m || j >= n || visited[i][j] || array[i][j] == 1)
            return false;
        list.add(Arrays.asList(i, j));
        if (i == m - 1 && j == n - 1)
            return true;
        visited[i][j] = true;
        if (dfs(i + 1, j, visited) || dfs(i, j + 1, visited))
            return true;
        list.remove(list.size() - 1);
        return false;
    }
}

// 动态规划
class SolutionProblem08_02Two {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 || n == 0)
            return list;
        if (obstacleGrid[0][0] == 0 || obstacleGrid[m - 1][n - 1] == 0)
            return list;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[0][i] == 1)
                dp[0][i] = 0;
            else
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        if (dp[m - 1][n - 1] == 0)
            return list;
        int r = m - 1, c = n - 1;
        while (r != 0 || c != 0) {
            list.add(Arrays.asList(r, c));
            int up = 0;
            if (r > 0)
                up = dp[r - 1][c];
            int left = 0;
            if (c > 0)
                left = dp[r][c - 1];
            if (up >= left)
                r--;
            else c--;
        }
        list.add(Arrays.asList(0,0));
        return list;
    }

}
