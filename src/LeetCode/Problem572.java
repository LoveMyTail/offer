package LeetCode;

import java.util.HashMap;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * 示例 1:
 * 给定的树 s:
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * 4
 * / \
 * 1   2
 * 返回 true
 */
public class Problem572 {
    public static void main(String[] args) {
        System.out.println(1==1 || 2==2);
        System.out.println("aaa".hashCode());
    }
}

// 分两步，先在s中找t的节点，找到后再判断是否是一样的树
class SolutionProblem572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        if (s == null)
            return false;
        return isSubtree(s.left, t) || isSubtree(s.right, t) || judge(s, t);
    }

    private boolean judge(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return judge(s.left, t.left) && judge(s.right, t.right);
    }
}
