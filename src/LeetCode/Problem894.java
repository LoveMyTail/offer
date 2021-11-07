package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 你可以按任何顺序返回树的最终列表。
 */
public class Problem894 {
    public static void main(String[] args) {
        List<TreeNode> nodes = new SolutionProblem894().allPossibleFBT(7);
        System.out.println(nodes);
    }
}
// 由于满二叉树每个节点要么有0个子节点，要么有2个子节点，所以一个节点的左子树或者右子树一定只有奇数个节点
class SolutionProblem894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0)
            return list;
        if (N == 1){
            TreeNode head = new TreeNode(0);
            list.add(head);
            return list;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode head = new TreeNode(0);
                    head.left = l;
                    head.right = r;
                    list.add(head);
                }
            }
        }
        return list;
    }

//    public TreeNode method(int num){
//        if (num == 1)
//            return new TreeNode(0);
//        TreeNode node = new TreeNode(0);
//        for (int i = 1; i < num-1; i++) {
//            node.left = method(i);
//            node.right = method(num-i-1);
//            list.add(node);
//            i++;
//        }
//        return node;
//    }

}
