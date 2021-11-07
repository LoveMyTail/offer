package Offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class TwentyEight {
    public static void main(String[] args) {

    }
}

/**
 * 传统的前序遍历为先遍历父节点，然后再遍历左子节点和右子节点
 * 那么便重新定义一种前序遍历，为遍历父节点后，然后先遍历右子节点再遍历左子节点
 * 如果两种前序遍历出的结果一致，表示对称
 */

class SolutionTwentyEight {
    public boolean isSymmetric(TreeNode root) {
        return method(root,root);
    }

    public boolean method(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }else if(node1.val!=node2.val){
            return false;
        }
        return method(node1.left,node2.right) && method(node1.right,node2.left);
    }
}
