package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Problem04_05 {
    public static void main(String[] args) {

    }
}

// 递归,给定当前判断区间的最大值和最小值
class SolutionProblem04_05 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBSThelp(root.left, Integer.MIN_VALUE, root.val)
                && isValidBSThelp(root.right, root.val, Integer.MAX_VALUE);

    }

    private boolean isValidBSThelp(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        boolean left = isValidBSThelp(root.left, min, root.val);
        boolean right = isValidBSThelp(root.right, root.val, max);
        return left && right;
    }
}

class SolutionProblem04_05MethodTwo {
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        method(root);
        return judge(list);
    }

    private boolean judge(List<Integer> list) {
        for (int i =0;i<list.size()-1;i++){
            if (list.get(i)>=list.get(i+1))
                return false;
        }
        return true;
    }

    private void method(TreeNode root) {
        if (root == null)
            return;
        method(root.left);
        list.add(root.val);
        method(root.right);
    }

}
