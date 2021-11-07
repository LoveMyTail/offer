package Offer;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *   3
 *  / \
 * 1   4
 * \
 *  2
 * 输出: 4
 */
public class FiftyFour {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        System.out.println(new SolutionFiftyFour().kthLargest(root,3));
    }
}

// 中序遍历
// 换一种思路，只需要找到第k大的数就好，那么可以更改中序遍历的顺序，先遍历右节点，
// 在遍历左节点，设置一个计数器，即可更快的找出结果
class SolutionFiftyFour {
    public int kthLargest(TreeNode root, int k) {
        //Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        // 中序遍历，将数据放入队列中
        //method(root, stack);
        // 中序遍历，将数据放入ArrayList中
        method2(root,list);
//        for (int i = 0; i < k-1; i++) {
//            System.out.println("当前取出的是："+stack.pop());
//        }
        return list.get(list.size()-k);
    }

    private void method2(TreeNode root, List<Integer> list) {
        if (root.left != null)
            method2(root.left, list);
        list.add(root.val);
        if (root.right != null)
            method2(root.right, list);
    }

    // 放入栈中
    private void method(TreeNode root, Stack<Integer> stack) {
        if (root.left != null)
            method(root.left, stack);
        stack.push(root.val);
        if (root.right != null)
            method(root.right, stack);
    }
}
