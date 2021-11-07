package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 示例：
 * 输入：
 *    1
 *     \
 *      3
 *     /
 *    2
 * 输出：
 * 1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class Problem530 {
}
// 二叉搜索树，中序遍历为单调递增序列
class SolutionProblem530 {
    List<Integer> list = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root.left!=null)
            dfs(root.left);
        list.add(root.val);
        if (list.size() >= 2) {
            int cur = Math.abs(list.get(list.size()-1)-list.get(list.size()-2));
            min = Math.min(min,cur);
        }
        if (root.right!=null)
            dfs(root.right);
    }
}
