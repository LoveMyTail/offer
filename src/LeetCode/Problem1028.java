package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），
 * 然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * 示例 1：
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 */
public class Problem1028 {
    public static void main(String[] args) {

    }
}



class SolutionProblem1028 {
    public TreeNode recoverFromPreorder(String S) {
        if (S.length()==0 || S == null)
            return null;
        Deque<TreeNode> deque = new LinkedList<>();
        int cur = 0;
        while (cur<S.length()){
            int level = 0;
            while (S.charAt(cur)=='-'){
                level++;
                cur++;
            }
            int value = 0;
            while (cur<S.length() && Character.isDigit(S.charAt(cur))){
                value = value*10+(S.charAt(cur)-'0');
                cur++;
            }
            TreeNode node = new TreeNode(value);
            if (level == deque.size()){
                if (!deque.isEmpty()){
                    deque.peek().left = node;
                }
            }else{
                while (level!=deque.size()){
                    deque.pop();
                }
                deque.peek().right = node;
            }
            deque.push(node);
        }
        while (deque.size()>1){
            deque.pop();
        }
        return deque.peek();
    }
}
