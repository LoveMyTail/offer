package OtherJob;

import java.util.*;

public class Main20210324 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // map用来存储每个节点的权值
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i,sc.nextInt());
        }
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }
        Solution s = new Solution();
        // 构建出二叉树
        TreeNode tree = s.buildTree(preorder, inorder,map);
        // 先序遍历寻找对称的树以及获取权值的和
        int i = s.method(tree);
        System.out.println(i);
    }
}
class Solution{
    int value = Integer.MIN_VALUE;
    public TreeNode buildTree(int[] preorder, int[] inorder,HashMap<Integer,Integer> map) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(map.get(preorder[0]));
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = map.get(preorder[i]);
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
    // 判断当前树是否为对称的
    public boolean judge(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }else if(node1.val!=node2.val){
            return false;
        }
        return judge(node1.left,node2.right) && judge(node1.right,node2.left);
    }

    // 当前树的权值的和
    public int getSum(TreeNode node){
        if (node == null)
            return 0;
        else
            return node.val+getSum(node.left)+getSum(node.right);
    }

    public int method(TreeNode node){
        if (node == null)
            return 0;
        if (node.left == null && node.right == null){
            return node.val;
        }
        if (judge(node.left,node.right)){
            return getSum(node);
        }else{
            return method(node.left)>method(node.right)?method(node.left):method(node.right);
        }
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        val = x;
    }
}
