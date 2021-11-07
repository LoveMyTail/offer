package Job.DiDi.others;

import LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树深度
 */
public class DepthOfTree {
}
class SolutionDepthOfTree{
    // 递归方式求解
    public int recursion(TreeNode root){
        if (root == null)
            return 0;
        else
            return 1+Math.max(recursion(root.left),recursion(root.right));
    }
    // 非递归方式求解
    public int notRecursion(TreeNode root){
        if(root == null)
            return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }}, tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
