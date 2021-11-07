package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * 示例 1：
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 */
public class Problem973 {
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] ints = new SolutionProblem973().kClosest(points, 2);
        for (int[] anInt : ints) {
            System.out.println(anInt[0]+","+anInt[1]);
        }
    }
}

class SolutionProblem973 {
    public int[][] kClosest(int[][] points, int K) {
        if (points.length <= K)
            return points;
        PriorityQueue<Integer> queue = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double v = (Math.pow(points[o1][0], 2) + Math.pow(points[o1][1], 2)) - (Math.pow(points[o2][0], 2) + Math.pow(points[o2][1], 2));
                return v > 0 ? -1 : 1;
            }
        });
        for (int i = 0; i < points.length; i++) {
            queue.add(i);
            if (queue.size()>K)
                queue.poll();
        }
        int[][] res = new int[K][2];
        int cur = 0;
        for (Integer integer : queue) {
            res[cur][0] = points[integer][0];
            res[cur][1] = points[integer][1];
            cur++;
        }
        return res;
    }
}
