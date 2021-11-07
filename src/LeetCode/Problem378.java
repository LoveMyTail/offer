package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * 示例：
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 */
public class Problem378 {
    public static void main(String[] args) {

    }
}
// 归并排序
class SolutionProblem378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;  // 行数
        for (int i = 0; i < n; i++) {
            // 将每一行的第一个数字、行号以及列号作为一个数组存入queue
            queue.offer(new int[]{matrix[i][0], i, 0});
        }
        // 找第k个数
        for (int i = 0; i < k - 1; i++) {
            int[] now = queue.poll();
            // 如果当前元素的列号等于n-1，也就是说该行被遍历结束，则需要在队列中删除该行的元素
            if (now[2] != n - 1) {
                queue.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return queue.poll()[0];
    }
}
