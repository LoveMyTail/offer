package LeetCode;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Problem120 {
    public static void main(String[] args) {

    }
}
// 递归，超时
class SolutionProblem120One {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        // 如果只有一行数据，则返回第一行中的唯一一个数据
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int count = 0;  // 表示当前是第count行
        int index = 0;  // 表示第count行的第index个数据
        return triangle.get(0).get(0) + Math.min(method(triangle, count + 1, index), method(triangle, count + 1, index + 1));
    }

    private int method(List<List<Integer>> triangle, int count, int index) {
        if (count >= triangle.size() || index >= triangle.get(count).size())
            return 0;
        return triangle.get(count).get(index) + Math.min(method(triangle, count + 1, index), method(triangle, count + 1, index + 1));
    }
}
// 动态规划
class SolutionProblem120Two {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] array = new int[n][n];
        array[0][0] = triangle.get(0).get(0);
        for (int i =1;i<n;i++){
            array[i][0] = triangle.get(i).get(0)+array[i-1][0];
            for(int j =1;j<i;j++){
                array[i][j] = Math.min(array[i-1][j],array[i-1][j-1]) + triangle.get(i).get(j);
            }
            array[i][i] = array[i-1][i-1]+triangle.get(i).get(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i =0;i<n;i++){
            min = Math.min(min, array[n - 1][i]);
        }
        return min;
    }
}
