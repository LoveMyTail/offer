package Offer;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 例如:
 * 给定的树 A:
 *        3
 *       / \
 *      4   5
 *     / \
 *    1   2
 * 给定的树 B：
 *      4
 *     /
 *    1
 */
public class TwentySix {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        TreeNode B = new TreeNode(3);
        SolutionTwentySix s = new SolutionTwentySix();
        System.out.println(s.isSubStructure(A, B));
    }
}

/**
 * 思路
 * 先找匹配的根节点，找到匹配的根节点后再判断结构是否一致
 */
/*class Offer.SolutionTwentySix {
    public boolean isSubStructure(Offer.TreeNode A, Offer.TreeNode B) {
        if(A == null || B == null)
            return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean dfs(Offer.TreeNode A, Offer.TreeNode B){
        if(B == null)
            return true;
        if(A == null)
            return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}*/


/**
 * 输入：
 * [10,12,6,8,3,11]
 * [10,12,6,8]
 * 输出：false
 * 预期：true
 */
class SolutionTwentySix {
    TreeNode cur = null;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B==null)
            return false;
        judgeOne(A,B);
        //System.out.println(cur.val);

        return judgeTwo(cur,B) && judgeTwo(cur.left,B.left) && judgeTwo(cur.right,B.right);
    }

    private boolean judgeTwo(TreeNode cur, TreeNode b) {
        if (cur == null && b==null){
            return true;
        }else if (cur!=null && b==null){
            return false;
        }else if (cur==null && b!=null){
            return false;
        }else{
            return cur.val==b.val && judgeTwo(cur.left,b.left) && judgeTwo(cur.right,b.right);
        }
    }

    private void judgeOne(TreeNode a, TreeNode b) {
        if (a == null){
            return;
        }
        if (a.val == b.val){
            cur = a;
        }else{
            judgeOne(a.left,b);
            judgeOne(a.right,b);
        }
    }

}
