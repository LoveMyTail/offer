package Job.WangYi.SecondTime;

import LeetCode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   // 树上有多少个节点
        int n = sc.nextInt();   // 有多少条边
        sc.nextLine();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] s = str.split(" ");

            Integer rootVal = Integer.valueOf(s[0]);   // 当前节点的值
            String LeftOrRight = s[1];                  // 左还是右
            Integer val = Integer.valueOf(s[2]);        // 左孩子或者右孩子的值

            if (map.containsKey(rootVal)) {
                TreeNode node = map.get(rootVal);
                if (LeftOrRight.equals("left")) {
                    TreeNode left = new TreeNode(val);
                    node.left = left;
                    map.put(val, left);
                } else if (LeftOrRight.equals("right")) {
                    TreeNode right = new TreeNode(val);
                    node.right = right;
                    map.put(val, right);
                }
            } else {
                TreeNode node = new TreeNode(rootVal);
                map.put(rootVal, node);
                if (LeftOrRight.equals("left") ) {
                    TreeNode left = new TreeNode(val);
                    node.left = left;
                    map.put(val, left);
                } else if (LeftOrRight.equals("right")) {
                    TreeNode right = new TreeNode(val);
                    node.right = right;
                    map.put(val, right);
                }
            }
        }
        TreeNode root = map.get(1);
        SolutionMainOne s = new SolutionMainOne();
        int num = s.getNum(root);
        System.out.println(num);

    }
}

class SolutionMainOne {
    public int getNum(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left!=null)
                queue.add(poll.left);
            if (poll.right!=null)
                queue.add(poll.right);
            if (poll.left!=null && poll.right!=null
                    && poll.left.left == null
                    && poll.left.right == null
                    && poll.right.left == null
                    && poll.right.right == null)
                count++;
        }
        return count;
    }
}
