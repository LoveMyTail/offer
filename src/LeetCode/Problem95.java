package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Problem95 {
    public static void main(String[] args) {

    }
}

class SolutionProblem95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();

        return method(1, n);

    }

    private LinkedList<TreeNode> method(int left, int right) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if (left > right) {
            list.add(null);
            return list;
        }
        for (int i = left; i <= right; i++) {
            LinkedList<TreeNode> leftTree = method(left, i - 1);
            LinkedList<TreeNode> rightTree = method(i + 1, right);
            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = l;
                    treeNode.right = r;
                    list.addLast(treeNode);
                }
            }
        }
        return list;
    }

}
