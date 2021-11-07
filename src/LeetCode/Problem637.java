package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 示例 1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
public class Problem637 {
    public static void main(String[] args) {

    }
}
class SolutionProblem637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double cur = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                cur+=poll.val;
                if (poll.left!=null)
                    queue.add(poll.left);
                if (poll.right!=null)
                    queue.add(poll.right);
            }
            list.add(cur/size);
        }
        return list;
    }
}
