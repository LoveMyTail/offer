package LeetCode;

import java.util.Arrays;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 */
public class Problem114 {
    public static void main(String[] args) {
        int[] array = {8,3,4,2,7,4};
        System.out.println(Arrays.binarySearch(array, 0, 2, 4));
    }
}
class SolutionProblem114 {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right!=null){
            root = root.right;
        }
        flatten(right);
        root.right = right;
    }

}
