package Offer;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class TwentySeven {
    public static void main(String[] args) {

    }
}
class SolutionTwentySeven {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null )
            return root;
        method(root);
        return root;
    }

    private void method(TreeNode cur) {
        if (cur!=null){
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            method(cur.left);
            method(cur.right);
        }else
            return;

    }
}
// 非递归
class SolutionTwentySevenTwo {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.left!=null)
                stack.add(pop.left);
            if (pop.right!=null)
                stack.add(pop.right);
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
        }
        return root;
    }
}
