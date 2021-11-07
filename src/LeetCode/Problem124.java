package LeetCode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，
 * 且不一定经过根节点。
 * 示例 1:
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 * 输出: 6
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: 42
 */
public class Problem124 {
    public static void main(String[] args) {

    }
}
class SolutionProblem124 {
    int cur = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        method(root);
        return cur;
    }

    public int method(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(method(root.left),0);
        int right = Math.max(method(root.right),0);
        int now = root.val+left+right;
        cur = Math.max(cur,now);
        return Math.max(left,right)+root.val;
    }
}
