package Job.YuanFuDao.Test;

import LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfNodeInKthLevelInTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(100);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new SolutionNumberOfNodeInKthLevelInTree().NumberOfNodeInKthLevelInTree(root, 4));
    }
}

class SolutionNumberOfNodeInKthLevelInTree {
    public int NumberOfNodeInKthLevelInTree(TreeNode root, int k) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int curLevel = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curLevel == k) {
                return size;
            } else {
                while (size > 0) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null)
                        queue.offer(poll.left);
                    if (poll.right != null)
                        queue.offer(poll.right);
                    size--;
                }

            }
            curLevel++;
        }
        return 0;
    }
}
