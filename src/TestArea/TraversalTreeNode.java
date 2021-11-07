package TestArea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 各种遍历树的方式
 * 前序-中序-后序-层序
 * 递归-非递归
 */
public class TraversalTreeNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        SolutionTraversalTreeNode s = new SolutionTraversalTreeNode();
        System.out.println(s.preorderNotRecursion(root));   // 递归中序遍历
    }
}

class SolutionTraversalTreeNode {
    List<Integer> list = new ArrayList<>();

    // 递归中序遍历
    public List<Integer> inorderRecursion(TreeNode root) {
        if (root == null)
            return list;
        inorderRecursionMethod(root);
        return list;
    }

    private void inorderRecursionMethod(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            inorderRecursionMethod(root.left);
        list.add(root.val);
        if (root.right != null)
            inorderRecursionMethod(root.right);
    }

    // 非递归中序遍历
    public List<Integer> inorderNotRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    // 递归先序遍历
    public List<Integer> preorderRecursion(TreeNode root) {
        if (root == null)
            return list;
        preorderRecursionMethod(root);
        return list;
    }

    private void preorderRecursionMethod(TreeNode root) {
        if (root == null)
            return;
        list.add(root.val);
        preorderRecursionMethod(root.left);
        preorderRecursionMethod(root.right);
    }

    // 非递归先序遍历
    public List<Integer> preorderNotRecursion(TreeNode root) {
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right!=null)
                stack.add(pop.right);
            if (pop.left!=null)
                stack.add(pop.left);
        }
        return list;
    }

    // 递归后序遍历
    public List<Integer> postorderRecursion(TreeNode root) {
        if (root == null)
            return list;
        postorderRecursionMethod(root);
        return list;
    }

    private void postorderRecursionMethod(TreeNode root) {
        if (root == null)
            return;
        postorderRecursionMethod(root.left);
        postorderRecursionMethod(root.right);
        list.add(root.val);
    }

    // 非递归后序遍历
    // 从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，按照从上到下、从左至右的顺序依次压入栈中。
    // 因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。
    public List<Integer> postorderNotRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    // 递归层序遍历
    public List<Integer> levelOrderRecursion(TreeNode root) {

        return list;
    }

    // 非递归层序遍历
    public List<Integer> levelOrderNotRecursion(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left!=null)
                queue.add(poll.left);
            if (poll.right!=null)
                queue.add(poll.right);
        }
        return list;
    }

}
