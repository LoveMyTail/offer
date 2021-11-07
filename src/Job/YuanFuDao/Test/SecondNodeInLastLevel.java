package Job.YuanFuDao.Test;


import LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树最底层的第二个元素
 */
public class SecondNodeInLastLevel {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(100);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode node = new SolutionSNILL().secondNodeInLastLevel(root);
        System.out.println(node.val);
    }
}
// 层序遍历,最后一层的从左往右的第二个节点，也就是从右往左的倒数第二个节点
class SolutionSNILL{
    public TreeNode secondNodeInLastLevel(TreeNode root) throws  Exception {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            if (size>1) {
                throw new Exception("asd");
            }
            TreeNode node = queue.poll();
            if (queue.size() == 1)
                cur = node;
            if (node.right!=null)
                queue.offer(node.right);
            if (node.left!=null)
                queue.offer(node.left);
        }
        return cur;
    }
}
