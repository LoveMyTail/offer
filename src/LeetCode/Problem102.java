package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Problem102 {
    public static void main(String[] args) {

    }
}
class SolutionProblem102 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return list;
        int count = 0;
        method(root,count);
        return list;
    }

    private void method(TreeNode root, int count) {
        if (list.size()==count)
            list.add(new ArrayList<>());
        list.get(count).add(root.val);
        if (root.left!=null)
            method(root.left,count+1);
        if (root.right!=null)
            method(root.right,count+1);
    }
}
