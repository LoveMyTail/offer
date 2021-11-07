package Job.DiDi.others;


import LeetCode.TreeNode;

public class isMirrorTree {
    public static void main(String[] args) {

    }
}

class SolutionIsMirrorTree {
    public boolean mirrorTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if ((node1 == null && node2 != null) || (node1 != null && node2 == null) || (node1.val != node2.val))
            return false;
        return mirrorTree(node1.left, node2.right) && mirrorTree(node1.right, node2.left);
    }
}
