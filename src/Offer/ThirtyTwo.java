package Offer;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 层序遍历
 */
public class ThirtyTwo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<List<Integer>> list = new SolutionThirtyTwoQuestionThree().levelOrder(root);
        System.out.println(list);
    }
}
class SolutionThirtyTwo {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
        }
        int[] array = new int[list.size()];
        for (int i = 0;i<list.size();i++){
            array[i] = list.get(i);
        }
        return array;
    }

}

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
class SolutionThirtyTwoQuestionTwo {
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;
        method(root,0);
        return levels;
    }

    private void method(TreeNode root, int level) {
        if (levels.size()==level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(root.val);
        if (root.left!=null){
            method(root.left,level+1);
        }
        if (root.right!=null){
            method(root.right,level+1);
        }
    }
}

/**
 * “之”字型打印二叉树
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
class SolutionThirtyTwoQuestionThree {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return list;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            for (int i = queue.size();i>0;i--){
                TreeNode node = queue.removeFirst();
                cur.add(node.val);
                if (node.left!=null)
                    queue.addLast(node.left);
                if (node.right!=null)
                    queue.addLast(node.right);
            }
            list.add(new ArrayList<>(cur));
            if (queue.isEmpty())
                break;
            cur = new ArrayList<>();
            for (int i = queue.size();i>0;i--){
                TreeNode node = queue.removeLast();
                cur.add(node.val);
                if (node.right!=null)
                    queue.addFirst(node.right);
                if (node.left!=null)
                    queue.addFirst(node.left);
            }
            list.add(new ArrayList<>(cur));
        }
        return list;
    }
}
