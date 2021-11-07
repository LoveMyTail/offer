package Offer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class FortySeven {
    public static void main(String[] args) {
        SolutionFortySeven s = new SolutionFortySeven();
        int i = s.maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}});
        System.out.println(i);
    }
}

class SolutionFortySeven {
    public int maxValue(int[][] grid) {
        // 初始化第一行
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 初始化第一列
        for (int j = 1; j < grid.length; j++) {
            grid[j][0] += grid[j - 1][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];

    }
}
