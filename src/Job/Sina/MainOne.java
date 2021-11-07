package Job.Sina;



import LeetCode.TreeNode;

import java.util.*;

public class MainOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] split = str.split(",");
        int len = split.length;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.valueOf(split[i]);
        }
        SolutionMainOne s = new SolutionMainOne();
        TreeNode node = s.buildTree(array);
        TreeNode treeNode = s.method(node);
        List<Integer> list = s.levelOrderNotRecursion(treeNode);
        for (int i = 0; i < list.size(); i++) {
            if (i!=list.size()-1)
                System.out.print(list.get(i)+",");
            else
                System.out.print(list.get(i));
        }
    }
}

class SolutionMainOne {
    public TreeNode method(TreeNode root) {
        if (root == null || root.left == null)
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode node = method(left);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return node;
    }

    public TreeNode buildTree(int[] array) {
        TreeNode p = new TreeNode(array[0]);
        TreeNode q = p;
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        while (p != null) {
            if (2 * i + 1 < array.length) {
                p.left = new TreeNode(array[2*i+1]);
                queue.add(p.left);
            }
            if (2*i+2<array.length){
                p.right = new TreeNode(array[2*i+2]);
                queue.add(p.right);
            }
            p = queue.poll();
            i+=1;
        }
        return q;
    }

    public List<Integer> levelOrderNotRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
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
