package Offer;

import java.util.HashMap;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树
 * 假设输入的前序遍历和中序遍历的结果中都不含重复数字
 */
public class Seven {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        SolutionSeven solution = new SolutionSeven();
        solution.buildTree(preorder, inorder);
    }

}
class SolutionSeven {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        if (preorder == null)
            return null;
        if (preorder.length != inorder.length)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return method(preStart, preEnd, inStart, inEnd);
    }

    private TreeNode method(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int num = preorder[preStart];
        node.left = method(preStart + 1, preStart+1+map.get(num) - inStart, inStart, map.get(num) - 1);
        node.right = method(preStart + (map.get(num) - inStart + 1), preEnd, map.get(num) + 1, inEnd);
        return node;
    }
}
