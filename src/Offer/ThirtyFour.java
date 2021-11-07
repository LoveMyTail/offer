package Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class ThirtyFour {
    public static void main(String[] args) {

    }
}

/**
 * 回溯
 */
class SolutionThirtyFour {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> cur = new ArrayList<>();
        method(cur,root,sum);
        return list;
    }

    private void method(List<Integer> cur, TreeNode root, int sum) {
        if (root == null)
            return;
        cur.add(root.val);
        sum-=root.val;
        if (sum ==0 && root.left==null && root.right==null){
            list.add(new ArrayList<>(cur));
        }else{
            method(cur,root.left,sum);
            method(cur,root.right,sum);
        }
        cur.remove(cur.size()-1);
    }
}
