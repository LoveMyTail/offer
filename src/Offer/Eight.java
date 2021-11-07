package Offer;

/**
 * 二叉树的下一个节点
 * 给定一颗二叉树的其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左右子节点的指针，还有一个指向父节点的指针
 */
public class Eight {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        TreeNode cur = node.left.left;

        TreeNode treeNode = new SolutionEight().inorderSuccessor(node, cur);
        System.out.println(treeNode.val);
    }
}
// 如果是二叉搜索树，便可以递归查询
class SolutionEight {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode node = inorderSuccessor(root.left, p);
        return node == null ? root : node;
    }
}
// 如果只是普通的二叉树，那么就得分情况讨论
class SolutionEightTwo {
    public TreeNode inorderSuccessor(TreeNode p) {
        if (p==null)
            return null;
        if (p.right!=null){
            p = p.right;
            while (p.left!=null)
                p = p.left;
            return p;
        }else if (p.right == null){

        }
        return p;
    }
}
