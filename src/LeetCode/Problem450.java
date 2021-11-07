package LeetCode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class Problem450 {
    public static void main(String[] args) {
    }
}

class SolutionProblem450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            // 当前节点是叶子节点，则直接删除
            if (root.left == null && root.right == null)
                root = null;
            // 当前节点由右子树，则将右子树中最小的值作为当前节点的值，并且删除最小值的节点
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // 当前节点没有右子树但是由左子树，则将左子树中最大值作为当前节点的值，并且删除最大值的节点
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
