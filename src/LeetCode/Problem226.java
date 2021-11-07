package LeetCode;

/**
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Problem226 {
    public static void main(String[] args) {

    }
}
class SolutionProblem226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode cur = root.left;
        root.left = root.right;
        root.right = cur;
        invert(root.left);
        invert(root.right);
    }
}
