package Job.YuanFuDao.Test;

import LeetCode.TreeNode;

import java.lang.ref.SoftReference;

/**
 * 判断一棵树是不是二叉平衡搜索树
 */
public class JudgeBalanceAndSearchTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(new SolutionJJudgeBalanceAndSearchTree().JudgeBalanceAndSearchTree(root));
    }
}

class SolutionJJudgeBalanceAndSearchTree {
    public boolean JudgeBalanceAndSearchTree(TreeNode root) {
        return judgeBalance(root) && judgeSearch(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    // 判断其是否是搜索树 可以用递归判断值是否满足响应的范围，也可以根据性质判断：搜索树中序遍历递增
    private boolean judgeSearch(TreeNode root, int low, int high) {
        if (root == null)
            return true;
        int val = root.val;
        if (low != Integer.MAX_VALUE && val <= low)
            return false;
        if (high != Integer.MIN_VALUE && val >= high)
            return false;
        if (!judgeSearch(root.right, val, high))
            return false;
        if (!judgeSearch(root.left, low, val))
            return false;
        return true;
    }

    // 判断其是否是平衡树,
    private boolean judgeBalance(TreeNode root) {
        if (root == null)
            return true;
        return judgeBalance(root.left)
                && judgeBalance(root.right)
                && Math.abs(dfs(root.left) - dfs(root.right)) <= 1;
    }

    // 求以当前节点为根的树的高度
    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }
}
