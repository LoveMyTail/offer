package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class Problem144 {
    public static void main(String[] args) {

    }
}
// 递归
class SolutionProblem144MethodOne {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode root) {
        if (root == null)
            return ;
        else{
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
// 迭代
class SolutionProblem144MethodTwo {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);
            // 注意这里的顺序
            if (pop.right!=null)
                stack.add(pop.right);
            if (pop.left!=null)
                stack.add(pop.left);
        }
        return list;
    }
}
