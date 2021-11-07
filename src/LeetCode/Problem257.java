package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明:叶子节点是指没有子节点的节点。
 * 示例:
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Problem257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        SolutionProblem257 s = new SolutionProblem257();
        List<String> list = s.binaryTreePaths(root);
        System.out.println(list);
    }
}
class SolutionProblem257 {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null){
            return ans;
        }
        dfs(root, "");
        return ans;
    }

    public void dfs(TreeNode root, String s){
        s += root.val;  //拼接上新的节点值
        if(root.left == null && root.right == null){
            ans.add(s);
        }
        if(root.left != null){
            dfs(root.left, s + "->");
        }
        if(root.right != null){
            dfs(root.right, s + "->");
        }
    }
}
