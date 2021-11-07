package Offer;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class FiftyFive {
    public static void main(String[] args) {

    }
}

// 深度优先,递归
class SolutionFiftyFive {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(method(root.left) + 1, method(root.right) + 1);
    }

    private int method(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(method(root.left) + 1, method(root.right) + 1);
    }
}

// 问题二，判断一棵树是不是平衡二叉树
class SolutionFiftyFive2 {
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        //return Math.abs(judge(root.left)-judge(root.right))<=1 && isBalanced(root.left) &&isBalanced(root.right);
        return method(root);
    }

    // 该方法用于判断该树是不是一颗平衡树
    private boolean method(TreeNode root) {
        if (root==null)
            return true;
        // 判断左子树和右子树是不是平衡树，如果都是平衡树，求高度差
        if (method(root.left) && method(root.right)){
            if (Math.abs(judge(root.left)-judge(root.right))<=1){
                return true;
            }
        }
        return false;
        //return Math.abs(judge(root.left)-judge(root.right))<=1 && method(root.left) &&method(root.right);
    }
    //用户求当前节点的深度
    private int judge(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(judge(root.left)+1,judge(root.right)+1);
    }
}
