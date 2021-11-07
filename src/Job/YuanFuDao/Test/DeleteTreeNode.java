package Job.YuanFuDao.Test;

import LeetCode.TreeNode;

// 删除二叉搜索树中指定节点
public class DeleteTreeNode {
    public static void main(String[] args) {

    }
}

class SolutionDeleteTreeNode {
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
