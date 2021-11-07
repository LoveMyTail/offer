package LeetCode;
/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem107 {
    public static void main(String[] args) {

    }
}
class SolutionProblem107 {
    List<List<Integer>> list = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> cur = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                cur.add(poll.val);
                if (poll.left!=null)
                    queue.add(poll.left);
                if (poll.right!=null)
                    queue.add(poll.right);
            }
            list.add(0,cur);
        }
        return list;
    }
}
